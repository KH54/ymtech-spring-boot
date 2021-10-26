package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.Score;
import com.example.test.service.score.ScoreServiceImpl;

@RestController
public class ScoreController {

    @Autowired
    ScoreServiceImpl scoreService;

    /**
     * 모든 User와 Score의 정보를 GET하는 컨트롤러 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 24. 오후 7:06:31
     * 
     * @return : GET한 정보를 JSON 형식으로 출력, 상태 코드 출력
     *
     * @modified 2021. 10. 24. 오후 7:06:31 || Kyunghun Park || 최초 생성
     *
     */
    @RequestMapping(value = "/users/score", method = RequestMethod.GET)
    public ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(scoreService.getAll(), HttpStatus.OK);
    }

    /**
     * 특정 User와 Score의 정보를 GET하는 컨트롤러 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 24. 오후 7:13:19
     * 
     * @param id : GET할 Score의 id
     * @return : GET한 정보를 JSON 형식으로 출력, 상태 코드 출력
     *
     * @modified 2021. 10. 24. 오후 7:13:19 || Kyunghun Park || 최초 생성
     *
     */
    @RequestMapping(value = "/users/score/{user-id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getScore(@PathVariable("user-id") String id) {
        return new ResponseEntity<>(scoreService.getScore(id), HttpStatus.OK);

    }

    /**
     * 특정 User의 Score를 PATCH하는 컨트롤러 메소드
     *
     * @author "KyungHun Park"
     * @since 2021. 10. 24. 오후 7:14:56
     * 
     * @param id    : PATCH할 Score의 id
     * @param score : PATCH할 Score를 담은 객체
     * @return : PATCH한 정보를 JSON 형식으로 출력, 상태 코드 출력
     *
     * @modified 2021. 10. 24. 오후 7:14:56 || Kyunghun Park || 최초 생성
     *
     */
    @RequestMapping(value = "/users/score/{user-id}", method = RequestMethod.PATCH)
    public ResponseEntity<Object> updateScore(@PathVariable("user-id") String id, @RequestBody Score score) {
        return new ResponseEntity<>(scoreService.updateScore(id, score), HttpStatus.OK);
    }
}