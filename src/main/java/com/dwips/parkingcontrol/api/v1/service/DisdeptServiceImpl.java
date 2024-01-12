package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.domain.Tdisdept;
import com.dwips.parkingcontrol.api.v1.dto.DisdeptRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TdisdeptCustomRepository;
import com.dwips.parkingcontrol.api.v1.repository.TdisdeptRepository;
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
public class DisdeptServiceImpl implements DisdeptService{

    private final TdisdeptRepository tdisdeptRepository;

    private final TdisdeptCustomRepository tdisdeptCustomRepository;

    @Override
    public HashMap<String, Object> search(DisdeptRequestDto disdpeptRequestDto) {

        Integer result = 0;

        List<Tdisdept> tdisdeptList = tdisdeptCustomRepository.customFindAll(
                disdpeptRequestDto.getSitenum(),
                disdpeptRequestDto.getGroupnum(),
                disdpeptRequestDto.getDeptcode(),
                disdpeptRequestDto.getDeptname()
        );

        if(tdisdeptList.isEmpty()){
            tdisdeptList = null;
        }else{
            result = 1;
        }

        HashMap<String,Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tdisdept",tdisdeptList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(DisdeptRequestDto disdpeptRequestDto) {
        Integer result = 0;

        List<Tdisdept> tdisdeptList = new ArrayList<>();

        tdisdeptList.add(tdisdeptRepository.save(disdpeptRequestDto.getTdisdept()));

        if(!tdisdeptList.isEmpty()){
            result = 1;
        }else{
            tdisdeptList = null;
        }

        HashMap<String,Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tdisdept",tdisdeptList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(DisdeptRequestDto disdpeptRequestDto) {

        Integer result = 0;

        List<Tdisdept> tdisdeptList = new ArrayList<>();

        Tdisdept tdisdept = tdisdeptRepository.findBySitenumAndGroupnumAndXindex(
            disdpeptRequestDto.getSitenum(),
            disdpeptRequestDto.getGroupnum(),
            disdpeptRequestDto.getTdisdept().getXindex()
        );

        if(tdisdept!=null){
            tdisdeptRepository.save(disdpeptRequestDto.getTdisdept());
            tdisdeptList.add(tdisdept);
            result = 1;
        }

        HashMap<String,Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tdisdept",tdisdeptList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(DisdeptRequestDto disdpeptRequestDto) {

        Integer result = 0;

        Tdisdept tdisdept = tdisdeptRepository.findBySitenumAndGroupnumAndXindex(
                disdpeptRequestDto.getSitenum(),
                disdpeptRequestDto.getGroupnum(),
                disdpeptRequestDto.getXindex()
        );

        if(tdisdept!=null){
            tdisdeptRepository.delete(tdisdept);
            result = 1;
        }

        HashMap<String,Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }
}
