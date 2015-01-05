import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.http.Consts;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.data.golf.entity.Brassie;
import com.data.golf.entity.Game;
import com.data.golf.entity.GameLog;
import com.data.golf.entity.Position;

public class HttpConnTest {

	private Game game = new Game();
	private ArrayList<GameLog> gameLogList = new ArrayList<GameLog>(); // 18洞的数据

	public static void main(String[] args) throws Exception {

		HttpConnTest connTest = new HttpConnTest();
		//256 dao 286
		for (int i = 0; i < 1; i++) {

			connTest.bulidGame();
		}
		//connTest.getData();
	}

	private void bulidGame() {
		// TODO Auto-generated method stub
		
		game.setUserId("334");
		game.setCourseId("1");
		game.setCaddieId("221");
		
		Random rand = new Random();
		int start = rand.nextInt(5);// 0-16
		
		switch (start) {
		case 0:
			game.setStartPos(Position.GOLDT);
			break;
		case 1:
			game.setStartPos(Position.BLACKT);
			break;
		case 2:
			game.setStartPos(Position.BLUET);
			break;
		case 3:
			game.setStartPos(Position.WHITET);
			break;
		case 4:
			game.setStartPos(Position.REDT);
			break;
		}

		try {
			game.setWeather(URLEncoder.encode("晴", "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		   StringBuffer sbRes = new StringBuffer();
	       HttpClient httpClient = new DefaultHttpClient();// 创建httpClient对象
	        try {
	            // 请求超时
	            httpClient.getParams().setParameter(
	                    CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);
	            // 读取超时
	            httpClient.getParams().setParameter(
	                    CoreConnectionPNames.SO_TIMEOUT, 20000);

	           // http://121.196.141.146/golf/api/bulid_game_old.json?caddie_id=221&user_id=225&course_id=1
	            HttpPost httppost = new HttpPost(
	                    "http://121.196.141.146/golf/test/bulid_game_old.json");
	            httppost.setHeader("user-agent", "golf data center");

	            List<NameValuePair> nvps = new ArrayList<NameValuePair>();  

	            nvps.add(new BasicNameValuePair("user_id", game.getUserId()));  
	            nvps.add(new BasicNameValuePair("caddie_id","221")); 
	            nvps.add(new BasicNameValuePair("course_id", "1")); 
	            nvps.add(new BasicNameValuePair("start_pos", game.getStartPos())); 
	            nvps.add(new BasicNameValuePair("weather", game.getWeather())); 
	            httppost.setEntity(new UrlEncodedFormEntity(nvps));
	            
	            HttpResponse responce = httpClient.execute(httppost);// 得到responce对象
	            
	            int resStatu = responce.getStatusLine().getStatusCode();// 返回码
	            if (resStatu == HttpStatus.SC_OK || resStatu==302 ) {// 200正常 其他就不对
	                // 获得相应实体
	                HttpEntity entity = responce.getEntity();
	                String html = new String(EntityUtils.toString(entity).getBytes(
	                        "ISO-8859-1"), "UTF-8");// 获得html源代码
	                sbRes.append(html.trim());
	                System.out.println("gameId"+html);
	                upGame(html.trim());
	            }
	        } catch (Exception e) {
	            System.out.println("接口调用出错！" + e.getMessage());
	            // 调用小九接口
	        } finally {
	            httpClient.getConnectionManager().shutdown();
	        }
		
		
		
	}
	
	private void upGame(String gameid) {
	
		   StringBuffer sbRes = new StringBuffer();
	       HttpClient httpClient = new DefaultHttpClient();// 创建httpClient对象
	        try {
	            // 请求超时
	            httpClient.getParams().setParameter(
	                    CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);
	            // 读取超时
	            httpClient.getParams().setParameter(
	                    CoreConnectionPNames.SO_TIMEOUT, 20000);

	            HttpPost httppost = new HttpPost(
	                    "http://121.196.141.146:80/golf/test/up_gamelog_old.jsp");
	            httppost.setHeader("user-agent", "Golf data center");
	            List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
	            
	            String json = getData();
	            
	            nvps.add(new BasicNameValuePair("game_id", gameid)); 
	            nvps.add(new BasicNameValuePair("gameLog",  URLEncoder.encode(json, "utf-8")));  
	            nvps.add(new BasicNameValuePair("user_id", game.getUserId())); 
	            nvps.add(new BasicNameValuePair("course_id", game.getCourseId())); 
	            httppost.setEntity(new UrlEncodedFormEntity(nvps,Consts.UTF_8));
	            
	            HttpResponse responce = httpClient.execute(httppost);// 得到responce对象
	            int resStatu = responce.getStatusLine().getStatusCode();// 返回码
	            
	            if (resStatu == HttpStatus.SC_OK) {// 200正常 其他就不对
	                // 获得相应实体
	                HttpEntity entity = responce.getEntity();
	                String html = new String(EntityUtils.toString(entity));// 获得html源代码
	                System.out.println(html);
	            }
	        } catch (Exception e) {
	            System.out.println("接口调用出错！-----" + e.getMessage());
	            // 调用小九接口
	        } finally {
	            httpClient.getConnectionManager().shutdown();
	        }
		
		 

	}

	private String getData() {

		ArrayList<GameLog> gameLogList = new ArrayList<GameLog>(); // 18洞的数据
		Random rand = new Random();
		// 生成70－99之间的随机数
		
		int start = rand.nextInt(5);// 0-14
		
		switch (start) {
		case 0:
			game.setStartPos("金T台");
			break;
		case 1:
			game.setStartPos("黑 T台");
			break;
		case 2:
			game.setStartPos("蓝T台");
			break;
		case 3:
			game.setStartPos("白T台");
			break;
		case 4:
			game.setStartPos("红T台");
			break;
		}
		for (int k = 0; k < 18; k++) {

			int randNum = rand.nextInt(6) + 1;//1-6

			for (int i = 0; i < randNum; i++) {
				
				GameLog gameLog = new GameLog();
				int position = rand.nextInt(30);// 0-24
				switch (position) {
				case 0:
					gameLog.setEndPos(Position.LEFTSAND);
					break;
				case 1:
					gameLog.setEndPos(Position.RIGHTSAND);
					break;
				case 2:
					gameLog.setEndPos(Position.LEFTSANDFAIR);
					break;
				case 3:
					gameLog.setEndPos(Position.RIGHTSANDFAIR);
					break;
				case 4:
					gameLog.setEndPos(Position.LEFTGRASS);
					break;
				case 5:
					gameLog.setEndPos(Position.RIGHTGRASS);
					break;
				case 6:
					gameLog.setEndPos(Position.LEFTWOODS);
					break;
				case 7:
					gameLog.setEndPos(Position.RIGHTWOODS);
					break;

				case 8:
					gameLog.setEndPos(Position.GREEN3);
					break;
					
				case 9:
					gameLog.setEndPos(Position.FAIRWAY);
					break;
					//
					
				case 10:
					gameLog.setEndPos(Position.LEFTSAND);
					break;
				case 11:
					gameLog.setEndPos(Position.RIGHTSAND);
					break;
				case 12:
					gameLog.setEndPos(Position.LEFTSANDFAIR);
					break;
				case 13:
					gameLog.setEndPos(Position.RIGHTSANDFAIR);
					break;
				case 14:
					gameLog.setEndPos(Position.LEFTGRASS);
					break;
				case 15:
					gameLog.setEndPos(Position.RIGHTGRASS);
					break;
				case 16:
					gameLog.setEndPos(Position.LEFTWOODS);
					break;
				case 17:
					gameLog.setEndPos(Position.RIGHTWOODS);
					break;
					
				case 18:
					gameLog.setEndPos(Position.GREEN5);
					break;
					
				case 19:
					gameLog.setEndPos(Position.FAIRWAY);
					break;
					
			//
				case 20:
					gameLog.setEndPos(Position.LEFTLOSS);
					break;
				case 21:
					gameLog.setEndPos(Position.WATER);

					break;
				case 22:
					gameLog.setEndPos(Position.RIGHTLOSS);
					break;
				case 23:
					gameLog.setEndPos(Position.GREEN10);
					break;
				case 24:
					gameLog.setEndPos(Position.GREEN15);
					break;
				case 25:
					gameLog.setEndPos(Position.GREEN20);
					break;
				case 26:
					gameLog.setEndPos(Position.GREEN20M);
					break;
					
				default:
					gameLog.setEndPos(Position.FAIRWAY);
					break;
				}

				// endpos
				if (i == 0) {

					gameLog.setStartPos(game.getStartPos());
					gameLog.setBrassie("1W");
					int distance = rand.nextInt(250) + 80;// 5-84
					gameLog.setDistance(distance);
					
				} else {
					// i=1 gameLogList.size()=1
					gameLog.setStartPos(gameLogList.get(gameLogList.size() -1).getEndPos());
					
					if (gameLogList.get(i - 1).getDistance()==-1) {
						
						gameLog.setStartPos(gameLogList.get(i - 2)
								.getStartPos());
					}
					
					// 果岭
					if(gameLog.getStartPos().contains(Position.GREEN)){
						
						int brase = rand.nextInt(6);// 0-5
						switch (brase) {
						case 0:
							gameLog.setBrassie(Brassie.PW);
							break;
						case 1:
							gameLog.setBrassie(Brassie.PUT);
							break;

						case 2:
							gameLog.setBrassie(Brassie.ANGLE_52);
						case 3:
							gameLog.setBrassie(Brassie.ANGLE_56);
						case 4:
							gameLog.setBrassie(Brassie.ANGLE_58);
						case 5:
							gameLog.setBrassie(Brassie.ANGLE_60);
							break;
						}
						int distance = rand.nextInt(80) + 5;// 5-84
						gameLog.setDistance(distance);
					}else{
						
						int brase = rand.nextInt(14)+2;// 2-15

						switch (brase) {
						case 2:
							gameLog.setBrassie(Brassie.THREE_WOODS);
							break;
						case 3:
							gameLog.setBrassie(Brassie.FIVE_WOODS);
							break;
						case 4:
							gameLog.setBrassie(Brassie.THREE_IRON);
							break;
						case 5:
							gameLog.setBrassie(Brassie.FIVE_IRON);
							break;
						case 6:
							gameLog.setBrassie(Brassie.FIVE_IRON);
							break;
						case 7:
							gameLog.setBrassie(Brassie.SIX_IRON);
							break;
						case 8:
							gameLog.setBrassie(Brassie.SEVEN_IRON);
							break;
						case 9:
							gameLog.setBrassie(Brassie.EIGHT_IRON);
							break;
						case 10:
							gameLog.setBrassie(Brassie.NINE_IRON);
							break;
						case 11:
							gameLog.setBrassie(Brassie.ANGLE_52);
							break;
						case 12:
							gameLog.setBrassie(Brassie.ANGLE_56);
							break;
						case 13:
							gameLog.setBrassie(Brassie.ANGLE_58);
							break;
						case 14:
							gameLog.setBrassie(Brassie.ANGLE_60);
							break;
						case 15:
							gameLog.setBrassie(Brassie.MIX);
							break;
						}
						int distance = rand.nextInt(200) + 5;// 5-84
						gameLog.setDistance(distance);
					}
					
				}
				


				int hit = rand.nextInt(4);// 0-16

				switch (hit) {
				case 0:
					gameLog.setHitPoint("正常");
					break;
				case 1:
					gameLog.setHitPoint("厚");
					break;
				case 2:
					gameLog.setHitPoint("薄");
					break;
				case 3:
					gameLog.setHitPoint("甜点");
					break;

				default:
					break;
				}
				
				
				//罚杆 最后一杆进洞不能是罚杆
				if(i!=randNum-1 && i!=0){
					if(gameLogList.get(gameLogList.size() -1).getEndPos().equals(Position.LEFTLOSS)
							||gameLogList.get(gameLogList.size() -1).getEndPos().equals(Position.RIGHTLOSS)
							||gameLogList.get(gameLogList.size() -1).getEndPos().equals(Position.WATER)){
						
						GameLog gameLog2 = new GameLog();
						gameLog2.setBrassie(Position.PENALTY);
						gameLog2.setHitPoint(Position.PENALTY);
						gameLog2.setStartPos(Position.PENALTY);
						gameLog2.setEndPos(Position.PENALTY);
						gameLog2.setDistance(-1);
						gameLog2.setBrand("泰勒梅");
						gameLog2.setHoleId(k + 1 + "");
						gameLogList.add(gameLog2);
					}
					
				}
				
				// 最后一杆进洞
				if(i==randNum-1){
					
					gameLog.setStartPos(Position.GREEN10);
					int brase = rand.nextInt(6);// 0-5
					switch (brase) {
					case 0:
						gameLog.setBrassie(Brassie.PW);
						break;
					case 1:
						gameLog.setBrassie(Brassie.PUT);
						break;

					case 2:
						gameLog.setBrassie(Brassie.ANGLE_52);
					case 3:
						gameLog.setBrassie(Brassie.ANGLE_56);
					case 4:
						gameLog.setBrassie(Brassie.ANGLE_56);
					case 5:
						gameLog.setBrassie(Brassie.ANGLE_60);
						break;
					}
					int distance = rand.nextInt(80) + 5;// 5-84
					gameLog.setDistance(distance);
					gameLog.setEndPos(Position.HOLE);
				}
				gameLog.setBrand("泰勒梅");
				gameLog.setHoleId(k + 1 + "");
				gameLogList.add(gameLog);
			}

		}
		String json = (String) JSON.toJSONString(gameLogList);
		json = (String) JSON.toJSONString(gameLogList);
		System.out.println(json);
		return json;
	}
}
