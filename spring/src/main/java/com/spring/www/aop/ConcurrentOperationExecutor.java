package com.spring.www.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;

@Aspect
public class ConcurrentOperationExecutor implements Ordered {

    private static final int DEFAULT_MAX_RETRTES = 2;
    private int maxRetries = DEFAULT_MAX_RETRTES;
    private int order = 1;

    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getMaxRetries() {
        return maxRetries;
    }

    @Around("execution(* com.spring.www.service.UserService.create())")
    public Object doConcurrentOperation(ProceedingJoinPoint point) throws Throwable {

        System.out.println("execute method before");
        Object o = point.proceed();
        System.out.println("execute method after");
        return o;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
