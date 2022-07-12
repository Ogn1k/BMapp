package com.example.aaaaa123;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("itemId")
    @Expose
    private int id;
    @SerializedName("itemName")
    @Expose
    private String name; //title
    @SerializedName("itemDesc")
    @Expose
    private String desc;//body
    @SerializedName("itemUrl")
    @Expose
    private String url;//images


    public Post(int id, String name, String desc, String url)
    {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getUrl() {
        return url;
    }

}