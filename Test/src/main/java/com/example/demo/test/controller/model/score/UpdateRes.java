package com.example.demo.test.controller.model.score;

import com.example.demo.test.model.Score;
import com.example.demo.test.model.User;

public class UpdateRes {
    private Score before;
    private Score after;
    public UpdateRes() {
        
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:38:25
     *
     * @return 
     */
    public Score getBefore() {
        return before;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:38:25
     *
     * @param before
     */
    public void setBefore(Score before) {
        this.before = before;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:38:25
     *
     * @return 
     */
    public Score getAfter() {
        return after;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:38:25
     *
     * @param after
     */
    public void setAfter(Score after) {
        this.after = after;
    }
    
    public void setAfter(Score after, Score before) {
        this.after = after;
        before.getPwd();
        before.getName();
        before.getGender();
        before.getAge();
        
    }
     
}
