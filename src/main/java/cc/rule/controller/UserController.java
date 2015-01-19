package cc.rule.controller;

import cc.rule.model.User;
import org.springframework.stereotype.Controller;
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
    public String index(){
        return "login";
    }
    @RequestMapping(value = "/user",method =RequestMethod.POST)
    public String add(@RequestParam String username,@RequestParam String password){
        if (username.equals("admin") && password.equals("admin"))
            return "dashboard";
        else
        return "login";
    }
    @RequestMapping(value="/user",method= RequestMethod.GET)
    public User user(){
        return  new User("xyn","12346");
    }
}
