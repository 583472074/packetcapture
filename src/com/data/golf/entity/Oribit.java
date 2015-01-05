package com.data.golf.entity;

/**
 * @Description: 轨迹实体
 * @author admin
 * @date 2014-10-31 上午9:18:30
 * @version V1.0
 */
public class Oribit {


	public Oribit() {
	}
	
	public Oribit(int direction, int distance) {
		super();
		this.direction = direction;
		this.distance = distance;
	}
	public static final int LEFT = 0;// 左
	public  static final int RIGHT = 1;// 右
	public static final int CENTER = 2;// 中
	
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	private int direction;// 方向
	private int distance;// 距离

}
