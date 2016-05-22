/**
 * 
 */
package music.recommd.monitor;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import music.recommd.exception.UnauthorizedException;
import music.recommd.service.inter.ValidationService;

/**
 * @author jaron
 *
 */
@Aspect
@Component
public class AdminMonitor {

	@Autowired
	private ValidationService validationService;

	@Before("execution(@music.recommd.annotation.Admin * *(..))")
	public void nullCheck(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint
				.getSignature();

		String[] parameterNames = methodSignature.getParameterNames();
		Object[] parameterValues = joinPoint.getArgs();
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		for (int i = 0; i < parameterNames.length; i++) {
			parametersMap.put(parameterNames[i], parameterValues[i]);
		}
		String accessToken = (String) parametersMap.get("accessToken");

		if (accessToken == null || !validationService.validate(accessToken)) {
			throw new UnauthorizedException("invalid accessToken");
		}
	}

}
