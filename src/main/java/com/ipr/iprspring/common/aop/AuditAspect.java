package com.ipr.iprspring.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class AuditAspect {

    @Around("@annotation(com.ipr.iprspring.common.annotations.Audit)")
    public Object audit(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Параметры запроса: {}", Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        log.info("Ответ: {}", result);
        return result;
    }
}
