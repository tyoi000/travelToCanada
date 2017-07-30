package cn.celadon.travel.canada.web;

import cn.celadon.travel.canada.Util.ResultCode;
import cn.celadon.travel.canada.Util.ResultMsg;
import cn.celadon.travel.canada.domin.webTemplates.WebNode;
import cn.celadon.travel.canada.service.IAuthorizationService;
import cn.celadon.travel.canada.service.IWebNodeService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.IniFactorySupport;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.util.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Security;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by empqqty on 6/29/2017.
 */
@RestController
public class LoginController {

    @Autowired
    private IWebNodeService service;

    @Autowired
    private IAuthorizationService authorizationService;

    @RequestMapping( value = "/loginSystem",method= RequestMethod.GET)
    @ResponseBody
    public ResultMsg loginSystem(@RequestParam(value="userName")String userName, @RequestParam(value = "password") String password){

        ResultMsg resultMsg = new ResultMsg(ResultCode.SUCCESS,"Login succeed");
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        try {
            currentUser.login(token);
        } catch (AuthenticationException e) {
            resultMsg.setResultCode(ResultCode.ERROR);
            resultMsg.setMessage(e.getMessage());
            token.clear();
        }

        return resultMsg;

    }

    @RequestMapping( value = "/logout", method = RequestMethod.GET)
    public String logoutSystem(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "redirect:/index.html";
    }

    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getCurrentUserInfo(){
        Map<String, Object> userRoles = new HashedMap();
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()){
            String userName = (String) currentUser.getPrincipal();
            userRoles.put("userName",userName);
            List<String> roles = authorizationService.getAllRolesForUser(userName);
            userRoles.put("roles", roles);
            return userRoles;
        } else {
            return null;
        }

    }

}
