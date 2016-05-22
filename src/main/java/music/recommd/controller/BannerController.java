package music.recommd.controller;

import javax.transaction.Transactional;

import org.omg.CORBA.COMM_FAILURE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import music.recommd.annotation.JSONResponse;
import music.recommd.service.inter.BannerService;
import music.recommd.utils.CommonConst;


/**
 * @apiDefine Sbanner 广告模块(BANNER)
 */

@RestController
@RequestMapping(value = "/banner", produces = "application/json")
@Transactional
public class BannerController {
	
	@Autowired
	private BannerService bannerService;

	/**
	 * @api {GET} http://115.28.238.193:8080/music/banner  1-查询所有广告
	 * @apiName getAll
	 * @apiGroup Sbanner
	 * @apiSuccessExample {json} Success-Response: HTTP/1.1 200 OK 
     * {
     *  	"status":200
     *  	"data":[
     *  		{
     *  			"bannerId":5,
     *  			"bannerPic": "http://p3.music.126.net/xzR5BGu5KkjwZS2tgUdPRg==/1400777823690676.jpg",
     *  			"bannerType":"0"  //广告类型0表示静态图不跳转 1表示跳转URL 2表示跳转某个音乐
     *  			
     *  		},
     *  		{
     *  			"bannerId":4,
     *  			"bannerPic": "http://p3.music.126.net/ovGtKuxRswFgr2VwfzsNuA==/1371091009424506.jpg",
     *  			"bannerType":"2"
     *  		}	
     *  
     *  	]
     * 
     * 
     * 
     * }
	 */
	
	@JSONResponse
	@RequestMapping(method = RequestMethod.GET)
	public String getAll(){
		return JSON.toJSONString(this.bannerService.findAll(CommonConst.DEFAULT_START_PAGE, CommonConst.DEFAULT_SIZE));
	}
}
