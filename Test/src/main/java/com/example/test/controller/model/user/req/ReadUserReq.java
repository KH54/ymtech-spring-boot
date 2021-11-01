package com.example.test.controller.model.user.req;

import com.example.test.model.Score;
import com.example.test.model.User;

/**
 * 사용자의 GET 요청 내용을 담기 위한 Request 
 *
 * @author "KyungHun Park"
 * @since 2021. 11. 1. 오후 1:38:35
 *
 * @modified 2021. 11. 1. 오후 1:38:35 || Kyunghun Park || 최초 생성
 *
 */
public class ReadUserReq {

    private String id;
    private String pwd;
    private String name;
    private String gender;
    private int age;

    public ReadUserReq() {

    }

    public ReadUserReq(String id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public ReadUserReq(User user) {
        this.id = user.getId();
        this.pwd = user.getPwd();
        this.name = user.getName();
        this.gender = user.getGender();
        this.age = user.getAge();
    }

    public ReadUserReq(Score score) {
        this.id = score.getId();
        this.pwd = score.getPwd();
        this.name = score.getName();
        this.gender = score.getGender();
        this.age = score.getAge();
    }

    public ReadUserReq(String id) {
        this.id = id;
    }

    /**
     * id를 호출합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 25. 오후 5:42:54
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
     * @since 2021. 10. 25. 오후 5:42:54
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * name을 호출합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 25. 오후 5:42:54
     *
     * @return
     */

    public String getName() {
        return name;
    }

    /**
     * ReadUserReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 26. 오전 11:56:17
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
     * @since 2021. 10. 26. 오전 11:56:17
     *
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * name 을(를) 지정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 25. 오후 5:42:54
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ReadUserReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 25. 오후 5:42:54
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
     * @since 2021. 10. 25. 오후 5:42:54
     *
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * ReadUserReq.java
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 25. 오후 5:42:54
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
     * @since 2021. 10. 25. 오후 5:42:54
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

}