package ecommerceapp.service;

import ecommerceapp.dto.PasswordDto;
import ecommerceapp.dto.LoginDto;
import ecommerceapp.exception.InvalidUserDetailsException;
import ecommerceapp.model.User;
import ecommerceapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public static final String USER_NOT_FOUND = "User : %s does not exist!";

    @Autowired
    private UserRepository repository;

    public String addUser(User user) throws InvalidUserDetailsException {
        if (repository.existsByUserId(user.getUserId())) {
            throw new InvalidUserDetailsException("UserId already exists");
        }
        repository.save(user);
        return "Successfully created the User";
    }

    public List<User> getUsers() throws InvalidUserDetailsException {
        return repository.findAll();
    }

    public User getUser(String userId) throws InvalidUserDetailsException {
        return Optional.ofNullable(repository.findByUserId(userId))
                .orElseThrow(() ->
                        new InvalidUserDetailsException(String.format(USER_NOT_FOUND, userId)));
    }

    public String updateUserName(String userId, String updatedUserName) throws InvalidUserDetailsException {
        User user = getUser(userId);
        user.setUserName(updatedUserName);
        repository.save(user);
        return "Updated the UserName successfully";
    }

    public String updatePassword(String userId, PasswordDto passwordDto) throws InvalidUserDetailsException {
        if (!passwordDto.getNewPassword().equals(passwordDto.getConfirmPassword())) {
            throw new InvalidUserDetailsException("Password and Confirm password should match!");
        }

        User user = getUser(userId);
        if (!user.getPassword().equals(passwordDto.getOldPassword())) {
            throw new InvalidUserDetailsException("Password incorrect, Please verify!!!");
        }
        user.setPassword(passwordDto.getNewPassword());
        repository.save(user);
        return "Password updated successfully";
    }

    public User getUserByUserName(String userName) throws InvalidUserDetailsException {
        return Optional.ofNullable(repository.findByUserName(userName))
                .orElseThrow(() ->
                        new InvalidUserDetailsException(String.format(USER_NOT_FOUND, userName)));
    }

    public String signInUser(LoginDto userDto) throws InvalidUserDetailsException {
        User user = getUser(userDto.getUserId());
        if(!user.getPassword().equals(userDto.getPassword())) {
            throw new InvalidUserDetailsException("Password incorrect, Please verify!!!");
        }
        return "Successfully logged In";
    }
}
