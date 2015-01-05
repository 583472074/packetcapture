package com.data.golf.entity;


/**
 * @Description: 每洞的数据
 * @author admin
 * @date 2014-10-14 下午4:18:20
 * @version V1.0
 */
public class Hole implements java.io.Serializable {

	
	private String weId;  // 主键
	private Integer courseId;// 球场ID（关联球场表）
	private Integer orderId; // 顺序号
	private double redLength; // 长度
	private double whiteLength; // 长度
	private double blueLength; // 长度
	private double goldLength; // 长度
	private double blackLength; // 长度
	private Integer teeGround;// T台数
	private Integer sandpit;// 沙坑数
	private Integer bendFairway;// 曲道数
	private Integer parNum;// 标准杆数
	private String memo;// --说明
	
	public String  getWeId() {
		return weId;
	}
	public void setWeId(String  weId) {
		this.weId = weId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public double getRedLength() {
		return redLength;
	}
	public void setRedLength(double redLength) {
		this.redLength = redLength;
	}
	public double getWhiteLength() {
		return whiteLength;
	}
	public void setWhiteLength(double whiteLength) {
		this.whiteLength = whiteLength;
	}
	public double getBlueLength() {
		return blueLength;
	}
	public void setBlueLength(double blueLength) {
		this.blueLength = blueLength;
	}
	public double getGoldLength() {
		return goldLength;
	}
	public void setGoldLength(double goldLength) {
		this.goldLength = goldLength;
	}
	public double getBlackLength() {
		return blackLength;
	}
	public void setBlackLength(double blackLength) {
		this.blackLength = blackLength;
	}
	public Integer getTeeGround() {
		return teeGround;
	}
	public void setTeeGround(Integer teeGround) {
		this.teeGround = teeGround;
	}
	public Integer getSandpit() {
		return sandpit;
	}
	public void setSandpit(Integer sandpit) {
		this.sandpit = sandpit;
	}
	public Integer getBendFairway() {
		return bendFairway;
	}
	public void setBendFairway(Integer bendFairway) {
		this.bendFairway = bendFairway;
	}
	public Integer getParNum() {
		return parNum;
	}
	public void setParNum(Integer parNum) {
		this.parNum = parNum;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}


}
