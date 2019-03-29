package com.example.server;

import java.util.List;


import com.example.server.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.server.entity.Vote;

@Controller
@RequestMapping ("vote")
public class RestController {

    @Autowired
    VoteService service;


    @RequestMapping ( method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public ResponseEntity<Vote> add (@RequestBody Vote vote) {
        try {
            service.create(vote);
            return new ResponseEntity<Vote>(vote,HttpStatus.OK);
        }catch (Throwable e ){
            return new ResponseEntity<Vote>(vote, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @RequestMapping ( method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> voting (@RequestBody int id) {
        try {
            service.vote(id);
            return new ResponseEntity<String>("successfully", HttpStatus.OK);
        } catch (Throwable e) {
            return new ResponseEntity<String>("unsuccessfully", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

        @RequestMapping (value="/status", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
        @ResponseBody
        public ResponseEntity<String> changeStatus(@RequestBody int id) {
            try {
                service.changeStatus(id);
                return new ResponseEntity<String>("successfully", HttpStatus.OK);
            }catch (Throwable e ) {
                return new ResponseEntity<String>("unsuccessfully", HttpStatus.INTERNAL_SERVER_ERROR);
            }


        }


    @RequestMapping (value="/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Vote> get (@PathVariable("id") Integer id) {
        try {
            Vote vote = service.get(id);
            return new ResponseEntity<Vote>(vote, HttpStatus.OK);
        }catch (Throwable e ){
            return new ResponseEntity<Vote>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping (value="/link/{link}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Vote> getByLink (@PathVariable("link") String link) {
        try {
            Vote vote = service.getByLink(link);
            return new ResponseEntity<Vote>(vote, HttpStatus.OK);
        }catch (Throwable e ){
            return new ResponseEntity<Vote>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping (value ="/all", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public ResponseEntity<List<Vote>> getAll () {
        try {
            List<Vote> list = service.getAll();
            return new ResponseEntity<List<Vote>>(list, HttpStatus.OK);
        }catch (Throwable e ){
            return new ResponseEntity<List<Vote>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}