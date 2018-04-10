package com.renwen.weather.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

import com.renwen.weather.domain.WeatherInfo;

public class weatherService {
	
	public static List<WeatherInfo> getWeatherInfos(InputStream is) throws Exception{
		XmlPullParser parser = Xml.newPullParser();
		//初始化解析器
		parser.setInput(is,"utf-8");
		List<WeatherInfo> weatherInfo=null;
		WeatherInfo info=null;
		int type = parser.getEventType();
		while(type!=XmlPullParser.END_DOCUMENT){
			switch(type){
			case XmlPullParser.START_TAG:
				if("infos".equals(parser.getName())){
					//解析到全局的开始标签
					weatherInfo = new ArrayList<WeatherInfo>();
				}else if("city".equals(parser.getName())){
					info = new WeatherInfo();
					String idStr=parser.getAttributeValue(0);
					info.setId(Integer.parseInt(idStr));
				}else if("temp".equals(parser.getName())){
					String temp = parser.nextText();
					info.setTemp(temp);
				}else if("weather".equals(parser.getName())){
					String weather = parser.nextText();
					info.setWeather(weather);
				}else if("wind".equals(parser.getName())){
					String wind = parser.nextText();
					info.setWind(wind);
				}else if("name".equals(parser.getName())){
					String name = parser.nextText();
					info.setName(name);
				}else if("pm".equals(parser.getName())){
					String pm = parser.nextText();
					info.setPm(pm);
				}
				break;
			case XmlPullParser.END_TAG:
				if("city".equals(parser.getName())){
					weatherInfo.add(info);
				}
				break;
			}
			type=parser.next();
		}
		return weatherInfo;
	}
}
