package com.example.demo.test.controller.model.user;

import com.example.demo.test.model.User;

public class CreateRes {

    private User create;

    public CreateRes() {

    }

    /**
     * created을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 15. 오전 10:57:07
     * @return created
     */
    public User getCreate() {
        return create;
    }

    /**
     * created을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 15. 오전 10:57:07
     * @param created
     */
    public void setCreated(User create) {
        this.create = create;
    }

}