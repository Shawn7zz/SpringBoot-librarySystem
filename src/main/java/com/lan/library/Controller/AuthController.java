package com.lan.library.Controller;

import com.lan.library.Dao.UserDao;
import com.lan.library.Entity.User;
import com.lan.library.api.request.LoginRequest;
import com.lan.library.api.request.SignUpRequest;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;


/**
 * @author Xiang Lan
 * Created on 2019-06-25 16:47
 */
@RestController
@RequestMapping("/api/auth")
@Api(value = "Auth")
public class AuthController {


    @Autowired
    UserDao userDao;


//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//        if(userDao.existsByNameAndAndPassword(loginRequest.getUsername(),loginRequest.getPassword())){
//            return new ResponseEntity<>("success",HttpStatus.OK);
//        }
//        return new ResponseEntity<>("fail",HttpStatus.OK);
//    }

    @PostMapping("/signin")
    public LoginRequest authenticateUser( HttpServletRequest httpServletRequest) {

        System.out.println(httpServletRequest.getParameter("password"));

        return new LoginRequest("asfsd","afsd");
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest newUser) {

        User user = new User();
        user.setName(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        user.setEmail(newUser.getEmail());
        userDao.save(user);
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

}
