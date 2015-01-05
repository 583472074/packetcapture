import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.data.golf.entity.Brassie;
import com.data.golf.entity.Game;
import com.data.golf.entity.GameLog;
import com.data.golf.entity.Position;

public class getSchool {

	private Game game = new Game();
	private ArrayList<GameLog> gameLogList = new ArrayList<GameLog>(); // 18洞的数据
	public static final String SPLIT=";..;";
	public static void main(String[] args) throws Exception {

		getSchool connTest = new getSchool();

		
		connTest.getCourse();
	
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

	private void getCourse() {
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

	          
	            HttpPost httppost = new HttpPost("http://jiaowu.zzuli.edu.cn/jwweb/ZNPK/KBFB_ClassSel_rpt.aspx");

	            httppost.setHeader("Host","jiaowu.zzuli.edu.cn");  
	           httppost.setHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0");
	           httppost.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");  
	           httppost.setHeader("Accept-Language","zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");  
	           httppost.setHeader("Accept-Encoding","gzip, deflate");  
	           httppost.setHeader("Referer", "http://jiaowu.zzuli.edu.cn/jwweb/ZNPK/KBFB_ClassSel.aspx");  
	           httppost.setHeader("Content-Type","application/x-www-form-urlencoded");  
	           httppost.setHeader("Pragma","no-cache");  
	           httppost.setHeader("Cache-Control","no-cache");  
	          // httppost.setHeader("Content-Length","143");  
	           httppost.setHeader("Cookie", "ASP.NET_SessionId=tpqc0kngmvn1mx45t1kmvr55");  
	           httppost.setHeader("Connection", "keep-alive");  
	           
	           
	            
	           List<NameValuePair> nvps = new ArrayList<NameValuePair>();  
	           nvps.add(new BasicNameValuePair("Sel_XNXQ", "20140"));  //院系
	           nvps.add(new BasicNameValuePair("Sel_XZBJ", "2011120102"));  //班级
	           
	           //Sel_XNXQ 入学年纪 20140       2014-2015级    第一上学期
	           //2011131402       级 13年-14年  0代表互联网  2班级
	           
	          // 20111 "2011120202"  国商1102
	          // 20111 "2011120102"  互联网1102
	           
/*	           nvps.add(new BasicNameValuePair("Sel_XNXQ", "20130"));  
	           nvps.add(new BasicNameValuePair("Sel_XZBJ", "2011131402"));  
*/	           //nvps.add(new BasicNameValuePair("txtxzbj", "2013131701"));  
	          // nvps.add(new BasicNameValuePair("XZBJ", "2013131701"));  
	           //nvps.add(new BasicNameValuePair("xzbj", "2013131701"));  
	           //nvps.add(new BasicNameValuePair("xzbj", "2013131701"));  
	           nvps.add(new BasicNameValuePair("type", "1")); // 2012131702
	           nvps.add(new BasicNameValuePair("Submit01", "%BC%EC%CB%F7")); 
	           httppost.setEntity(new UrlEncodedFormEntity(nvps));
	            
	           HttpResponse responce = httpClient.execute(httppost);// 得到responce对象
	            
	           int resStatu = responce.getStatusLine().getStatusCode();// 返回码
	           System.out.println("resStatu"+resStatu);
 
	           
	            
	            if (resStatu == HttpStatus.SC_OK || resStatu==302 ) {// 200正常 其他就不对
	                // 获得相应实体
		    		HttpEntity entity = responce.getEntity();
		    		Header header = entity.getContentEncoding();
		    		if (header != null)
		    		{
		    			HeaderElement[] codecs = header.getElements();
		    			for (int i = 0; i < codecs.length; i++)
		    			{
		    				if (codecs[i].getName().equalsIgnoreCase("gzip"))
		    				{
		    					System.out.println("zipopppppp");
		    					responce.setEntity(new GzipDecompressingEntity(entity));
		    				}
		    			}
		    		}
	            	
	            	
	                
	                String html = new String(EntityUtils.toString(entity).getBytes(
	                        "UTF-8"), "UTF-8");// 获得html源代码
	                sbRes.append(html.trim());
	              //  System.out.println(html);
	                
	                System.out.println("过滤html标签----------");
	                Document doc = Jsoup.parse(html.trim());
	                Elements trs = doc.select("TABLE");
	                Elements trs1 = trs.select("TABLE");
	                //System.out.println(trs1);
	                //Elements trs = doc.select("TABLE").select("tr");
	                for(int i = 0;i<trs.size();i++){
	                	System.out.println(i);
	                	if(i==1){
	                		
	                	}
	                    Elements tds = trs.get(i).select("td");
	                   /* for(int j = 0;j<tds.size();j++){
	                        String text = tds.get(j).text();
	                        if(!"".equals(text))
	                        System.out.println("星期"+(i+1)+"第"+(j+1)+"节课是"+text);
	                    }*/
	                }
	               trs = trs1.get(3).select("tr");
	               System.out.println(trs);
					for (int i = 0; i < trs.size(); i++) {
						Elements tds = trs.get(i).select("td");
						for (int j = 0; j < tds.size(); j++) {
							String text = tds.get(j).text();
							// 过滤星期
							if (!"".equals(text) && !text.startsWith("星期"))
								//过滤上午 下午字段
								if (tds.size() == 9) {
									if (j > 1)
										System.out.println("星期" + (j - 1) + "第" + (i) + "节课是：" + text);
								} else {
									if (j > 0)
										System.out.println("星期" + (j) + "第" + (i) + "节课是：" + text);
								}
						}
					}
	            }
	            


	    		
	        } catch (Exception e) {
	   
	        	e.printStackTrace();
	            // 调用小九接口
	        } finally {
	            httpClient.getConnectionManager().shutdown();
	        }
		
		
		
	}
	

}
