package com.example.test.controller.model.score;

import com.example.test.model.Score;

/**
 * 삭제 정보를 담기 위한 Response 클래스
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 24. 오후 9:56:20
 *
 * @modified 2021. 10. 24. 오후 9:56:20 || Kyunghun Park || 최초 생성
 *
 */
public class DeleteRes {
    Score delete;
    // 기본 생성자
    public DeleteRes() {
        
    }

    /**
     * delete을(를) 호출합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 22. 오후 1:22:31
     *
     * @return 
     */
    public Score getDelete() {
        return delete;
    }

    /**
     * delete을(를) 저장합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 22. 오후 1:22:31
     *
     * @param deleted
     */
    public void setDelete(Score deleted) {
        this.delete = deleted;
    }
    
    
}
