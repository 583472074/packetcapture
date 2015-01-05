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

public class AddUser {

	private Game game = new Game();
	private ArrayList<GameLog> gameLogList = new ArrayList<GameLog>(); // 18洞的数据

	public static void main(String[] args) throws Exception {

		AddUser connTest = new AddUser();
		connTest.bulidGame();

		for (int i = 0; i < 10; i++) {

			connTest.bulidGame();
		}
		//connTest.getData();
		
/*		 URL url = new
		 //URL("http://121.196.141.146/golf/api/course_list.json?city=北京");
		 URL("http://121.196.141.146/golf/api/bulid_game_old.json?caddie_id=221&user_id=223&course_id=1");
		 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		 conn.setRequestProperty("user-agent", "Golf data center");
		 conn.setDoInput(true); conn.setDoOutput(true); conn.connect();
		 DataOutputStream out = new DataOutputStream(conn .getOutputStream());
		 // The URL-encoded contend // 正文，正文内容其实跟get的URL中 '? '后的参数字符串一致 String
		 String content = "account=" + URLEncoder.encode("一个大肥人", "UTF-8"); 
		 content+="&pswd="+URLEncoder.encode("两个个大肥人", "UTF-8");;
		 //将字符串中的16位的unicode字符以8位的字符形式写到流里面 out.writeBytes(content); //打印相应内容
		 BufferedReader br = new BufferedReader(new
		 InputStreamReader(conn.getInputStream(),"UTF-8")); String str = null;
		 while((str = br.readLine()) != null){ System.out.println(str); }
		 conn.disconnect();*/
		 

	}

	private void bulidGame() {
		// TODO Auto-generated method stub
		
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
		game.setUserId("225");
		game.setCourseId("1");
		game.setCaddieId("221");
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
	                    "http://121.196.141.146/golf/usr/regist.tst");
	            httppost.setHeader("user-agent", "golf data center");

	            List<NameValuePair> nvps = new ArrayList<NameValuePair>();  

	            String chars = "abcdefghijklmnopqrstuvwxyz";
	            String chars1 = "赵钱孙 李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张";
	            
	            System.out.println(chars.charAt((int)(Math.random() * 26)));
	            nvps.add(new BasicNameValuePair("knickname", chars1.charAt((int)(Math.random() * (chars1.length()-1)))+""+chars.charAt((int)(Math.random() * 26))+"")); // 昵称 
	            
	            int distance = rand.nextInt(250) + 80;// 5-84
	           
	            String  mob =  139+ ""+(rand.nextInt(999)+1000)+""+(rand.nextInt(999)+1000);
	            System.out.println(mob);
	            
	            
	            nvps.add(new BasicNameValuePair("kusername",mob));//手机
	            nvps.add(new BasicNameValuePair("ksex", "M")); 
	            nvps.add(new BasicNameValuePair("kcountry", "中国")); 
	            nvps.add(new BasicNameValuePair("kprovince", "天津")); 
	            nvps.add(new BasicNameValuePair("kregion", "天津")); 
	            nvps.add(new BasicNameValuePair("kpassword", "123456")); 
	            
	            httppost.setEntity(new UrlEncodedFormEntity(nvps,Consts.UTF_8));
	            
	            HttpResponse responce = httpClient.execute(httppost);// 得到responce对象
	            
	            int resStatu = responce.getStatusLine().getStatusCode();// 返回码
	            System.out.println("resStatu"+resStatu);
	            if (resStatu == HttpStatus.SC_OK || resStatu==302 ) {// 200正常 其他就不对
	                // 获得相应实体
	                HttpEntity entity = responce.getEntity();
	                String html = new String(EntityUtils.toString(entity).getBytes(
	                        "ISO-8859-1"), "UTF-8");// 获得html源代码
	                sbRes.append(html.trim());
	                System.out.println("gameId"+html);
	               
	            }
	        } catch (Exception e) {
	            System.out.println("接口调用出错！" + e.getMessage());
	            // 调用小九接口
	        } finally {
	            httpClient.getConnectionManager().shutdown();
	        }
		
		
		
	}
	



}
