package com.example.test.service.score.impl;

import java.util.List;

import com.example.test.controller.model.score.res.ReadScoreRes;
import com.example.test.controller.model.score.res.UpdateScoreRes;
import com.example.test.model.Score;

public interface IScoreService {

    /**
     * 모든 유저의 정보와 성적을 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 11. 1. 오전 10:00:00
     * 
     * @return : Score 객체의 List 형태로 출력
     *
     * @modified 2021. 11. 1. 오전 10:00:00 || Kyunghun Park || 최초 생성
     *
     */
    public List<Score> getAll();

    /**
     * id와 일치하는 유저의 정보와 성적을 출력하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 11. 1. 오전 10:03:52
     * 
     * @param id : 유저의 id
     * @return : Score 객체 형태의 Response로 반환
     *
     * @modified 2021. 11. 1. 오전 10:03:52 || Kyunghun Park || 최초 생성
     *
     */
    public ReadScoreRes getScore(String id);

    /**
     * id와 일치하는 유저의 정보를 업데이트
     *
     * @author "KyungHun Park"
     * @since 2021. 11. 1. 오전 10:03:56
     * 
     * @param id    : 유저의 id
     * @param score : 업데이트할 성적 객체 정보
     * @return : Score 객체 형태의 Response로 반환
     *
     * @modified 2021. 11. 1. 오전 10:03:56 || Kyunghun Park || 최초 생성
     *
     */
    public UpdateScoreRes updateScore(String id, Score score);

}
