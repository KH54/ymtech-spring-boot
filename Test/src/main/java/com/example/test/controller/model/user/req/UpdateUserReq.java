package com.example.test.controller.model.user.req;

import com.example.test.controller.model.user.ControllerUser;
import com.example.test.model.User;

public class UpdateUserReq {
    private ControllerUser update;

    public UpdateUserReq() {

    }

    public UpdateUserReq(User user) {
        this.update = new ControllerUser(user);
    }

    /**
     * UpdateUserReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 2:39:52
     *
     * @return
     */
    public ControllerUser getUpdate() {
        return update;
    }

    /**
     * update 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 2:39:52
     *
     * @param update
     */
    public void setUpdate(ControllerUser update) {
        this.update = update;
    }
    
    public void setUpdate(User user) {
        this.update = new ControllerUser(user);
    }

}