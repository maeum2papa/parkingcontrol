package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tbcardinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tdiscountinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodaccount;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import com.dwips.parkingcontrol.api.v1.dto.PeriodmemberExtendRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.PeriodmemberRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TbcardinfoRepository;
import com.dwips.parkingcontrol.api.v1.repository.TperiodaccountResitory;
import com.dwips.parkingcontrol.api.v1.repository.TperiodmemberCustomRespository;
import com.dwips.parkingcontrol.api.v1.repository.TperiodmemberRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class PeriodmemberServiceImpl implements PeriodmemberService{

    private final CommonComponent commonComponent;

    private final TperiodmemberRespository tperiodmemberRespository;
    private final TperiodmemberCustomRespository tperiodmemberCustomRespository;
    private final TbcardinfoRepository tbcardinfoRepository;
    private final TperiodaccountResitory tperiodaccountResitory;

    /*
    차량번호,시작일자 및 종료 일자 가 없으면 전체 차량
    예) 차량번호는 있고 시작일자 및 종료일자 가 없으면 전체기간
    차량번호는 없고 시작일 과 종료일 있으면 기간에 해당하는 모든 정보
    모두 없으면 전체 차량
    */
    @Override
    public HashMap<String, Object> search(PeriodmemberRequestDto periodmemberRequestDto) {

        Integer result = 0;

        String carnum = (periodmemberRequestDto.getCarnum()!=null)?periodmemberRequestDto.getCarnum():null;
        LocalDateTime datefrom  = null;
        LocalDateTime dateto  = null;

        if(periodmemberRequestDto.getDatefrom()!=null){
            datefrom = commonComponent.stringDateToLocalDateTime(periodmemberRequestDto.getDatefrom(),"from");
        }

        if(periodmemberRequestDto.getDateto()!=null){
            dateto = commonComponent.stringDateToLocalDateTime(periodmemberRequestDto.getDateto(),"to");
        }

        List<Tperiodmember> tperiodmemberList = new ArrayList<>();

        if(carnum == null && datefrom == null && dateto == null){
            log.info("등록차량조회 전체차량");
            //전체차량
            tperiodmemberList = tperiodmemberCustomRespository.customFindAll(
                    periodmemberRequestDto.getSitenum(),
                    periodmemberRequestDto.getGroupnum(),
                    periodmemberRequestDto.getCompany(),
                    periodmemberRequestDto.getDepartment(),
                    periodmemberRequestDto.getName()
            );

        }else if(carnum != null && datefrom == null && dateto == null){
            log.info("등록차량조회 전체기간");
            //전체기간
            tperiodmemberList = tperiodmemberCustomRespository.customFindAllByCarnum(
                    periodmemberRequestDto.getSitenum(),
                    periodmemberRequestDto.getGroupnum(),
                    periodmemberRequestDto.getCompany(),
                    periodmemberRequestDto.getDepartment(),
                    periodmemberRequestDto.getName(),
                    carnum
            );
        }else if(carnum == null && datefrom != null && dateto != null){
            log.info("등록차량조회 기간 내 전체차량");
            //기간내 전체 차량
            tperiodmemberList = tperiodmemberCustomRespository.customFindAllByRegdate(
                    periodmemberRequestDto.getSitenum(),
                    periodmemberRequestDto.getGroupnum(),
                    datefrom,
                    dateto,
                    periodmemberRequestDto.getCompany(),
                    periodmemberRequestDto.getDepartment(),
                    periodmemberRequestDto.getName()
            );
        }else if(carnum != null && datefrom != null && dateto != null){
            log.info("등록차량조회 기간 내 특정차량");
            tperiodmemberList = tperiodmemberCustomRespository.customFindAllByRegdateAndCarnum(
                    periodmemberRequestDto.getSitenum(),
                    periodmemberRequestDto.getGroupnum(),
                    datefrom,
                    dateto,
                    periodmemberRequestDto.getCompany(),
                    periodmemberRequestDto.getDepartment(),
                    periodmemberRequestDto.getName(),
                    carnum
            );
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        if(tperiodmemberList.isEmpty()){
            tperiodmemberList = null;
        }else{
            result = 1;
        }

        resultMap.put("result",result);
        resultMap.put("tperiodmember",tperiodmemberList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(PeriodmemberRequestDto periodmemberRequestDto) {

        Integer result = 0;
        Tperiodmember tperiodmember = null;

        if(periodmemberRequestDto.getXindex() != null){
            tperiodmember = tperiodmemberRespository.findBySitenumAndGroupnumAndXindex(
                    periodmemberRequestDto.getSitenum(),
                    periodmemberRequestDto.getGroupnum(),
                    periodmemberRequestDto.getXindex()
            );
        }else if(periodmemberRequestDto.getCarnum() != null){
            tperiodmember = tperiodmemberRespository.findBySitenumAndGroupnumAndCarnum(
                    periodmemberRequestDto.getSitenum(),
                    periodmemberRequestDto.getGroupnum(),
                    periodmemberRequestDto.getCarnum()
            );
        }

        if(tperiodmember != null){
            tperiodmemberRespository.delete(tperiodmember);
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> extend(PeriodmemberExtendRequestDto periodmemberExtendRequestDto) {

        Integer result = 0;

        Tperiodmember tperiodmember = tperiodmemberRespository.findBySitenumAndGroupnumAndCarnum(
                periodmemberExtendRequestDto.getSitenum(),
                periodmemberExtendRequestDto.getGroupnum(),
                periodmemberExtendRequestDto.getCarnum()
        );

        Tperiodmember requestTperiodmember = periodmemberExtendRequestDto.getTperiodmember();

        if(tperiodmember == null){

            //insert
            Tperiodmember build = Tperiodmember.builder()
                    .sitenum(requestTperiodmember.getSitenum())
                    .groupnum(requestTperiodmember.getGroupnum())
                    .devicenum(requestTperiodmember.getDevicenum())
                    .cardno(requestTperiodmember.getCardno())
                    .serialno(requestTperiodmember.getSerialno())
                    .periodtype(requestTperiodmember.getPeriodtype())
                    .carnum(requestTperiodmember.getCarnum())
                    .cartype(requestTperiodmember.getCartype())
                    .name(requestTperiodmember.getName())
                    .tel(requestTperiodmember.getTel())
                    .groupcode(requestTperiodmember.getGroupcode())
                    .company(requestTperiodmember.getCompany())
                    .depart(requestTperiodmember.getDepart())
                    .addr(requestTperiodmember.getAddr())
                    .parktype(requestTperiodmember.getParktype())
                    .regdate(requestTperiodmember.getRegdate())
                    .startdate(requestTperiodmember.getStartdate())
                    .enddate(requestTperiodmember.getEnddate())
                    .parktimecode(requestTperiodmember.getParktimecode())
                    .parktimetime(requestTperiodmember.getParktimetime())
                    .parkprice(requestTperiodmember.getParkprice())
                    .parkarea(requestTperiodmember.getParkarea())
                    .parklevel(requestTperiodmember.getParklevel())
                    .parkvalidday(requestTperiodmember.getParkvalidday())
                    .useflag(requestTperiodmember.getUseflag())
                    .serviceday(requestTperiodmember.getServiceday())
                    .diskey(requestTperiodmember.getDiskey())
                    .mid(requestTperiodmember.getMid())
                    .mname(requestTperiodmember.getMname())
                    .paytype(requestTperiodmember.getPaytype())
                    .outflag(requestTperiodmember.getOutflag())
                    .infodiskey(requestTperiodmember.getInfodiskey())
                    .useyn(requestTperiodmember.getUseyn())
                    .build();

            tperiodmember= tperiodmemberRespository.save(build);


        }else{

            tperiodmember.setDevicenum(requestTperiodmember.getDevicenum());
            tperiodmember.setCardno(requestTperiodmember.getCardno());
            tperiodmember.setSerialno(requestTperiodmember.getSerialno());
            tperiodmember.setPeriodtype(requestTperiodmember.getPeriodtype());
            tperiodmember.setCarnum(requestTperiodmember.getCarnum());
            tperiodmember.setCartype(requestTperiodmember.getCartype());
            tperiodmember.setName(requestTperiodmember.getName());
            tperiodmember.setTel(requestTperiodmember.getTel());
            tperiodmember.setGroupcode(requestTperiodmember.getGroupcode());
            tperiodmember.setCompany(requestTperiodmember.getCompany());
            tperiodmember.setDepart(requestTperiodmember.getDepart());
            tperiodmember.setAddr(requestTperiodmember.getAddr());
            tperiodmember.setParktype(requestTperiodmember.getParktype());
            tperiodmember.setStartdate(requestTperiodmember.getStartdate());
            tperiodmember.setEnddate(requestTperiodmember.getEnddate());
            tperiodmember.setParktimecode(requestTperiodmember.getParktimecode());
            tperiodmember.setParktimetime(requestTperiodmember.getParktimetime());
            tperiodmember.setParkprice(requestTperiodmember.getParkprice());
            tperiodmember.setParkarea(requestTperiodmember.getParkarea());
            tperiodmember.setParklevel(requestTperiodmember.getParklevel());
            tperiodmember.setParkvalidday(requestTperiodmember.getParkvalidday());
            tperiodmember.setUseflag(requestTperiodmember.getUseflag());
            tperiodmember.setServiceday(requestTperiodmember.getServiceday());
            tperiodmember.setDiskey(requestTperiodmember.getDiskey());
            tperiodmember.setMid(requestTperiodmember.getMid());
            tperiodmember.setMname(requestTperiodmember.getMname());
            tperiodmember.setPaytype(requestTperiodmember.getPaytype());
            tperiodmember.setOutflag(requestTperiodmember.getOutflag());
            tperiodmember.setInfodiskey(requestTperiodmember.getInfodiskey());
            tperiodmember.setUseyn(requestTperiodmember.getUseyn());
        }

        if(tperiodmember!=null){
            result = 1;
        }

        Tbcardinfo requestDtoTbcardinfo = periodmemberExtendRequestDto.getTbcardinfo();

        if(requestDtoTbcardinfo!=null){
            tbcardinfoRepository.save(requestDtoTbcardinfo);
        }

        Tperiodaccount requestDtoTperiodaccount = periodmemberExtendRequestDto.getTperiodaccount();

        if(requestDtoTperiodaccount!=null){
            tperiodaccountResitory.save(requestDtoTperiodaccount);
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tperiodmember",tperiodmember);

        return resultMap;
    }
}
