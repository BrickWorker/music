package music.recommd.service.inter;

public interface CaptchaService {
	String getCaptcha(String phone);

	//验证手机验证码
	Boolean validateCaptcha(String phone, String captcha);
}
