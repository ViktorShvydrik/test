package com.example.server.dao;

import com.example.server.entity.Vote;

import java.util.List;

public interface VoteDao {

    Vote create(Vote vote);

    Vote get(int id) ;

    Vote getByLink (String link);

    List<Vote> getAll();

    void update (Vote vote);
}
