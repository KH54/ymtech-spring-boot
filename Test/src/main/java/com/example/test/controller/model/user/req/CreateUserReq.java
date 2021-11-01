package com.example.test.controller.model.user.req;

import com.example.test.controller.model.score.ControllerScore;
import com.example.test.controller.model.user.ControllerUser;
import com.example.test.model.User;

/**
 * 사용자의 유저 Create 생성 결과를 담기 위한 Response
 *
 * @author "KyungHun Park"
 * @since 2021. 11. 1. 오후 1:38:07
 *
 * @modified 2021. 11. 1. 오후 1:38:07 || Kyunghun Park || 최초 생성
 *
 */
public class CreateUserReq {
    private ControllerScore controlScore;
    private ControllerUser controlUser;

    public CreateUserReq() {

    }

    public CreateUserReq(ControllerScore controllerScore) {
        this.controlScore.setId(controllerScore.getId());
        this.controlScore.setPwd(controllerScore.getPwd());
        this.controlScore.setName(controllerScore.getName());
        this.controlScore.setGender(controllerScore.getGender());
        this.controlScore.setAge(controllerScore.getAge());
    }
    
    public CreateUserReq(User user) {
        this.controlUser = new ControllerUser(user);
    }

    /**
     * CreateUserReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 1:51:14
     *
     * @return 
     */
    public ControllerScore getControlScore() {
        return controlScore;
    }

    /**
     * controlScore 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 1:51:14
     *
     * @param controlScore
     */
    public void setControlScore(ControllerScore controlScore) {
        this.controlScore = controlScore;
    }

    /**
     * CreateUserReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 1:51:14
     *
     * @return 
     */
    public ControllerUser getControlUser() {
        return controlUser;
    }

    /**
     * controlUser 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 1:51:14
     *
     * @param controlUser
     */
    public void setControlUser(ControllerUser controlUser) {
        this.controlUser = controlUser;
    }


}