package cn.celadon.travel.canada.service.Impl;

import cn.celadon.travel.canada.domin.authentication.UserInfo;
import cn.celadon.travel.canada.domin.authentication.UserRoleInfo;
import cn.celadon.travel.canada.repository.UserRepository;
import cn.celadon.travel.canada.repository.UserRoleRepositoy;
import cn.celadon.travel.canada.service.IAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by empqqty on 7/29/2017.
 */
@Service
@Transactional
public class AuthorizationServiceImpl implements IAuthorizationService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepositoy userRoleRepositoy;

    @Override
    public List<String> getAllRolesForUser(String userName) {
        UserInfo userInfo = userRepository.findByName(userName);
        List<UserRoleInfo> userRoleInfos = userRoleRepositoy.findAllRoles(userInfo);

        List<String> roles = new ArrayList<>();
        for (UserRoleInfo userRoleInfo : userRoleInfos){
            roles.add(userRoleInfo.getRoleInfo().getRoleName());
        }

        return roles;
    }
}
