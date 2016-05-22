package music.recommd.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import music.recommd.annotation.JSONResponse;
import music.recommd.service.inter.MusicTypeService;

/**
 * @apiDefine SType 广告模块(MUSICTYPE)
 */

@RestController
@RequestMapping(value = "/musictype", produces = "application/json")
@Transactional
public class MusicTypeController {
	
	@Autowired
	private MusicTypeService musicTypeService;
	
	/**
	 * @api {GET} http://115.28.238.193:8080/music/musictype  1-查询所有音乐类型
	 * @apiName getAll
	 * @apiGroup SType
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 200 OK 
     * {
     * 	
     * 
     * }
     */
	
	@JSONResponse
	@RequestMapping(method = RequestMethod.GET)
	public String getAll(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "5") Integer limit){
		return JSON.toJSONString(this.musicTypeService.getAllType(page, limit));
	}

}
