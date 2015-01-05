package com.data.golf.entity;


/**   
* @Description:  简介的user
* @author admin 
* @date 2014-11-5 上午9:47:43 
* @version V1.0   
*/
public class UserBrief implements java.io.Serializable {
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPicuri() {
		return picuri;
	}
	public void setPicuri(String picuri) {
		this.picuri = picuri;
	}
	private String userId;// 用户id
	private String cname;// 姓名
	private String picuri;// 头像url
	private boolean check;// 头像url
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}

}
