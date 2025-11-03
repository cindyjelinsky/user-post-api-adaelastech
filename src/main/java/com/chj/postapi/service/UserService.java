package com.chj.postapi.service;


import com.chj.postapi.entity.User;
import com.chj.postapi.httpservice.HttpService;
import com.chj.postapi.repository.UserRepository;
import com.chj.postapi.util.JsonUtil;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private HttpService httpService;

    public UserService(UserRepository userRepository, HttpService httpService) {
        this.userRepository = userRepository;
        this.httpService = httpService;
    }



    @Transactional
    public void saveAllUserFromHttp() {
        String json = httpService.httpGetMultipleUsers();
        List<User> list = JsonUtil.fromJsonToList(json,"users",User.class);

        for(User user:list){
            try{
                user.setId(null);
                userRepository.save(user);
            }catch(DataIntegrityViolationException e){
                System.out.println("Ignored duplicated email:"  + user.getEmail());
            }
        }



    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }


}
