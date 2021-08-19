package com.bitinbyte.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * LuvAopExpressions
 */
@Aspect
@Component
public class LuvAopExpressions {
    @Pointcut("execution(* com.bitinbyte.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    // Create pointcut for getter methods
    @Pointcut("execution(* com.bitinbyte.aopdemo.dao.*.get*(..))")
    public void getter() {
    }

    // Create pointcut for setter methods
    @Pointcut("execution(* com.bitinbyte.aopdemo.dao.*.set*(..))")
    public void setter() {
    }

    // Create pointcut: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(setter() || getter())")
    public void forDaoPackageNoGetterSetter() {
    }

}
