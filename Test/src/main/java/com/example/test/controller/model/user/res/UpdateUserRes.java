package com.example.test.controller.model.user.res;

import com.example.test.controller.model.user.ControllerUser;
import com.example.test.model.User;

/**
 * Update Response 객체
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 15. 오전 11:04:04
 *
 * @modified 2021. 10. 15. 오전 11:04:04 || Kyunghun Park || 최초 생성
 *
 */
public class UpdateUserRes {
    private ControllerUser before;
    private ControllerUser after;

    public UpdateUserRes() {

    }

    /**
     * UpdateUserRes.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 2:29:23
     *
     * @return
     */
    public ControllerUser getBefore() {
        return before;
    }

    /**
     * before 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 2:29:23
     *
     * @param before
     */
    public void setBefore(ControllerUser before) {
        this.before = before;
    }

    public void setBefore(User user) {
        this.before = new ControllerUser(user);
    }

    /**
     * UpdateUserRes.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 2:29:23
     *
     * @return
     */
    public ControllerUser getAfter() {
        return after;
    }

    /**
     * after 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 2:29:23
     *
     * @param after
     */
    public void setAfter(User after) {
        this.after = new ControllerUser(after);
    }

}
