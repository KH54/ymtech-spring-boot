package com.example.demo.test.controller.model.user;

import com.example.demo.test.model.User;

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
