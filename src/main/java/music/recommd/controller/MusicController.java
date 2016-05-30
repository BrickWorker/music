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
import music.recommd.model.Album;
import music.recommd.model.Music;
import music.recommd.service.inter.AlbumService;
import music.recommd.service.inter.MusicService;

/**
 * @apiDefine Smusic 音乐(MUSIC)
 */

@RestController
@RequestMapping(value = "/music", produces = "application/json")
@Transactional
public class MusicController {
	
	@Autowired
	private MusicService musicService;
	
	@Autowired
	private AlbumService albumService;
	
	
	/**
	 * @api {GET} http://115.28.238.193:8080/music/music?page={page}&limit={limit}  1-查询所有音乐
	 * @apiName getAll
	 * @apiGroup Smusic
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 200 OK 
     * {
     * 		//page（默认第0页）表示第几页，从第0页开始，limit（默认5条）表示页面大小。
     *  	"status":200
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
     *          .
     *          .
     *          .
     *          .
     *          .
     *          .
     *  
     *  	],
     *  msg: "OK"
     * }
	 */
	@JSONResponse
	@RequestMapping(method = RequestMethod.GET)
	public String getAll(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "5") Integer limit){
		return JSON.toJSONString(this.musicService.findAll(page, limit),
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.DisableCircularReferenceDetect);
	}
	
	/**
	 * @api {GET} http://115.28.238.193:8080/music/length 7-查询音乐总数
	 * @apiName getLength
	 * @apiGroup Smusic
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 200 OK 
     * {
     *  	"status":200
     *  	"data":[
     *  			"length":"203"
     *  	],
     *  msg: "OK"
     * }
	 */
	
	//查询所有音乐长度的接口
	@JSONResponse
	@RequestMapping(value = "length", method = RequestMethod.GET)
	public String getAll(){
		return JSON.toJSONString(this.musicService.findLength());
	}
	
	/**
	 * @api {GET} http://115.28.238.193:8080/music/music/type/{typeId}?page={page}&limit={limit}  2-查询音乐类型
	 * @apiName getTypeAll
	 * @apiGroup Smusic
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 200 OK 
     * {
     * 		//page（默认第0页）表示第几页，从第0页开始，limit（默认5条）表示页面大小。
     *		//type 有2中情况 100000	华语      
	 *		//				200000	欧美
	 *		//				300000	日语
	 *		//				400000	韩语
	 *		//				500000	粤语
	 *						1	流行
	 *						2	摇滚
	 *						3	民谣
	 *						4	电子
	 *						5	舞曲
	 *						6	说唱
	 *						7	轻音乐
	 *						8	爵士
	 *						9	乡村
	 *						10	古典
	 *						11	民族
	 *						12	英伦
	 *						13	金属
	 *						14	古风
     *  	"status":200
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
     *          .
     *          .
     *          .
     *          .
     *          .
     *          .
     *  
     *  	],
     *  msg: "OK"
     * }
	 */
	//分页获取不通类型的音乐
	@JSONResponse
	@RequestMapping(value = "type/{typeId}", method = RequestMethod.GET)
	public String getTypeMusic(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "5") Integer limit, @PathVariable(value = "typeId") String type){
		return JSON.toJSONString(this.musicService.findByType(type, page, limit),
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.DisableCircularReferenceDetect);
	}
	
	
	/**
	 * @api {GET} http://115.28.238.193:8080/music/music/type/new?page={page}&limit={limit}  3-查询最新音乐
	 * @apiName getNew
	 * @apiGroup Smusic
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 200 OK 
     * {
     * 		//page（默认第0页）表示第几页，从第0页开始，limit（默认5条）表示页面大小。
     *  	"status":200
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
     *          .
     *          .
     *          .
     *          .
     *          .
     *          .
     *  
     *  	],
     *  msg: "OK"
     * }
	 */
	
	//新碟上架
	@JSONResponse
	@RequestMapping(value = "type/new", method = RequestMethod.GET)
	public String getNew(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "5") Integer limit){
		return JSON.toJSONString(this.musicService.findByIsNew(page, limit),
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.DisableCircularReferenceDetect);
	}
	
	
	/**
	 * @api {POST} http://115.28.238.193:8080/music/music/pv/count/{musicId}  4-音乐PV接口
	 * @apiName musicCount
	 * @apiGroup Smusic
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 200 OK 
     * {
     *  	"status":200
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
     *  		musicPv: 1, //其实就是改变这个字段
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
     *          .
     *          .
     *          .
     *          .
     *          .
     *          .
     *  
     *  	],
     *  msg: "OK"
     * }
	 */
	
	//PV接口
	@JSONResponse
	@RequestMapping(value = "pv/count/{musicId}", method = RequestMethod.POST)
	public String pvCount(@PathVariable(value = "musicId") Long musicId){
		Music music = this.musicService.findOne(musicId);
		music = this.musicService.countPv(music);
		return JSON.toJSONString(this.musicService.save(music));
	}
	
	
	
	/**
	 * @api {GET} http://115.28.238.193:8080/music/music/hot?page={page}&limit={limit}  5-查询最热音乐
	 * @apiName getHot
	 * @apiGroup Smusic
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 200 OK 
     * {
     * 		//page（默认第0页）表示第几页，从第0页开始，limit（默认5条）表示页面大小。
     *  	"status":200
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
     *          .
     *          .
     *          .
     *          .
     *          .
     *          .
     *  
     *  	],
     *  msg: "OK"
     * }
	 */
	//获取热门音乐
	
	@JSONResponse
	@RequestMapping(value = "hot", method = RequestMethod.GET)
	public String getHot(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "limit", required = false, defaultValue = "5") Integer limit){
		return JSON.toJSONString(this.musicService.findHot(page, limit),
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.DisableCircularReferenceDetect);
	}
	
	
	
	/**
	 * @api {GET} http://115.28.238.193:8080/music/music/{ablumId} 6-按专辑获取音乐
	 * @apiName getMusicByAlbum
	 * @apiGroup Smusic
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 200 OK 
     * {
     *  	"status":200
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
     *          .
     *          .
     *          .
     *          .
     *          .
     *          .
     *  
     *  	],
     *  msg: "OK"
     * }
	 */
	//按专辑获取音乐
	
	@JSONResponse
	@RequestMapping(value = "{albumId}", method = RequestMethod.GET)
	public String getMusicByAlbum(@PathVariable("albumId") Long albumId){
		Album album = this.albumService.findOne(albumId);
		return JSON.toJSONString(this.musicService.findByAlbum(album),
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteEnumUsingToString,
				SerializerFeature.DisableCircularReferenceDetect);
	}
	
}
