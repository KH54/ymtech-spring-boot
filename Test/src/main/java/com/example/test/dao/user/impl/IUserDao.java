package com.example.test.dao.user.impl;

import java.util.List;

import com.example.test.model.User;

/**
 * UserDao의 메소드를 지정하기 위한 interface
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 24. 오후 9:31:30
 *
 * @modified 2021. 10. 24. 오후 9:31:30 || Kyunghun Park || 최초 생성
 *
 */
public interface IUserDao {
    /**
     * 모든 유저의 정보(성적 미포함)를 DB에서 조회 및 특정 조건을 만족하는 유저를 조회하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 24. 오후 9:31:43
     * 
     * @param id     : 검색 조건을 위한 유저 id
     * @param name   : 검색 조건을 위한 유저 name
     * @param gender : 검색 조건을 위한 유저 gender
     * @param age    : 검색 조건을 위한 유저 age
     * @return : 결과를 List로 반환
     *
     * @modified 2021. 10. 24. 오후 9:31:43 || Kyunghun Park || 최초 생성
     *
     */
    public List<User> getUsers(String id, String name, String gender, int age);

    /**
     * 특정 유저의 정보(성적 미포함)을 조회하기 위한 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 24. 오후 9:33:16
     * 
     * @param id : 조회할 유저의 id
     * @return : 조회 결과를 User 객체로 반환
     *
     * @modified 2021. 10. 24. 오후 9:33:16 || Kyunghun Park || 최초 생성
     *
     */
    public User getUser(String id);

    /**
     * 새로운 유저를 DB에 저장하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 24. 오후 9:33:43
     * 
     * @param user : 저장할 정보를 담은 User 객체
     * @return : 저장에 성공하면 1 실패하면 0 반환 
     *
     * @modified 2021. 10. 24. 오후 9:33:43 || Kyunghun Park || 최초 생성
     *
     */
    public int createUser(User user);

    /**
     * 특정 유저 정보를 삭제하기 위한 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 24. 오후 9:35:46
     * 
     * @param id : 삭제할 유저의 id
     * @return : 성공하면 1 실패하면 0 반환
     *
     * @modified 2021. 10. 24. 오후 9:35:46 || Kyunghun Park || 최초 생성
     *
     */
    public int deleteUser(String id);

    /**
     * 특정 유저의 정보를 수정하기 위한 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 24. 오후 9:36:12
     * 
     * @param user : 수정할 정보를 가진 User 객체
     * @return : 수정에 성공한 개수만큼 Integer로 반환
     *
     * @modified 2021. 10. 24. 오후 9:36:12 || Kyunghun Park || 최초 생성
     *
     */
    public int updateUser(User user);
}