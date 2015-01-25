package cc.rule.controller;

import cc.rule.dao.UserDao;
import cc.rule.model.User;
import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tusizi on 2015/1/18.
 */
@Controller
public class UserController {
    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        UserDao userDao = new UserDao();
        List<User> users = userDao.query(username);
        if (users.isEmpty()) {
            model.addAttribute("error", "用户名不存在");
            return "login";
        } else if (!password.equals(users.get(0).getPassword())) {
            model.addAttribute("error", "密码错误");
            return "login";
        } else
            return "dashboard";
    }

    //注册
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String addReg(@RequestParam String username,
                         @RequestParam String password,
                         @RequestParam String rePassword,
                         Model model) {
        model.addAttribute("page", "reg");//把reg存到page里，page是键 选项卡的跳转
        UserDao userDao = new UserDao();
        List<User> users = userDao.query();
        if (!password.equals(rePassword)) {
            model.addAttribute("error", "密码不一致");
            return "login";
        } else if (users.size()==1) {
            model.addAttribute("error", "用户已存在");
            return "login";
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userDao.insert(user);
        return "dashboard";
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User user() {
        return new User("xyn", "12346");
    }
}
