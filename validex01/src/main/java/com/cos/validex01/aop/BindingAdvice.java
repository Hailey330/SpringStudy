package com.cos.validex01.aop;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.cos.validex01.RespDto;
import com.cos.validex01.StatusCode;

// 공통 관심사 : advice 
@Component // 메모리 띄움 → 모든 어노테이션은 Component의 자식
@Aspect // AOP 등록 완료
public class BindingAdvice {

	// @Before는 joinPoint에 접근하지 못함.
	// 접근하고 싶으면 Around 사용 - Around 사용하면 응답해줄 수 있음
	@Before("execution(* com.cos.validex01.test.BindControllerTest.*(..))")
	public void test1() {
		System.out.println("Before ::: BindController에 오신 것을 환영합니다.");
	}

	@After("execution(* com.cos.validex01.test.BindControllerTest.*(..))")
	public void test2() {
		System.out.println("After ::: BindController를 이용해주셔서 감사합니다.");
	}

	// @Before(핵심로직 전), @After(핵심로직 후 - 함수가 끝나는 때를 알아야함), @Around(핵심로직 앞 뒤)
//	@Around("execution(* com.cos.validex01..*Controller.*(..))") // 내 package의 모든 controller에 동작하라는 것
	// * 모든 리턴타입 | com.cos.validex01 .. 이하에 있는 모든 Controller | *(..) 메소드, 모든 파라미터
	public Object validationHandler(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		// joinPoint를 적어두면 받음 → 핵심 로직을 받는다! Proxy를 가져온다.
		String type = proceedingJoinPoint.getSignature().getDeclaringTypeName();
		String method = proceedingJoinPoint.getSignature().getName();
		System.out.println("type :" + type);
		System.out.println("method :" + method);
		
		Object[] args = proceedingJoinPoint.getArgs(); // args : 조인 포인트의 파라미터
		
		for(Object arg : args) {
			if (arg instanceof BindingResult) {
				BindingResult bindingResult = (BindingResult) arg;
				
				if (bindingResult.hasErrors()) {
					// 오류 메시지를 던져줌
					Map<String, String> errorMap = new HashMap<>();

					for (FieldError error : bindingResult.getFieldErrors()) {
						errorMap.put(error.getField(), error.getDefaultMessage());
					}

					RespDto<?> respDto = RespDto.builder()
							.statusCode(StatusCode.FAIL)
							.msg(method + " 요청에 실패하였습니다.")
							.data(errorMap)
							.build();

					return new ResponseEntity<RespDto>(respDto, HttpStatus.BAD_REQUEST);
				}
 			} 
		}
		return proceedingJoinPoint.proceed(); // 원래 흐름타게 보냄
	}
}
