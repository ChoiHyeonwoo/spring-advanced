package hello.advanced.aop.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV1 {

    private final HelloTraceV1 helloTraceV1;

    public void save (String itemId) {
        TraceStatus status = null;
        try {
            status = helloTraceV1.begin("OrderRepository.save()");

            if(itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생");
            }
            sleep(1000);
            helloTraceV1.end(status);
        } catch (Exception e) {
            helloTraceV1.exception(status, e);
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
