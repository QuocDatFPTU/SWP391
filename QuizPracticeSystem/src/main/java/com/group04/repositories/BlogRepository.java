/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group04.repositories;

import com.group04.entities.Blog;
import java.util.List;

/**
 *
 * @author HP
 */
public interface BlogRepository {
    List<Blog> getAllBlog();
}
