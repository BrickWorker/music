package music.recommd.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import music.recommd.model.MusicCount;
import music.recommd.model.User;

public class DataAnalysis {
	private final static Logger logger = LoggerFactory.getLogger(DataAnalysis.class);
	
	public static Map<Double, User> getSimilarity(User user1, User user2, List<MusicCount> musicList1, List<MusicCount> musicList2, int type){
		logger.info("===================开始相似度计算=====================");
		logger.info(".");
		logger.info(".");
		logger.info(".");
		logger.info(".");
		logger.info(".");
		logger.info(".");
		logger.info(".");
		double result = 0.0d; //相似度结果
		int commonItems = 0;//相同音乐
		if(type == 1){
			logger.info("第一种相似度计算方式=========》》");
			logger.info("该种计算方式#没有#考虑用户两者之间的听过的共同歌曲的数量");
			for (MusicCount music1 : musicList1) {
				for (MusicCount music2 : musicList2) {
					if(music1.getMusicId().equals(music2.getMusicId())){
						commonItems++;
						result += Math.pow((music1.getCount()-music2.getCount()), 2); //打分的差的评分求和
					}
				}
			}
			//如果两者的相似条目为0，那么相似度为0
			if(commonItems > 0){
				result = Math.sqrt(result/(double)commonItems);
				result = 1.0d - Math.tanh(result);
			}
		}else{
			logger.info("第二种相似度计算方式=========》》");
			logger.info("该种计算方式#需要#考虑用户两者之间的听过的共同歌曲的数量");
			for (MusicCount music1 : musicList1) {
				for (MusicCount music2 : musicList2) {
					if(music1.getMusicId() == music2.getMusicId()){
						commonItems++;
						result += Math.pow((music1.getCount()-music2.getCount()), 2); //打分的差的评分求和
					}
				}
			}
			//如果两者的相似条目为0，那么相似度为0
			if(commonItems > 0){
				result = Math.sqrt(result/(double)commonItems);
				result = 1.0d - Math.tanh(result);
				logger.info("开始考虑用户之间的相同条目对相似度的影响程度");
				int theMaxItems = Math.min(musicList1.size(), musicList2.size());
				logger.info("在用户A和用户B之间取最小值，减小偶然性");
				result = result*((double)commonItems/(double)theMaxItems);
			}
		}
		logger.info(".");
		logger.info(".");
		logger.info(".");
		logger.info(".");
		logger.info(".");
		logger.info(".");
		logger.info(".");
		logger.info(".");
		logger.info("计算完成，开始打印结果");
		logger.info("用户："+user1.getName()+" 和用户："+user2.getName()+" 之间 的相似度为"+result);
		logger.info("=====================================end============================================");
		//处理结果
		Map<Double, User> resultMap = new HashMap<Double, User>();
		resultMap.put(result, user2);
		return resultMap;
	}
}
