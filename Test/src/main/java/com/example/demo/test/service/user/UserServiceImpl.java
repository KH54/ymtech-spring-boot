package com.example.demo.test.service.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.test.controller.model.user.CreateRes;
import com.example.demo.test.controller.model.user.DeleteRes;
import com.example.demo.test.controller.model.user.ReadRes;
import com.example.demo.test.controller.model.user.UpdateRes;
import com.example.demo.test.custom_exception.NullValueObjectException;
import com.example.demo.test.dao.user.UserDao;
import com.example.demo.test.model.User;
import com.example.demo.test.service.user.impl.IUserService;

/**
 * 
 * @description : User객체의 CRUD를 담당하는 Service
 *
 * @author : Kyunghun Park
 * @since : 2021. 10. 18. 오전 10:59:01
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    // 유저 정보를 저장할 HashMap
    @Autowired
    UserDao userDao;

    /**
     * @see com.example.demo.test.service.user.impl.IUserService#createUser(User)
     */
    @Override
    public CreateRes createUser(User user) {
        CreateRes res = new CreateRes();

        userDao.createUser(user);

        res.setCreated(userDao.getUser(user.getId()));

        return res;
    }

    /**
     * @see com.example.demo.test.service.user.impl.IUserService#getUser(String)
     */
    @Override
    public ReadRes getUser(String id) {
        ReadRes res = new ReadRes();
        res.setRead(userDao.getUser(id));

        return res;
    }

    /**
     * @see com.example.demo.test.service.user.impl.IUserService#getAllUsers()
     */
    @Override
    public List<User> getUsers(String name, String gender, int age) {
        List<User> list = userDao.getUsers(name, gender, age);

        if (list.size() == 0) {
            throw new NullValueObjectException();
        }
        return new ArrayList<>(list);
    }

    /**
     * @see com.example.demo.test.service.user.impl.IUserService#updateUser(String,
     *      User)
     */
    @Override
    public UpdateRes updateUser(String id, User user) {
        UpdateRes res = new UpdateRes();

        // Map에 일치하는 id가 존재하면 실행
        if (userDao.getUser(id) != null) {

            // 변경 후 비교하기 위하여 원래 갖고 있던 정보 저장
            res.setBefore(userDao.getUser(id));

            // 변경될 회원정보에 id 저장
            user.setId(id);

            // Switch
            // 입력받은 정보를 가진 객체에 pwd 변경사항이 없는 경우
            
            user.setPwd(user.getPwd() != null ? user.getPwd() : userDao.getUser(id).getPwd());
            user.setName(user.getName() != null ? user.getName() : userDao.getUser(id).getName());
            user.setGender(user.getGender() != null ? user.getGender() : userDao.getUser(id).getGender());
            user.setAge(user.getAge() != 0 ? user.getAge() : userDao.getUser(id).getAge());
            

            res.setAfter(user);

            // 변경된 user 객체의 정보를 id(key)값과 일치하는 Map에 저장
            userDao.updateUser(user);
        }
        return res;

    }

    /**
     * @see com.example.demo.test.service.user.impl.IUserService#deleteUser(String)
     */
    @Override
    public DeleteRes deleteUser(String id) {
        DeleteRes res = new DeleteRes();

        if (userDao.getUser(id) != null) {
            res.setDeleted(userDao.getUser(id));
            userDao.deleteUser(id);
        } else {
            throw new NullValueObjectException();
        }
        return res;
    }
}