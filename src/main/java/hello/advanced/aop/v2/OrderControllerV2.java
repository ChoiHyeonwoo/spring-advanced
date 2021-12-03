package hello.advanced.aop.v2;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderServiceV2;

    private final HelloTraceV2 helloTraceV2;

    @GetMapping("/v2/request")
    public String request(String itemId) {
        TraceStatus status = null;
        try {
            status = helloTraceV2.begin("OrderController.request()");
            orderServiceV2.orderItem(status.getTraceId(), itemId);
            helloTraceV2.end(status);
            return "ok";
        } catch (Exception e) {
            helloTraceV2.exception(status, e);
            throw e; //예외를 꼭 다시 던져주어야 한다.
        }
    }
}
