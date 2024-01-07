package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.dto.CalculateSearchRequestDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TparkinfoCustomRepository {

    private final EntityManager entityManager;

    private final CommonComponent commonComponent;

    public List<Tparkinfo> customFindAll(CalculateSearchRequestDto calculateSearchRequestDto){

        String qlString = "SELECT e FROM Tparkinfo e ";

        List<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+calculateSearchRequestDto.getSitenum());
        whereArray.add("e.groupnum = "+calculateSearchRequestDto.getGroupnum());
        whereArray.add("e.outdatetime >= :datefrom");
        whereArray.add("e.outdatetime <= :dateto");
        whereArray.add("(e.outflag = 79 OR e.outflag = 88)");

        if(calculateSearchRequestDto.getDevicenum() != null){
            whereArray.add("e.indevicenum = "+calculateSearchRequestDto.getDevicenum());
        }

        if(calculateSearchRequestDto.getCarnum() != null) {
            whereArray.add("e.carnum like '"+calculateSearchRequestDto.getCarnum()+"%'");
        }

        if(calculateSearchRequestDto.getMname() != null) {
            whereArray.add("e.mname = '"+calculateSearchRequestDto.getMname()+"'");
        }

        qlString = qlString +" WHERE "+String.join(" AND ",whereArray);

        TypedQuery<Tparkinfo> query = entityManager.createQuery(qlString, Tparkinfo.class);
        query.setParameter("datefrom",commonComponent.stringDateToLocalDateTime(calculateSearchRequestDto.getDatefrom(),"from"));
        query.setParameter("dateto",commonComponent.stringDateToLocalDateTime(calculateSearchRequestDto.getDateto(),"to"));

        return query.getResultList();
    }

}
