import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.data.golf.entity.Brassie;
import com.data.golf.entity.Game;
import com.data.golf.entity.GameLog;
import com.data.golf.entity.Position;

public class getCourse {

	private Game game = new Game();
	private ArrayList<GameLog> gameLogList = new ArrayList<GameLog>(); // 18洞的数据
	public static final String SPLIT=";..;";
	public static void main(String[] args) throws Exception {

		getCourse connTest = new getCourse();

/*		connTest.getCourse("重庆");
		connTest.getCourse("河北");
		connTest.getCourse("山西");
		connTest.getCourse("台湾");
		connTest.getCourse("辽宁");
		connTest.getCourse("吉林");
		connTest.getCourse("黑龙江");
		connTest.getCourse("江苏");
		connTest.getCourse("浙江");
		connTest.getCourse("安徽");
		connTest.getCourse("福建");*/
		String citys [] ={"北京","天津","上海","重庆","河北","山西","台湾","辽宁","吉林","黑龙江","江苏","浙江","安徽","福建","江西", "山东", "河南","湖北","湖南","广东","甘肃",
				"四川","贵州","海南","云南", "青海","陕西","广西","西藏","宁夏","新疆","内蒙古","澳门","香港",};
/*		for(String city :citys){
			connTest.getCourse(city);
		}*/
	    String arch = System.getProperty("sun.arch.data.model");
	    System.out.println(arch);
		/*String ss="北京CBD国际高尔夫俱乐部;..;1";
		String[] sss= ss.split(";..;");
		System.out.println(sss[0]);*/


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

	private void getCourse(String state) {
		// TODO Auto-generated method stub
		

		
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
	                    "http://121.196.141.146/golf/test/select_course1.json"+"?state="+state);
	            httppost.setHeader("user-agent", "golf data center");

	            List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
	         
	            nvps.add(new BasicNameValuePair("state", state));  
	           
	           // httppost.setEntity(new UrlEncodedFormEntity(nvps));
	            
	            HttpResponse responce = httpClient.execute(httppost);// 得到responce对象
	            
	            int resStatu = responce.getStatusLine().getStatusCode();// 返回码
	            System.out.println("resStatu"+resStatu);
	            if (resStatu == HttpStatus.SC_OK || resStatu==302 ) {// 200正常 其他就不对
	                // 获得相应实体
	                HttpEntity entity = responce.getEntity();
	                String html = new String(EntityUtils.toString(entity).getBytes(
	                        "UTF-8"), "UTF-8");// 获得html源代码
	                sbRes.append(html.trim());
	                System.out.println("gameId"+html);
	                JSONObject job =  (JSONObject) JSONObject.parse(html);
	                JSONArray jr = job.getJSONArray("golf_course");
	                List<Cc> ccs =JSON.parseArray(jr.toJSONString(), Cc.class);
	                BufferedWriter bw = new BufferedWriter(new FileWriter("d:\\"+1+".txt", true));
	                // +"\r\n"
	                int i= 0;
	                for(Cc c:ccs){
	                	if(i==0){
	                		
	                		bw.write("rlist = new ArrayList<String>();"+"\r\n"); 
	                		bw.write("rlist.add(" +"\"" +"所有球场"+"\");"+"\r\n"); 
	                	}
	                	i++;
	                	bw.write("rlist.add(" +"\"" +c.getC_name()+SPLIT+c.getWeId()+"\");"+"\r\n"); 
	                	if(i==ccs.size()){
	                		bw.write("map.put("+"\"" +state+"\"" +", rlist);"+"\r\n");
	                		
	                	}
	                }
	               
	                bw.flush();
	                bw.close();
	                
	            }
	        } catch (Exception e) {
	            System.out.println("接口调用出错！" + e.getMessage());
	            BufferedWriter bw =null;
            		try {
            			bw = new BufferedWriter(new FileWriter("d:\\"+1+".txt", true));
						bw.write("rlist = new ArrayList<String>();"+"\r\n");
						bw.write("rlist.add(" +"\"" +"所有球场"+"\");"+"\r\n"); 
						bw.write("map.put("+"\"" +state+"\"" +", rlist);"+"\r\n");
						bw.flush();
			            bw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
            		
	            // 调用小九接口
	        } finally {
	            httpClient.getConnectionManager().shutdown();
	        }
		
		
		
	}
	

}
