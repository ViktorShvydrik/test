package com.example.server.dao;

import com.example.server.entity.Vote;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class ImplVoteDao implements VoteDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Vote create(Vote vote) {
         entityManager.persist(vote);
        return vote;
    }

    @Override
    public Vote get(int id) {
        return entityManager.find(Vote.class, id);
    }

    @Override
    public Vote getByLink(String link) {
        Vote vote = null;
        String hql = "FROM Vote as v where v.link like :lin";
        List<Vote> list = (List<Vote>) entityManager.createQuery(hql).setParameter("lin", link).getResultList();
            if(list.iterator().hasNext()){
              vote = list.iterator().next();
            }
        return vote;
    }

    @Override
    public List<Vote> getAll() {
        String hql = "FROM Vote as v ORDER BY v.id";
        return (List<Vote>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void update(Vote vote) {
        entityManager.merge(vote);
    }
}
