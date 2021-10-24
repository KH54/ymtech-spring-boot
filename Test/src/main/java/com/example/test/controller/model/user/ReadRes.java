package com.example.test.controller.model.user;

import com.example.test.model.User;

/**
 * 조회 정보를 담기 위한 Response 클래스
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 24. 오후 9:55:01
 *
 * @modified 2021. 10. 24. 오후 9:55:01 || Kyunghun Park || 최초 생성
 *
 */
public class ReadRes {
    private User read;

    public ReadRes() {

    }

    /**
     * read을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 15. 오후 1:41:13
     * @return load
     */
    public User getRead() {
        return read;
    }
    
    /**
     * read을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 15. 오후 1:41:13
     * @param load
     */
    public void setRead(User read) {
        this.read = read;
    }

}