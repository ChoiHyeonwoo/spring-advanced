package hello.advanced.aop.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV2 {

    private final HelloTraceV2 helloTraceV2;

    public void save(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = helloTraceV2.beginSync(traceId, "OrderRepository.save()");

            if(itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생");
            }
            sleep(1000);
            helloTraceV2.end(status);
        } catch (Exception e) {
            helloTraceV2.exception(status, e);
            throw e; //예외를 꼭 다시 던져주어야 한다.
        }

    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
