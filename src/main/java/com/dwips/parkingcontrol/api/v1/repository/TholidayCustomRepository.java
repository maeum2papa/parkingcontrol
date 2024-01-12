package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tholiday;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TholidayCustomRepository {

    private final EntityManager entityManager;

    public List<Tholiday> customFindAll(Long sitenum, Long groupnum, LocalDate yearfrom, LocalDate yeaerto){

        String qlString = "SELECT e FROM Tholiday e ";

        List<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+sitenum);
        whereArray.add("e.groupnum = "+groupnum);

        if(yearfrom!=null && yeaerto!=null){
            whereArray.add("e.holiday >= :yearfrom");
            whereArray.add("e.holiday <= :yeaerto");
        }

        qlString = qlString +" WHERE "+String.join(" AND ",whereArray);

        TypedQuery<Tholiday> query = entityManager.createQuery(qlString,Tholiday.class);

        query.setParameter("yearfrom",yearfrom);
        query.setParameter("yeaerto",yeaerto);

        return query.getResultList();
    }
}
