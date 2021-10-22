package com.example.demo.test.model;

import java.util.List;

public class UserScore {

    List<Score> score;
    List<User> user;

    public UserScore() {

    }

    public UserScore(List<User> user, List<Score> score) {
        this.score = score;
        this.user = user;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 20. 오후 4:47:37
     *
     * @return 
     */
    public List<Score> getScore() {
        return score;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 20. 오후 4:47:37
     *
     * @param score
     */
    public void setScore(List<Score> score) {
        this.score = score;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 20. 오후 4:47:37
     *
     * @return 
     */
    public List<User> getUser() {
        return user;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 20. 오후 4:47:37
     *
     * @param user
     */
    public void setUser(List<User> user) {
        this.user = user;
    }

}
