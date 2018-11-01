package com.honor.zhenghejpa.controller;

import com.honor.zhenghejpa.entity.User;
import com.honor.zhenghejpa.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import sun.misc.Contended;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {

        return service.findByUsername(username);
    }

    @ApiOperation(value = "用户列表", notes = "用户列表")
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = service.findAll();
        return users;
    }

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @RequestMapping(value = {""}, method = RequestMethod.POST)
    public User postUsers(@RequestBody User user) {

        return service.saveUser(user);
    }

    @ApiOperation(value = "获取用户信息", notes = "根据url的id来获取详细信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return service.findUserById(id);
    }

    @ApiOperation(value = "更新信息", notes = "根据url的id来指定更新用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User putUsers(@PathVariable Long id, @RequestBody User user) {
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setId(id);
        return service.updateUser(user1);
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "success";
    }

    @ApiIgnore
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String jsonTest(){
        return "hi you!";
    }

}
