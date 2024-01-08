package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.domain.Tnorecognition;
import com.dwips.parkingcontrol.api.v1.dto.NoregcarRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TnorecognitionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class NoregcarServiceImpl implements NoregcarService{

    private final TnorecognitionRepository tnorecognitionRepository;

    @Override
    public HashMap<String, Object> save(NoregcarRequestDto noregcarRequestDto) {

        Integer result = 1;

        Tnorecognition tnorecognition = tnorecognitionRepository.save(noregcarRequestDto.getTnorecognition());

        if(tnorecognition.getXindex() != null){
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }
}
