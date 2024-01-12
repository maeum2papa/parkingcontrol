package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tblacklist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TblackListCustomRepository {

    private final EntityManager entityManager;

    public List<Tblacklist> customFindAll(Long sitenum, Long groupnum, String carnum, LocalDate datefrom, LocalDate dateto){

        String qlString = "SELECT e FROM Tblacklist e ";

        List<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+sitenum);
        whereArray.add("e.groupnum = "+groupnum);

        if(datefrom!=null && dateto!=null) {
            whereArray.add("e.enddate >= :datefrom");
            whereArray.add("e.enddate <= :dateto");
        }


        if(carnum != null){
            whereArray.add("e.carnum like '%"+carnum+"'");
        }

        qlString = qlString +" WHERE "+String.join(" AND ",whereArray);

        TypedQuery<Tblacklist> query = entityManager.createQuery(qlString, Tblacklist.class);

        if(datefrom!=null && dateto!=null) {
            query.setParameter("datefrom", datefrom);
            query.setParameter("dateto", dateto);
        }

        return query.getResultList();

    }
}
