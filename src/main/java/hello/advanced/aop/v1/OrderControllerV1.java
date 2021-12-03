package hello.advanced.aop.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderServiceV1;

    private final HelloTraceV1 helloTraceV1;

    @GetMapping("/v1/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = helloTraceV1.begin("OrderController.request()");
            orderServiceV1.orderItem(itemId);
            helloTraceV1.end(status);
            return "ok";
        } catch (Exception e) {
            helloTraceV1.exception(status, e);
            throw e; //예외를 꼭 다시 던져주어야 한다.
        }
    }
}
