package cn.celadon.travel.canada.repository;

import cn.celadon.travel.canada.domin.dynamicDataModules.OtherStaticData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by empqqty on 7/22/2017.
 */
public interface OtherStaticDataRepository extends JpaRepository<OtherStaticData, Long> {
    @Query("from OtherStaticData o where o.dataType=:type ")
    public List<OtherStaticData> findByDataType(@Param("type") String dataType);
}
