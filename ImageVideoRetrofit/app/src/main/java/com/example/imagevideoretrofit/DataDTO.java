package com.example.imagevideoretrofit;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class DataDTO implements Serializable {

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("description")
	private Object description;

	@SerializedName("datetime")
	private int datetime;

	@SerializedName("type")
	private String type;

	@SerializedName("animated")
	private boolean animated;

	@SerializedName("width")
	private int width;

	@SerializedName("height")
	private int height;

	@SerializedName("size")
	private int size;

	@SerializedName("views")
	private int views;

	@SerializedName("bandwidth")
	private int bandwidth;

	@SerializedName("vote")
	private Object vote;

	@SerializedName("favorite")
	private boolean favorite;

	@SerializedName("nsfw")
	private Object nsfw;

	@SerializedName("section")
	private Object section;

	@SerializedName("account_url")
	private Object accountUrl;

	@SerializedName("account_id")
	private int accountId;

	@SerializedName("is_ad")
	private boolean isAd;

	@SerializedName("in_most_viral")
	private boolean inMostViral;

	@SerializedName("has_sound")
	private boolean hasSound;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("ad_type")
	private int adType;

	@SerializedName("ad_url")
	private String adUrl;

	@SerializedName("edited")
	private String edited;

	@SerializedName("in_gallery")
	private boolean inGallery;

	@SerializedName("deletehash")
	private String deletehash;

	@SerializedName("name")
	private String name;

	@SerializedName("link")
	private String link;

	public String getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public Object getDescription(){
		return description;
	}

	public int getDatetime(){
		return datetime;
	}

	public String getType(){
		return type;
	}

	public boolean isAnimated(){
		return animated;
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

	public int getSize(){
		return size;
	}

	public int getViews(){
		return views;
	}

	public int getBandwidth(){
		return bandwidth;
	}

	public Object getVote(){
		return vote;
	}

	public boolean isFavorite(){
		return favorite;
	}

	public Object getNsfw(){
		return nsfw;
	}

	public Object getSection(){
		return section;
	}

	public Object getAccountUrl(){
		return accountUrl;
	}

	public int getAccountId(){
		return accountId;
	}

	public boolean isIsAd(){
		return isAd;
	}

	public boolean isInMostViral(){
		return inMostViral;
	}

	public boolean isHasSound(){
		return hasSound;
	}

	public List<Object> getTags(){
		return tags;
	}

	public int getAdType(){
		return adType;
	}

	public String getAdUrl(){
		return adUrl;
	}

	public String getEdited(){
		return edited;
	}

	public boolean isInGallery(){
		return inGallery;
	}

	public String getDeletehash(){
		return deletehash;
	}

	public String getName(){
		return name;
	}

	public String getLink(){
		return link;
	}
}