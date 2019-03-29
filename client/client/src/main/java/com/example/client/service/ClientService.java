package com.example.client.service;

import com.example.client.bean.Vote;

import java.util.List;


public interface ClientService {

    List<Vote> getAll ();
    Vote get(String link);
    Vote get(int id);
    void vote (int id);
    void changeStatus (int id);
    Vote add (Vote vote, String [] categories);

}
