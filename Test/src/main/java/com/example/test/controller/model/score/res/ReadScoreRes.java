package com.example.test.controller.model.score.res;

import com.example.test.controller.model.score.ControllerScore;
import com.example.test.controller.model.score.req.ReadScoreReq;

/**
 * 조회 정보를 담기 위한 Response 클래스 
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 24. 오후 9:57:42
 *
 * @modified 2021. 10. 24. 오후 9:57:42 || Kyunghun Park || 최초 생성
 *
 */
public class ReadScoreRes {
    private ControllerScore read;
    
    
    // 기본 생성자
    public ReadScoreRes() {
        
    }

    public ReadScoreRes(ReadScoreReq req) {
       this.read = req.getRead();
    }

    /**
     * read를 호출합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 3:29:08
     *
     * @return ControllerScore 객체
     */
    public ControllerScore getRead() {
        return read;
    }

    /**
     * read 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 3:29:08
     *
     * @param read
     */
    public void setRead(ControllerScore read) {
        this.read = read;
    }

   

}
