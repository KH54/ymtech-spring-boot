package com.example.test.controller.model.user;

import com.example.test.model.User;

/**
 * 삭제할 정보를 담기 위한 Response 클래스
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 24. 오후 9:55:51
 *
 * @modified 2021. 10. 24. 오후 9:55:51 || Kyunghun Park || 최초 생성
 *
 */
public class DeleteRes {
    private User deleted;

    public DeleteRes() {

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
