package cn.celadon.travel.canada.repository;

import cn.celadon.travel.canada.domin.webTemplates.WebNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by empqqty on 6/29/2017.
 */
public interface WebNodeRepository extends JpaRepository<WebNode,Long> {

    @Query("from WebNode w where w.parentNode=:parentNode")
    public List<WebNode> findChildNodes(@Param("parentNode") WebNode parentNode);
}
