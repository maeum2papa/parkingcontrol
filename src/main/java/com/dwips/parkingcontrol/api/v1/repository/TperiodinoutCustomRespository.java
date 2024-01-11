package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tperiodinout;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TperiodinoutCustomRespository {

    private final EntityManager entityManager;

    public List<Tperiodinout> customFindAll(Long sitenum, Long groupnum, Long qtype, String carnum, Long cardid, String name, Long xindex, LocalDateTime datefrom, LocalDateTime dateto) {

        String qlString = "SELECT e FROM Tperiodinout e ";

        List<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+sitenum);
        whereArray.add("e.groupnum = "+groupnum);


        if(qtype == 0 || qtype == 1){

            whereArray.add("e.indatetime >= :datefrom");
            whereArray.add("e.indatetime <= :dateto");

        }else if(qtype == 2){

            whereArray.add("e.outdatetime >= :datefrom");
            whereArray.add("e.outdatetime <= :dateto");

        }

        if(carnum != null){
            whereArray.add("e.carnum like '%"+carnum+"'");
        }

        if(cardid != null) {
            whereArray.add("e.department = '"+cardid+"'");
        }

        if(name != null) {
            whereArray.add("e.name = '"+name+"'");
        }

        if(xindex != null) {
            whereArray.add("e.xindex = '"+xindex+"'");
        }

        qlString = qlString +" WHERE "+String.join(" AND ",whereArray);

        TypedQuery<Tperiodinout> query = entityManager.createQuery(qlString, Tperiodinout.class);

        query.setParameter("datefrom",datefrom);
        query.setParameter("dateto",dateto);

        return query.getResultList();

    }

}
