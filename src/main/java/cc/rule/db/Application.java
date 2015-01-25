package cc.rule.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cc.rule.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Application {

    public static void main(String args[]) {


        JdbcTemplate jdbcTemplate = new H2Template().getTemplate();
//        System.out.println("Creating tables");
//        jdbcTemplate.execute("drop table customers if exists");
//        jdbcTemplate.execute("create table customers(" +
//                "id serial, first_name varchar(255), last_name varchar(255))");
//
//        String[] names = "John Woo;Jeff Dean;Josh Bloch;Josh Long".split(";");
//        for (String fullname : names) {
//            String[] name = fullname.split(" ");
//            System.out.printf("Inserting customer record for %s %s\n", name[0], name[1]);
//            jdbcTemplate.update(
//                    "INSERT INTO customers(first_name,last_name) values(?,?)",
//                    name[0], name[1]);
//        }
//
//        System.out.println("Querying for customer records where first_name = 'Josh':");
        List<User> results = jdbcTemplate.query(
                "select * from user",
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new User(rs.getString("username"), rs.getString("password"));
                    }
                });

        for (User user : results) {
            System.out.println(user.getUsername());
        }
    }
}
