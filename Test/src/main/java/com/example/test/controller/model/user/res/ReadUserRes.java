package com.example.test.controller.model.user.res;

import com.example.test.controller.model.user.ControllerUser;
import com.example.test.controller.model.user.req.ReadUserReq;

/**
 * 조회 정보를 담기 위한 Response 클래스
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 24. 오후 9:55:01
 *
 * @modified 2021. 10. 24. 오후 9:55:01 || Kyunghun Park || 최초 생성
 *
 */
public class ReadUserRes{
    private ControllerUser read;

    public ReadUserRes() {

    }
    
    /**
     * ReadUserRes.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오전 11:38:31
     *
     * @return 
     */
    public ControllerUser getRead() {
        return read;
    }

    /**
     * read 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오전 11:38:31
     *
     * @param read
     */
    public void setRead(ControllerUser read) {
        this.read = read;
    }

}
