package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.domain.Tapsinfo;
import com.dwips.parkingcontrol.api.v1.dto.ApsinfoRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TapsinfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class ApsinfoServiceImpl implements  ApsinfoService{

    private final TapsinfoRepository tapsinfoRepository;

    @Override
    public HashMap<String, Object> save(ApsinfoRequestDto apsinfoRequestDto) {
        Integer result = 0;

        Tapsinfo tapsinfo = tapsinfoRepository.save(apsinfoRequestDto.getTapsinfo());

        if(tapsinfo!=null){
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result", result);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(ApsinfoRequestDto apsinfoRequestDto) {
        Integer result = 0;

        Tapsinfo tapsinfo = tapsinfoRepository.findBySitenumAndGroupnumAndXindex(
            apsinfoRequestDto.getSitenum(),
            apsinfoRequestDto.getGroupnum(),
            apsinfoRequestDto.getTapsinfo().getXindex()
        );

        if(tapsinfo!=null){
            tapsinfo.setStatus(0l);
            tapsinfoRepository.save(tapsinfo);
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("result", result);

        return resultMap;
    }
}
