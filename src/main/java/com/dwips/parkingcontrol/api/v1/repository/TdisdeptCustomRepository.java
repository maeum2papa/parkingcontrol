package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tdisdept;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TdisdeptCustomRepository {

    private final EntityManager entityManager;

    public List<Tdisdept> customFindAll(Long sitenum, Long groupnum, Long deptcode, String deptname){

        String qString = "select e from Tdisdept e ";

        List<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+sitenum);
        whereArray.add("e.groupnum = "+groupnum);

        if(deptcode!=null){
            whereArray.add("e.deptcode = "+deptcode);
        }

        if(deptname!=null){
            whereArray.add("e.deptname = '"+deptname+"'");
        }

        qString = qString +" WHERE "+String.join(" AND ",whereArray);

        TypedQuery<Tdisdept> query = entityManager.createQuery(qString, Tdisdept.class);

        return query.getResultList();
    }
}
