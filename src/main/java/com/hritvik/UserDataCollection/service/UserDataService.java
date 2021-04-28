package com.hritvik.UserDataCollection.service;

import com.hritvik.UserDataCollection.model.UserData;
import com.hritvik.UserDataCollection.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {

    @Autowired
    private UserDataRepository userDataRepository;

    public void addNewUser(UserData newUser) {
        userDataRepository.addNewUser(newUser);
    }

    public List<UserData> getAllUsersData() {
        return userDataRepository.addAllUsersData();
    }

    public void deleteUser(Integer userId) {
        userDataRepository.deleteUser(userId);
    }

    public UserData getUserData(Integer userId) {
        return userDataRepository.getUserData(userId);
    }

    public void updateUserData(UserData newData) {
        userDataRepository.updateUserData(newData);
    }
}
