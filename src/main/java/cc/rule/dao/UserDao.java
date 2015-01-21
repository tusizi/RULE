package cc.rule.dao;

import cc.rule.db.DBTemplate;
import cc.rule.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by tusizi on 2015/1/21.
 */
public class UserDao {
    JdbcTemplate jdbcTemplate;
    public UserDao() {
        jdbcTemplate = new DBTemplate().getTemplate();
    }
    public void insert ( User user ){
        jdbcTemplate.update(
                "INSERT INTO user(username,password) values(?,?)",
                user.getUsername(), user.getPassword());
    }

}
