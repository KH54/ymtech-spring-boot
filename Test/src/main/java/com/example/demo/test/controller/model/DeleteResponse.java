package com.example.demo.test.controller.model;

import com.example.demo.test.model.User;

public class DeleteResponse {
    private User deleted;

    public DeleteResponse() {

    }

    /**
     * deleted을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 15. 오후 1:49:54
     * @return deleted
     */
    public User getDeleted() {
        return deleted;
    }

    /**
     * deleted을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 15. 오후 1:49:54
     * @param deleted
     */
    public void setDeleted(User deleted) {
        this.deleted = deleted;
    }

}
