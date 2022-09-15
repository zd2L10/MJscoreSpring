package com.example.app.domain;

import java.util.Date;

public class Result {
	
	private Integer result_id;
	private Integer user_id;
	private String derection;
	private Integer rank;
	private Date time;
	private Integer east_score;
	private Integer south_score;
	private Integer west_score;
	private Integer north_score;
	private String east_player;
	private String south_player;
	private String west_player;
	private String north_player;
	
	
	public Integer getId() {
		return result_id;
	}
	public void setId(Integer result_id) {
		this.result_id = result_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getDerection() {
		return derection;
	}
	public void setDerection(String derection) {
		this.derection = derection;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getEast_score() {
		return east_score;
	}
	public void setEast_score(Integer east_score) {
		this.east_score = east_score;
	}
	public Integer getSouth_score() {
		return south_score;
	}
	public void setSouth_score(Integer south_score) {
		this.south_score = south_score;
	}
	public Integer getWest_score() {
		return west_score;
	}
	public void setWest_score(Integer west_score) {
		this.west_score = west_score;
	}
	public Integer getNorth_score() {
		return north_score;
	}
	public void setNorth_score(Integer north_score) {
		this.north_score = north_score;
	}
	public String getEast_player() {
		return east_player;
	}
	public void setEast_player(String east_player) {
		this.east_player = east_player;
	}
	public String getSouth_player() {
		return south_player;
	}
	public void setSouth_player(String south_player) {
		this.south_player = south_player;
	}
	public String getWest_player() {
		return west_player;
	}
	public void setWest_player(String west_player) {
		this.west_player = west_player;
	}
	public String getNorth_player() {
		return north_player;
	}
	public void setNorth_player(String north_player) {
		this.north_player = north_player;
	}
	
	
}
