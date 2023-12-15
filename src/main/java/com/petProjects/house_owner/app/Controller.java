package com.petProjects.house_owner.app;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private final UserDao userDao;


    public Controller(UserDao userDao) {
        this.userDao = userDao;
    }
    @RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public  long CreateUser(@RequestBody User user){
        return userDao.createUser(user);
    }
}
