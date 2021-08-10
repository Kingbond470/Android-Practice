package com.example.itunesapi;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseDTO implements Serializable {

	@SerializedName("resultCount")
	private int resultCount;

	@SerializedName("results")
	private List<ResultsDTO> results;

	public int getResultCount(){
		return resultCount;
	}

	public List<ResultsDTO> getResults(){
		return results;
	}
}