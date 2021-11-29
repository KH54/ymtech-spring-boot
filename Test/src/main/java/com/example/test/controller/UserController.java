package com.example.test.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.Score;
import com.example.test.model.User;
import com.example.test.service.user.UserServiceImpl;

/**
 * 유저의 CRUD 컨트롤러
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 12. 오후 4:33:51
 *
 */
@Validated
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 모든 user를 GET하는 메소드 or 특정 조건을 만족하는 user를 GET하는 메소드
     * 
     * @author "KyungHun Park"
     * @since 2021. 10. 13. 오후 4:51:48
     * 
     * @param id     : 검색 조건을 위한 id
     * @param name   : 검색 조건을 위한 name
     * @param gender : 검색 조건을 위한 gender
     * @param age    : 검색 조건을 위한 age
     * @return : 조회할 User를 JSON 형식으로 출력, 상태 코드 출력
     *
     * @modified 2021.10.13. Kyunghun Park 최초 생성
     *
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Object> getUsers(
            @RequestParam(value = "id", required = false) @Size(min = 1, max = 8) String id, 
            @RequestParam(value = "name", required = false) @Size(min = 1, max = 8) String name,
            @RequestParam(value = "gender", required = false) @Size(min = 1, max = 8) String gender, 
            @RequestParam(value = "age", defaultValue = "0", required = false) int age) {

        return new ResponseEntity<>(userService.getUsers(id, name, gender, age), HttpStatus.OK);
    }

    /**
     * id와 일치하는 user를 GET하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 13. 오후 4:52:39
     *
     * @param id : GET할 User의 id
     * @return 조회할 User를 JSON 형식으로 출력, 상태 코드 출력
     *
     * @modified 2021. 10. 13. Kyunghun Park 최초 생성
     * 
     *
     */
    @RequestMapping(value = "/users/{user-id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUser(@PathVariable("user-id") @NotBlank @Size(min = 1, max = 8) String id) {

        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    /**
     * User 객체의 정보(id,pwd,name)를 입력받아 POST하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 13. 오후 4:53:20
     *
     * @param user : POST할 값을 가진 객체
     * @return : POST한 User를 JSON 형식으로 출력, 상태 코드 출력
     *
     * @modified 2021. 10. 13. Kyunghun Park 최초 생성
     *
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody Score score) {
        return new ResponseEntity<>(userService.createScore(score), HttpStatus.CREATED);
    }

    /**
     * 일치하는 id의 pwd, name을 UPDATE하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 13. 오후 4:54:23
     *
     * @param id   : PATCH할 User의 id
     * @param user : 갱신할 User의 갱신 정보를 담은 객체
     * @return PATCH할 User를 JSON 형식으로 출력, 상태 코드 출력
     *
     * @modified 2021. 10. 13. Kyunghun Park 최초 생성
     *
     */
    @RequestMapping(value = "/users/{user-id}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> updateUser(
            @PathVariable("user-id") @NotBlank String id, 
            @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);
    }

    /**
     * 입력 받은 id와 일치하는 User를 Delete하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 17. 오후 4:36:00
     *
     * @param id : 삭제할 User의 id
     * @return : 삭제할 User를 JSON 형식으로 출력, 상태 코드 출력
     *
     * @modified 2021. 10. 17. Kyunghun Park 최초 생성
     *
     */
    @RequestMapping(value = "/users/{user-id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable("user-id") @NotBlank @Size(min = 1, max = 8) String id) {

        return new ResponseEntity<Object>(userService.deleteUser(id), HttpStatus.OK);
    }
}
