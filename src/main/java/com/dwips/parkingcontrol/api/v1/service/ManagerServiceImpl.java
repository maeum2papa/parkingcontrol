package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tmanager;
import com.dwips.parkingcontrol.api.v1.dto.ManagerRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TmanagerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ManagerServiceImpl implements ManagerService{

    private final CommonComponent commonComponent;

    private final TmanagerRepository tmanagerRepository;

    //id 및 name 이 없을 경우 전제 데이터,id,name 둘중 하나만 있을수 있음
    @Override
    public HashMap<String, Object> search(ManagerRequestDto managerRequestDto) {

        Integer result = 0;
        List<Tmanager> tmanagerList = new ArrayList<>();

        if(managerRequestDto.getName() == null && managerRequestDto.getId() == null){
            tmanagerList = tmanagerRepository.findAllBySitenumAndGroupnum(
                    managerRequestDto.getSitenum(),
                    managerRequestDto.getGroupnum()
            );
        }else if(managerRequestDto.getName() == null && managerRequestDto.getId() != null){
            tmanagerList = tmanagerRepository.findAllBySitenumAndGroupnumAndName(
                    managerRequestDto.getSitenum(),
                    managerRequestDto.getGroupnum(),
                    managerRequestDto.getName()
            );
        }else if(managerRequestDto.getName() != null && managerRequestDto.getId() == null){
            tmanagerList = tmanagerRepository.findAllBySitenumAndGroupnumAndMid(
                    managerRequestDto.getSitenum(),
                    managerRequestDto.getGroupnum(),
                    managerRequestDto.getId()
            );
        }else{
            tmanagerList = tmanagerRepository.findAllBySitenumAndGroupnumAndMidAndName(
                    managerRequestDto.getSitenum(),
                    managerRequestDto.getGroupnum(),
                    managerRequestDto.getId(),
                    managerRequestDto.getName()
            );
        }

        if(managerRequestDto.getSitenum() == null && managerRequestDto.getGroupnum() == null){
            tmanagerList = tmanagerRepository.findAll();
        }

        if(!tmanagerList.isEmpty()){
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tmanager",tmanagerList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(ManagerRequestDto managerRequestDto) {
        Integer result = 0;
        List<Tmanager> tmanagerList = new ArrayList<>();

        if(managerRequestDto.getTmanager()!=null){

            if(managerRequestDto.getTmanager().getSitenum() != null && managerRequestDto.getTmanager().getSitenum() != 0L
                    && managerRequestDto.getTmanager().getGroupnum() != null && managerRequestDto.getTmanager().getGroupnum() != 0L
                    && managerRequestDto.getTmanager().getName() != null && !managerRequestDto.getTmanager().getName().isEmpty()
                    && managerRequestDto.getTmanager().getMid() != null && !managerRequestDto.getTmanager().getMid().isEmpty()
                    && managerRequestDto.getTmanager().getMpw() != null && !managerRequestDto.getTmanager().getMpw().isEmpty()
                    && managerRequestDto.getTmanager().getTel() != null && !managerRequestDto.getTmanager().getTel().isEmpty()
                    && managerRequestDto.getTmanager().getGrade() != null && managerRequestDto.getTmanager().getGrade() != 0L
            ){

                Long tmanagerCount = tmanagerRepository.countByMid(managerRequestDto.getTmanager().getMid());

                if(tmanagerCount == 0) {
                    tmanagerList.add(tmanagerRepository.save(managerRequestDto.getTmanager()));
                    result = 1;
                }
            }
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tmanager",tmanagerList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(ManagerRequestDto managerRequestDto) {
        Integer result = 0;
        List<Tmanager> tmanagerList = new ArrayList<>();

        if(managerRequestDto.getTmanager().getXindex() != null && managerRequestDto.getTmanager().getXindex() != 0L
                && managerRequestDto.getTmanager().getSitenum() != null && managerRequestDto.getTmanager().getSitenum() != 0L
                && managerRequestDto.getTmanager().getGroupnum() != null && managerRequestDto.getTmanager().getGroupnum() != 0L
                && managerRequestDto.getTmanager().getName() != null && !managerRequestDto.getTmanager().getName().isEmpty()
                && managerRequestDto.getTmanager().getMid() != null && !managerRequestDto.getTmanager().getMid().isEmpty()
                && managerRequestDto.getTmanager().getMpw() != null && !managerRequestDto.getTmanager().getMpw().isEmpty()
                && managerRequestDto.getTmanager().getTel() != null && !managerRequestDto.getTmanager().getTel().isEmpty()
                && managerRequestDto.getTmanager().getGrade() != null && managerRequestDto.getTmanager().getGrade() != 0L
        ) {
            Tmanager tmanager = tmanagerRepository.findBySitenumAndGroupnumAndXindex(
                    managerRequestDto.getSitenum(),
                    managerRequestDto.getGroupnum(),
                    managerRequestDto.getTmanager().getXindex()
            );

            if(tmanager!=null){
                tmanagerList.add(tmanagerRepository.save(managerRequestDto.getTmanager()));
                result = 1;
            }
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tmanager",tmanagerList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(ManagerRequestDto managerRequestDto) {
        Integer result = 0;

        Tmanager tmanager = tmanagerRepository.findBySitenumAndGroupnumAndXindex(
                managerRequestDto.getSitenum(),
                managerRequestDto.getGroupnum(),
                managerRequestDto.getXindex()
        );

        if(tmanager!=null){
            tmanagerRepository.delete(tmanager);
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }
}
