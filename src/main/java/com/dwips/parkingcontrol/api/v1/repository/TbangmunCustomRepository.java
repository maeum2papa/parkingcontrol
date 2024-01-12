package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tbangmun;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TbangmunCustomRepository {

    private final EntityManager entityManager;


    public List<Tbangmun> customFindAll(Long sitenum, Long groupnum, String carnum, String visitplace, LocalDate datefrom, LocalDate dateto) {

        String qlString = "SELECT e FROM Tbangmun e ";

        List<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+sitenum);
        whereArray.add("e.sitenum = "+groupnum);

        if(datefrom!=null && dateto!=null){
            whereArray.add("e.startdate >= :datefrom");
            whereArray.add("e.startdate <= :dateto");
        }

        if(carnum!=null){
            whereArray.add("e.carnum like '%"+carnum+"'");
        }

        if(visitplace!=null){
            whereArray.add("e.carnum = '"+visitplace+"'");
        }

        qlString = qlString +" WHERE "+String.join(" AND ",whereArray);

        TypedQuery<Tbangmun> query = entityManager.createQuery(qlString,Tbangmun.class);
        if(datefrom!=null && dateto!=null){
            query.setParameter("datefrom",datefrom);
            query.setParameter("dateto",dateto);
        }


        return query.getResultList();
    }
}
