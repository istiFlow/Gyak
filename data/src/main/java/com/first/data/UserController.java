package com.first.data;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @PostMapping("/users")
    public UserEntity create(@RequestBody UserEntity userEntity) throws ValidationException {
        return userService.create(userEntity);
    }

}
