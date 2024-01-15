package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tdepartment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TdepartmentCustomRepository {

    private final EntityManager entityManager;


    public List<Tdepartment> customFindAll(Long sitenum, Long groupnum, Long ccode, String cname, Long code, String name) {

        String qlQuery = "SELECT e FROM Tdepartment e ";

        ArrayList<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+sitenum);
        whereArray.add("e.groupnum = "+groupnum);

        if(ccode!=null){
            whereArray.add("e.ccode = "+ccode);
        }

        if(cname!=null){
            whereArray.add("e.cname = '"+cname+"'");
        }

        if(code!=null){
            whereArray.add("e.code = "+code);
        }

        if(name!=null){
            whereArray.add("e.name = '"+name+"'");
        }


        TypedQuery<Tdepartment> query = entityManager.createQuery(qlQuery,Tdepartment.class);

        return query.getResultList();
    }
}
