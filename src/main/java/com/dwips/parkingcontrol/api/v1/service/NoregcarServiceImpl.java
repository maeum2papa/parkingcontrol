package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tnorecognition;
import com.dwips.parkingcontrol.api.v1.dto.NoregcarDelRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.NoregcarRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.NoregcarSearchRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TnorecognitionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class NoregcarServiceImpl implements NoregcarService{

    private final CommonComponent commonComponent;

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

    @Override
    public HashMap<String, Object> delete(NoregcarDelRequestDto noregcarDelRequestDto) {

        Integer result = 0;

        Tnorecognition tnorecognition = tnorecognitionRepository.findBySitenumAndGroupnumAndXindex(
                noregcarDelRequestDto.getSitenum(),
                noregcarDelRequestDto.getGroupnum(),
                noregcarDelRequestDto.getXindex()
        );

        if(tnorecognition != null){
            tnorecognitionRepository.delete(tnorecognition);
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;

    }

    @Override
    public HashMap<String, Object> search(NoregcarSearchRequestDto noregcarSearchRequestDto) {

        Integer result = 0;
        List<Tnorecognition> tnorecognitionList = null;

        if(noregcarSearchRequestDto.getDatefrom() == null && noregcarSearchRequestDto.getDateto() == null){

            tnorecognitionList = tnorecognitionRepository.findAllBySitenumAndGroupnum(
                    noregcarSearchRequestDto.getSitenum(),
                    noregcarSearchRequestDto.getGroupnum()
            );

        }else {
            tnorecognitionList = tnorecognitionRepository.findAllBySitenumAndGroupnumAndIodatetimeGreaterThanEqualAndIodatetimeLessThanEqual(
                    noregcarSearchRequestDto.getSitenum(),
                    noregcarSearchRequestDto.getGroupnum(),
                    commonComponent.stringDateToLocalDateTime(noregcarSearchRequestDto.getDatefrom(), "from"),
                    commonComponent.stringDateToLocalDateTime(noregcarSearchRequestDto.getDateto(), "to")
            );
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        if(tnorecognitionList.isEmpty()){
            tnorecognitionList = null;
        }else{
            result = 1;
        }

        resultMap.put("result",result);
        resultMap.put("tnorecognition",tnorecognitionList);

        return resultMap;
    }
}
