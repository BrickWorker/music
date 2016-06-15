package music.recommd.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import music.recommd.annotation.Admin;
import music.recommd.annotation.JSONResponse;
import music.recommd.service.inter.UserService;
import music.recommd.service.inter.ValidationService;
import scala.languageFeature.reflectiveCalls;


/**
 * @apiDefine SCollect 用户模块(COLLECT)
 */

@RestController
@RequestMapping(value = "/collect", produces = "application/json")
@Transactional
public class CollectController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ValidationService validationService;
	
	 /**
		 * @api {POST} http://115.28.238.193/music/collect/{userId}/{musicId}?accessToken={} 1-用户添加收藏
		 * @apiName UserCollect
		 * @apiGroup SCollect
		 * @apiSuccessExample {json} Success-Response: HTTP/1.1 CREATE
	     * {
	     * 	 msg=OK
	     * 	 status=200
	     * 	 data[
	     * 		{
	     * 		brief=(null)
	     * 		email=(null)
	     * 		name=童志祥
	     * 		password=123456
	     * 		phone=15757115779
	     * 		pic=(null)
	     * 		sex=1
	     * 		userId=6eeb86bb-87a5-4542-afc6-eda0718e206a
	     * 		}
	     * 		]
	     *   //返回一个user对象
	     * }
		 */
	@Admin
	@JSONResponse
	@RequestMapping(value = "{userId}/{musicId}", method = RequestMethod.POST)
	public String collectCreate(@PathVariable(value = "musicId") Long musicId, @RequestParam("accessToken") String accessToken
			,@PathVariable(value = "userId") String userId){
		return JSON.toJSONString(this.userService.collect(musicId, userId),
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.DisableCircularReferenceDetect);
	}
	
	 /**
	 * @api {GET} http://115.28.238.193/music/collect/{userId}/{musicId}?accessToken={} 2-查询是否被收藏
	 * @apiName IsCollect
	 * @apiGroup SCollect
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 CREATE
     * {
     * 	 msg=OK
     * 	 status=200
     * 	 data:
     * 		{
     * 		"status":true;
     * 		}
     * }
	 */
	@Admin
	@JSONResponse
	@RequestMapping(value = "{userId}/{musicId}", method = RequestMethod.GET)
	public String isCollect(@PathVariable(value = "musicId") Long musicId, @RequestParam("accessToken") String accessToken
			,@PathVariable(value = "userId") String userId){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", this.userService.isCollect(musicId, userId));
		return JSON.toJSONString(jsonObject);
	}
	
	 /**
	 * @api {PUT} http://115.28.238.193/music/collect/{userId}/{musicId}?accessToken={} 3-移除收藏
	 * @apiName RemoveCollect
	 * @apiGroup SCollect
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 CREATE
     * {
     * 	 msg=OK
     * 	 status=200
     * 	 data:
     * 		{
     * 		"status":true;//删除成功  
     * 		}
     * }
	 */
	
	@Admin
	@JSONResponse
	@RequestMapping(value = "{userId}/{musicId}", method = RequestMethod.PUT)
	public String removeCollect(@PathVariable(value = "musicId") Long musicId, @RequestParam("accessToken") String accessToken
			,@PathVariable(value = "userId") String userId){
		return JSON.toJSONString(this.userService.removeCollect(musicId, userId),
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.DisableCircularReferenceDetect);
	}
	
	 /**
	 * @api {GET} http://115.28.238.193/music/collect/get/all?accessToken={} 4-获取用户收藏
	 * @apiName getAllCollect
	 * @apiGroup SCollect
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 CREATE
    * {
    * 	 msg=OK
    * 	 status=200
    * 	 data:
    * 		{
    * 		"status":true;
    * 		}
    * }
	 */
	@Admin
	@JSONResponse
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public String getCollect(@RequestParam("accessToken") String accessToken){
		return JSON.toJSONString(this.validationService.getUserByAccessToken(accessToken).getuserCollect(),
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.DisableCircularReferenceDetect);
		
	}
}
