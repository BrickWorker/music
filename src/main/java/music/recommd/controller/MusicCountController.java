package music.recommd.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import music.recommd.annotation.JSONResponse;
import music.recommd.model.MusicCount;
import music.recommd.service.inter.MusicCountService;
import music.recommd.service.inter.ValidationService;



/**
 * @apiDefine SmusicCount 音乐打分系列(MUSICCOUNT)
 */


@RestController
@RequestMapping(value = "/musicCount", produces = "application/json")
@Transactional
public class MusicCountController {
	
	@Autowired
	private ValidationService validationService;
	
	@Autowired
	private MusicCountService musicCountService;
	
	
	
	
	/**
	 * @api {POST} http://115.28.238.193/musicCount/{musicId}?accessToken={} 1-用户音乐计数
	 * @apiName createOrUpdateCount
	 * @apiGroup SmusicCount
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 CREATE
     * {
     *    {
  	 *			"status" : 200,
  	 *			"data" : {
  	 * 					"count" : 1, 
  	 * 					"id" : 1, 
  	 * 					"musicId" : "195", 
  	 * 					"userId" : "6eeb86bb-87a5-4542-afc6-eda0718e206a"
  	 * 				 }, 
  	 *			"msg" : "OK"
	 *			}
     * }
	 */
	
	@JSONResponse
	@RequestMapping(value="{musicId}", method = RequestMethod.POST)
	public String createOrUpdate(@PathVariable("musicId") String musicId, @RequestParam("accessToken") String accessToken){
		String userId = this.validationService.getUserIdByAccessToken(accessToken);
		MusicCount musicCount = this.musicCountService.isHeard(userId, musicId);
		if(musicCount == null){
			//创建
			MusicCount count = new MusicCount();
			count.setCount(1);
			count.setMusicId(musicId);
			count.setUserId(userId);
			return JSON.toJSONString(this.musicCountService.save(count));
		}else{
			int currentCount = musicCount.getCount();
			if(currentCount<9){
				//最大到10为止
				musicCount.setCount(currentCount+1);
			}
			return JSON.toJSONString(this.musicCountService.save(musicCount));
		}
		
	}

}
