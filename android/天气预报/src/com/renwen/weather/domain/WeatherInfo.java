package com.renwen.weather.domain;

public class WeatherInfo {
	private int id;
	private String name;
	private String wind;
	private String weather;
	private String temp;
	private String pm;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getPm() {
		return pm;
	}
	public void setPm(String pm) {
		this.pm = pm;
	}
	@Override
	public String toString() {
		return "WeatherInfo [城市id=" + id + ", 名称name=" + name + ", 风力wind=" + wind
				+ ", 天气weather=" + weather + ", 温度temp=" + temp + ", pm=" + pm
				+ "]";
	}
	
}
