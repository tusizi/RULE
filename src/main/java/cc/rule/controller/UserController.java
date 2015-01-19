package cc.rule.controller;

import cc.rule.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tusizi on 2015/1/18.
 */
@RestController
public class UserController {
    @RequestMapping(value="/user",method= RequestMethod.GET)
    public User user(){
        return  new User("xyn","12346");
    }
}
