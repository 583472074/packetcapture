package com.data.golf.entity;

/**   
* @Description: 球童 
* @author admin 
* @date 2014-11-5 上午9:42:02 
* @version V1.0   
*/
public class Caddie {

	public String getWeId() {
		return weId;
	}
	public void setWeId(String weId) {
		this.weId = weId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	private String weId;// 球场id
	private String cname;// 名称

	
}
