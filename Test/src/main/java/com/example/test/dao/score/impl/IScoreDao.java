package com.example.test.dao.score.impl;

import java.util.List;

import com.example.test.controller.model.score.req.ReadScoreReq;
import com.example.test.controller.model.score.req.UpdateScoreReq;
import com.example.test.model.Score;

/**
 * ScoreDao의 메소드를 지정하기 위한 interface
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 24. 오후 9:30:45
 *
 * @modified 2021. 10. 24. 오후 9:30:45 || Kyunghun Park || 최초 생성
 *
 */
public interface IScoreDao {

    /**
     * 모든 유저의 정보(성적 포함)를 DB에서 조회하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 24. 오후 9:27:43
     * 
     * @return : 조회 결과를 List로 반환
     *
     * @modified 2021. 10. 24. 오후 9:27:43 || Kyunghun Park || 최초 생성
     *
     */
    public List<Score> getAll();

    /**
     * 특정 유저의 정보(성적 포함)를 DB에서 조회하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 24. 오후 9:27:47
     * 
     * @param id : 조회할 user의 id
     * @return : 조회 결과를 Score 객체로 반환
     *
     * @modified 2021. 10. 24. 오후 9:27:47 || Kyunghun Park || 최초 생성
     *
     */
    public Score getScore(ReadScoreReq req);

    /**
     * 특정 유저의 성적 정보를 DB에서 수정하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 24. 오후 9:29:06
     * 
     * @param score : 수정할 정보를 가진 Score 객체
     * @return : 수정에 성공한 개수만큼 Integer로 반환
     *
     * @modified 2021. 10. 24. 오후 9:29:06 || Kyunghun Park || 최초 생성
     *
     */
    public Integer updateScore(UpdateScoreReq req);

    /**
     * 특정 유저의 성적 정보를 DB에서 삭제하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 24. 오후 9:30:07
     * 
     * @param id : 삭제할 User의 id
     * @return : 삭제에 성공하면 1 아니면 0을 반환
     *
     * @modified 2021. 10. 24. 오후 9:30:07 || Kyunghun Park || 최초 생성
     *
     */
    public Integer deleteScore(String id);
}
