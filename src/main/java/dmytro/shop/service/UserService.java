package dmytro.shop.service;

import dmytro.shop.dto.request.UserRequest;
import dmytro.shop.dto.response.UserResponse;
import dmytro.shop.entiti.User;
import dmytro.shop.exception.WrongInputDataException;
import dmytro.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse save (UserRequest userRequest){
        return new UserResponse(userRepository.save(userRequestToUser(userRequest, null)));
    }
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    public User findOne(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new WrongInputDataException
                        ("Product with" + id + "not exists"));
    }
    public void delete(Long id) {
        userRepository.delete(findOne(id));
    }

    public UserResponse update(UserRequest userRequest, Long id){
        return new UserResponse(userRepository.save(userRequestToUser(userRequest, findOne(id))));
    }
    private User userRequestToUser(UserRequest userRequest, User user) {
        if ( user == null){
            user = new User();
        }
        user.setLogin(userRequest.getLogin());

        return user;
    }

}
