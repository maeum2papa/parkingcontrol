package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tbcardinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tdisaccount;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TdisaccountCustomRepository {

    private final EntityManager entityManager;

    public List<Tdisaccount> customFindAll(Long sitenum, Long groupnum, String id, String name){

        String qlString = "SELECT e FROM Tdisaccount e";

        List<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+sitenum);
        whereArray.add("e.groupnum = "+groupnum);

        if(id!=null){
            whereArray.add("e.id = '"+id+"'");
        }

        if(name!=null){
            whereArray.add("e.name = '"+name+"'");
        }

        qlString = qlString +" WHERE "+String.join(" AND ",whereArray);

        TypedQuery<Tdisaccount> query = entityManager.createQuery(qlString, Tdisaccount.class);

        return query.getResultList();
    }

}
