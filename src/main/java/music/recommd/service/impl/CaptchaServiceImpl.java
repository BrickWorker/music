package music.recommd.service.impl;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.google.common.collect.MapMaker;

import music.recommd.service.inter.CaptchaService;

@Component
@Transactional
public class CaptchaServiceImpl implements CaptchaService{
	private ConcurrentMap<String, String> capthcaMap = new MapMaker().expiration(15, TimeUnit.MINUTES).makeMap();

	@Override
	 public String getCaptcha(String phone) {
	        capthcaMap.put(phone,  RandomStringUtils.randomNumeric(4));
	        return capthcaMap.get(phone);
	    }

	@Override
	public Boolean validateCaptcha(String phone, String captcha) {
		 if (!capthcaMap.containsKey(phone) || !capthcaMap.get(phone).equals(captcha)) {
	            return false;
	        } else {
	            return true;
	        }
	}
}
