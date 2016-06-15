package music.recommd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import music.recommd.annotation.JSONResponse;
import music.recommd.model.Music;
import music.recommd.model.MusicCount;
import music.recommd.model.User;
import music.recommd.service.inter.MusicCountService;
import music.recommd.service.inter.UserService;
import music.recommd.service.inter.ValidationService;
import music.recommd.utils.DataAnalysis;
import music.recommd.utils.DealMapAnalysis;



/**
 * @apiDefine SmusicCount 音乐打分系列(MUSICCOUNT)
 */


@RestController
@RequestMapping(value = "/musicCount", produces = "application/json")
@Transactional
public class MusicCountController {
	
	private final static Logger logger = LoggerFactory.getLogger(MusicCountController.class);
	
	@Autowired
	private ValidationService validationService;
	
	@Autowired
	private MusicCountService musicCountService;
	
	
	@Autowired
	private UserService userService;
	
	
	
	
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
	
	/**
	 * @api {GET} http://115.28.238.193/musicCount/getSimilarity?accessToken={}&type={type} 2-用户音乐相似度计算
	 * @apiName getSimilarity
	 * @apiGroup SmusicCount
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 CREATE
     * {
     *    {
  	 *			"status" : 200,
  	 *			"data" : {
  	 * 					{
	 *						isCollect: 0,
	 *						isNew: 1,
	 *						musicAddress: "http://m2.music.126.net/4iHN8XdfvXAffG0aiIJsOA==/6672936069027865.mp3",
	 *						musicAlbum: {
	 *						albumDescription: ""发行时间：1999-01-01；发行公司： 麦田音乐；那一年，一个看上去与这个世界颇有些格格不入的青年带着一盘全新的专辑出现在我们面前，将我们带入一个全新的时代，这就是麦田旗下新人朴树推出的红白蓝专辑之二《我去2000 年》。 专辑中收录了曾在中央人民广播电台以及中国原创歌曲总榜创下佳绩的《白桦林》和《NEWBOY》，而《我去两千年》、《旅途》、《那些花儿》等优秀作品不仅昭示了朴树极具浪漫的忧郁情调，更暴露出新类摇滚的风格信息。" ",
	 *						albumId: 36,
	 *						albumName: "我去2000年 ",
	 *						albumPic: "http://p4.music.126.net/2KL6NzROawvUWX1kzM3vmA==/129742372092472.jpg?param=90y90 ",
	 *						albumPv: 8,
	 *						isNew: 1,
	 *						singer: {
	 *						singerDescription: "中国大陆歌手，音乐人。1996年10月正式成为“麦田音乐”签约歌手，为简略笔划而定艺名朴树。首支单曲《火车开往冬天》，96年底推出后成绩斐然。99年1月，推出首张个人专辑《我去两千年》。99年12月与华纳唱片正式签订唱片合约，成为其亚太区旗下的第一位内地歌手，其首张专辑《我去两千年》将由华纳重新混录和拍摄最新单曲录影带后，于2000年上半年在海外隆重上市。代表作品：《那些花儿》，《白桦林》，《生如夏花》。主要成就：中歌榜最佳新人奖，最受欢迎男歌手，年度最佳制作人奖。　",
	 *						singerId: 37,
	 *						singerName: "朴树",
	 *						singerPic: "http://p4.music.126.net/2KL6NzROawvUWX1kzM3vmA==/129742372092472.jpg?param=90y90"
	 *						}
	 *						},
	 *						musicDload: "0",
	 *						musicId: 199,
	 *						musicName: "白桦林",
	 *						musicPv: 7,
	 *						musicSinger: {
	 *						$ref: "$[0].musicAlbum.singer"
	 *						},
	 *						musicType: "112109"
	 *						},
  	 * 				 }, 
  	 *			"msg" : "OK"
	 *			}
     * }
	 */

	@JSONResponse
	@RequestMapping(value="getSimilarity", method = RequestMethod.GET)
	public String getSimilarity(@RequestParam("accessToken") String accessToken,
			@RequestParam("type") Integer type){
		//存储获得的相似度
		Map<Double, User> resultMap = new HashMap<Double, User>();
		User user = this.validationService.getUserByAccessToken(accessToken);
		//获取所有用户
		List<User> userList = this.userService.getAll();
		logger.info("获取用户"+user.getName()+"的个人信息");
		List<MusicCount> musicCount = this.musicCountService.getMusicCountAll(user.getUserId());
		for (User compareUser : userList) {
			logger.info("获取用户"+compareUser.getName()+"的个人信息");
			List<MusicCount> musicCount2 = this.musicCountService.getMusicCountAll(compareUser.getUserId());
			resultMap.putAll(DataAnalysis.getSimilarity(user, compareUser, musicCount, musicCount2, type));
		}
		//处理计算结果
		User nearestUser = DealMapAnalysis.getMaxSimilarity(resultMap);
		Set<Music> resultMusic = nearestUser.getuserCollect();
		return JSON.toJSONString(resultMusic,
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.DisableCircularReferenceDetect);
	}
}
