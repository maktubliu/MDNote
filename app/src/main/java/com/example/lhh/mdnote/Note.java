package com.example.lhh.mdnote;

import java.util.Date;

/**
 * Created by LHH on 2016/4/25.
 */
public class Note  {
    private static final long serialVersionUID = -831930284387787342L;
    private Long id;
    private String title;
    private String content;
    private Date createAt;
    private Date updateAt;
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public Date getCreateAt(){
        return createAt;
    }
    public void setCreateAt(Date createAt){
        this.createAt = createAt;
    }
    public Date getUpdateAt(){
        return updateAt;
    }
    public void setUpdateAt(Date updateAt){
        this.updateAt = updateAt;
    }

}
