package com.example.demo.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.test.model.User;
import com.example.demo.test.service.impl.UserService;

/**
 * 유저의 CRUD 컨트롤러
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 12. 오후 4:33:51
 *
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 모든 user를 GET하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 13. 오후 4:51:48
     *
     * @return 생성한 User를 JSON 형식으로 출력, 상태 코드 출력
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);

    }

    /**
     * id와 일치하는 유저를 GET하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 13. 오후 4:52:39
     *
     * @param id : GET할 User의 id
     * @return 조회할 User를 JSON 형식으로 출력, 상태 코드 출력
     */
    @RequestMapping(value = "/users/{user-id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUser(@PathVariable("user-id") String id) {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    /**
     * User 객체의 정보(id,pwd,nick)를 입력받아 POST하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 13. 오후 4:53:20
     *
     * @param user : 등록할 내용을 입력받은 정보를 가진 객체
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    /**
     * 일치하는 id의 pwd, nick을 변경하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 13. 오후 4:54:23
     *
     * @param id   : 갱신할 User의 id
     * @param user : 갱신할 User의 갱신 정보를 담은 객체
     * @return 갱신할 User를 JSON 형식으로 출력, 상태 코드 출력
     */
    @RequestMapping(value = "/users/{user-id}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> updateUser(@PathVariable("user-id") String id, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(id, user), HttpStatus.OK);

    }

    /**
     * 입력 받은 id와 일치하는 User를 삭제하는 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 17. 오후 4:36:00
     *
     * @param id : 삭제할 User의 id
     * @return 삭제할 User를 JSON 형식으로 출력, 상태 코드 출력
     */
    @RequestMapping(value = "/users/{user-id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable("user-id") String id) {

        return new ResponseEntity<Object>(userService.deleteUser(id), HttpStatus.OK);
    }

    /**
     * 파라미터로 들어온 정보를 포함하는 User 객체를 출력하는 메소드
     * 
     * @author "KyungHun Park"
     * @since 2021. 10. 18.
     *
     * @param pwd  : 조회할 pwd
     * @param nick : 조회할 nick
     * @return 조회할 User를 JSON 형식으로 출력, 상태 코드 출력
     */
    @RequestMapping(value = "/users/element", method = RequestMethod.GET)
    public ResponseEntity<Object> getElementUser(@RequestParam(value = "pwd", required = false) String pwd, @RequestParam(value = "nick", required = false) String nick) {

        return new ResponseEntity<Object>(userService.getElementUser(pwd, nick), HttpStatus.OK);

    }

}
