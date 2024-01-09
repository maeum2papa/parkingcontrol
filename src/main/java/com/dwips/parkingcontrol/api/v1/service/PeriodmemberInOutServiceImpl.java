package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodinout;
import com.dwips.parkingcontrol.api.v1.dto.PeriodmemberInOutRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TperiodinoutCustomRespository;
import com.dwips.parkingcontrol.api.v1.repository.TperiodinoutRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class PeriodmemberInOutServiceImpl implements PeriodmemberInOutService{

    private final CommonComponent commonComponent;

    private final TperiodinoutRespository tperiodinoutRespository;

    private final TperiodinoutCustomRespository tperiodinoutCustomRespository;


    /*
    차량번호,시작일자 및 종료 일자 가 없으면 전체 차량
    예) 차량번호는 있고 시작일자 및 종료일자 가 없으면 전체기간
        차량번호는 없고 시작일 과 종료일 있으면 기간에 해당하는 모든 정보 모두 없으면 전체 차량
     */
    @Override
    public HashMap<String, Object> search(PeriodmemberInOutRequestDto periodmemberInOutRequestDto) {

        Integer result = 0 ;

        List<Tperiodinout> tperiodinoutList = tperiodinoutCustomRespository.customFindAll(
                periodmemberInOutRequestDto.getSitenum(),
                periodmemberInOutRequestDto.getGroupnum(),
                periodmemberInOutRequestDto.getQtype(),
                periodmemberInOutRequestDto.getCarnum(),
                periodmemberInOutRequestDto.getCardid(),
                periodmemberInOutRequestDto.getName(),
                periodmemberInOutRequestDto.getXindex(),
                commonComponent.stringDateToLocalDateTime(periodmemberInOutRequestDto.getDatefrom(),"from"),
                commonComponent.stringDateToLocalDateTime(periodmemberInOutRequestDto.getDateto(),"to")
        );

        if(tperiodinoutList.isEmpty()){
            tperiodinoutList = null;
        }else{
            result = 1 ;
        }


        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tperiodinout",tperiodinoutList);

        return resultMap;
    }
}
