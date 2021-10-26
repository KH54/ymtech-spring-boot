package com.example.test.service.score.impl;

import java.util.List;

import com.example.test.controller.model.score.res.ReadScoreRes;
import com.example.test.controller.model.score.res.UpdateScoreRes;
import com.example.test.model.Score;

public interface IScoreService {
    
    public List<Score> getAll();
    
    public ReadScoreRes getScore(String id);
    
    public UpdateScoreRes updateScore(String id, Score score);
    
}
