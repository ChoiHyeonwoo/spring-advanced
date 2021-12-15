package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubclassLogic1;
import hello.advanced.trace.template.code.SubclassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0(){
        logic1();
        logic2();
    }

    private void logic1(){
        long startTime = System.currentTimeMillis();
        // 비즈니스실행
        log.info("비즈니스 1 실행");
        // 비즈니스 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2(){
        long startTime = System.currentTimeMillis();
        // 비즈니스실행
        log.info("비즈니스 2 실행");
        // 비즈니스 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    @Test
    void templateMethodV1(){
        AbstractTemplate template1 = new SubclassLogic1();
        template1.execute();

        AbstractTemplate template2 = new SubclassLogic2();
        template2.execute();
    }
}
