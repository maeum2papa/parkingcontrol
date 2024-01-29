package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.domain.Tvaninfo;
import com.dwips.parkingcontrol.api.v1.dto.VaninfoRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TvaninfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
@RequiredArgsConstructor
public class VaninfoServiceImpl implements VaninfoService{

    private final TvaninfoRepository tvaninfoRepository;

    @Override
    public HashMap<String, Object> search(VaninfoRequestDto vaninfoRequestDto) {
        Integer result = 0;
        List<Tvaninfo> tvaninfoList = new ArrayList<>();

        if(vaninfoRequestDto.getVancode()!=null) {
            tvaninfoList = tvaninfoRepository.findAllBySitenumAndGroupnumAndVancode(
                vaninfoRequestDto.getSitenum(),
                vaninfoRequestDto.getGroupnum(),
                vaninfoRequestDto.getVancode()
            );
        }else{
            tvaninfoList = tvaninfoRepository.findAllBySitenumAndGroupnum(
                    vaninfoRequestDto.getSitenum(),
                    vaninfoRequestDto.getGroupnum()
            );
        }

        if(!tvaninfoList.isEmpty()){
            result = 1;
        }else{
            tvaninfoList = null;
        }


        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",result);
        resultMap.put("tvaninfo",tvaninfoList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(VaninfoRequestDto vaninfoRequestDto) {
        Integer result = 0;
        List<Tvaninfo> tvaninfoList = new ArrayList<>();

        Tvaninfo tvaninfo = tvaninfoRepository.findBySitenumAndGroupnumAndVancodeAndBranchcode(
            vaninfoRequestDto.getSitenum(),
            vaninfoRequestDto.getGroupnum(),
            vaninfoRequestDto.getTvaninfo().getVancode(),
            vaninfoRequestDto.getTvaninfo().getBranchcode()
        );

        if(tvaninfo==null){
            tvaninfoList.add(tvaninfoRepository.save(vaninfoRequestDto.getTvaninfo()));
            result = 1;
        }else{
            tvaninfoList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",result);
        resultMap.put("tvaninfo",tvaninfoList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(VaninfoRequestDto vaninfoRequestDto) {
        Integer result = 0;
        List<Tvaninfo> tvaninfoList = new ArrayList<>();

        Tvaninfo tvaninfo = tvaninfoRepository.findBySitenumAndGroupnumAndXindex(
                vaninfoRequestDto.getSitenum(),
                vaninfoRequestDto.getGroupnum(),
                vaninfoRequestDto.getTvaninfo().getXindex()
        );

        if(tvaninfo!=null) {
            tvaninfoRepository.save(vaninfoRequestDto.getTvaninfo());
            tvaninfoList.add(tvaninfo);
            result = 1;
        }else{
            tvaninfoList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",result);
        resultMap.put("tvaninfo",tvaninfoList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(VaninfoRequestDto vaninfoRequestDto) {
        Integer result = 0;


        Tvaninfo tvaninfo = tvaninfoRepository.findBySitenumAndGroupnumAndXindex(
                vaninfoRequestDto.getSitenum(),
                vaninfoRequestDto.getGroupnum(),
                vaninfoRequestDto.getXindex()
        );

        if(tvaninfo!=null){

            tvaninfoRepository.delete(tvaninfo);

            result = 1;

        }


        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result",result);
        resultMap.put("xindex",tvaninfo.getXindex());

        return resultMap;
    }
}
