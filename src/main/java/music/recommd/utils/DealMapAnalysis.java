package music.recommd.utils;

import java.util.Map;
import java.util.Set;

import music.recommd.model.User;

public class DealMapAnalysis {
	
	public static User getMaxSimilarity(Map<Double, User> map){
		//遍历所有，返回倒数第二个大的User
			Set<Double> doubleSet = map.keySet();
			Double result = 0.0;
			for (Double currentDouble : doubleSet) {
				if(currentDouble !=1){
					if(currentDouble > result){
						result = currentDouble;
					}
				}
			}
			//拿到最大的KEY值
			return map.get(result);
	}

}
