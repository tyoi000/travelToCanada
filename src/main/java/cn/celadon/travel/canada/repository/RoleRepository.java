package cn.celadon.travel.canada.repository;

import cn.celadon.travel.canada.domin.authentication.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by empqqty on 7/29/2017.
 */
public interface RoleRepository extends JpaRepository<RoleInfo, Long>{
}
