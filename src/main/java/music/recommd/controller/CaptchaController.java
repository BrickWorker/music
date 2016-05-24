package music.recommd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import music.recommd.service.inter.CaptchaService;
import music.recommd.service.inter.UserService;
import music.recommd.utils.ShortMessagePushUtils;

/**
 * @apiDefine SCaptcha 短信验证码(CAPTCHA)
 */


@RestController
@RequestMapping(value = "/tcaptcha", produces = "application/json")
public class CaptchaController {
	
	private final  Logger logger = LoggerFactory.getLogger(CaptchaController.class);
	
	@Autowired
	private CaptchaService captchaService;
	
	@Autowired
	private UserService userService;

	/**
	 * @api {POST} http://115.28.238.193/music/tcaptcha?phone={phone_num} 1-创建
     * @apiName create
     * @apiGroup SCaptcha
     * @apiSuccessExample {json} Success-Response: HTTP/1.1  CREATED 
     * 		HTTP/1.1 201 CREATED
     * 		{
     * 			"captcha": "132856"
     * 		}
     */
	@ResponseStatus(value = HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	public String createCaptcha(@RequestParam(value = "phone") String phone){
		System.err.println("start simon");
		JSONObject jsonObject = new JSONObject();
		String captcha = this.captchaService.getCaptcha(phone);
		try {
			ShortMessagePushUtils.sendMessage(phone, captcha);
		} catch (Exception e) {
			System.err.println("短信推送失败");
			e.printStackTrace(System.err);
		}
		logger.info("phone:"+phone+"===========>captcha:"+captcha);
		jsonObject.put("captcha", captcha);
		return JSON.toJSONString(jsonObject);
	}
	
	
	/**
	 * @api {GET} http://115.28.238.193/music/tcaptcha/isPhoneRegistered?phone={phone_num} 2-验证账号是否被注册
     * @apiName find
     * @apiGroup SCaptcha
     * @apiSuccessExample {json} Success-Response: HTTP/1.1  FIND 
     * 		HTTP/1.1 201 CREATED
     * 		{
     * 			"status":"true";//true 表示号码已被注册
     * 		}
     */  
	@RequestMapping(value = "isPhoneRegistered", method = RequestMethod.GET)
	  public String isPhoneRegistered(@RequestParam("phone") String phone){
    	JSONObject josnObject = new JSONObject();
    	josnObject.put("status", this.userService.isRgister(phone));
    	return JSON.toJSONString(josnObject);
    }
}
