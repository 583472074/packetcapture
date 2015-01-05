package com.data.golf.entity;

public class Statistics {


	 public String getOneWoodnum() {
		return oneWoodnum;
	}
	public void setOneWoodnum(String oneWoodnum) {
		this.oneWoodnum = oneWoodnum;
	}
	public String getOneWoodSuc() {
		return oneWoodSuc;
	}
	public void setOneWoodSuc(String oneWoodSuc) {
		this.oneWoodSuc = oneWoodSuc;
	}
	public float getOneWoodSucRatio() {
		return oneWoodSucRatio;
	}
	public void setOneWoodSucRatio(float oneWoodSucRatio) {
		this.oneWoodSucRatio = oneWoodSucRatio;
	}
	public String getLongIronNum() {
		return longIronNum;
	}
	public void setLongIronNum(String longIronNum) {
		this.longIronNum = longIronNum;
	}
	public String getLongIronSuc() {
		return longIronSuc;
	}
	public void setLongIronSuc(String longIronSuc) {
		this.longIronSuc = longIronSuc;
	}
	public float getLongIronSucRatio() {
		return longIronSucRatio;
	}
	public void setLongIronSucRatio(float longIronSucRatio) {
		this.longIronSucRatio = longIronSucRatio;
	}
	public String getMiddleIronNum() {
		return middleIronNum;
	}
	public void setMiddleIronNum(String middleIronNum) {
		this.middleIronNum = middleIronNum;
	}
	public String getMiddleIronSuc() {
		return middleIronSuc;
	}
	public void setMiddleIronSuc(String middleIronSuc) {
		this.middleIronSuc = middleIronSuc;
	}
	public float getMiddleIronSucRatio() {
		return middleIronSucRatio;
	}
	public void setMiddleIronSucRatio(float middleIronSucRatio) {
		this.middleIronSucRatio = middleIronSucRatio;
	}
	public String getShortIronNum() {
		return shortIronNum;
	}
	public void setShortIronNum(String shortIronNum) {
		this.shortIronNum = shortIronNum;
	}
	public String getShortIronSuc() {
		return shortIronSuc;
	}
	public void setShortIronSuc(String shortIronSuc) {
		this.shortIronSuc = shortIronSuc;
	}
	public float getShortIronSucRatio() {
		return shortIronSucRatio;
	}
	public void setShortIronSucRatio(float shortIronSucRatio) {
		this.shortIronSucRatio = shortIronSucRatio;
	}
	public String getPutNum() {
		return putNum;
	}
	public void setPutNum(String putNum) {
		this.putNum = putNum;
	}
	public String getPutSuc() {
		return putSuc;
	}
	public void setPutSuc(String putSuc) {
		this.putSuc = putSuc;
	}
	public float getPutSucRatio() {
		return putSucRatio;
	}
	public void setPutSucRatio(float putSucRatio) {
		this.putSucRatio = putSucRatio;
	}
	public String getPichNum() {
		return pichNum;
	}
	public void setPichNum(String pichNum) {
		this.pichNum = pichNum;
	}
	public String getPichSuc() {
		return pichSuc;
	}
	public void setPichSuc(String pichSuc) {
		this.pichSuc = pichSuc;
	}
	public float getPichSucRatio() {
		return pichSucRatio;
	}
	public void setPichSucRatio(float pichSucRatio) {
		this.pichSucRatio = pichSucRatio;
	}
	private String oneWoodnum;//1号木总次数
	 private String oneWoodSuc;//1号木成功次数
	 private float oneWoodSucRatio;//1号木成功率
	 
	 private String longIronNum;        //长铁 总次数
	 private String longIronSuc;        //长铁成功总次数
	 private float longIronSucRatio;    //长铁 成功成功率
	 
	 
	 private String middleIronNum;        //中铁 总次数
	 private String middleIronSuc;       //中铁 成功总次数
	 private float middleIronSucRatio;  //中铁  成功成功率
	 
	 
	 private String shortIronNum;        //短铁 总次数
	 private String shortIronSuc;       //短铁 成功总次数
	 private float shortIronSucRatio;  //短铁  成功成功率
	 
	 
	 private String putNum;    // 推杆总次数
	 private String putSuc;//推杆成功总次数
	 private float putSucRatio; //推杆成功成功率
	 
	 private String pichNum;    // 切杆总次数
	 private String pichSuc;//切杆 成功总次数
	 private float  pichSucRatio; //切杆 成功率

}
