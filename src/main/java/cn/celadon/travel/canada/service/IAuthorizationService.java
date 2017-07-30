package cn.celadon.travel.canada.service;

import cn.celadon.travel.canada.domin.authentication.RoleInfo;
import cn.celadon.travel.canada.domin.authentication.UserInfo;

import java.util.List;

/**
 * Created by empqqty on 7/29/2017.
 */
public interface IAuthorizationService {
    public List<String> getAllRolesForUser(String userName);

}
