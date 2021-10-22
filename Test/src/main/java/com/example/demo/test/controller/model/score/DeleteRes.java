package com.example.demo.test.controller.model.score;

import com.example.demo.test.model.Score;

public class DeleteRes {
    Score deleted;
    
    public DeleteRes() {
        
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 22. 오후 1:22:31
     *
     * @return 
     */
    public Score getDeleted() {
        return deleted;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 22. 오후 1:22:31
     *
     * @param deleted
     */
    public void setDeleted(Score deleted) {
        this.deleted = deleted;
    }
    
    
}
