package com.dwips.parkingcontrol.api.v1.service;


import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodaccount;
import com.dwips.parkingcontrol.api.v1.dto.PeriodaccountRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TperiodaccountCustomResitory;
import com.dwips.parkingcontrol.api.v1.repository.TperiodaccountResitory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class PeriodaccountServiceImpl implements PeriodaccountService{

    private final CommonComponent commonComponent;

    private final TperiodaccountResitory tperiodaccountResitory;

    private final TperiodaccountCustomResitory tperiodaccountCustomResitory;

    @Override
    public HashMap<String, Object> search(PeriodaccountRequestDto periodaccountRequestDto) {

        List<Tperiodaccount> tperiodaccountList = tperiodaccountCustomResitory.customFindAll(
                periodaccountRequestDto.getSitenum(),
                periodaccountRequestDto.getGroupnum(),
                periodaccountRequestDto.getCarnum(),
                periodaccountRequestDto.getPflag(),
                commonComponent.stringDateToLocalDateTime(periodaccountRequestDto.getDatefrom(),"from"),
                commonComponent.stringDateToLocalDateTime(periodaccountRequestDto.getDateto(),"to")
        );

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",1);
        resultMap.put("tperiodaccount",tperiodaccountList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(PeriodaccountRequestDto periodaccountRequestDto) {

        List<Tperiodaccount> tperiodaccountList = new ArrayList<>();

        tperiodaccountList.add(tperiodaccountResitory.save(periodaccountRequestDto.getTperiodaccount()));

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",1);
        resultMap.put("tperiodaccount",tperiodaccountList);

        return resultMap;
    }
}
