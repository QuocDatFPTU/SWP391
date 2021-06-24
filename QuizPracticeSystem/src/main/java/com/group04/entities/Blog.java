/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author HP
 */
@Entity
@Table(name = "tblBlog")
public class Blog {
    @Id
    @Column(name = "blogID")
    private String blogID;
    
    @Column(name = "blogDetail")
    private String blogDetail;

    public Blog() {
    }

    public Blog(String blogID, String blogDetail) {
        this.blogID = blogID;
        this.blogDetail = blogDetail;
    }

    public String getBlogID() {
        return blogID;
    }

    public void setBlogID(String blogID) {
        this.blogID = blogID;
    }

    public String getBlogDetail() {
        return blogDetail;
    }

    public void setBlogDetail(String blogDetail) {
        this.blogDetail = blogDetail;
    }
    
}
