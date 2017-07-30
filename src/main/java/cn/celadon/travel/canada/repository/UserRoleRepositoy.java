package cn.celadon.travel.canada.repository;

import cn.celadon.travel.canada.domin.authentication.UserInfo;
import cn.celadon.travel.canada.domin.authentication.UserRoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by empqqty on 7/29/2017.
 */
public interface UserRoleRepositoy extends JpaRepository<UserRoleInfo, Long> {

    @Query("from UserRoleInfo w where w.userInfo=:userInfo")
    public List<UserRoleInfo> findAllRoles(@Param("userInfo") UserInfo userInfo);
}
