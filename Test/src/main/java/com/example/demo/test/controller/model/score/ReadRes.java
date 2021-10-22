package com.example.demo.test.controller.model.score;

import com.example.demo.test.model.Score;

public class ReadRes {
    private Score score;
    
    public ReadRes() {
        
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:46
     *
     * @return 
     */
    public Score getRead() {
        return score;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:46
     *
     * @param score
     */
    public void setRead(Score score) {
        this.score = score;
    }
    
}
