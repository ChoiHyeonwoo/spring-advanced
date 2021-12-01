package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelloTraceV1Test {

    @Test
    void begin_end (){
        HelloTraceV1 traceV1 = new HelloTraceV1();
        TraceStatus traceStatus = traceV1.begin("hello");
        traceV1.end(traceStatus);
    }

    @Test
    void begin_exception(){
        HelloTraceV1 traceV1 = new HelloTraceV1();
        TraceStatus traceStatus = traceV1.begin("hello");
        traceV1.exception(traceStatus, new IllegalStateException());
    }
}