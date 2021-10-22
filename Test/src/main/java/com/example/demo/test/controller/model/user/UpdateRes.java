package com.example.demo.test.controller.model.user;

import com.example.demo.test.model.User;

public class UpdateRes {
    private User before;
    private User after;
    
    public UpdateRes() {
        
    }
    /**
     * before을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 15. 오전 11:06:04
     * @return before
     */
    public User getBefore() {
        return before;
    }
    /**
     * before을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 15. 오전 11:06:04
     * @param before 
     */
    public void setBefore(User before) {
        this.before = before;
    }
    /**
     * after을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 15. 오전 11:06:04
     * @return after
     */
    public User getAfter() {
        return after;
    }
    /**
     * after을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 15. 오전 11:06:04
     * @param after 
     */
    public void setAfter(User after) {
        this.after = after;
    }
    
    
}
