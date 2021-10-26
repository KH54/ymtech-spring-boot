package com.example.test.controller.model.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.example.test.controller.model.user.res.UpdateUserRes;
import com.example.test.model.User;

/**
 * User 객체 생성을 위한 메소드
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 24. 오후 9:46:56
 * 
 * @Validated : 유효성 검사를 위한 annotation
 *
 * @modified 2021. 10. 24. 오후 9:46:56 || Kyunghun Park || 최초 생성
 * 
 */
@Validated
public class ControllerUser {
    // 유저 ID -- PK
    @NotBlank(message = "plz correct id(Nonblank, NonEmpty)")
    @Size(max = 8)
    private String id;

    // 유저 비밀번호, 이름, 성별, 나이
    @NotBlank(message = "plz correct password(Nonblank, NonEmpty)")
    @Size(max = 16)
    private String pwd;
    @NotBlank(message = "plz correct password(Nonblank, NonEmpty)")
    @Size(max = 8)
    private String name;
    @NotBlank(message = "plz correct password(Nonblank, NonEmpty)")
    @Size(max = 8)
    private String gender;
    @Positive(message = "plz positive age")
    private int age;

    // 기본 생성자
    public ControllerUser() {
        this.getId();
        this.getPwd();
        this.getName();
        this.getGender();
        this.getAge();
    }

    public ControllerUser(String id, String pwd, String name, String gender, int age) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public ControllerUser(User user) {
        this.id = user.getId();
        this.pwd = user.getPwd();
        this.name = user.getName();
        this.gender = user.getGender();
        this.age = user.getAge();
    }

    public ControllerUser(String id) {
        this.id = id;
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