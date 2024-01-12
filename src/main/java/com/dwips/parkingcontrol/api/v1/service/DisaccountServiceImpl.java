package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.domain.Tdisaccount;
import com.dwips.parkingcontrol.api.v1.dto.DisaccountRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TdisaccountCustomRepository;
import com.dwips.parkingcontrol.api.v1.repository.TdisaccountRepository;
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
public class DisaccountServiceImpl implements DisaccountService{

    private final TdisaccountRepository tdisaccountRepository;

    private final TdisaccountCustomRepository tdisaccountCustomRepository;

    @Override
    public HashMap<String, Object> search(DisaccountRequestDto disaccountRequestDto) {

        Integer result = 0;

        List<Tdisaccount> tdisaccountList = tdisaccountCustomRepository.customFindAll(
                disaccountRequestDto.getSitenum(),
                disaccountRequestDto.getGroupnum(),
                disaccountRequestDto.getId(),
                disaccountRequestDto.getName()
        );

        if(tdisaccountList.isEmpty()){
            tdisaccountList = null;
        }else{
            result = 1;
        }

        HashMap<String,Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tdisaccount",tdisaccountList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(DisaccountRequestDto disaccountRequestDto) {

        Integer result = 0;

        List<Tdisaccount> tdisaccountList = new ArrayList<>();

        tdisaccountList.add(tdisaccountRepository.save(disaccountRequestDto.getTdisaccount()));

        if(!tdisaccountList.isEmpty()){
            result = 1;
        }else{
            tdisaccountList = null;
        }

        HashMap<String,Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tdisaccount",tdisaccountList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(DisaccountRequestDto disaccountRequestDto) {

        Integer result = 0;

        List<Tdisaccount> tdisaccountList = new ArrayList<>();

        Tdisaccount tdisaccount = tdisaccountRepository.findBySitenumAndGroupnumAndXindex(
                disaccountRequestDto.getSitenum(),
                disaccountRequestDto.getGroupnum(),
                disaccountRequestDto.getTdisaccount().getXindex()
        );

        if(tdisaccount!=null){
            tdisaccountRepository.save(disaccountRequestDto.getTdisaccount());
            tdisaccountList.add(tdisaccount);
            result = 1;
        }else{
            tdisaccountList = null;
        }

        HashMap<String,Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tdisaccount",tdisaccountList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(DisaccountRequestDto disaccountRequestDto) {

        Integer result = 0;

        Tdisaccount tdisaccount = tdisaccountRepository.findBySitenumAndGroupnumAndXindex(
            disaccountRequestDto.getSitenum(),
            disaccountRequestDto.getGroupnum(),
            disaccountRequestDto.getXindex()
        );

        if(tdisaccount!=null){
            tdisaccountRepository.delete(tdisaccount);
            result = 1;
        }

        HashMap<String,Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }
}
