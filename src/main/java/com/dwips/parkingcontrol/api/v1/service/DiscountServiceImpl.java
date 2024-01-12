package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.domain.Tdiscountl;
import com.dwips.parkingcontrol.api.v1.dto.DiscountRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TdiscountlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class DiscountServiceImpl implements DiscountService{

    private final TdiscountlRepository tdiscountlRepository;

    @Override
    public HashMap<String, Object> search(DiscountRequestDto discountRequestDto) {

        Integer result = 0;

        List<Tdiscountl> tdiscountlList = tdiscountlRepository.findAllBySitenumAndGroupnum(
                discountRequestDto.getSitenum(),
                discountRequestDto.getGroupnum()
        );

        if(!tdiscountlList.isEmpty()){
            result = 1;
        }else{
            tdiscountlList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tdiscount",tdiscountlList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(DiscountRequestDto discountRequestDto) {

        Integer result = 0;

        List<Tdiscountl> tdiscountlList = new ArrayList<>();

        tdiscountlList.add(tdiscountlRepository.save(discountRequestDto.getTdiscount()));

        if(!tdiscountlList.isEmpty()){
            result = 1;
        }else{
            tdiscountlList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tdiscount",tdiscountlList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(DiscountRequestDto discountRequestDto) {

        Integer result = 0;

        List<Tdiscountl> tdiscountlList = new ArrayList<>();

        Tdiscountl tdiscount = tdiscountlRepository.findBySitenumAndGroupnumAndXindex(
            discountRequestDto.getSitenum(),
            discountRequestDto.getGroupnum(),
            discountRequestDto.getTdiscount().getXindex()
        );

        if(tdiscount!=null){
            tdiscountlRepository.save(tdiscount);
            tdiscountlList.add(tdiscount);
            result = 1;
        }else{
            tdiscountlList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tdiscount",tdiscountlList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(DiscountRequestDto discountRequestDto) {

        Integer result = 0;

        HashMap<String, Object> resultMap = new HashMap<>();

        Tdiscountl tdiscount = tdiscountlRepository.findBySitenumAndGroupnumAndXindex(
                discountRequestDto.getSitenum(),
                discountRequestDto.getGroupnum(),
                discountRequestDto.getXindex()
        );

        if(tdiscount!=null){
            tdiscountlRepository.delete(tdiscount);
            result = 1;
        }

        resultMap.put("result",result);

        return resultMap;
    }
}
