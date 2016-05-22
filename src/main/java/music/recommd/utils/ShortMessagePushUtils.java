package music.recommd.utils;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class ShortMessagePushUtils {
	
	private static String url = "http://gw.api.taobao.com/router/rest";	//淘宝开放平台url
	
	private static String appkey = "23241254";	//应用的appkey
	
	private static String secret = "41622f6b4c7464dee96ab9d4bcfed0ab";	//应用的appSecret
	
	private static String sessionKey = "";
	
	public static String sendMessage(String phone,String code){
		String result = "";
		TaobaoClient client=new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req=new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend("123456");
		req.setSmsType("normal");
		req.setSmsFreeSignName("半米科技");
		req.setSmsParam("{\"xxxxxx\":\""+code+"\"}");
		req.setRecNum(phone);
		req.setSmsTemplateCode("SMS_395004");
		try {
			AlibabaAliqinFcSmsNumSendResponse response = client.execute(req , sessionKey);
			result = response.getBody();
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		sendMessage("15757115779","1234");
	}
}
