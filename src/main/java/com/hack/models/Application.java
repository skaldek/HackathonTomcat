package com.hack.models;

import javax.persistence.*;


@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "user_id")
    private String user_id;
    @JoinColumn(name = "description")
    private String description;

    public Application(){}

    public Application(String description){
        this.description = description;
    }

    public Application(String userId, String description){
        this.description = description;
        this.user_id = userId;
    }
    
    public Application(String userId, Integer id, String description){
        this.description = description;
        this.id = id;
        this.user_id = userId;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setUserId(String userId){
        this.user_id = userId;
    }

    public String getUserId(){
        return user_id;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
