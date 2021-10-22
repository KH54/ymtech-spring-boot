package com.example.demo.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.test.model.Score;
import com.example.demo.test.service.score.ScoreServiceImpl;

@RestController
public class ScoreController {

    @Autowired
    ScoreServiceImpl scoreService;

    @RequestMapping(value = "/users/score", method = RequestMethod.GET)
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(scoreService.getAll(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/users/score/{user-id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getScore(@PathVariable("user-id") String id) {
        return new ResponseEntity<>(scoreService.getScore(id), HttpStatus.OK);

    }

    @RequestMapping(value = "/users/score/{user-id}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> updateScore(@PathVariable("user-id") String id, @RequestBody Score Score) {
        return new ResponseEntity<>(scoreService.updateScore(id, Score), HttpStatus.OK);
    }

    @RequestMapping(value = "/users/score/{user-id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteScore(@PathVariable("user-id") String id) {
        return new ResponseEntity<>(scoreService.deleteScore(id), HttpStatus.OK);
    }
}