package cc.rule.dao;

import cc.rule.db.DBTemplate;
import cc.rule.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tusizi on 2015/1/21.
 */
public class UserDao {
    JdbcTemplate jdbcTemplate;

    public UserDao() {
        jdbcTemplate = new DBTemplate().getTemplate();
    }

    public void insert(User user) {
        /*if(user.getUsername()!=)*/
        jdbcTemplate.update(
                "INSERT INTO user(username,password) values(?,?)",
                user.getUsername(), user.getPassword());
    }

    public List<User> query(String username) {
        List<User> results = jdbcTemplate.query(
                "select * from user where username = ?", new Object[]{username},
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new User(rs.getString("username"), rs.getString("password"));
                    }
                });
        return results;
    }public List<User> query() {
        List<User> results = jdbcTemplate.query(
                "select * from user", new Object[]{},
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new User(rs.getString("username"), rs.getString("password"));
                    }
                });
        return results;
    }

    public User find(String username){
        User user = jdbcTemplate.query(
                "select * from user where username = ?",
                new String[]{username},
                new ResultSetExtractor<User>() {
                    @Override
                    public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                        return new User(rs.getString("username"), rs.getString("password"));
                    }
                }
        );
        return user;
    }


}
