package com.example.test.dao.score;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.test.controller.model.score.req.ReadScoreReq;
import com.example.test.controller.model.score.req.UpdateScoreReq;
import com.example.test.dao.score.impl.IScoreDao;
import com.example.test.db.Query;
import com.example.test.model.Score;

@Repository
public class ScoreDao implements IScoreDao {

    // 의존성 주입
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @see com.example.test.dao.score.impl.IScoreDao#getAll()
     */
    @Override
    public List<Score> getAll() {
        // Query를 실행하고 RowMapper를 사용하여 결과를 Score 객체로 변환 
        return jdbcTemplate.query(Query.SQL_USER_SCORE_SELECT, BeanPropertyRowMapper.newInstance(Score.class));
    }

    /**
     * @see com.example.test.dao.score.impl.IScoreDao#getScore(String)
     */
    @Override
    public Score getScore(ReadScoreReq req) {
        try {
            // Query를 실행하고 RowMapper를 사용하여 결과를 Score 객체로 변환
            Score score = jdbcTemplate.queryForObject(Query.SQL_SCORE_SELECT, BeanPropertyRowMapper.newInstance(Score.class), req.getId());
            score.setId(req.getId());
            return score;
        } catch (IncorrectResultSizeDataAccessException e) {
            // 결과 값이 0개이거나 2개 이상인 경우
        }
        return null;
    }

    /**
     * @see com.example.test.dao.score.impl.IScoreDao#updateScore(Score)
     */
    @Override
    public Integer updateScore(UpdateScoreReq req) {
        // 업데이트할 Score 객체의 정보로 Query 실행
        return jdbcTemplate.update(Query.SQL_SCORE_UPDATE, req.getUpdate().getKorean(), req.getUpdate().getMath(), req.getUpdate().getEnglish(), req.getUpdate().getScience(), req.getUpdate().getAverage(), req.getUpdate().getId());
    }

    /**
     * @see com.example.test.dao.score.impl.IScoreDao#deleteScore(String)
     */
    @Override
    public Integer deleteScore(String id) {
        // 삭제할 id를 입력 받아 Query 실행
        return jdbcTemplate.update(Query.SQL_SCORE_DELETE, id);
    }

}
