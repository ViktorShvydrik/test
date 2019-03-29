package com.example.server.service;

import com.example.server.entity.Vote;


import java.util.List;

public interface VoteService {

    void create(Vote vote);
    Vote get (int id);
    Vote getByLink (String link);
    List<Vote> getAll ();
    void vote (int id);
    void changeStatus(int id);


}
