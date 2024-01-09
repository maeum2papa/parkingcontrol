package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tbcardinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodinout;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TbcardinfoCutomRepository {

    private final EntityManager entityManager;

    public List<Tbcardinfo> customFindAll(Long sitenum, Long groupnum, String carnum, String rescode, String cardid, String cardname, Long devicenum, LocalDateTime datefrom, LocalDateTime dateto) {

        String qlString = "SELECT e FROM Tbcardinfo e ";

        List<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+sitenum);
        whereArray.add("e.groupnum = "+groupnum);
        whereArray.add("e.dealdate >= :datefrom");
        whereArray.add("e.dealdate <= :dateto");


        if(carnum != null){
            whereArray.add("e.carnum like '%"+carnum+"'");
        }

        if(rescode != null){
            whereArray.add("e.rescode = '"+rescode+"'");
        }

        if(cardid != null) {
            whereArray.add("e.cardid '= "+cardid+"'");
        }

        if(cardname != null) {
            whereArray.add("e.cardname = '"+cardname+"'");
        }

        if(devicenum != null) {
            whereArray.add("e.devicenum = "+devicenum);
        }

        qlString = qlString +" WHERE "+String.join(" AND ",whereArray);

        TypedQuery<Tbcardinfo> query = entityManager.createQuery(qlString, Tbcardinfo.class);

        query.setParameter("datefrom",datefrom);
        query.setParameter("dateto",dateto);

        return query.getResultList();

    }
}
