package cc.rule.dao;

import cc.rule.model.User;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by tusizi on 2015/1/22.
 */
public class UserDaoTest {
    @Test
    public void should_inc_one_after_insert() throws Exception {
        UserDao userDao = new UserDao();
        List<User> beforeUsers = userDao.query();
        userDao.insert(new User());
        List<User> afterUsers = userDao.query();
        assertThat(afterUsers.size()-beforeUsers.size(), is(1));
    }
}
