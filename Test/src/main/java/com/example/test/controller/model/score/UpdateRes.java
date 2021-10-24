package com.example.test.controller.model.score;

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
public class UpdateRes {
    private Score before;
    private Score after;
    // 기본 생성자
    public UpdateRes() {
        
    }

    /**
     * Before을(를) 호출합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:38:25
     *
     * @return 
     */
    public Score getBefore() {
        return before;
    }

    /**
     * Before을(를) 저장합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:38:25
     *
     * @param before
     */
    public void setBefore(Score before) {
        this.before = before;
    }

    /**
     * After을(를) 호출합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:38:25
     *
     * @return 
     */
    public Score getAfter() {
        return after;
    }

    /**
     * After을(를) 저장합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:38:25
     *
     * @param after
     */
    public void setAfter(Score after) {
        this.after = after;
    }     
}
