package ryanyoshimura.restfulblog.controller;


import ryanyoshimura.restfulblog.data.Post;
import ryanyoshimura.restfulblog.data.User;
import ryanyoshimura.restfulblog.data.UserRole;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users", produces = "application/json")
public class UsersController {
    private final List<User> users = new ArrayList<>();

    private long nextId = 2;

    @PostConstruct
    public void init() {
        User me = new User(1, "docrob", "docrob@docrob.com", "12345", LocalDate.now(), UserRole.ADMIN, new ArrayList<>());
        users.add(me);

        Post myPost = new Post(100L, "doc post 1", "post 1 from doc", null, null);
        me.getPosts().add(myPost);

        myPost = new Post(101L, "doc post 2", "lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem lorem ", null, null);
        me.getPosts().add(myPost);
    }

    @GetMapping("")
    public List<User> fetchUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public User fetchUserById(@PathVariable long id) {
        // search through the list of posts
        // and return the post that matches the given id
        User user = findUserById(id);
        if(user == null) {
            // what to do if we don't find it
            throw new RuntimeException("I don't know what I am doing");
        }

        // we found the post so just return it
        return user;
    }

    @GetMapping("/me")
    private User fetchMe() {
        return users.get(0);
    }

    @GetMapping("/username/{userName}")
    private User fetchByUserName(@PathVariable String userName) {
        User user = findUserByUserName(userName);
        if(user == null) {
            // what to do if we don't find it
            throw new RuntimeException("I don't know what I am doing");
        }
        return user;
    }

    @GetMapping("/email/{email}")
    private User fetchByEmail(@PathVariable String email) {
        User user = findUserByEmail(email);
        if(user == null) {
            // what to do if we don't find it
            throw new RuntimeException("I don't know what I am doing");
        }
        return user;
    }

    private User findUserByUserName(String userName) {
        for (User user: users) {
            if(user.getUserName().equals(userName)) {
                return user;
            }
        }
        // didn't find it so do something
        return null;
    }

    private User findUserByEmail(String email) {
        for (User user: users) {
            if(user.getEmail().equals(email)) {
                return user;
            }
        }
        // didn't find it so do something
        return null;
    }

    private User findUserById(long id) {
        for (User user: users) {
            if(user.getId() == id) {
                return user;
            }
        }
        // didn't find it so do something
        return null;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody User newUser) {
        // assign  nextId to the new post
        newUser.setId(nextId);
        // don't need the below line at this point but just for kicks
        newUser.setCreatedAt(LocalDate.now());
        nextId++;

        users.add(newUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable long id) {
        // search through the list of posts
        // and delete the post that matches the given id
        User user = findUserById(id);
        if(user != null) {
            users.remove(user);
            return;
        }
        // what to do if we don't find it
        throw new RuntimeException("User not found");
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody User updatedUser, @PathVariable long id) {
        // find the post to update in the posts list

        User user = findUserById(id);
        if(user == null) {
            System.out.println("User not found");
        } else {
            if(updatedUser.getEmail() != null) {
                user.setEmail(updatedUser.getEmail());
            }
            return;
        }
        throw new RuntimeException("User not found");
    }

    @PutMapping("/{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @RequestParam String newPassword) {
        User user = findUserById(id);
        if(user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User id " + id + " not found");
        }

        // compare old password with saved pw
        if(!user.getPassword().equals(oldPassword)) {
            throw new RuntimeException("amscray");
        }

        // validate new password
        if(newPassword.length() < 3) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "new pw length must be at least 3 characters");
        }

        user.setPassword(newPassword);
    }
}