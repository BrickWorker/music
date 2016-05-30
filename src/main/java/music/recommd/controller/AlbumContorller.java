package music.recommd.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import music.recommd.annotation.JSONResponse;
import music.recommd.model.Singer;
import music.recommd.service.inter.AlbumService;
import music.recommd.service.inter.SingerService;

/**
 * @apiDefine SAlubm 音乐(ALUBM)
 */


@RestController
@RequestMapping(value = "/album", produces = "application/json")
@Transactional
public class AlbumContorller {
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private SingerService singerService;
	
	/**
	 * @api {GET} http://115.28.238.193:8080/music/album/new?page={page}&limit={limit}  1-查询最新专辑
	 * @apiName getNew
	 * @apiGroup SAlubm
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 200 OK 
     * {
     * 			status: 200,
     * 			data: [
     * 				{
     * 					albumDescription: "发行时间：2016-02-02；唱片公司：环球唱片；《青丘狐传说》电视剧插曲",
     * 					albumId: 0,
     * 					albumName: "别惹我哭 ",
     * 					albumPic: "http://p4.music.126.net/GIu2t7Le3JuMQh8a7vdBtQ==/1378787583916309.jpg?param=90y90 ",
     * 					albumPv: null,
     * 					isNew: 0,
     * 				singer: {
	 *							singerBith: 2,
	 *							singerDescription: "3",
	 *							singerId: 0,
	 *							singerName: "郭静",
	 *							singerPic: "http://p4.music.126.net/GIu2t7Le3JuMQh8a7vdBtQ==/1378787583916309.jpg?param=90y90"
	 *							singerSex: 5
	 *						}
	 *				}
	 *				msg: "OK"
	 *							
     * }	
     */
	@JSONResponse
	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String getNew(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "5") Integer limit){
		return JSON.toJSONString(this.albumService.findNew(page, limit),
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.DisableCircularReferenceDetect);
	}
	
	
	/**
	 * @api {GET} http://115.28.238.193:8080/music/album/hot?page={page}&limit={limit}  2-查询最热专辑
	 * @apiName getHot
	 * @apiGroup SAlubm
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 200 OK 
     * {
     *  		status: 200,
     * 			data: [
     * 				{
     * 					albumDescription: "发行时间：2016-02-02；唱片公司：环球唱片；《青丘狐传说》电视剧插曲",
     * 					albumId: 0,
     * 					albumName: "别惹我哭 ",
     * 					albumPic: "http://p4.music.126.net/GIu2t7Le3JuMQh8a7vdBtQ==/1378787583916309.jpg?param=90y90 ",
     * 					albumPv: null,
     * 					isNew: 0,
     * 				singer: {
	 *							singerBith: 2,
	 *							singerDescription: "3",
	 *							singerId: 0,
	 *							singerName: "郭静",
	 *							singerPic: "http://p4.music.126.net/GIu2t7Le3JuMQh8a7vdBtQ==/1378787583916309.jpg?param=90y90"
	 *							singerSex: 5
	 *						}
	 *				}
	 *				msg: "OK"
	 *							
     * }
     */
	
	@JSONResponse
	@RequestMapping(value = "hot", method = RequestMethod.GET)
	public String getHot(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "5") Integer limit){
		return JSON.toJSONString(this.albumService.findHot(page, limit),
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.DisableCircularReferenceDetect);
	}
	
	

	/**
	 * @api {GET} http://115.28.238.193:8080/music/album/{singerId}  3-按歌手查找专辑
	 * @apiName getAlbumBySinger
	 * @apiGroup SAlubm
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 200 OK 
     * {
     * 
     * 		status: 200,
	 *		data: [
	 *				{
	 *					albumDescription: ""发行时间：2016-01-25；发行公司： 种子音乐；爱情无论古与今情意未分人与狐 献给世上为爱情义无反顾的人们 2015年，一位爱唱歌的女孩，披上战袍、首登大型歌唱比赛舞台，她没有攒人热泪的出身背景，亦不为人气汲汲营营，只有一颗真挚的心，为所有仔细聆听她歌唱的听众献唱，她是爱唱歌的女孩 — 关诗敏。 作为第四季《中国好声音》周杰伦「地表最强战队」一员，关诗敏以纯熟的歌唱技巧，张弛有度地演绎不同声音表情，更以天赋的动人嗓音与细腻的声线，挥洒极具个人特质的演唱风格。参与节目的几首作品，皆获得大量网友一致好",
	 *					albumId: 5,
	 *					albumName: "风之恋 ",
	 *					albumPic: "http://p3.music.126.net/sEZmGyrOV_PlPyw70qSGLA==/1420569023363855.jpg?param=90y90 ",
	 *					albumPv: 0,
	 *					isNew: 0,
	 *					singer: {
	 *					singerDescription: "年仅16岁就获得”第一届华人星光大道总冠军”，成为融音乐教父陶喆首位入门女弟子，同时立刻着手为她量身订制首张个人专辑，未发片网络视频破千万次点阅，罗大佑、刘家昌大师级来宾同声盛赞网友一致好评，受封星光宅男女神。2012年发表首张个人专辑《关在家》，由陶喆领军金曲创作和制作组合娃娃、朱敬然、许哲珮、徐佳莹、1976阿凯。",
	 *					singerId: 5,
	 *					singerName: "关诗敏",
	 *					singerPic: "http://p3.music.126.net/sEZmGyrOV_PlPyw70qSGLA==/1420569023363855.jpg?param=90y90"
	 *				}
	 *				}
	 *				],
	 *				msg: "OK"
     * 
     * }
	*/
	//按歌手寻找专辑
	@JSONResponse
	@RequestMapping(value = "{singerId}", method = RequestMethod.GET)
	public String getAlbumBySinger(@PathVariable("singerId") Long singerId){
		Singer singer = this.singerService.findOne(singerId);
		return JSON.toJSONString(this.albumService.findAlbumBySinger(singer));
	}
}
