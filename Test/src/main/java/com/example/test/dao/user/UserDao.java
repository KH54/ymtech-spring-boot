package com.example.test.dao.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.test.dao.user.impl.IUserDao;
import com.example.test.db.Query;
import com.example.test.model.User;

/**
 * 
 *
 * @author "KyungHun Park"
 * @since 2021. 10. 24. 오후 9:07:12
 *
 * @modified 2021. 10. 24. 오후 9:07:12 || Kyunghun Park || 최초 생성
 *
 */
@Repository
public class UserDao implements IUserDao {

    //의존성 주입
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * @see com.example.test.dao.user.impl.IUserDao#getUsers(String, String, String, int)
     */
    @Override
    public List<User> getUsers(String id, String name, String gender, int age) {
        // 입력 받은 parameter를 저장하기 위한 List
        List<Object> params = new ArrayList<>();

        // 추가할 Query를 저장하기 위한 String
        StringBuilder sb = new StringBuilder();

        // 기존 쿼리
        String query = Query.SQL_USER_SELECT_ELE;

        // parameter의 값이 존재하는 경우 쿼리문에 추가
        if (id != null) {
            params.add(id);
            sb.append("AND id=? ");
        }
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
        
        // Query 수정
        query = sb != null ? query.replace("{where_clause}", sb.toString()) : query;
        // 쿼리를 실행하고 RowMapper를 이용해서 ResultSet 결과를 User 객체로 변환
        return jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(User.class), params.toArray());
    }

    /**
     * @see com.example.test.dao.user.impl.IUserDao#getUser(String)
     */
    @Override
    public User getUser(String id) {
        try {
            // 쿼리를 실행하고 RowMapper를 이용해서 ResultSet 결과를 User 객체로 변환
            User user = jdbcTemplate.queryForObject(Query.SQL_USER_SELECT_ID, BeanPropertyRowMapper.newInstance(User.class), id);

            return user;
        } catch (IncorrectResultSizeDataAccessException e) {
            // 결과 값이 0개이거나 2개 이상인 경우
        }
        return null;
    }

    /**
     * @see com.example.test.dao.user.impl.IUserDao#createUser(User)
     */
    @Override
    public int createUser(User user) {
        // 생성할 User 객체의 정보로 Query 실행
        return jdbcTemplate.update(Query.SQL_USER_INSERT, user.getId(), user.getPwd(), user.getName(), user.getGender(), user.getAge());
    }

    /**
     * @see com.example.test.dao.user.impl.IUserDao#deleteUser(String)
     */
    @Override
    public int deleteUser(String id) {
        // 삭제할 id를 입력 받아 Query 실행
        return jdbcTemplate.update(Query.SQL_USER_DELETE, id);
    }

    /**
     * @see com.example.test.dao.user.impl.IUserDao#updateUser(User)
     */
    @Override
    public int updateUser(User user) {
        // 업데이트할 User 객체의 정보로 Query 실행
        return jdbcTemplate.update(Query.SQL_USER_UPDATE, user.getPwd(), user.getName(), user.getGender(), user.getAge(), user.getId());
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