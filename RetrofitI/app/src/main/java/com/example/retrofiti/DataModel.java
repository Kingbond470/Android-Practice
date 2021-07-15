package com.example.retrofiti;


import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class DataModel implements Serializable {

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("avatar")
	private String avatar;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	public String getAvatar(){
		return avatar;
	}

	@Override
 	public String toString(){
		return 
			"DataModel{" + 
			"id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",first_name = '" + firstName + '\'' + 
			",last_name = '" + lastName + '\'' + 
			",avatar = '" + avatar + '\'' + 
			"}";
		}
}