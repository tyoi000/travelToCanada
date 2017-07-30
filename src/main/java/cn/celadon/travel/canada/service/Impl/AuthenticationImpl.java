package cn.celadon.travel.canada.service.Impl;

import cn.celadon.travel.canada.domin.authentication.UserInfo;
import cn.celadon.travel.canada.repository.UserRepository;
import cn.celadon.travel.canada.service.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by empqqty on 7/29/2017.
 */
@Service
@Transactional
public class AuthenticationImpl implements IAuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserInfo findUserInfo(String userName) {
        return userRepository.findByName(userName);
    }

    @Override
    public List<UserInfo> findAllUserInfo() {
       return userRepository.findAll();
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userRepository.save(userInfo);
    }
}
