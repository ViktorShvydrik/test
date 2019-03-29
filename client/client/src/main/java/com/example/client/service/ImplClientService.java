package com.example.client.service;

import com.example.client.bean.Category;
import com.example.client.bean.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImplClientService implements ClientService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Vote> getAll() {
        ResponseEntity<List<Vote>> entity =  restTemplate.exchange("http://localhost:8080/vote/all",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Vote>>(){
        });
        List<Vote> list = entity.getBody();
        return list;
    }

    @Override
    public Vote get(String link) {
        String uri = "http://localhost:8080/vote/link/" +link;
        Vote vote = restTemplate.getForObject(uri, Vote.class);
        return vote;
    }

    @Override
    public Vote get(int id) {
        String uri = "http://localhost:8080/vote/" +id;
        Vote vote = restTemplate.getForObject(uri, Vote.class);
        return vote;
    }

    @Override
    public void vote (int id) {
        String uri = "http://localhost:8080/vote/";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put ( uri, id);
    }

    @Override
    public void changeStatus (int id) {
        String uri = "http://localhost:8080/vote/status/";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put (uri, id);
    }

    @Override
    public Vote add(Vote vote, String[] categories) {
        List<Category> list = new ArrayList<Category>();
        for (String cat: categories) {
            if(!cat.isEmpty()) {
                Category category = new Category();
                category.setName(cat);
                list.add(category);
            }
        }
        vote.setList(list);
        Vote addVote = restTemplate.postForObject( "http://localhost:8080/vote", vote, Vote.class);
        return addVote;
    }



}
