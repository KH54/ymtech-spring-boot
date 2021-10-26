package com.example.test.controller.model.score.res;

import com.example.test.controller.model.score.ControllerScore;
import com.example.test.model.Score;

public class CreateScoreRes {
    private ControllerScore create;
    
    public CreateScoreRes() {
        
    }

    /**
     * CreateScoreRes.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:48:43
     *
     * @return 
     */
    public ControllerScore getCreate() {
        return create;
    }

    /**
     * create 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:48:43
     *
     * @param create
     */
    public void setCreate(ControllerScore create) {
        this.create = create;
    }
    
    public void setCreate(Score score) {
        this.create = new ControllerScore(score);
    }


}