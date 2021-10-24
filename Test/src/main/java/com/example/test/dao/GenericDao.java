package com.example.test.dao;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.BiConsumer;
//import java.util.function.Function;
//
//import org.springframework.stereotype.Repository;
//import com.example.demo.test.db.DB;
//
//@Repository
//public class GenericDao<T, K> {
//    public List<T> getUsers(String name, String gender, int age, String sql, Function<ResultSet, T> convertFunction) {
//        // table에 저장된 값들을 읽기 위해 저장하는 리스트
//        List<T> result = new ArrayList<>();
//        T newInstance = null;
//
//        // DB 연결 및 쿼리 실행
//        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD);) {
//            PreparedStatement stmt = con.prepareStatement(sql);
//            if (name == null && gender == null && age == 0) {
//                ResultSet rs = stmt.executeQuery();
//                // table에 저장된 데이터 확인
//                while (rs.next()) {
//                    // 하나의 레코드를 User 객체에 저장
//                    newInstance = convertFunction.apply(rs);
//                    // 저장된 객체를 리스트에 저장
//                    result.add(newInstance);
//                }
//                return result;
//            } else {
//                stmt = con.prepareStatement(DB.SQL_USER_SELECT_ELE);
//                stmt.setObject(1, name);
//                stmt.setObject(2, gender);
//                stmt.setObject(3, age);
//
//                ResultSet rs = stmt.executeQuery();
//
//                while (rs.next()) {
//                    newInstance = convertFunction.apply(rs);
//                    result.add(newInstance);
//                }
//                stmt.close();
//                rs.close();
//            }
//        } catch (SQLException e) {
//            System.out.println("GenericDAO selectAll Error");
//        }
//        return result;
//    }
//
//    public T getUser(K pk, String sql, Function<ResultSet, T> convertFunction) {
//        // 함수형 인터페이스의 결과값을 받을 Generic type의 인스턴스
//        T newInstance = null;
//
//        // DB 연결 및 쿼리문 호출
//        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); PreparedStatement stmt = con.prepareStatement(sql);) {
//
//            // 와일드 카드 입력
//            stmt.setObject(1, pk);
//
//            // 쿼리 실행
//            ResultSet rs = stmt.executeQuery();
//
//            // 입력한 와일드 카드의 결과 값이 있는 경우
//            if (rs.next()) {
//                // 함수형 인터페이스 rs를 ResultSet에 적용시킨다.
//                newInstance = convertFunction.apply(rs);
//            }
//        } catch (SQLException e) {
//            System.out.println("GenericDAO Select Error");
//        }
//        return newInstance;
//    }
//
//    public Integer createUser(T vo, String sql, BiConsumer<PreparedStatement, T> stmtFunction) {
//
//        // DB 연결 및 쿼리문 호출
//        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); PreparedStatement stmt = con.prepareStatement(sql);) {
//
//            stmtFunction.accept(stmt, vo);
//            // insert 결과 반환
//            return stmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("GenericDao Insert SQL Error");
//        }
//        return null;
//    }
//
//    public Integer updateUser(T vo, String sql, BiConsumer<PreparedStatement, T> stmtFunction) {
//
//        // DB 연결 및 쿼리문 호출
//        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); PreparedStatement stmt = con.prepareStatement(sql);) {
//
//            stmtFunction.accept(stmt, vo);
//
//            // update 결과 반환
//            return stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // System.out.println("GenericDao Update SQL Error");
//        }
//        return null;
//    }
//
//    public Integer deleteUser(K pk, String sql) {
//
//        // DB 연결 및 쿼리문 호출
//        try (Connection con = DriverManager.getConnection(DB.URL, DB.ID, DB.PWD); PreparedStatement stmt = con.prepareStatement(sql);) {
//
//            // 매개변수로 받은 PK를 와일드카드에 입력
//            stmt.setObject(1, pk);
//
//            // delete 결과 반환
//            return stmt.executeUpdate();
//
//        } catch (SQLException e) {
//            System.out.println("GenericDao Delete SQL Error");
//        }
//        return null;
//    }
//}
