package com.example.server.dao;

import com.example.server.entity.Category;
import com.example.server.entity.Vote;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class ImplCategoryDao implements CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> addList(List<Category> list, Vote vote) {
        if(!list.isEmpty()) {
            List<Category> readyList = new ArrayList<Category>();
            for (Category cat : list) {
                cat.setIdVote(vote.getId());
                add(cat);
                readyList.add(cat);
            }
            return readyList;
        } else return null;

    }

    @Override
    public Category add(Category cat) {
        entityManager.persist(cat);
        return cat;
    }


    @Override
    public void vote(int id) {
        Category cat = get(id);
        int count = cat.getCount();
        count++;
        cat.setCount(count);
        entityManager.persist(cat);
    }

    private Category get(int id){
        return entityManager.find(Category.class, id);
    }
}
