package com.example.test.controller.model.score.req;

import java.util.UUID;

import com.example.test.controller.model.score.ControllerScore;
import com.example.test.model.Score;

public class CreateScoreReq {
    private ControllerScore create;

    private String uuid;
    private String id;
    private String pwd;
    private String name;
    private String gender;
    private int age;
    private int korean;
    private int math;
    private int english;
    private int science;
    private int average;

    public CreateScoreReq() {

    }
    


    public CreateScoreReq(Score score) {
        this.uuid = UUID.randomUUID().toString();
        this.id = score.getId();
        this.pwd = score.getPwd();
        this.name = score.getName();
        this.gender = score.getGender();
        this.age = score.getAge();
        this.korean = score.getKorean();
        this.math = score.getMath();
        this.english = score.getEnglish();
        this.science = score.getScience();
        this.average = score.getAverage();
    }
    

    /**
     * CreateScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:45:03
     *
     * @return
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * uuid 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:45:03
     *
     * @param uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * CreateScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:45:03
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
     * @since 2021. 10. 26. 오후 5:45:03
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * CreateScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:45:03
     *
     * @return
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * pwd 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:45:03
     *
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * CreateScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:45:03
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * name 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:45:03
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * CreateScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:45:03
     *
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     * gender 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:45:03
     *
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * CreateScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:45:03
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * age 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:45:03
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * CreateScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:45:03
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
     * @since 2021. 10. 26. 오후 5:45:03
     *
     * @param korean
     */
    public void setKorean(int korean) {
        this.korean = korean;
    }

    /**
     * CreateScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:45:03
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
     * @since 2021. 10. 26. 오후 5:45:03
     *
     * @param math
     */
    public void setMath(int math) {
        this.math = math;
    }

    /**
     * CreateScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:45:03
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
     * @since 2021. 10. 26. 오후 5:45:03
     *
     * @param english
     */
    public void setEnglish(int english) {
        this.english = english;
    }

    /**
     * CreateScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:45:03
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
     * @since 2021. 10. 26. 오후 5:45:03
     *
     * @param science
     */
    public void setScience(int science) {
        this.science = science;
    }

    /**
     * CreateScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오후 5:45:03
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
     * @since 2021. 10. 26. 오후 5:45:03
     *
     * @param average
     */
    public void setAverage(int average) {
        this.average = average;
    }

    /**
     * CreateScoreReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오전 9:50:31
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
     * @since 2021. 10. 26. 오전 9:50:31
     *
     * @param create
     */
    public void setCreate(ControllerScore create) {
        this.create = create;
    }

}