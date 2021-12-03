package hello.advanced.aop.configuration;

import hello.advanced.trace.hellotrace.HelloTraceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public HelloTraceV1 helloTraceV1(){
        return new HelloTraceV1();
    }
}
