package music.recommd.controller;

import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import music.recommd.annotation.Admin;


/**
 * @apiDefine SCollect 用户模块(COLLECT)
 */

@RestController
@RequestMapping(value = "/collect", produces = "application/json")
@Transactional
public class CollectController {
	
	 /**
		 * @api {POST} http://115.28.238.193/music/collect/{userId}?accessToken={} 1-用户添加收藏
		 * @apiName createUser
		 * @apiGroup SUser
		 * @apiParamExample {json} Request-Example: 
	     * {
	     *      
	     * }
		 * @apiSuccessExample {json} Success-Response: HTTP/1.1 CREATE
	     * {
	     *    "code":"201",
	     *    "message":"创建成功"
	     * }
		 */
	@Admin
	@RequestMapping(value = "{userId}", method = RequestMethod.POST)
	public String collectCreate(@RequestParam(value = "musicId") Long musicId, @RequestParam("accessToken") String accessToken
			,@PathVariable(value = "userId") String userId){
		return null;
	}

}
