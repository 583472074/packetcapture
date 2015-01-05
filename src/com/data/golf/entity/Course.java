package com.data.golf.entity;

import java.util.List;

/**
 * @Description: 球场实体表
 * @author admin
 * @date 2014-10-31 下午8:02:15
 * @version V1.0
 */
public class Course implements java.io.Serializable {
	
	private String weId;// 球场id
	private String cname;// 名称
	private String state;// 省
	private String city; // 市
	private String address; // 地址
	private String boss; // 产权人
	private String contacts; // 联系人
	private String tel; // 电话
	private String mobile; // 手机
	private String model; // 球场模式
	private String grass; // 果岭草种
	private int allLength; // 全长
	private String memo; // 介绍
	private List<Hole> holeList;// 18个洞的数据


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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBoss() {
		return boss;
	}
	public void setBoss(String boss) {
		this.boss = boss;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getGrass() {
		return grass;
	}
	public void setGrass(String grass) {
		this.grass = grass;
	}
	public int getAllLength() {
		return allLength;
	}
	public void setAllLength(int allLength) {
		this.allLength = allLength;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public List<Hole> getHoleList() {
		return holeList;
	}
	public void setHoleList(List<Hole> holeList) {
		this.holeList = holeList;
	}

}
