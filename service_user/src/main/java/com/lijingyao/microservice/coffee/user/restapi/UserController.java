package com.lijingyao.microservice.coffee.user.restapi;

import com.lijingyao.microservice.coffee.template.users.UserRegisterDTO;
import com.lijingyao.microservice.coffee.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 用户基础信息的资源
 * <p>
 * Created by lijingyao on 2017/1/3 22:56.
 */
@RestController
@RequestMapping("/users")
public class UserController {


    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    /**
     * 添加用户信息
     *
     * @return
     */
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    public ResponseEntity registeredNewUser(@RequestBody UserRegisterDTO registerDTO) {
        return new ResponseEntity(userService.registeredNewUser(registerDTO), HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}",method = {RequestMethod.GET})
    public ResponseEntity getUser(@PathVariable("id")Long id) {
        return new ResponseEntity(userService.getUser(id), HttpStatus.OK);
    }




}
