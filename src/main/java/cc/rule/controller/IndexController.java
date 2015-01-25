package cc.rule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by tusizi on 2015/1/25.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "login";
    }
}
