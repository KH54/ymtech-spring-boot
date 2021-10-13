package com.example.demo.test.model;

/**
 * @Entity JPA가 관리하는 Class임을 명시 매핑할 테이블네임을 속성에 입력
 * @Id 기본키로 설정하는 어노테이션
 * 
 * @author "KyungHun Park"
 * @since 2021. 10. 12. 오후 1:44:24
 *
 */
public class User {
    // 유저 ID -- PK   
    private String userId;
    // 유저 PW
    private String userPwd;
    // 유저 닉네임
    private String userNick;

    public User() {

    }

    // 생성자 오버로딩
    public User(String userId, String userPwd, String userNick) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userNick = userNick;
    }

    /**
     * userId을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 12. 오후 1:18:48
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * userId을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 12. 오후 1:18:48
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * userPwd을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 12. 오후 1:18:48
     * @return userPwd
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * userPwd을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 12. 오후 1:18:48
     * @param userPwd
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * userNick을(를) 가져옵니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 12. 오후 1:18:48
     * @return userNick
     */
    public String getUserNick() {
        return userNick;
    }

    /**
     * userNick을(를) 설정합니다.
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 12. 오후 1:18:48
     * @param userNick
     */
    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    /**
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 13. 오후 1:48:59
     * @see
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[userId=");
        builder.append(userId);
        builder.append(", userPwd=");
        builder.append(userPwd);
        builder.append(", userNick=");
        builder.append(userNick);
        builder.append("]");
        return builder.toString();
    }

}