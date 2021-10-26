package com.example.test.controller.model.score.req;

import com.example.test.controller.model.score.ControllerScore;
import com.example.test.model.Score;

public class ReadScoreReq {
    private ControllerScore read;
    private String id;
    private int korean;
    private int math;
    private int english;
    private int science;
    private int average;
    
    public ReadScoreReq() {
        
    }

    public ReadScoreReq(Score score) {
        this.korean = score.getKorean();
        this.math = score.getMath();
        this.english = score.getEnglish();
        this.science = score.getScience();
        this.average = score.getAverage();
    }
    
    public ReadScoreReq(String id) {
        this.id = id;
    }

    
    /**
     * ReadScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 3:43:45
     *
     * @return 
     */
    public int getKorean() {
        return korean;
    }

    /**
     * korean 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 3:43:45
     *
     * @param korean
     */
    public void setKorean(int korean) {
        this.korean = korean;
    }

    /**
     * ReadScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 3:43:45
     *
     * @return 
     */
    public int getMath() {
        return math;
    }

    /**
     * math 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 3:43:45
     *
     * @param math
     */
    public void setMath(int math) {
        this.math = math;
    }

    /**
     * ReadScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 3:43:45
     *
     * @return 
     */
    public int getEnglish() {
        return english;
    }

    /**
     * english 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 3:43:45
     *
     * @param english
     */
    public void setEnglish(int english) {
        this.english = english;
    }

    /**
     * ReadScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 3:43:45
     *
     * @return 
     */
    public int getScience() {
        return science;
    }

    /**
     * science 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 3:43:45
     *
     * @param science
     */
    public void setScience(int science) {
        this.science = science;
    }

    /**
     * ReadScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 3:43:45
     *
     * @return 
     */
    public int getAverage() {
        return average;
    }

    /**
     * average 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 3:43:45
     *
     * @param average
     */
    public void setAverage(int average) {
        this.average = average;
    }

    /**
     * ReadScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 3:25:04
     *
     * @return 
     */
    public ControllerScore getRead() {
        return read;
    }

    /**
     * read 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 3:25:04
     *
     * @param read
     */
    public void setRead(ControllerScore read) {
        this.read = read;
    }

    /**
     * ReadScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 3:36:34
     *
     * @return 
     */
    public String getId() {
        return id;
    }

    /**
     * id 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 3:36:34
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
}
