package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV2Test {

    @Test
    void begin_end (){
        HelloTraceV2 traceV2 = new HelloTraceV2();
        TraceStatus traceStatus1 = traceV2.begin("hello");
        TraceStatus traceStatus2 = traceV2.beginSync(traceStatus1.getTraceId(), "hello2");
        traceV2.end(traceStatus2);
        traceV2.end(traceStatus1);
    }

    @Test
    void begin_exception(){
        HelloTraceV2 traceV2 = new HelloTraceV2();
        TraceStatus traceStatus1 = traceV2.begin("hello");
        TraceStatus traceStatus2 = traceV2.beginSync(traceStatus1.getTraceId(), "hello2");
        traceV2.exception(traceStatus2, new IllegalStateException());
        traceV2.exception(traceStatus1, new IllegalStateException());
    }
}