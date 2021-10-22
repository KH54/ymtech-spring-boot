package com.example.demo.test.dao.score;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.test.dao.score.impl.IScoreDao;
import com.example.demo.test.db.DB;
import com.example.demo.test.model.Score;

@Repository
public class ScoreDao implements IScoreDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Score> getAll() {
        return jdbcTemplate.query(DB.SQL_USER_SCORE_SELECT, BeanPropertyRowMapper.newInstance(Score.class));
    }

    @Override
    public Score getScore(String id) {
        try {
            Score score = jdbcTemplate.queryForObject(DB.SQL_SCORE_SELECT, BeanPropertyRowMapper.newInstance(Score.class), id);
            score.setId(id);
            return score;
        } catch (IncorrectResultSizeDataAccessException e) {
        }
        return null;
    }

    @Override
    public Integer updateScore(Score score) {
        return jdbcTemplate.update(DB.SQL_SCORE_UPDATE, score.getKorean(), score.getMath(), score.getEnglish(), score.getScience(), score.getAverage(), score.getId());
    }

    @Override
    public Integer deleteScore(String id) {
        return jdbcTemplate.update(DB.SQL_SCORE_DELETE, id);
    }

}
