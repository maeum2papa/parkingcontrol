package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.domain.Tparkconfig;
import com.dwips.parkingcontrol.api.v1.dto.ParkconfigRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TparkconfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkconfigServiceImpl implements ParkconfigService{

    private final TparkconfigRepository tparkconfigRepository;

    @Override
    public HashMap<String, Object> search(ParkconfigRequestDto parkconfigRequestDto) {

        Integer result = 0;
        List<Tparkconfig> tparkfonfigList = tparkconfigRepository.findAllBySitenumAndGroupnum(
                parkconfigRequestDto.getSitenum(),
                parkconfigRequestDto.getGroupnum()
        );

        if(!tparkfonfigList.isEmpty()){
            result = 1;
        }else{
            tparkfonfigList = null;
        }

        HashMap<String,Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tprakfonfig",tparkfonfigList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(ParkconfigRequestDto parkconfigRequestDto) {
        //∴ sitenum+groupnum+cmd_type 은 하나만 존재해야 함
        Integer result = 0;
        List<Tparkconfig> tparkfonfigList = new ArrayList<>();

        Tparkconfig tparkconfig = tparkconfigRepository.findBySitenumAndGroupnumAndCmdtype(
                parkconfigRequestDto.getSitenum(),
                parkconfigRequestDto.getGroupnum(),
                parkconfigRequestDto.getTparkconfig().getCmdtype()
        );

        if(tparkconfig == null){
            tparkfonfigList.add(tparkconfigRepository.save(parkconfigRequestDto.getTparkconfig()));
        }

        if(!tparkfonfigList.isEmpty()){
            result = 1;
        }else{
            tparkfonfigList = null;
        }

        HashMap<String,Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tprakfonfig",tparkfonfigList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(ParkconfigRequestDto parkconfigRequestDto) {
        //∴ sitenum+groupnum+cmd_type 은 하나만 존재해야 함
        Integer result = 0;
        List<Tparkconfig> tparkfonfigList = new ArrayList<>();

        Tparkconfig tparkconfig = tparkconfigRepository.findBySitenumAndGroupnumAndXindex(
                parkconfigRequestDto.getSitenum(),
                parkconfigRequestDto.getGroupnum(),
                parkconfigRequestDto.getTparkconfig().getXindex()
        );


        if(tparkconfig!=null){
            tparkfonfigList.add(tparkconfigRepository.save(parkconfigRequestDto.getTparkconfig()));
            result = 1;
        }else{
            tparkfonfigList = null;
        }

        HashMap<String,Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tprakfonfig",tparkfonfigList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(ParkconfigRequestDto parkconfigRequestDto) {

        Integer result = 0;

        Tparkconfig tparkconfig = tparkconfigRepository.findBySitenumAndGroupnumAndXindex(
                parkconfigRequestDto.getSitenum(),
                parkconfigRequestDto.getGroupnum(),
                parkconfigRequestDto.getXindex()
        );

        if(tparkconfig!=null){
            tparkconfigRepository.delete(tparkconfig);
            result = 1;
        }

        HashMap<String,Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }
}
