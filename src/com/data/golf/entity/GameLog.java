package com.data.golf.entity;

/**
 * @Description: 每杆球的信息
 * @author admin
 * @date 2014-10-14 下午2:26:17
 * @version V1.0
 */
public class GameLog implements java.io.Serializable {

	private int holeOrder;   //  洞顺序  根据洞号码 找出一组洞的数据
	private int brassieNum;   // brassie 当前第几杆
	private int distance;  // 距离
	private String holeId;   // 洞id
	private String hitPoint; // 击点
	private String startPos;    //出球位
	private String endPos; // 落球点
	private String brassie; // 杆号(球杆种类)
	private String memo;//备注
	
	private String userId;     //用户ID
	private String courseId;   //球场id
	private String gameId;     //赛事id
	private String brand;       //球杆品牌

	
	public GameLog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GameLog(String userId, String courseId, String gameId,
			String holeNum) {
		super();
		this.userId = userId;
		this.courseId = courseId;
		this.gameId = gameId;
		this.holeId = holeNum;
	}
	
	public int getBrassieNum() {
		return brassieNum;
	}

	public void setBrassieNum(int brassieNum) {
		this.brassieNum = brassieNum;
	}
	public int getHoleOrder() {
		return holeOrder;
	}

	public void setHoleOrder(int holeOrder) {
		this.holeOrder = holeOrder;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getHoleId() {
		return holeId;
	}

	public void setHoleId(String holeId) {
		this.holeId = holeId;
	}

	public String getHitPoint() {
		return hitPoint;
	}

	public void setHitPoint(String hitPoint) {
		this.hitPoint = hitPoint;
	}

	public String getStartPos() {
		return startPos;
	}

	public void setStartPos(String startPos) {
		this.startPos = startPos;
	}

	public String getEndPos() {
		return endPos;
	}

	public void setEndPos(String endPos) {
		this.endPos = endPos;
	}

	public String getBrassie() {
		return brassie;
	}

	public void setBrassie(String brassie) {
		this.brassie = brassie;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

}
