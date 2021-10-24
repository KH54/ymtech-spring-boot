package com.example.test.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.controller.model.user.CreateRes;
import com.example.test.controller.model.user.DeleteRes;
import com.example.test.controller.model.user.ReadRes;
import com.example.test.controller.model.user.UpdateRes;
import com.example.test.custom_exception.NullValueObjectException;
import com.example.test.dao.user.UserDao;
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

    /**
     * @see com.example.test.service.user.impl.IUserService#getAllUsers()
     */
    @Override
    public List<User> getUsers(String id, String name, String gender, int age) {
        // 전달받은 parameter를 Dao로 전달한 결과를 list에 저장
        List<User> list = userDao.getUsers(id, name, gender, age);

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
    public ReadRes getUser(String id) {
        // 사용자의 요청에 대한 응답을 담기 위한 객체
        ReadRes res = new ReadRes();

        // id를 Dao로 전달한 결과를 set
        res.setRead(userDao.getUser(id));

        return res;
    }

    /**
     * @see com.example.test.service.user.impl.IUserService#createUser(User)
     */
    @Override
    public CreateRes createUser(User user) {
        // 사용자의 요청에 대한 응답을 담기 위한 객체
        CreateRes res = new CreateRes();

        // TODO 유효성 검사 생각해보기
        if (!userDao.getUsers(user.getId(), null, null, 0).equals(null)) {
            // Dao로 객체 전달
            userDao.createUser(user);

            // 전달 결과를 set
            res.setCreated(userDao.getUser(user.getId()));
        } else {
            // user_id가 겹치면..
            System.out.println("dd");
            return res;
        }

        return res;
    }

    /**
     * @see com.example.test.service.user.impl.IUserService#updateUser(String,
     *      User)
     */
    @Override
    public UpdateRes updateUser(String id, User user) {
        // 사용자의 요청에 대한 응답을 담기 위한 객체
        UpdateRes res = new UpdateRes();

        // 일치하는 id가 존재하면 실행
        if (userDao.getUser(id) != null) {

            // 변경하기 전의 User 객체 저장
            res.setBefore(userDao.getUser(id));

            // 변경될 회원정보에 id 저장
            user.setId(id);

            // 변경할 값을 입력 받지 않았다면 Score의 이전 정보를 그대로 저장
            user.setPwd(user.getPwd() != null ? user.getPwd() : userDao.getUser(id).getPwd());
            user.setName(user.getName() != null ? user.getName() : userDao.getUser(id).getName());
            user.setGender(user.getGender() != null ? user.getGender() : userDao.getUser(id).getGender());
            user.setAge(user.getAge() != 0 ? user.getAge() : userDao.getUser(id).getAge());

            // 업데이트된 내용을 set
            res.setAfter(user);

            if (res.getBefore() == res.getAfter()) {
                // TODO 변경 사항 없는 경우
            }

            // 변경된 객체를 Dao로 전달
            userDao.updateUser(user);
        }
        return res;

    }

    /**
     * @see com.example.test.service.user.impl.IUserService#deleteUser(String)
     */
    @Override
    public DeleteRes deleteUser(String id) {
        // 사용자의 요청에 대한 응답을 담기 위한 객체
        DeleteRes res = new DeleteRes();

        // 일치하는 id가 존재하는 경우
        if (userDao.getUser(id) != null) {
            // user의 정보를 set
            res.setDeleted(userDao.getUser(id));

            // user 정보 삭제
            userDao.deleteUser(id);
        } else {
            throw new NullValueObjectException();
        }
        return res;
    }
}