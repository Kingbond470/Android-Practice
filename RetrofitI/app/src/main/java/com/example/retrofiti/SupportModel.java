package com.example.retrofiti;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class SupportModel implements Serializable {

	@SerializedName("url")
	private String url;

	@SerializedName("text")
	private String text;

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	@Override
 	public String toString(){
		return 
			"SupportModel{" + 
			"url = '" + url + '\'' + 
			",text = '" + text + '\'' + 
			"}";
		}
}