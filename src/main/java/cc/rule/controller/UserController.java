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
    public String add(@RequestParam String username, @RequestParam String password) {
        if (username.equals("admin") && password.equals("admin"))
            return "dashboard";
        else
            return "login";
    }
//注册
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String addReg(@RequestParam String username,
                         @RequestParam String password,
                         @RequestParam String rePassword,
                         Model model) {
        model.addAttribute("page","reg");
        if (!password.equals(rePassword)) {
            model.addAttribute("error", "密码不一致");
            return "login";
        } else if (username.equals("admin")) {
            model.addAttribute("error", "用户已存在");
            return "login";
        }
        User user = new User();
        UserDao userDao = new UserDao();
        user.setUsername(username);
        user.setUsername(password);
        userDao.insert(user);
        return "dashboard";
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User user() {
        return new User("xyn", "12346");
    }
}
