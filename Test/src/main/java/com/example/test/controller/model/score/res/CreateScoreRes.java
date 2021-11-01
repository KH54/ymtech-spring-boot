package com.example.test.controller.model.score.res;

import com.example.test.controller.model.score.ControllerScore;
import com.example.test.model.Score;

/**
 * 사용자의 Create 요청의 결과를 담는 Response
 *
 * @author "KyungHun Park"
 * @since 2021. 11. 1. 오후 1:37:02
 *
 * @modified 2021. 11. 1. 오후 1:37:02 || Kyunghun Park || 최초 생성
 *
 */
public class CreateScoreRes {
    private ControllerScore create;
    
    // 기본 생성자
    public CreateScoreRes() {
        
    }

    /**
     * create 호출
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:48:43
     *
     * @return 
     */
    public ControllerScore getCreate() {
        return create;
    }

    /**
     * create 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:48:43
     *
     * @param create
     */
    public void setCreate(ControllerScore create) {
        this.create = create;
    }
    
    /**
     * 파라미터를 CotrollerScore로 변환합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 11. 1. 오후 1:35:06
     * 
     * @param score : 사용자가 입력한 score 객체
     *
     * @modified 2021. 11. 1. 오후 1:35:06 || Kyunghun Park || 최초 생성
     *
     */
    public void setCreate(Score score) {
        this.create = new ControllerScore(score);
    }


}