package cn.celadon.travel.canada.repository;

import cn.celadon.travel.canada.domin.authentication.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by empqqty on 7/29/2017.
 */
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    @Query("from UserInfo u where u.userName=:userName")
    public UserInfo findByName(@Param("userName") String userName);
}
