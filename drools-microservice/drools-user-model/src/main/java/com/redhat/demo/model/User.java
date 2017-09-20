/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redhat.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nikhil Malvankar
 */
@XmlRootElement
public class User {
    
    private String name;
    private Integer age;
    private String category;
    private String comments;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
    public String toString() {
        return "User{" + "name=" + name + ", age=" + age + ", category=" + category + ", comments=" + comments + "}";
    }

   
    
    
}
