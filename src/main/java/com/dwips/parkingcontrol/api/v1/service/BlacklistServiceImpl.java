package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tblacklist;
import com.dwips.parkingcontrol.api.v1.dto.BlackListRequestDto;

import com.dwips.parkingcontrol.api.v1.repository.TblackListCustomRepository;
import com.dwips.parkingcontrol.api.v1.repository.TblackListRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BlacklistServiceImpl implements BlacklistService{

    private final CommonComponent commonComponent;

    private final TblackListRepository tblackListRepository;

    private final TblackListCustomRepository tblackListCustomRepository;

    @Override
    public HashMap<String, Object> search(BlackListRequestDto blackListRequestDto) {

        Integer result = 0;

        List<Tblacklist> tblacklistList = tblackListCustomRepository.customFindAll(
                blackListRequestDto.getSitenum(),
                blackListRequestDto.getGroupnum(),
                blackListRequestDto.getCarnum(),
                commonComponent.stringDateToLocalDate(blackListRequestDto.getDatefrom()),
                commonComponent.stringDateToLocalDate(blackListRequestDto.getDateto())
        );

        if(!tblacklistList.isEmpty()){
            result = 1;
        }else{
            tblacklistList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tblacklist",tblacklistList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(BlackListRequestDto blackListRequestDto) {

        Integer result = 0;

        List<Tblacklist> tblacklistList = new ArrayList<>();

        tblacklistList.add(tblackListRepository.save(blackListRequestDto.getTblacklist()));

        if(!tblacklistList.isEmpty()){
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tblacklist",tblacklistList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(BlackListRequestDto blackListRequestDto) {

        Integer result = 0;

        List<Tblacklist> tblacklistList = new ArrayList<>();

        Tblacklist tblacklist = tblackListRepository.findBySitenumAndGroupnumAndXindex(
                blackListRequestDto.getSitenum(),
                blackListRequestDto.getGroupnum(),
                blackListRequestDto.getTblacklist().getXindex()
        );

        if(tblacklist!=null){
            tblackListRepository.save(blackListRequestDto.getTblacklist());
            tblacklistList.add(tblacklist);
            result = 1;
        }else{
            tblacklistList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tblacklist",tblacklistList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(BlackListRequestDto blackListRequestDto) {

        Integer result = 0;

        Tblacklist tblacklist = null;

        if(blackListRequestDto.getXindex() != null){
            tblacklist = tblackListRepository.findBySitenumAndGroupnumAndXindex(
                    blackListRequestDto.getSitenum(),
                    blackListRequestDto.getGroupnum(),
                    blackListRequestDto.getXindex()
            );
        }else if(blackListRequestDto.getCarnum() != null){
            tblacklist = tblackListRepository.findBySitenumAndGroupnumAndCarnum(
                    blackListRequestDto.getSitenum(),
                    blackListRequestDto.getGroupnum(),
                    blackListRequestDto.getCarnum()
            );
        }

        if(tblacklist!=null){
            tblackListRepository.delete(tblacklist);
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }
}
