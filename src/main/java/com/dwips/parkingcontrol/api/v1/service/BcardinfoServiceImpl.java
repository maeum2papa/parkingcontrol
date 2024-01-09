package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tbcardinfo;
import com.dwips.parkingcontrol.api.v1.dto.BcardinfoRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TbcardinfoCutomRepository;
import com.dwips.parkingcontrol.api.v1.repository.TbcardinfoRepository;
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
public class BcardinfoServiceImpl implements BcardinfoService{

    private final TbcardinfoCutomRepository tbcardinfoCutomRepository;
    private final CommonComponent commonComponent;


    @Override
    public HashMap<String, Object> search(BcardinfoRequestDto bcardinfoRequestDto) {

        Integer result = 0;
        List<Tbcardinfo> bcardinfoList = tbcardinfoCutomRepository.customFindAll(
                bcardinfoRequestDto.getSitenum(),
                bcardinfoRequestDto.getGroupnum(),
                bcardinfoRequestDto.getCarnum(),
                bcardinfoRequestDto.getRescode(),
                bcardinfoRequestDto.getCardid(),
                bcardinfoRequestDto.getCardname(),
                bcardinfoRequestDto.getDevicenum(),
                commonComponent.stringDateToLocalDateTime(bcardinfoRequestDto.getDatefrom(),"from"),
                commonComponent.stringDateToLocalDateTime(bcardinfoRequestDto.getDateto(),"to")
        );

        if(bcardinfoList.isEmpty()){
            bcardinfoList = null;
        }else{
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("bcardinfo",bcardinfoList);

        return resultMap;
    }
}
