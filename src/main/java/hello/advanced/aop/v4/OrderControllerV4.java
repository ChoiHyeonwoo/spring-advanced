package hello.advanced.aop.v4;

import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderServiceV4;

    private final LogTrace logTrace;

    @GetMapping("/v4/request")
    public String request(String itemId) {
        AbstractTemplate<String> template = new AbstractTemplate<>(logTrace) {
            @Override
            protected String call() {
                orderServiceV4.orderItem(itemId);
                return "OK";
            }
        };
        return template.execute("OrderController.request()");
    }
}
