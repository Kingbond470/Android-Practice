package com.example.retrofiti;


import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class ResponseModel implements Serializable {

	@SerializedName("data")
	private DataModel data;

	@SerializedName("support")
	private SupportModel support;

	public void setData(DataModel data){
		this.data = data;
	}

	public DataModel getData(){
		return data;
	}

	public void setSupport(SupportModel support){
		this.support = support;
	}

	public SupportModel getSupport(){
		return support;
	}

	@Override
 	public String toString(){
		return 
			"ResponseModel{" + 
			"data = '" + data + '\'' + 
			",support = '" + support + '\'' + 
			"}";
		}
}