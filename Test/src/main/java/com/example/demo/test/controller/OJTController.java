package com.example.demo.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.test.model.User;

@RestController
public class OJTController {
    /**
     * 조회 등록 수정 삭제
     */

    private static Map<String, User> userRepo = new HashMap<>();

    static {
        User userFirst = new User();
        userFirst.setUserId("ppp");
        userFirst.setUserPwd("dd");
        userFirst.setUserNick("경훈");

        userRepo.put(userFirst.getUserId(), userFirst);

        User userSecond = new User();
        userSecond.setUserId("kkk");
        userSecond.setUserPwd("dd");
        userSecond.setUserNick("가나다");
        userRepo.put(userSecond.getUserId(), userSecond);

    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<Object> getUser() {

        return new ResponseEntity<>(userRepo.values(), HttpStatus.OK);

    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(User user) {
        userRepo.put(user.getUserId(), user);

        return new ResponseEntity<>("create complete", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@PathVariable("userId") String id, User user) {
        userRepo.remove(id);
        user.setUserId(id);
        userRepo.put(id, user);

        return new ResponseEntity<Object>("Update complete", HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable("userId") String id) {
        userRepo.remove(id);

        return new ResponseEntity<Object>("Delete complete", HttpStatus.OK);
    }

}
