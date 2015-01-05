package com.data.golf.entity;

/**
 * @Description: 赛事记录
 * @author admin
 * @date 2014-11-5 下午8:54:56
 * @version V1.0
 */
public class Game implements java.io.Serializable{

	
	public final static String GOLD_TEE="金T";
	public final static String BLACK_TEE="黑T";
	public final static String BLUE_TEE="蓝T";
	public final static String RED_TEE="红T";
	public final static String WHITE_TEE="白T";
	
	private String caddieId;// 球童id
	private String userId; // 用户id
	private String weather;// 参数：天气
	private String startPos;// 参数：发球区
	private String courseId;// 球场id
	private String title;// 标题
	private String gameId;// 赛id

	public String getGameId() {
		return gameId;
	}
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCaddieId() {
		return caddieId;
	}
	public void setCaddieId(String caddieId) {
		this.caddieId = caddieId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getStartPos() {
		return startPos;
	}
	public void setStartPos(String startPos) {
		this.startPos = startPos;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

}
