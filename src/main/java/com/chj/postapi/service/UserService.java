package com.chj.postapi.service;


import com.chj.postapi.entity.User;
import com.chj.postapi.httpservice.HttpService;
import com.chj.postapi.repository.UserRepository;
import com.chj.postapi.util.JsonUtil;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private HttpService httpService;

    public UserService(UserRepository userRepository, HttpService httpService) {
        this.userRepository = userRepository;
        this.httpService = httpService;
    }


    public User saveUserFromHttp() {
       User user = JsonUtil.fromJsonToEntity(httpService.httpGetUser(), User.class);
       return userRepository.save(user);
    }

    public List<User> saveAllUserFromHttp() {
        String json = httpService.httpGetMultipleUsers();
        List<User> list = JsonUtil.fromJsonToList(json,"users",User.class);

        for (User user : list) {
            try {
                userRepository.saveAndFlush(user);
            } catch (DataIntegrityViolationException e) {
                System.out.println("Ignored duplicated Emaiil: " + user.getEmail());
            }
        }
        return list;
    }


}
