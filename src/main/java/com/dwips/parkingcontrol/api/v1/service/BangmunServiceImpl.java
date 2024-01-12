package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tbangmun;
import com.dwips.parkingcontrol.api.v1.dto.BangmunRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TbangmunCustomRepository;
import com.dwips.parkingcontrol.api.v1.repository.TbangmunRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BangmunServiceImpl implements BangmunService{

    private final CommonComponent commonComponent;

    private final TbangmunRepository tbangmunRepository;

    private final TbangmunCustomRepository tbangmunCustomRepository;

    @Override
    public HashMap<String, Object> search(BangmunRequestDto bangmunRequestDto) {

        Integer result = 0;

        List<Tbangmun> tbangmunList = tbangmunCustomRepository.customFindAll(
                bangmunRequestDto.getSitenum(),
                bangmunRequestDto.getGroupnum(),
                bangmunRequestDto.getCarnum(),
                bangmunRequestDto.getVisitplace(),
                commonComponent.stringDateToLocalDate(bangmunRequestDto.getDatefrom()),
                commonComponent.stringDateToLocalDate(bangmunRequestDto.getDateto())
        );

        if(!tbangmunList.isEmpty()){
            result = 1;
        }else{
            tbangmunList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tbangmun",tbangmunList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(BangmunRequestDto bangmunRequestDto) {

        Integer result = 0;
        List<Tbangmun> tbangmunList = new ArrayList<>();

        tbangmunList.add(tbangmunRepository.save(bangmunRequestDto.getTbangmun()));

        if(!tbangmunList.isEmpty()){
            result = 1;
        }else{
            tbangmunList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tbangmun",tbangmunList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(BangmunRequestDto bangmunRequestDto) {

        Integer result = 0;
        List<Tbangmun> tbangmunList = new ArrayList<>();

        Tbangmun tbangmun = tbangmunRepository.findBySitenumAndGroupnumAndXindex(
                bangmunRequestDto.getSitenum(),
                bangmunRequestDto.getGroupnum(),
                bangmunRequestDto.getTbangmun().getXindex()
        );

        if(tbangmun!=null){
            tbangmunRepository.save(bangmunRequestDto.getTbangmun());
            tbangmunList.add(tbangmun);
            result = 1;
        }else{
            tbangmunList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tbangmun",tbangmunList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(BangmunRequestDto bangmunRequestDto) {

        Integer result = 0;

        Tbangmun tbangmun = null;

        if(bangmunRequestDto.getXindex()!=null){
            tbangmun = tbangmunRepository.findBySitenumAndGroupnumAndXindex(
                    bangmunRequestDto.getSitenum(),
                    bangmunRequestDto.getGroupnum(),
                    bangmunRequestDto.getXindex()
            );
        }else if(bangmunRequestDto.getCarnum()!=null){
            tbangmun = tbangmunRepository.findBySitenumAndGroupnumAndCarnum(
                    bangmunRequestDto.getSitenum(),
                    bangmunRequestDto.getGroupnum(),
                    bangmunRequestDto.getCarnum()
            );
        }


        if(tbangmun!=null){
            tbangmunRepository.delete(tbangmun);
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }
}
