package com.example.test.service.score.impl;

import java.util.List;

import com.example.test.controller.model.score.DeleteRes;
import com.example.test.controller.model.score.ReadRes;
import com.example.test.controller.model.score.UpdateRes;
import com.example.test.model.Score;

public interface IScoreService {
    
    public List<Score> getAll();
    
    public ReadRes getScore(String id);
    
    public UpdateRes updateScore(String id, Score score);
    
    public DeleteRes deleteScore(String id);
}
