package com.example.test.controller.model.user;

import com.example.test.model.User;

/**
 * Create 정보를 담기 위한 Response 클래스
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 24. 오후 9:49:57
 *
 * @modified 2021. 10. 24. 오후 9:49:57 || Kyunghun Park || 최초 생성
 *
 */
public class CreateRes {

    private User create;

    public CreateRes() {

    }

    /**
     * create을(를) 호출합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 15. 오전 10:57:07
     * @return created
     */
    public User getCreate() {
        return create;
    }

    /**
     * create을(를) 설정합니다.
     * 
     * @author "KyungHun Park"
     * @since 2021. 10. 15. 오전 10:57:07
     * @param created
     */
    public void setCreated(User create) {
        this.create = create;
    }

}