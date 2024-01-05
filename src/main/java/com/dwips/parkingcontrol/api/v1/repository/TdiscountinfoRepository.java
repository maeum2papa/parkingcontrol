package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tdiscountinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface TdiscountinfoRepository extends JpaRepository<Tdiscountinfo, Long> {

    List<Tdiscountinfo> findAllByPindex(Long xindex);

    List<Tdiscountinfo> findAllByPindexAndDeptcode(Long xindex, Long deptcode);

    //할인세부정보(totdiscode)
    //select a.discode,count(a.discode) as count from tdiscountinfo a join tparkinfo b on a.pindex=b.xindex where b. .... 절 group by discode;
    @Query("SELECT e.discode AS discode,COUNT(e.discode) AS count FROM Tdiscountinfo e JOIN Tparkinfo ee ON e.pindex=ee.xindex WHERE ee.outdatetime BETWEEN :datefrom AND :dateto GROUP BY e.discode")
    List<Map<String,Long>> countDiscode(
            @Param("datefrom") LocalDateTime datefrom,
            @Param("dateto")LocalDateTime dateto
    );


}
