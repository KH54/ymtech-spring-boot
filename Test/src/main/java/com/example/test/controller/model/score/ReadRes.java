package com.example.test.controller.model.score;

import com.example.test.model.Score;

/**
 * 조회 정보를 담기 위한 Response 클래스 
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 24. 오후 9:57:42
 *
 * @modified 2021. 10. 24. 오후 9:57:42 || Kyunghun Park || 최초 생성
 *
 */
public class ReadRes {
    private Score score;
    
    // 기본 생성자
    public ReadRes() {
        
    }

    /**
     * Read을(를) 호출합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:46
     *
     * @return 
     */
    public Score getRead() {
        return score;
    }

    /**
     * Read을(를) 저장합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:46
     *
     * @param score
     */
    public void setRead(Score score) {
        this.score = score;
    }
    
}
