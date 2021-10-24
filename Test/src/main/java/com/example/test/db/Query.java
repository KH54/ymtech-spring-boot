package com.example.test.db;


/**
 * DB 연결 및 연결 정보, 쿼리
 *
 * @author "KyungHun Park"
 * @since 2021. 9. 9. 오전 11:36:51
 *
 */
public class Query {

    // 유저 쿼리
    public static final String SQL_USER_INSERT = "INSERT INTO user(id, pwd, name, gender, age) values(?,?,?,?,?)";
    public static final String SQL_USER_DELETE = "DELETE FROM user WHERE id = ?";
    public static final String SQL_USER_UPDATE = "UPDATE user SET pwd = ?, name = ?, gender = ?, age = ? WHERE id = ?";
    public static final String SQL_USER_SELECT = "SELECT * FROM user";
    public static final String SQL_USER_SELECT_ID = "SELECT * FROM  user WHERE id = ?";
    public static final String SQL_USER_SELECT_PW = "SELECT pwd FROM user WHERE id = ?";
    public static final String SQL_USER_SELECT_ELE = "SELECT * FROM user WHERE 1=1 {where_clause}";

    //점수 쿼리
    public static final String SQL_USER_SCORE_SELECT = "SELECT * FROM user JOIN user_score ON user.id = user_score.user_id ;";
    public static final String SQL_SCORE_UPDATE = "UPDATE user_score SET korean = ?, math = ?, english = ?, science = ?, average = ? WHERE user_id = ?";
    public static final String SQL_SCORE_DELETE = "DELETE FROM user_score WHERE user_id = ?";
    public static final String SQL_SCORE_SELECT = "SELECT * FROM user JOIN user_score ON user.id = user_score.user_id WHERE user.id= ?";
    //SELECT * FROM user JOIN user_score ON user.id = user_score.user_id WHERE user.id="119";
}