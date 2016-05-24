package music.recommd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import music.recommd.annotation.JSONResponse;
import music.recommd.exception.UnauthorizedException;
import music.recommd.model.User;
import music.recommd.service.inter.UserService;
import music.recommd.service.inter.ValidationService;

/**
 * @apiDefine SValidation 用户验证(AccessToken)
 */

@RestController
@RequestMapping(value = "user/validation", produces = "application/json")
public class ValidationController {
	
	
	@Autowired
	private ValidationService validationService;
	
	@Autowired
	private UserService userService;

	
	/**
	 * @api {POST} http://115.28.238.193/music/user/validation?phone={}&password={} 1-用户登录
     * @apiName create
     * @apiGroup SValidation
     * @apiSuccessExample {json} Success-Response:
     * HTTP/1.1 201 CREATED
     * {
     *   "id": 1,
     *   "name": 童志祥
     *   "accessToken": "f91d424b-f536-4f27-8baf-8a8cd6527c62",
     *   "uid": "7d49b86f-3a26-4fe0-a63e-6620cd4dbedb",
     * }
     */
	@RequestMapping(method = RequestMethod.POST)
	@JSONResponse
	public String getAccessToken(@RequestParam(value = "phone") String phone,
			@RequestParam(value = "password") String password){
		if(!this.validationService.validatePassword(phone, password)){
			throw new UnauthorizedException("phone or password invalid");
		}
		User user = this.userService.findByPhone(phone);
		return JSON.toJSONString(this.validationService.createOrUpdateAccessToken(user));
	}
}
