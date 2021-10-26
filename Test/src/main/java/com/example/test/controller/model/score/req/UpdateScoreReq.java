package com.example.test.controller.model.score.req;

import com.example.test.controller.model.score.ControllerScore;
import com.example.test.model.Score;

public class UpdateScoreReq {
    private ControllerScore update;


    public UpdateScoreReq() {

    }

    public UpdateScoreReq(Score score) {
        this.update = new ControllerScore(score);
    }

    /**
     * UpdateScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:07:14
     *
     * @return 
     */
    public ControllerScore getUpdate() {
        return update;
    }

    /**
     * update 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:07:14
     *
     * @param update
     */
    public void setUpdate(ControllerScore update) {
        this.update = update;
    }
    
    public void setUpdate(Score score) {
        this.update = new ControllerScore(score);
    }

}
