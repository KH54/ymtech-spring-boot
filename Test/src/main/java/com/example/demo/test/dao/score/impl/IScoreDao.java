package com.example.demo.test.dao.score.impl;

import java.util.List;

import com.example.demo.test.model.Score;

public interface IScoreDao {
    
    public List<Score> getAll();
    
    public Score getScore(String id);

    public Integer updateScore(Score score);
    
    public Integer deleteScore(String id);
}
