package com.example.server.dao;

import com.example.server.entity.Category;
import com.example.server.entity.Vote;

import java.util.List;

public interface CategoryDao {

     List<Category> addList (List<Category> list, Vote vote);
     Category add (Category cat);
     void vote (int id);

}
