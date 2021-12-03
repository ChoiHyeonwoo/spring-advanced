package hello.advanced.aop.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepositoryV2;

    private final HelloTraceV2 helloTraceV2;

    public void orderItem(TraceId traceId, String itemId){
        TraceStatus status = null;
        try {
            status = helloTraceV2.beginSync(traceId, "OrderService.orderItem()");
            orderRepositoryV2.save(status.getTraceId(), itemId);
            helloTraceV2.end(status);
        } catch (Exception e) {
            helloTraceV2.exception(status, e);
            throw e; //예외를 꼭 다시 던져주어야 한다.
        }
    }
}
