package com.example.server.service;

import com.example.server.dao.CategoryDao;
import com.example.server.dao.VoteDao;
import com.example.server.entity.Category;
import com.example.server.entity.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Random;

@Transactional
@Repository
public class ImplVoteService implements VoteService {

    @Autowired
    VoteDao voteDao;
    @Autowired
    CategoryDao categoryDao;

    @Override
    public void create(Vote vote) {
        Vote newVote = new Vote();
        newVote.setName(vote.getName());
        try {
            newVote.setLink(createLink());
            voteDao.create(newVote);
        }catch (Throwable e){
            newVote.setLink(createLink());
            voteDao.create(newVote);
        }
        List<Category> list = categoryDao.addList(vote.getList(), newVote);
        newVote.setList(list);
    }

    @Override
    public Vote get(int id) {
        return voteDao.get(id);
    }

    @Override
    public Vote getByLink(String link) {
        return voteDao.getByLink(link);
    }


    @Override
    public List<Vote> getAll() {
        return voteDao.getAll();
    }

    @Override
    public void vote(int id) {
        categoryDao.vote(id);
    }

    @Override
    public void changeStatus(int id) {
        Vote vote = get(id);
        vote.setStatus(!vote.getStatus());
        voteDao.update(vote);
    }

    private String createLink () {
        String link = "";
        Random r = new Random();
        int cntchars = 8;
        for (int i = 0; i < cntchars; ++i) {
            char next = 0;
            int range = 10;

            switch (r.nextInt(3)) {
                case 0: {next = '0';range = 10;} break;
                case 1: {next = 'a';range = 26;} break;
                case 2: {next = 'A';range = 26;} break;
            }
            link += (char) ((r.nextInt(range)) + next);
        }
        return link;
    }
}
