package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tgateinfo;
import com.dwips.parkingcontrol.api.v1.dto.GateinfoRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TgateinfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class TgateinfoServiceImpl implements TgateinfoService{

    private final CommonComponent commonComponent;
    private final TgateinfoRepository tgateinfoRepository;

    @Override
    public HashMap<String, Object> search(GateinfoRequestDto gateinfoRequestDto) {

        Integer result = 0;

        Tgateinfo tgateinfo = tgateinfoRepository.findBySitenumAndGroupnumAndXindex(
                gateinfoRequestDto.getSitenum(),
                gateinfoRequestDto.getGroupnum(),
                gateinfoRequestDto.getTgateinfo().getXindex()
        );

        //tparkconfig 를 어떻게 찾아가지?
        //commonComponent.TcpClientSender("0.0.0.0",port,"gateip-command(192.168.0.140-RL11)");


        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("result",result);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(GateinfoRequestDto gateinfoRequestDto) {
        Integer result = 0;

        Tgateinfo tgateinfo = tgateinfoRepository.findBySitenumAndGroupnumAndGateip(
            gateinfoRequestDto.getSitenum(),
            gateinfoRequestDto.getGroupnum(),
            gateinfoRequestDto.getTgateinfo().getGateip()
        );

        if(tgateinfo == null){
            tgateinfoRepository.save(gateinfoRequestDto.getTgateinfo());
            result = 1;
        }

        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("result",result);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(GateinfoRequestDto gateinfoRequestDto) {
        Integer result = 0;

        Tgateinfo tgateinfo = tgateinfoRepository.findBySitenumAndGroupnumAndXindex(
                gateinfoRequestDto.getSitenum(),
                gateinfoRequestDto.getGroupnum(),
                gateinfoRequestDto.getTgateinfo().getXindex()
        );

        if(tgateinfo != null){
            tgateinfoRepository.save(gateinfoRequestDto.getTgateinfo());
            result = 1;
        }

        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("result",result);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(GateinfoRequestDto gateinfoRequestDto) {
        Integer result = 0;

        Tgateinfo tgateinfo = tgateinfoRepository.findBySitenumAndGroupnumAndXindex(
                gateinfoRequestDto.getSitenum(),
                gateinfoRequestDto.getGroupnum(),
                gateinfoRequestDto.getXindex()
        );

        if(tgateinfo!=null){
            tgateinfoRepository.delete(tgateinfo);
        }

        HashMap<String,Object> resultMap = new HashMap<>();
        resultMap.put("result",result);

        return resultMap;
    }
}
