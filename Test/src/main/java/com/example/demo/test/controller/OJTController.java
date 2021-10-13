package com.example.demo.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.test.model.User;

// 수정, 삭제할 때마다 GET
// RequestBody
// ResponseEntity<>() 데이터 검증, GET 메소드
/**
 * CRUD Controller 생성
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 12. 오후 4:33:51
 *
 */
@RestController
public class OJTController {
//    private static final Logger LOGGER = LogManager.getLogger(OJTController.class);

    private static Map<String, User> userMap = new HashMap<>();

    /**
     * 모든 user를 GET하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 13. 오후 4:51:48
     *
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUsers() {

        return new ResponseEntity<>(userMap.values(), HttpStatus.OK);

    }

    /**
     * id와 일치하는 유저를 GET하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 13. 오후 4:52:39
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/users/{user-id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUser(@PathVariable("user-id") String id) {
        // 일치하는 아이디가 있으면 GET
        if (userMap.containsKey(id)) {
            return new ResponseEntity<>(userMap.get(id), HttpStatus.OK);
        }
        return null;
    }

    /**
     * User 객체의 정보(id,pwd,nick)를 입력받아 POST하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 13. 오후 4:53:20
     *
     * @param user POST할 내용을 입력받은 정보를 가진 객체
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody User user) {
        StringBuilder result = new StringBuilder();
        
        userMap.put(user.getUserId(), user);
        
        result.append("Post result : ");
        result.append(user.toString());
        
        return new ResponseEntity<>(result.toString(), HttpStatus.CREATED);
    }

    /**
     * 일치하는 id의 pwd, nick을 변경하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 13. 오후 4:54:23
     *
     * @param id   변경할 user의 id - PK 값
     * @param user 업데이트할 내용을 입력받은 정보를 가진 객체
     * @return
     */
    @RequestMapping(value = "/users/{user-id}", method = RequestMethod.PATCH)
    public ResponseEntity<String> updateUser(@PathVariable("user-id") String id, @RequestBody User user) {
        StringBuilder result = new StringBuilder();

        // Map에 일치하는 id가 존재하면 실행
        if (userMap.containsKey(id)) {

            // 변경 후 비교하기 위하여 원래 갖고 있던 정보 저장
            User beforeUser = userMap.get(id);

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

            // 변경된 user 객체의 정보를 id(key)값과 일치하는 Map에 저장
            userMap.put(id, user);

            // 기존 정보와 변경된 정보 결합
            result.append("Before : ");
            result.append(beforeUser.toString());
            result.append("\nAfter : ");
            result.append(user.toString());

            return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
        }
        return null;
    }

    /**
     * DELETE 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 12. 오후 4:36:00
     *
     * @param id 유저의 id를 입력 받아 일치하는 id와 삭제하는 메소드
     * @return
     */
    @RequestMapping(value = "/users/{user-id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable("user-id") String id) {
        StringBuilder result = new StringBuilder();
        
        if(userMap.containsKey(id)) {
        userMap.remove(id);
        
        result.append(id);
        result.append("is delete");
        
        return new ResponseEntity<String>(result.toString(), HttpStatus.OK);
        }
        return null;
    }

}
