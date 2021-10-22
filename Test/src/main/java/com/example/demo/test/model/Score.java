package com.example.demo.test.model;

public class Score extends User {
    private String id;

    private int korean;
    private int math;
    private int english;
    private int science;
    private int average;

    public Score() {

    }
    

    public Score(String id, int korean, int math, int english, int science, int average) {
        this.id = id;
        this.korean = korean;
        this.math = math;
        this.english = english;
        this.science = science;
        this.average = average;
    }


    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @return
     */
    public int getKorean() {
        return korean;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @param korean
     */
    public void setKorean(int korean) {
        this.korean = korean;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @return
     */
    public int getMath() {
        return math;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @param math
     */
    public void setMath(int math) {
        this.math = math;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @return
     */
    public int getEnglish() {
        return english;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @param english
     */
    public void setEnglish(int english) {
        this.english = english;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @return
     */
    public int getScience() {
        return science;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @param science
     */
    public void setScience(int science) {
        this.science = science;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @return
     */
    public int getAverage() {
        return average;
    }

    /**
     * 
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 19. 오후 4:16:12
     *
     * @param average
     */
    public void setAverage(int average) {
        this.average = average;
    }

}
