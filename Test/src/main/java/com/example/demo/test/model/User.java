package com.example.demo.test.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

/**
 * 
 * @description : User 객체의 생성자
 *
 * @author : Kyunghun Park
 * @since : 2021. 10. 18. 오전 11:05:39
 *
 */
@Validated
public class User {
    // 유저 ID -- PK
    @NotBlank(message="plz insert value")
    @Size(max=8)
    private String id;
    // 유저 PW
    @NotBlank
    @Size(max=16)
    private String pwd;
    // 유저 닉네임
    @NotBlank
    @Size(max=8)
    private String name;
    @NotBlank
    @Size(max=8)
    private String gender;
    @Positive
    private int age;

    public User() {

    }

    // 생성자 오버로딩
    public User(String id, String pwd, String name, String gender, int age) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
    
   

    /**
     * id을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 12. 오후 1:18:48
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * id을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 12. 오후 1:18:48
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * pwd을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 12. 오후 1:18:48
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * pwd을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 12. 오후 1:18:48
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * name을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 12. 오후 1:18:48
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * name을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 12. 오후 1:18:48
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gender를 가져옵니다.
     * 
     * @author "KyungHun Park"
     * @since 2021. 10. 18.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 
     * geder를 설정합니다.
     * 
     * @author "KyungHun Park"
     * @since 2021. 10. 18.
     *
     * @param gender :
     *
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * age를 호출합니다.
     * 
     * @author "KyungHun Park"
     * @since 2021. 10. 18.
     *
     *
     */
    public int getAge() {
        return age;
    }

    /**
     * age를 설정합니다.
     * 
     * @author "KyungHun Park"
     * @since 2021. 10. 18.
     *
     * @param age : 나이
     *
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [id=");
        builder.append(id);
        builder.append(", pwd=");
        builder.append(pwd);
        builder.append(", name=");
        builder.append(name);
        builder.append(", gender=");
        builder.append(gender);
        builder.append(", age=");
        builder.append(age);
        builder.append("]");
        return builder.toString();
    }


}