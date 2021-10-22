package com.example.demo.test.service.user.impl;

import java.util.List;

import com.example.demo.test.controller.model.user.CreateRes;
import com.example.demo.test.controller.model.user.DeleteRes;
import com.example.demo.test.controller.model.user.ReadRes;
import com.example.demo.test.controller.model.user.UpdateRes;
import com.example.demo.test.model.User;

/**
 * 
 * @description : User의 Service 인터페이스 
 *
 * @author : Kyunghun Park 
 * @since : 2021. 10. 18. 오전 11:06:22
 *
 */
public interface IUserService {

    /**
     * User 생성 메소드
     * 
     * @author "KyungHun Park"
     * @since 2021. 10. 18.
     *
     * @param user : 입력 받은 정보를 가진 객체
     * @return 생성된 user 객체의 정보
     */
    public CreateRes createUser(User user);

    /**
     * 입력받은 id와 일치하는 User의 정보를 읽어 오는 메소드
     * 
     * @author "KyungHun Park"
     * @since 2021. 10. 18.
     *
     * @param id 읽어오려는 id의 정보를 담은 변수
     * @return 조회할 id 정보
     */
    public ReadRes getUser(String id);

    /**
     * 모든 User의 정보를 읽어 오는 메소드
     * 
     * @author "KyungHun Park"
     * @since 2021. 10. 18.
     *
     * @return 조회할 user 객체 전부
     */
    public List<User> getUsers(String name, String gender, int age);

    /**
     * id에 해당하는 User의 정보를 수정하는 메소드
     * 
     * @author "KyungHun Park"
     * @since 2021. 10. 18.
     *
     * @param id   : 수정하려는 id의 정보를 담은 변수
     * @param user : 수정하고자 하는 내용을 담은 객체
     * @return 갱신할 user 객체의 정보
     */
    public UpdateRes updateUser(String id, User user);

    /**
     * 입력받은 id와 일치하는 User를 삭제하는 메소드
     * 
     * @author "KyungHun Park"
     * @since 2021. 10. 18.
     *
     * @param id : 삭제할 id의 변수
     * @return id를 통해 삭제할 user 객체
     */
    public DeleteRes deleteUser(String id);
}