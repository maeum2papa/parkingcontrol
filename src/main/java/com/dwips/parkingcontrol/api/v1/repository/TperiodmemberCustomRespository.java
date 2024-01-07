package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import com.dwips.parkingcontrol.api.v1.dto.PeriodmemberRequestDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TperiodmemberCustomRespository {

    private final EntityManager entityManager;

    private final CommonComponent commonComponent;

    public List<Tperiodmember> customFindAll(Long stienum, Long groupnum, String company, String department, String name){

        String qlString = "SELECT e FROM Tperiodmember e ";

        List<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+stienum);
        whereArray.add("e.groupnum = "+groupnum);


        if(company != null){
            whereArray.add("e.company = '"+company+"'");
        }

        if(department != null) {
            whereArray.add("e.department '= "+department+"'");
        }

        if(name != null) {
            whereArray.add("e.name = '"+name+"'");
        }

        qlString = qlString +" WHERE "+String.join(" AND ",whereArray);

        TypedQuery<Tperiodmember> query = entityManager.createQuery(qlString, Tperiodmember.class);

        return query.getResultList();

    }

    public List<Tperiodmember> customFindAllByRegdate(Long stienum, Long groupnum, LocalDateTime datefrom, LocalDateTime dateto, String company, String department, String name) {
        String qlString = "SELECT e FROM Tperiodmember e ";

        List<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+stienum);
        whereArray.add("e.groupnum = "+groupnum);
        whereArray.add("e.regdate >= :datefrom");
        whereArray.add("e.regdate <= :dateto");


        if(company != null){
            whereArray.add("e.company = '"+company+"'");
        }

        if(department != null) {
            whereArray.add("e.department '= "+department+"'");
        }

        if(name != null) {
            whereArray.add("e.name = '"+name+"'");
        }

        qlString = qlString +" WHERE "+String.join(" AND ",whereArray);

        TypedQuery<Tperiodmember> query = entityManager.createQuery(qlString, Tperiodmember.class);
        query.setParameter("datefrom",datefrom);
        query.setParameter("dateto",dateto);

        return query.getResultList();
    }

    public List<Tperiodmember> customFindAllByRegdateAndCarnum(Long stienum, Long groupnum, LocalDateTime datefrom, LocalDateTime dateto, String company, String department, String name, String carnum){

        String qlString = "SELECT e FROM Tperiodmember e ";

        List<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+stienum);
        whereArray.add("e.groupnum = "+groupnum);
        whereArray.add("e.carnum like '%"+carnum+"'");
        whereArray.add("e.regdate >= :datefrom");
        whereArray.add("e.regdate <= :dateto");

        if(company != null){
            whereArray.add("e.company = '"+company+"'");
        }

        if(department != null) {
            whereArray.add("e.department '= "+department+"'");
        }

        if(name != null) {
            whereArray.add("e.name = '"+name+"'");
        }

        qlString = qlString +" WHERE "+String.join(" AND ",whereArray);

        TypedQuery<Tperiodmember> query = entityManager.createQuery(qlString, Tperiodmember.class);
        query.setParameter("datefrom",datefrom);
        query.setParameter("dateto",dateto);

        return query.getResultList();
    }


    public List<Tperiodmember> customFindAllByCarnum(Long stienum, Long groupnum, String company, String department, String name, String carnum){

        String qlString = "SELECT e FROM Tperiodmember e ";

        List<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+stienum);
        whereArray.add("e.groupnum = "+groupnum);
        whereArray.add("e.carnum like '%"+carnum+"'");

        if(company != null){
            whereArray.add("e.company = '"+company+"'");
        }

        if(department != null) {
            whereArray.add("e.department '= "+department+"'");
        }

        if(name != null) {
            whereArray.add("e.name = '"+name+"'");
        }

        qlString = qlString +" WHERE "+String.join(" AND ",whereArray);

        TypedQuery<Tperiodmember> query = entityManager.createQuery(qlString, Tperiodmember.class);

        return query.getResultList();
    }

}
