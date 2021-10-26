package com.example.test.controller.model.user.res;

import com.example.test.controller.model.user.ControllerUser;
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
public class CreateUserRes {

    private ControllerUser create;

    public CreateUserRes() {

    }

    /**
     * CreateUserRes.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 1:26:34
     *
     * @return 
     */
    public ControllerUser getCreate() {
        return create;
    }

    /**
     * create 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 1:26:34
     *
     * @param create
     */
    public void setCreate(ControllerUser create) {
        this.create = create;
    }
    
    public void setCreate(User user) {
        this.create = new ControllerUser(user);
    }



}