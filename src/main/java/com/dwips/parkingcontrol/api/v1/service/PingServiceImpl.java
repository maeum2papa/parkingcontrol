package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.domain.Tping;
import com.dwips.parkingcontrol.api.v1.dto.PingRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TpingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.SpringProperties;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PingServiceImpl implements PingService{

    private final TpingRepository tpingRepository;

    @Override
    public HashMap<String, Object> search(PingRequestDto pingRequestDto) {

        Integer result = 0;
        List<Tping> tpingList = tpingRepository.findAllBySitenumAndGroupnum(
            pingRequestDto.getSitenum(),
            pingRequestDto.getGroupnum()
        );

        if(!tpingList.isEmpty()){
            result = 1;
        }else{
            tpingList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tping",tpingList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(PingRequestDto pingRequestDto) {
        Integer result = 0;
        List<Tping> tpingList = new ArrayList<>();

        tpingList.add(tpingRepository.save(pingRequestDto.getTping()));

        if(!tpingList.isEmpty()){
            result = 1;
        }else{
            tpingList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tping",tpingList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(PingRequestDto pingRequestDto) {
        Integer result = 0;
        List<Tping> tpingList = new ArrayList<>();

        Tping tping = tpingRepository.findBySitenumAndGroupnumAndXindex(
                pingRequestDto.getSitenum(),
                pingRequestDto.getGroupnum(),
                pingRequestDto.getTping().getXindex()
        );

        if(tping!=null){
            tpingRepository.save(pingRequestDto.getTping());
            tpingList.add(tping);
            result = 1;
        }else{
            tpingList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tping",tpingList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(PingRequestDto pingRequestDto) {
        Integer result = 0;

        Tping tping = tpingRepository.findBySitenumAndGroupnumAndXindex(
                pingRequestDto.getSitenum(),
                pingRequestDto.getGroupnum(),
                pingRequestDto.getTping().getXindex()
        );

        if(tping!=null){
            tpingRepository.save(tping);
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> xparkin(PingRequestDto pingRequestDto) {

        Integer result = 0;

        List<Tping> tpingList = tpingRepository.findAllBySitenumAndGroupnumAndXparkin(
                pingRequestDto.getSitenum(),
                pingRequestDto.getGroupnum(),
                pingRequestDto.getXparkin()
        );

        if(!tpingList.isEmpty()){
            result = 1;
        }else{
            tpingList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tping",tpingList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> xparkinfo(PingRequestDto pingRequestDto) {

        Integer result = 0;

        List<Tping> tpingList = tpingRepository.findAllBySitenumAndGroupnumAndXparkinfo(
                pingRequestDto.getSitenum(),
                pingRequestDto.getGroupnum(),
                pingRequestDto.getXparkinfo()
        );

        if(!tpingList.isEmpty()){
            result = 1;
        }else{
            tpingList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tping",tpingList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> xparkcal(PingRequestDto pingRequestDto) {

        Integer result = 0;

        List<Tping> tpingList = tpingRepository.findAllBySitenumAndGroupnumAndXparkcal(
                pingRequestDto.getSitenum(),
                pingRequestDto.getGroupnum(),
                pingRequestDto.getXparkcal()
        );

        if(!tpingList.isEmpty()){
            result = 1;
        }else{
            tpingList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tping",tpingList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> xperiodin(PingRequestDto pingRequestDto) {

        Integer result = 0;

        List<Tping> tpingList = tpingRepository.findAllBySitenumAndGroupnumAndXperiodin(
                pingRequestDto.getSitenum(),
                pingRequestDto.getGroupnum(),
                pingRequestDto.getXperiodin()
        );

        if(!tpingList.isEmpty()){
            result = 1;
        }else{
            tpingList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tping",tpingList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> xperiodout(PingRequestDto pingRequestDto) {

        Integer result = 0;

        List<Tping> tpingList = tpingRepository.findAllBySitenumAndGroupnumAndXperiodinout(
                pingRequestDto.getSitenum(),
                pingRequestDto.getGroupnum(),
                pingRequestDto.getXperiodout()
        );

        if(!tpingList.isEmpty()){
            result = 1;
        }else{
            tpingList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tping",tpingList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> xcredit(PingRequestDto pingRequestDto) {

        Integer result = 0;

        List<Tping> tpingList = tpingRepository.findAllBySitenumAndGroupnumAndXcredit(
                pingRequestDto.getSitenum(),
                pingRequestDto.getGroupnum(),
                pingRequestDto.getXcredit()
        );

        if(!tpingList.isEmpty()){
            result = 1;
        }else{
            tpingList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tping",tpingList);

        return resultMap;
    }
}
