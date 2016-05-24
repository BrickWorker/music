package music.recommd.controller;

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
import music.recommd.service.inter.MusicService;
import music.recommd.service.inter.SingerService;

/**
 * @apiDefine SSinger 音乐(SINGER)
 */

@RestController
@RequestMapping(value = "/singer", produces = "application/json")
public class SingerController {
	
	@Autowired
	private SingerService singerService;
	
	@Autowired
	private MusicService musicService;
	
	/**
	 * @api {GET} http://115.28.238.193:8080/music/singer?page={page}&limit={limit}  1-查询所有歌手
	 * @apiName getAll
	 * @apiGroup SSinger
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 200 OK 
     * {
     * 			status: 200,
     * 			data:[
     * 				{
     * 					singerBith: null,
     * 					singerDescription: "GALA是由4个80年代出生的青年组成，是一支只用吉他来创造美妙旋律的乐队。成员有苏朵、苏依拉、石亮、于政。他们的一首《YOUNG FOR YOU》是大家都较为熟知的歌曲。2012年4月8日，获得第十二届音乐风云榜年度盛典最佳摇滚乐队。GALA是一支只用吉他来创造美妙旋律的乐队。这是四个对音乐充满热情又执迷不悟的小伙子。
     * 					singerId: 47,
     * 					singerName: "GALA",
     * 					singerPic: "http://p4.music.126.net/ieMiipix9uyP6lgc3jC6VQ==/3229265650823140.jpg?param=640y300",
     * 					singerSex: 1
     * 					}
     * 			]
     * }
     */

	
	@JSONResponse
	@RequestMapping(method = RequestMethod.GET)
	public String getAll(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "5") Integer limit){
		return JSON.toJSONString(this.singerService.findAll(page, limit),
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.DisableCircularReferenceDetect);
	}
	
	//TODO 按歌手寻找歌单
	/**
	 * @api {GET} http://115.28.238.193:8080/music/singer/{id}   2-按歌手寻找歌单
	 * @apiName getMusicBysinger
	 * @apiGroup SSinger
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 200 OK 
     * {
     * 		"status":200
     *  	"data":[
     *  		{
     *  			musicAddress: "http://m10.music.126.net/20160513130848/0c11a527d07663ac39d48fdc3a30eb87/ymusic/8435/74b7/c4b4/2ee5f91f91e59cef4ebaf46ef5566d27.mp3",
     *  			musicAlbum: {albumDescription: ""发行时间：1999-01-01；发行公司： 麦田音乐；那一年，一个看上去与这个世界颇有些格格不入的青年带着一盘全新的专辑出现在我们面前，将我们带入一个全新的时代，"
     *  			albumId: 36,
     *  			albumName: "我去2000年 ",
     *  			albumPic: "http://p4.music.126.net/2KL6NzROawvUWX1kzM3vmA==/129742372092472.jpg?param=90y90 ",
     *  			singer: {
     *  				singerId: 37,
     *  				singerName: "朴树",
     *  				singerPic: "http://p4.music.126.net/2KL6NzROawvUWX1kzM3vmA==/129742372092472.jpg?param=90y90"
     *  			}
     *  		},
     *  		musicDload: "0",
     *  		musicId: 200,
     *  		musicName: "火车开往冬天",
     *  		musicPv: 0,
     *  		musicSinger: {
     *  			singerId: 37,
     *  			singerName: "朴树",
     *  			singerPic: "http://p4.music.126.net/2KL6NzROawvUWX1kzM3vmA==/129742372092472.jpg?param=90y90"
     *  			}
     *  		musicType: "112109"
     *  		},
     *  		{
     *  			musicAddress: "http://m10.music.126.net/20160513130848/0c11a527d07663ac39d48fdc3a30eb87/ymusic/8435/74b7/c4b4/2ee5f91f91e59cef4ebaf46ef5566d27.mp3",
     *  			musicAlbum: {albumDescription: ""发行时间：1999-01-01；发行公司： 麦田音乐；那一年，一个看上去与这个世界颇有些格格不入的青年带着一盘全新的专辑出现在我们面前，将我们带入一个全新的时代，"
     *  			albumId: 36,
     *  			albumName: "我去2000年 ",
     *  			albumPic: "http://p4.music.126.net/2KL6NzROawvUWX1kzM3vmA==/129742372092472.jpg?param=90y90 ",
     *  			singer: {
     *  				singerId: 37,
     *  				singerName: "朴树",
     *  				singerPic: "http://p4.music.126.net/2KL6NzROawvUWX1kzM3vmA==/129742372092472.jpg?param=90y90"
     *  			}
     *  		},
     *  		musicDload: "0",
     *  		musicId: 200,
     *  		musicName: "火车开往冬天",
     *  		musicPv: 0,
     *  		musicSinger: {
     *  			singerId: 37,
     *  			singerName: "朴树",
     *  			singerPic: "http://p4.music.126.net/2KL6NzROawvUWX1kzM3vmA==/129742372092472.jpg?param=90y90"
     *  			}
     *  		musicType: "112109"
     *  		}
     * }
     */
	@JSONResponse
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String getMusicBySinger(@PathVariable("id") Long id){
		Singer singer = this.singerService.findOne(id);
		return JSON.toJSONString(this.musicService.findBySinger(singer),
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.DisableCircularReferenceDetect);
	}
}
