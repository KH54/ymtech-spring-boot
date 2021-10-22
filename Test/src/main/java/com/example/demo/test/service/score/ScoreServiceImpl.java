package com.example.demo.test.service.score;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.test.controller.model.score.DeleteRes;
import com.example.demo.test.controller.model.score.ReadRes;
import com.example.demo.test.controller.model.score.UpdateRes;
import com.example.demo.test.custom_exception.NullValueObjectException;
import com.example.demo.test.dao.score.ScoreDao;
import com.example.demo.test.model.Score;
import com.example.demo.test.service.score.impl.IScoreService;

@Service("scoreService")
public class ScoreServiceImpl implements IScoreService {

    @Autowired
    ScoreDao scoreDao;

    @Override
    public List<Score> getAll() {
        return scoreDao.getAll();
    }

    @Override
    public ReadRes getScore(String id) {
        ReadRes res = new ReadRes();
        res.setRead(scoreDao.getScore(id));
        return res;
    }

    @Override
    public UpdateRes updateScore(String id, Score score) {
        UpdateRes res = new UpdateRes();
        if (scoreDao.getScore(id) != null) {

            res.setBefore(scoreDao.getScore(id));
            
            score.setId(id);
            // 유효성 검사
            score.setEnglish(score.getEnglish() != 0 ? score.getEnglish() : scoreDao.getScore(id).getEnglish());
            score.setScience(score.getScience() != 0 ? score.getScience() : scoreDao.getScore(id).getScience());
            score.setAverage(score.getAverage() != 0 ? score.getAverage() : scoreDao.getScore(id).getAverage());
            score.setKorean(score.getKorean() != 0 ? score.getKorean() : scoreDao.getScore(id).getKorean());
            score.setMath(score.getMath() != 0 ? score.getMath() : scoreDao.getScore(id).getMath());

            score.setPwd(scoreDao.getScore(id).getPwd());
            score.setName(scoreDao.getScore(id).getName());
            score.setGender(scoreDao.getScore(id).getGender());
            score.setAge(scoreDao.getScore(id).getAge());
            
            res.setAfter(score);
            scoreDao.updateScore(score);

        }
        return res;
    }

    @Override
    public DeleteRes deleteScore(String id) {
        DeleteRes res = new DeleteRes();

        res.setDeleted(scoreDao.getScore(id) != null ? scoreDao.getScore(id) : null);

        if (scoreDao.getScore(id) != null) {
            res.setDeleted(scoreDao.getScore(id));
            scoreDao.deleteScore(id);
        } else {
            throw new NullValueObjectException();
        }
        return res;
    }

}
