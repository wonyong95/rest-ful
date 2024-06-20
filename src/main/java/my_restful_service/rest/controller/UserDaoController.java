package my_restful_service.rest.controller;

import my_restful_service.rest.bean.User;
import my_restful_service.rest.dao.UserDaoService;
import my_restful_service.rest.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Iterator;
import java.util.List;



@RestController
public class UserDaoController {
    private UserDaoService service;

    public UserDaoController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUsers(@PathVariable int id) {
        User user = service.findOne(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {

        User deleteUser = service.deleteById(id);

        if(deleteUser == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));

        }

        return null;
    }
}
