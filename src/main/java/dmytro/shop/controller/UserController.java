package dmytro.shop.controller;

import dmytro.shop.dto.request.UserRequest;
import dmytro.shop.dto.response.DataResponse;
import dmytro.shop.dto.response.UserResponse;
import dmytro.shop.entiti.User;
import dmytro.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponse save (@Valid  @RequestBody UserRequest userRequest) {
        return (UserResponse) userService.save(userRequest);
    }
    @GetMapping
    public List<UserResponse> findAll(){ return userService.findAll(); }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        userService.delete(id);
    }

    @PutMapping
    public UserResponse update(@RequestParam Long id, @RequestBody UserRequest userRequest) {
        return userService.update(userRequest, id);
    }
}
