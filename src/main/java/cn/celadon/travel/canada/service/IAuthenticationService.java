package cn.celadon.travel.canada.service;

import cn.celadon.travel.canada.domin.authentication.UserInfo;
import cn.celadon.travel.canada.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by empqqty on 7/29/2017.
 */
public interface IAuthenticationService {

    public UserInfo findUserInfo(String userName);
    public List<UserInfo> findAllUserInfo();
    public void addUser(UserInfo userInfo);
}
