package com.example.inshortsnewsapp;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseDTO implements Serializable {

	@SerializedName("category")
	private String category;

	@SerializedName("data")
	private List<DataDTO> data;

	@SerializedName("success")
	private boolean success;

	public String getCategory(){
		return category;
	}

	public List<DataDTO> getData(){
		return data;
	}

	public boolean isSuccess(){
		return success;
	}
}