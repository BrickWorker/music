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
import music.recommd.service.inter.AlbumService;

/**
 * @apiDefine SAlubm 音乐(ALUBM)
 */


@RestController
@RequestMapping(value = "/album", produces = "application/json")
@Transactional
public class AlbumContorller {
	
	@Autowired
	private AlbumService albumService;
	
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
	
	

}
