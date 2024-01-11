package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tperiodaccount;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodinout;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TperiodaccountCustomResitory {

    private final EntityManager entityManager;

    public List<Tperiodaccount> customFindAll(Long sitenum, Long groupnum, String carnum, Long pflag, LocalDateTime datefrom, LocalDateTime dateto) {

        String qlString = "SELECT e FROM Tperiodaccount e ";

        List<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+sitenum);
        whereArray.add("e.groupnum = "+groupnum);

        if(datefrom!=null && dateto!=null) {
            whereArray.add("e.regdate >= :datefrom");
            whereArray.add("e.regdate <= :dateto");
        }


        if(carnum != null){
            whereArray.add("e.carnum like '%"+carnum+"'");
        }

        if(pflag != null) {
            whereArray.add("e.pflag = "+pflag+"'");
        }


        qlString = qlString +" WHERE "+String.join(" AND ",whereArray);

        TypedQuery<Tperiodaccount> query = entityManager.createQuery(qlString, Tperiodaccount.class);

        if(datefrom!=null && dateto!=null) {
            query.setParameter("datefrom", datefrom);
            query.setParameter("dateto", dateto);
        }

        return query.getResultList();
    }
}
