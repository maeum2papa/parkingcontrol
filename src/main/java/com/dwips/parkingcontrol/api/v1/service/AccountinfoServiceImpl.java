package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.domain.Taccountinfo;
import com.dwips.parkingcontrol.api.v1.dto.AccountinfoRquestDto;
import com.dwips.parkingcontrol.api.v1.repository.TaccountinfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountinfoServiceImpl implements AccountinfoService{

    private final TaccountinfoRepository taccountinfoRepository;

    @Override
    public HashMap<String, Object> search(AccountinfoRquestDto accountinfoRquestDto) {
        Integer result = 0;
        List<Taccountinfo> taccountinfoList =  taccountinfoRepository.findAllBySitenumAndGroupnumAndId(
                accountinfoRquestDto.getSitenum(),
                accountinfoRquestDto.getGroupnum(),
                accountinfoRquestDto.getId()
        );

        if(!taccountinfoList.isEmpty()){
            result = 1;
        }else{
            taccountinfoList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("taccountinfo",taccountinfoList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(AccountinfoRquestDto accountinfoRquestDto) {
        Integer result = 0;
        List<Taccountinfo> taccountinfoList = new ArrayList<>();


        Taccountinfo taccountinfo = taccountinfoRepository.findBySitenumAndGroupnumAndIdAndDiskey(
                accountinfoRquestDto.getSitenum(),
                accountinfoRquestDto.getGroupnum(),
                accountinfoRquestDto.getId(),
                accountinfoRquestDto.getDiseky()
        );

        if(taccountinfo==null){
            Taccountinfo buildTaccountinfo = Taccountinfo.builder()
                    .sitenum(accountinfoRquestDto.getSitenum())
                    .groupnum(accountinfoRquestDto.getGroupnum())
                    .id(accountinfoRquestDto.getId())
                    .diskey(accountinfoRquestDto.getDiseky())
                    .build();
            taccountinfoList.add(taccountinfoRepository.save(buildTaccountinfo));
        }

        if(!taccountinfoList.isEmpty()){
            result = 1;
        }else{
            taccountinfoList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("taccountinfo",taccountinfoList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(AccountinfoRquestDto accountinfoRquestDto) {
        Integer result = 0;
        List<Taccountinfo> taccountinfoList = new ArrayList<>();


        Taccountinfo taccountinfo = taccountinfoRepository.findBySitenumAndGroupnumAndIdAndDiskey(
                accountinfoRquestDto.getSitenum(),
                accountinfoRquestDto.getGroupnum(),
                accountinfoRquestDto.getId(),
                accountinfoRquestDto.getDiseky()
        );

        if(taccountinfo!=null){
            taccountinfo.setId(accountinfoRquestDto.getId());
            taccountinfo.setDiskey(accountinfoRquestDto.getDiseky());
            taccountinfoList.add(taccountinfoRepository.save(taccountinfo));
        }

        if(!taccountinfoList.isEmpty()){
            result = 1;
        }else{
            taccountinfoList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("taccountinfo",taccountinfoList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(AccountinfoRquestDto accountinfoRquestDto) {

        Integer result = 0;

        List<Taccountinfo> taccountinfoList = new ArrayList<>();

        if(accountinfoRquestDto.getXindex()!=null){
            taccountinfoList = taccountinfoRepository.findAllBySitenumAndGroupnumAndXindex(
                    accountinfoRquestDto.getSitenum(),
                    accountinfoRquestDto.getGroupnum(),
                    accountinfoRquestDto.getXindex()
            );
        }else if(accountinfoRquestDto.getId()!=null){
            taccountinfoList = taccountinfoRepository.findAllBySitenumAndGroupnumAndId(
                    accountinfoRquestDto.getSitenum(),
                    accountinfoRquestDto.getGroupnum(),
                    accountinfoRquestDto.getId()
            );
        }

        if(!taccountinfoList.isEmpty()){
            taccountinfoRepository.deleteAll(taccountinfoList);
            result = 1;
        }


        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }
}
