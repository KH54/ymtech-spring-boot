package com.example.test.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.controller.model.score.req.CreateScoreReq;
import com.example.test.controller.model.score.req.ReadScoreReq;
import com.example.test.controller.model.score.res.CreateScoreRes;
import com.example.test.controller.model.user.ControllerUser;
import com.example.test.controller.model.user.req.CreateUserReq;
import com.example.test.controller.model.user.req.ReadUserReq;
import com.example.test.controller.model.user.req.UpdateUserReq;
import com.example.test.controller.model.user.res.CreateUserRes;
import com.example.test.controller.model.user.res.DeleteUserRes;
import com.example.test.controller.model.user.res.ReadUserRes;
import com.example.test.controller.model.user.res.UpdateUserRes;
import com.example.test.custom_exception.NullValueObjectException;
import com.example.test.dao.score.ScoreDao;
import com.example.test.dao.user.UserDao;
import com.example.test.model.Score;
import com.example.test.model.User;
import com.example.test.service.user.impl.IUserService;

/**
 * User객체의 CRUD를 담당하는 Service
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 18. 오전 10:59:01
 *
 * @modified 2021. 10. 18. 오전 10:59:01 || Kyunghun Park || 최초 생성
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    // UserDao 의존성 주입
    @Autowired
    UserDao userDao;
    @Autowired
    ScoreDao scoreDao;

    @Override
    public CreateScoreRes createScore(Score score) {
        ReadUserReq readUserReq = new ReadUserReq(score);
        ReadScoreReq readScoreReq = new ReadScoreReq(score.getId());
        
        CreateScoreRes res = new CreateScoreRes();
        CreateScoreReq req = new CreateScoreReq(score);

        if (userDao.getUser(readUserReq) != null) {
            userDao.createScore(req);
        }
        res.setCreate(scoreDao.getScore(readScoreReq));

        return res;
    }

    /**
     * @see com.example.test.service.user.impl.IUserService#createUser(User)
     */
    @Override
    public CreateUserRes createUser(User user) {
        // 사용자의 요청에 대한 응답을 담기 위한 객체
        ReadUserReq readReq = new ReadUserReq(user);

        CreateUserRes res = new CreateUserRes();
        CreateUserReq req = new CreateUserReq(user);

        userDao.createUser(req);

        // 전달 결과를 set
        res.setCreate(userDao.getUser(readReq));

        return res;
    }

    /**
     * @see com.example.test.service.user.impl.IUserService#getAllUsers()
     */
    @Override
    public List<User> getUsers(String id, String name, String gender, int age) {
        // 전달받은 parameter를 Dao로 전달한 결과를 list에 저장
        ReadUserReq req = new ReadUserReq(id, name, gender, age);
        List<User> list = userDao.getUsers(req);

        // 출력할 User가 없는 경우
        if (list.size() == 0) {
            throw new NullValueObjectException();
        }

        return new ArrayList<>(list);
    }

    /**
     * @see com.example.test.service.user.impl.IUserService#getUser(String)
     */
    @Override
    public ReadUserRes getUser(String id) {
        // 사용자의 요청에 대한 응답을 담기 위한 객체
        ReadUserRes res = new ReadUserRes();
        ReadUserReq req = new ReadUserReq(id);

        ControllerUser user = new ControllerUser(userDao.getUser(req));

        // id를 Dao로 전달한 결과를 set
        res.setRead(user);

        return res;
    }

    /**
     * @see com.example.test.service.user.impl.IUserService#updateUser(String, User)
     */
    @Override
    public UpdateUserRes updateUser(String id, User user) {
        // 사용자의 요청에 대한 응답을 담기 위한 객체
        UpdateUserRes res = new UpdateUserRes();
        user.setId(id);
        UpdateUserReq req = new UpdateUserReq(user);
        ReadUserReq readReq = new ReadUserReq(user);

        // 변경하기 전의 User 객체 저장

        res.setBefore(userDao.getUser(readReq));

        // 변경할 값을 입력 받지 않았다면 Score의 이전 정보를 그대로 저장
        user.setPwd(user.getPwd() != null ? user.getPwd() : res.getBefore().getId());
        user.setName(user.getName() != null ? user.getName() : res.getBefore().getName());
        user.setGender(user.getGender() != null ? user.getGender() : res.getBefore().getGender());
        user.setAge(user.getAge() != 0 ? user.getAge() : res.getBefore().getAge());

        // 변경될 회원정보에 id 저장
        req.setUpdate(user);
        // 업데이트된 내용을 set

        // 변경된 객체를 Dao로 전달
        userDao.updateUser(req);

        res.setAfter(user);
        return res;
    }

    /**
     * @see com.example.test.service.user.impl.IUserService#deleteUser(String)
     */
    @Override
    public DeleteUserRes deleteUser(String id) {
        // 사용자의 요청에 대한 응답을 담기 위한 객체
        DeleteUserRes res = new DeleteUserRes();
        ReadUserReq req = new ReadUserReq(id);

        // user의 정보를 set
        res.setDelete(userDao.getUser(req));

        // user 정보 삭제
        userDao.deleteUser(id);

        return res;
    }

}