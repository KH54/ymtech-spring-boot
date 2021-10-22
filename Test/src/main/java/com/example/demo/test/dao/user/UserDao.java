package com.example.demo.test.dao.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.test.dao.user.impl.IUserDao;
import com.example.demo.test.db.DB;
import com.example.demo.test.model.User;

@Repository
public class UserDao implements IUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getUsers(String name, String gender, int age) {

        List<Object> params = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        String query = DB.SQL_USER_SELECT_ELE;

        if (name != null) {
            params.add(name);
            sb.append("AND name=? ");
        }

        if (gender != null) {
            params.add(gender);
            sb.append("AND gender=? ");
        }
        
        if (age != 0) {
            params.add(age);
            sb.append("AND age=?");
        }
        query = query.replace("{where_clause}", sb.toString());

        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(User.class), params.toArray());

    }

    @Override
    public User getUser(String id) {
        try {
            User user = jdbcTemplate.queryForObject(DB.SQL_USER_SELECT_ID, BeanPropertyRowMapper.newInstance(User.class), id);

            return user;
        } catch (IncorrectResultSizeDataAccessException e) {

        }
        return null;
    }

    @Override
    public int createUser(User user) {
        return jdbcTemplate.update(DB.SQL_USER_INSERT, new Object[] { user.getId(), user.getPwd(), user.getName(), user.getGender(), user.getAge() });
    }

    @Override
    public int deleteUser(String id) {
        return jdbcTemplate.update(DB.SQL_USER_DELETE, id);
    }

    @Override
    public int updateUser(User user) {
        return jdbcTemplate.update(DB.SQL_USER_UPDATE, user.getPwd(), user.getName(), user.getGender(), user.getAge(), user.getId());
    }

//    
//    public List<User> getUsers(String name, String gender, int age) {
//
//        // 상속받은 Generic의 selectAll 메소드의 결과 값을 반환
//        return super.getUsers(name, gender, age,DB.SQL_USER_SELECT, (rs) -> {
//            try {
//                // User에 ResultSet을 매개변수로 하는 생성자의 반환 값을 매개변수로
//                return new User(rs);
//            } catch (SQLException ignore) {
//                System.out.println("User selectAll SQL Error");
//            }
//            return null;
//            
//        });
//
//    }
//
//    public User getUser(String id) {
//        // 상속받은 Generic의 select 메소드의 결과 값을 반환
//        return super.getUser(id, DB.SQL_USER_SELECT_ID, (rs) -> {
//            try {
//                // User에 ResultSet을 매개변수로 하는 생성자의 반환 값을 매개변수로
//                return new User(rs);
//            } catch (SQLException ignore) {
//                return null;
//            }
//        });
//    }
//
//    public int createUser(User user) {
//        // 상속받은 Generic의 insert 메소드의 결과 값을 반환
//        return super.createUser(user, DB.SQL_USER_INSERT, new BiConsumer<PreparedStatement, User>() {
//            @Override
//            public void accept(PreparedStatement stmt, User user) {
//                try {
//                    stmt.setString(1, user.getId());
//                    stmt.setString(2, user.getPwd());
//                    stmt.setString(3, user.getName());
//                    stmt.setString(4, user.getGender());
//                    stmt.setInt(5, user.getAge());
//                } catch (Exception e) {
//                    System.out.println("User Insert BiConsumer Error");
//                }
//            }
//        });
//    }
//
//    public int deleteUser(String id) {
//        // 상속받은 Generic의 delete 메소드의 결과 값을 반환
//        return super.deleteUser(id, DB.SQL_USER_DELETE);
//    }
//
//    public int updateUser(User user) {
//        // 상속받은 Generic의 update 메소드의 결과 값을 반환
//        return super.updateUser(user, DB.SQL_USER_UPDATE, new BiConsumer<PreparedStatement, User>() {
//            @Override
//            public void accept(PreparedStatement stmt, User user) {
//                try {
//                    stmt.setString(1, user.getPwd());
//                    stmt.setString(2, user.getName());
//                    stmt.setString(3, user.getGender());
//                    stmt.setInt(4, user.getAge());
//                    stmt.setString(5, user.getId());
//                } catch (SQLException e) {
//                    System.out.println("User Update BiConsumer Error");
//                }
//            }
//        });
//    }
}