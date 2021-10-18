package com.example.demo.test.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.test.controller.model.CreateResponse;
import com.example.demo.test.controller.model.DeleteResponse;
import com.example.demo.test.controller.model.ReadResponse;
import com.example.demo.test.controller.model.UpdateResponse;
import com.example.demo.test.custom_exception.NullValueObjectException;
import com.example.demo.test.model.User;
import com.example.demo.test.service.UserServiceImpl;

/**
 * 
 * @description : User객체의 CRUD를 담당하는 Service
 *
 * @author : Kyunghun Park
 * @since : 2021. 10. 18. 오전 10:59:01
 *
 */
@Service("userService")
public class UserService implements UserServiceImpl {
    // 유저 정보를 저장할 HashMap
    private static Map<String, User> userMap = new HashMap<>();

    // 기본 생성
    static {
        User defaultUser = new User();
        defaultUser.setUserId("1번유저");
        defaultUser.setUserPwd("1번유저비밀번호");
        defaultUser.setUserNick("1번유저닉네임");
        userMap.put(defaultUser.getUserId(), defaultUser);

        User testUser = new User();
        testUser.setUserId("2번유저");
        testUser.setUserPwd("2번유저비밀번호");
        testUser.setUserNick("2번유저닉네임");
        userMap.put(testUser.getUserId(), testUser);

        User checkUser = new User();
        checkUser.setUserId("3번유저");
        checkUser.setUserPwd("3번유저비밀번호");
        checkUser.setUserNick("3번유저닉네임");
        userMap.put(checkUser.getUserId(), checkUser);
    }

    /**
     * @see com.example.demo.test.service.UserServiceImpl#createUser(com.example.demo.test.model.User)
     */
    @Override
    public CreateResponse createUser(User user) {
        CreateResponse res = new CreateResponse();

        if (!userMap.containsKey(user.getUserId())) {
            userMap.put(user.getUserId(), user);

            res.setCreated(userMap.get(user.getUserId()));
        }
        return res;
    }

    /**
     * @see com.example.demo.test.service.UserServiceImpl#getUser(java.lang.String)
     */
    @Override
    public ReadResponse getUser(String id) {
        ReadResponse res = new ReadResponse();

        if (userMap.containsKey(id)) {
            res.setRead(userMap.get(id));
        }
        return res;
    }

    /**
     * @see com.example.demo.test.service.UserServiceImpl#getAllUsers()
     */
    @Override
    public List<User> getAllUsers() {

        if (userMap.size() == 0) {
            throw new NullValueObjectException();
        }
        return new ArrayList<>(userMap.values());
    }

    /**
     * @see com.example.demo.test.service.UserServiceImpl#updateUser(java.lang.String,
     *      com.example.demo.test.model.User)
     */
    @Override
    public UpdateResponse updateUser(String id, User user) {
        UpdateResponse res = new UpdateResponse();

        // Map에 일치하는 id가 존재하면 실행
        if (userMap.containsKey(id)) {

            // 변경 후 비교하기 위하여 원래 갖고 있던 정보 저장
            res.setBefore(userMap.get(id));

            // 변경될 회원정보에 id 저장
            user.setUserId(id);

            // 입력받은 정보를 가진 객체에 pwd 변경사항이 없는 경우
            if (user.getUserPwd() == null) {
                // user 객체에 userMap의 id(key)값과 일치하는 pwd 저장
                user.setUserPwd(userMap.get(id).getUserPwd());
            }
            // 입력받은 정보를 가진 객체에 Nick 변경사항이 없는 경우
            if (user.getUserNick() == null) {
                // user 객체에 userMap의 id(key)값과 일치하는 Nick 저장
                user.setUserNick(userMap.get(id).getUserNick());
            }

            res.setAfter(user);

            // 변경된 user 객체의 정보를 id(key)값과 일치하는 Map에 저장
            userMap.put(id, user);
        }
        return res;

    }

    /**
     * 
     * @see com.example.demo.test.service.UserServiceImpl#deleteUser(java.lang.String)
     */
    @Override
    public DeleteResponse deleteUser(String id) {
        DeleteResponse res = new DeleteResponse();

        if (userMap.containsKey(id)) {
            res.setDeleted(userMap.get(id));
            userMap.remove(id);
        } else {
            throw new NullValueObjectException();
        }
        return res;
    }

    /**
     * 
     * @see com.example.demo.test.service.UserServiceImpl#getElementUser(String,
     *      String)
     */
    @Override
    public List<User> getElementUser(String pwd, String nick) {

        List<User> elementList = new ArrayList<>();

        if (pwd == null && nick == null) {
            throw new NullPointerException();
        } else {
            for (User userInfo : userMap.values()) {
                if (pwd == null) {
                    if (userInfo.getUserNick().equals(nick)) {
                        elementList.add(userInfo);
                    }
                } else if (nick == null) {
                    if (userInfo.getUserPwd().equals(pwd)) {
                        elementList.add(userInfo);
                    }
                } else {
                    if (userInfo.getUserPwd().equals(pwd) || userInfo.getUserNick() == nick) {
                        elementList.add(userInfo);
                    }
                }
            }
        }

        return elementList;
    }
}