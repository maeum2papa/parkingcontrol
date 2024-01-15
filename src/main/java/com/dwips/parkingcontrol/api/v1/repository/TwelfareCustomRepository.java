package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Twelfare;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TwelfareCustomRepository {

    private final EntityManager entityManager;

    public List<Twelfare> customFindAll(Long sitenum, Long groupnum, String carnum, String name, Long diskey, LocalDate datefrom, LocalDate dateto ){

        String qlQuery = "SELECT e FROM Twelfare e ";

        List<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+sitenum);
        whereArray.add("e.groupnum = "+groupnum);

        if(carnum!=null){
            whereArray.add("e.carnum like '%"+carnum+"'");
        }

        if(name!=null){
            whereArray.add("e.name = "+name);
        }

        if(diskey!=null){
            whereArray.add("e.diskey = "+diskey);
        }

        if(datefrom!=null && dateto!=null){
            whereArray.add("e.enddate >= :datefrom");
            whereArray.add("e.enddate <= :dateto");
        }


        qlQuery = qlQuery +" WHERE "+String.join(" AND ",whereArray);

        TypedQuery<Twelfare> query = entityManager.createQuery(qlQuery,Twelfare.class);

        if(datefrom!=null && dateto!=null) {
            query.setParameter("datefrom", datefrom);
            query.setParameter("dateto", dateto);
        }

        return query.getResultList();
    }
}
