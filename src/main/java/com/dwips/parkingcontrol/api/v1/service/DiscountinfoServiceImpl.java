package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tdiscountinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tdiscountl;
import com.dwips.parkingcontrol.api.v1.dto.DiscountinfoRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TdiscountinfoCustomRepository;
import com.dwips.parkingcontrol.api.v1.repository.TdiscountinfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DiscountinfoServiceImpl implements DiscountinfoService{

    private final CommonComponent commonComponent;
    private final TdiscountinfoCustomRepository tdiscountinfoCustomRepository;

    @Override
    public HashMap<String, Object> search(DiscountinfoRequestDto discountinfoRequestDto) {
        Integer result = 0;
        List<Tdiscountinfo> tdiscountinfoList = new ArrayList<>();

        tdiscountinfoList = tdiscountinfoCustomRepository.customFindAll(
                discountinfoRequestDto.getSitenum(),
                discountinfoRequestDto.getGroupnum(),
                discountinfoRequestDto.getDevicenum(),
                discountinfoRequestDto.getDeptcode(),
                discountinfoRequestDto.getDisid(),
                discountinfoRequestDto.getPindex(),
                commonComponent.stringDateToLocalDateTime(discountinfoRequestDto.getDatefrom(),"from"),
                commonComponent.stringDateToLocalDateTime(discountinfoRequestDto.getDateto(),"to")
        );

        if(!tdiscountinfoList.isEmpty()){
            result = 1;
        }else{
            tdiscountinfoList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",result);
        resultMap.put("tdiscountinfo",tdiscountinfoList);

        return resultMap;
    }
}
