package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Twelfare;
import com.dwips.parkingcontrol.api.v1.dto.WelfareRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TwelfareCustomRepository;
import com.dwips.parkingcontrol.api.v1.repository.TwelfareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WelfareServiceImpl implements WelfareService{

    private final CommonComponent commonComponent;

    private final TwelfareRepository twelfareRepository;

    private final TwelfareCustomRepository twelfareCustomRepository;


    @Override
    public HashMap<String, Object> search(WelfareRequestDto welfareRequestDto) {

        Integer result = 0;

        List<Twelfare> twelfareList = twelfareCustomRepository.customFindAll(
                welfareRequestDto.getSitenum(),
                welfareRequestDto.getGroupnum(),
                welfareRequestDto.getCarnum(),
                welfareRequestDto.getName(),
                welfareRequestDto.getDiskey(),
                commonComponent.stringDateToLocalDate(welfareRequestDto.getDatefrom()),
                commonComponent.stringDateToLocalDate(welfareRequestDto.getDateto())
        );

        if(!twelfareList.isEmpty()){
            result = 1;
        }else{
            twelfareList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("twelfare",twelfareList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(WelfareRequestDto welfareRequestDto) {

        Integer result = 0;
        List<Twelfare> twelfareList = new ArrayList<>();

        twelfareList.add(twelfareRepository.save(welfareRequestDto.getTwelfare()));

        if(!twelfareList.isEmpty()){
            result = 1;
        }else{
            twelfareList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("twelfare",twelfareList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(WelfareRequestDto welfareRequestDto) {

        Integer result = 0;
        List<Twelfare> twelfareList = new ArrayList<>();

        Twelfare twelfare = twelfareRepository.findBySitenumAndGroupnumAndXindex(
                welfareRequestDto.getSitenum(),
                welfareRequestDto.getGroupnum(),
                welfareRequestDto.getTwelfare().getXindex()
        );

        if(twelfare!=null){
            twelfareRepository.save(welfareRequestDto.getTwelfare());
            twelfareList.add(twelfare);
            result = 1;
        }else{
            twelfareList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("twelfare",twelfareList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(WelfareRequestDto welfareRequestDto) {

        Integer result = 0;
        Twelfare twelfare = null;

        if(welfareRequestDto.getXindex()!=null){

            twelfare = twelfareRepository.findBySitenumAndGroupnumAndXindex(
                    welfareRequestDto.getSitenum(),
                    welfareRequestDto.getGroupnum(),
                    welfareRequestDto.getXindex()
            );

        }else if(welfareRequestDto.getCarnum()!=null){

            twelfare = twelfareRepository.findBySitenumAndGroupnumAndCarnum(
                    welfareRequestDto.getSitenum(),
                    welfareRequestDto.getGroupnum(),
                    welfareRequestDto.getCarnum()
            );
        }

        if(twelfare!=null){
            twelfareRepository.delete(twelfare);
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }
}
