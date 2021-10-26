package com.example.test.controller.model.score.res;

import com.example.test.controller.model.score.ControllerScore;
import com.example.test.model.Score;

/**
 * 수정 정보를 담기 위한 Response 클래스
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 24. 오후 9:58:24
 *
 * @modified 2021. 10. 24. 오후 9:58:24 || Kyunghun Park || 최초 생성
 *
 */
public class UpdateScoreRes {
    private ControllerScore before;
    private ControllerScore after;
    
    // 기본 생성자
    public UpdateScoreRes() {
        
    }
    /**
     * UpdateScoreRes.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 4:39:21
     *
     * @return 
     */
    public ControllerScore getBefore() {
        return before;
    }
    /**
     * before 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 4:39:21
     *
     * @param before
     */
    public void setBefore(ControllerScore before) {
        this.before = before;
    }
    /**
     * UpdateScoreRes.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 4:39:21
     *
     * @return 
     */
    
    public void setBefore(Score score) {
        this.before = new ControllerScore(score);
    }
    public ControllerScore getAfter() {
        return after;
    }
    /**
     * after 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 4:39:21
     *
     * @param after
     */
    public void setAfter(ControllerScore after) {
        this.after = after;
    }
    public void setAfter(Score after) {
        this.after = new ControllerScore(after);
    }
    
}