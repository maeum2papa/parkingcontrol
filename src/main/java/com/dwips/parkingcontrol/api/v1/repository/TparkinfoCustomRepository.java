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


    public List<Tparkinfo>  customFindAll(Long sitenum, Long groupnum, Long devicenum, String mname, Long xindex, String carnum, LocalDateTime datefrom, LocalDateTime dateto, Long qtype) {

        String qlString = "SELECT e FROM Tparkinfo e ";

        List<String> whereArray = new ArrayList<>();

        whereArray.add("e.sitenum = "+sitenum);
        whereArray.add("e.groupnum = "+groupnum);

        if(datefrom!=null && dateto!=null) {
            if (qtype == 2) {
                whereArray.add("e.outdatetime >= :datefrom");
                whereArray.add("e.outdatetime <= :dateto");
            } else {
                whereArray.add("e.indatetime >= :datefrom");
                whereArray.add("e.indatetime <= :dateto");
            }
        }


        if(devicenum!=null){
            whereArray.add("e.devicenum = "+devicenum);
        }

        if(mname!=null){
            whereArray.add("e.mname = '"+mname+"'");
        }

        if(xindex!=null){
            whereArray.add("e.xindex = "+xindex);
        }

        if(carnum!=null){
            whereArray.add("e.carnum like '%"+xindex+"'");
        }


        if(qtype == 0){
//            0:모든차량
//            기간이 있으면 기간내 모든 차량 (indatetime or outdatetime)
        }else if(qtype == 1){
//            1:출차하지않은차량 outflag 79 가 아닌차량
            whereArray.add("e.outflag != 79");

        }else if(qtype == 2){
//            2:출차한차량 outflag 79인 차량
            whereArray.add("e.outflag = 79");

        }else if(qtype == 3){
//            3:입차차량검색
//            기간이 없으면 모든 차량 있으면 기간내 차량 (indatetime) 기준

        }else if(qtype == 4){
//            4:주차시간별검색
        }


        qlString = qlString +" WHERE "+String.join(" AND ",whereArray);

        TypedQuery<Tparkinfo> query = entityManager.createQuery(qlString, Tparkinfo.class);
        if(datefrom!=null && dateto!=null) {
            query.setParameter("datefrom", datefrom);
            query.setParameter("dateto", dateto);
        }

        return query.getResultList();
    }
}
