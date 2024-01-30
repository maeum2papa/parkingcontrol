package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tdisaccount;
import com.dwips.parkingcontrol.api.v1.domain.Tdiscountinfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TdiscountinfoCustomRepository {

    private final EntityManager entityManager;

    public List<Tdiscountinfo> customFindAll(Long sitenum, Long groupnum, Long devicenum, Long deptcode, String disid, Long pindex, LocalDateTime datefrom, LocalDateTime dateto) {

        String qlString = "SELECT e FROM Tdiscountinfo e";

        List<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+sitenum);
        whereArray.add("e.groupnum = "+groupnum);

        if(devicenum!=null){
            whereArray.add("e.devicenum = '"+devicenum+"'");
        }

        if(deptcode!=null){
            whereArray.add("e.devicenum = '"+deptcode+"'");
        }

        if(pindex!=null){
            whereArray.add("e.pindex = '"+pindex+"'");
        }

        if(disid!=null){
            whereArray.add("e.id = '"+disid+"'");
        }

        if(datefrom!=null && dateto!=null) {
            whereArray.add("e.disdatetime >= :datefrom");
            whereArray.add("e.disdatetime <= :dateto");
        }

        qlString = qlString +" WHERE "+String.join(" AND ",whereArray);

        TypedQuery<Tdiscountinfo> query = entityManager.createQuery(qlString, Tdiscountinfo.class);

        return query.getResultList();
    }

}
