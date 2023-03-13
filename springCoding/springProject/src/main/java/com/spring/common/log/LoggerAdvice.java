package com.spring.common.log;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.spring.client.board.vo.BoardVO;

import lombok.extern.log4j.Log4j;

@Log4j
/* ���������� ��(bean)���� �ν��ϱ� ���ؼ� ��� */
@Component
/* �ش� Ŭ������ ��ü�� Aspect�� ������ ������ ��Ÿ���� ���ؼ� ��� */
@Aspect
public class LoggerAdvice {
	/* execution(@execution) �޼��带 �������� Pointcut�� ���� */
	/* @Before("execution(* com.spring..*Impl.*(..))")
	public void printLogging() {
		log.info("--------------------------------------");
		log.info("[���� �α� Log] ����Ͻ� ���� ���� �� ����");
		log.info("--------------------------------------");
	} */
	
	/* @Before("execution(* com.spring..*Impl.*(..)) && args(bvo)")
	public void printLogging(BoardVO bvo) {
		log.info("--------------------------------------");
		log.info("[���� �α� Log] ����Ͻ� ���� ���� �� ����");
		log.info("--------------------------------------");
		log.info("BoardVO Ÿ���� bvo �Ķ���� �� :"+bvo);
	} */
	
	/* @Before("execution(* com.spring..*Impl.*(..))")
	public void printLogging(JoinPoint jp) {
		log.info("--------------------------------------");
		log.info("[���� �α� Log] ����Ͻ� ���� ���� �� ����");
		// getArgs() : ���޵Ǵ� ��� �Ķ���͵��� Object�� �迭�� ������
		// getSignature() : �����ϴ� ��� ��ü�� ������ �˾Ƴ� �� ���
		log.info("[ȣ�� �޼����] "+jp.getSignature().getName());
		log.info("[ȣ�� �޼����� �Ķ���� ��] "+Arrays.toString(jp.getArgs()));
		log.info("--------------------------------------");
	} */
	
	/* ���ܰ� �߻��� ������ ���� */
	@AfterThrowing(pointcut="execution(* com.spring..*Impl.*(..))", throwing="exception")
	public void exceptionLogging(JoinPoint jp, Throwable exception) {
		log.info("--------------------------------------");
		log.info("[���ܹ߻�] ");
		log.info("[���ܹ߻� �޼����] " +jp.getSignature().getName());
		//exception.printStackTrace();
		log.info("[���� �޽���] "+exception);
		log.info("--------------------------------------");
	}
	
	/* ����Ͻ� ���� �޼��尡 ���������� ����� �� ���� */
	/* @AfterReturning(pointcut="execution(* com.spring..*Impl.*(..))", returning="returnValue")
	public void afterReturningMethod(JoinPoint jp, Object returnValue) {
		log.info("--------------------------------------");
		log.info("[���� �α� Log] ����Ͻ� ���� ���� �� ����");
		log.info("afterReturningMethod() called....." + jp.getSignature().getName());
		log.info("[���� ���] " + returnValue);
		log.info("--------------------------------------");
	} */
	
	@Around("execution(* com.spring..*Impl.*(..))")
	public Object timeLogging(ProceedingJoinPoint pjp) throws Throwable {
		log.info("--------------------------------------");
		log.info("[���� �α� Log] ����Ͻ� ���� ���� �� ����");
		
		// �������� currentTimeMillis()�� �ð� �����ؼ� ���
		// long StartTime = System.currentTimeMillies();
		
		StopWatch watch = new StopWatch();
		watch.start();
		log.info("[ȣ�� �޼����� �Ķ���� ��] " + Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		/* proceed() : ���� target ��ü�� �޼��带 �����ϴ� ��� */
		result = pjp.proceed();
		
		// long endTime = System.currentTimeMillies();
		watch.stop();
		
		log.info("[Class] "+pjp.getTarget().getClass());
		
		// logger.info(pjp.getSignature().getName() + ":�ҿ�ð� "+ (endTime-startTime)+"ms");
		log.info("[ȣ�� �޼����] " + pjp.getSignature().getName());
		log.info("[�ҿ�ð�] "+ watch.getTotalTimeSeconds()+"ms");
		log.info("[���� ���] " + result);
		log.info("[���� �α� Log] ����Ͻ� ���� ���� �� ����");
		log.info("--------------------------------------");
		
		return result;
	}
}
