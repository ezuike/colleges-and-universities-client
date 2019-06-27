package cn.gov.zcy.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试API
 */
@Controller
@RequestMapping("")
public class LoginController {

    @RequestMapping("/")
    public String index() {
        // 登录后session中存了name
        return "index";
    }

    @RequestMapping("/hello")
    public ResponseEntity<String> hello() {
        // 登录后session中存了name
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }
}
