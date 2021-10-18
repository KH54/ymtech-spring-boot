package com.example.demo.test.controller.model;

import com.example.demo.test.model.User;

public class ReadResponse {
    private User read;

    public ReadResponse() {

    }

    /**
     * load을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 15. 오후 1:41:13
     * @return load
     */
    public User getRead() {
        return read;
    }

    /**
     * load을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 15. 오후 1:41:13
     * @param load
     */
    public void setRead(User read) {
        this.read = read;
    }

}
