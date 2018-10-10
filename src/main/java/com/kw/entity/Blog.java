package com.kw.entity;

import java.sql.Date;

public class Blog {
 
    private Integer blogId;
    private String title;
    private Date pubtime;
    private Integer clickrate;
    private Integer categoryid;
    private String content;
    private String categoryname; 
    
    public Blog(Integer blogId, String title, Date pubtime, Integer clickrate,
			Integer categoryid, String content) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.pubtime = pubtime;
		this.clickrate = clickrate;
		this.categoryid = categoryid;
		this.content = content;
	}
    
    public Blog(){
    	super();
    }
    
	public Integer getBlogId() {
        return blogId;
    }
    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public Date getPubtime() {
        return pubtime;
    }
    
    public void setPubtime(Date pubtime) {
        this.pubtime = pubtime;
    }

    public Integer getClickrate() {
        return clickrate;
    }
    
    public void setClickrate(Integer clickrate) {
        this.clickrate = clickrate;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", title=" + title + ", pubtime="
				+ pubtime + ", clickrate=" + clickrate + ", categoryid="
				+ categoryid + ", content=" + content + "]";
	}
    
}