package music.recommd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import music.recommd.annotation.JSONResponse;
import music.recommd.model.User;
import music.recommd.service.inter.CaptchaService;
import music.recommd.service.inter.UserService;

/**
 * @apiDefine SUser 用户模块(USER)
 */

@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CaptchaService captchaService;
	
    /**
	 * @api {POST} http://115.28.238.193/music/user?captcha=1234 1-创建用户
	 * @apiName createUser
	 * @apiGroup SUser
	 * @apiParamExample {json} Request-Example: 
     * {
     *      "name":"simon",
     *      "phone":"15757115779",
     *      "password":"123456",
     *      "sex":"1"  0有洞的表示女孩，1表示男性
     * }
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 CREATE
     * {
     *    {
  	 *			"status" : 200,
  	 *			"data" : {
     *					"name" : "simon",
     *					"password" : "123456",
     *					"phone" : "15757115779",
     *					"sex" : "1",
     *					"userId" : "b7b38755-c744-48be-80db-453fbee91fbe"
  	 *					},
  	 *			"msg" : "OK"
	 *			}
     * }
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	@JSONResponse
	public String create(@RequestBody User user, @RequestParam(value = "captcha") String captcha){
		if(captcha != null && !this.captchaService.validateCaptcha(user.getPhone(),captcha)){
    		return JSON.toJSONString("验证码失效，请重新获取！");
    	}
		return JSON.toJSONString(this.userService.save(user));
	}

}
