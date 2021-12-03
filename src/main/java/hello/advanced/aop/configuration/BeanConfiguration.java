package hello.advanced.aop.configuration;

import hello.advanced.trace.hellotrace.HelloTraceV1;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public HelloTraceV1 helloTraceV1(){
        return new HelloTraceV1();
    }
    @Bean
    public HelloTraceV2 helloTraceV2(){
        return new HelloTraceV2();
    }
}
