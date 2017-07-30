package cn.celadon.travel.canada.service.Impl;

import cn.celadon.travel.canada.domin.authentication.UserInfo;
import cn.celadon.travel.canada.service.IAuthenticationService;
import cn.celadon.travel.canada.service.IAuthorizationService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by empqqty on 7/25/2017.
 */
public class ShiroRealmImpl extends AuthorizingRealm {

    @Autowired
    private IAuthorizationService authorizationService;

    @Autowired
    private IAuthenticationService authenticationService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        ShiroUser shiroUser = (ShiroUser)principalCollection.fromRealm(getName()).iterator().next();
        String usrName = shiroUser.name;
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

           List<String> roles =  authorizationService.getAllRolesForUser(usrName);
            if ( roles == null ||roles.size()==0){
                // do nothing
            } else {
                for (String roleName : roles){
                    info.addRole(roleName);
                }
            }

        return info;


    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        UserInfo userInfo = authenticationService.findUserInfo(usernamePasswordToken.getUsername());

        if (userInfo == null) {
            throw new UnknownAccountException();
        }
        if (userInfo.getPassword().equals(String.valueOf(usernamePasswordToken.getPassword()))){
            return new SimpleAccount(usernamePasswordToken.getUsername(), usernamePasswordToken.getPassword(),this.getName());
        } else {
            throw new IncorrectCredentialsException();
        }
    }

    public static class ShiroUser implements Serializable{
         private String id;
         private String number;
        private String name;

        public ShiroUser(String number, String name) {
            this.number = number;
            this.name = name;
        }

        public ShiroUser(String id, String number, String name) {
            this.id = id;
            this.number = number;
            this.name = name;
        }

        @Override
        public String toString() {
            return number;
        }

        public String getDisplayName(){
            return name;
        }
    }
}
