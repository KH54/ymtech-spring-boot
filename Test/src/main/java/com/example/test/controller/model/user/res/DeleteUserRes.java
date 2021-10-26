package com.example.test.controller.model.user.res;

import com.example.test.controller.model.user.ControllerUser;
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
public class DeleteUserRes {
    private ControllerUser delete;

    public DeleteUserRes() {

    }

    /**
     * DeleteUserRes.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 1:59:46
     *
     * @return 
     */
    public ControllerUser getDelete() {
        return delete;
    }

    /**
     * deleted 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 1:59:46
     *
     * @param deleted
     */
    public void setDelete(ControllerUser delete) {
        this.delete = delete;
    }
    
    public void setDelete(User user) {
        this.delete = new ControllerUser(user);
    }

}
