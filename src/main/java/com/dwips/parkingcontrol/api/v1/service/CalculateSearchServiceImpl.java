package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tbcardinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tdiscountinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.domain.Twelfare;
import com.dwips.parkingcontrol.api.v1.dto.CalculateSearchRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalculateSearchServiceImpl implements CalculateSearchService{

    private final CommonComponent commonComponent;

    private final TparkinfoRepository tparkinfoRepository;
    private final TbcardinfoRepository tbcardinfoRepository;
    private final TparkinfoCustomRepository tparkinfoCustomRepository;
    private final TdiscountinfoRepository tdiscountinfoRepository;
    private final TwelfareRepository twelfareRepository;

    @Override
    public HashMap<String,Object> defaultSearch(CalculateSearchRequestDto calculateSearchRequestDto) {

        Integer result = 0;
        Long qtype = calculateSearchRequestDto.getQtype();

        List<Tparkinfo> tparkinfoList = new ArrayList<>();
        HashMap<Long,List<Tbcardinfo>> tbcardinfoList = new HashMap<>();
        HashMap<Long,List<Tdiscountinfo>> tdiscountinfoList = new HashMap<>();
        HashMap<Long,List<Twelfare>> twelfareList = new HashMap<>();

        tparkinfoList = tparkinfoCustomRepository.customFindAll(calculateSearchRequestDto);


        if(tparkinfoList.size() > 0){

            result = 1;

            for(Tparkinfo tparkinfo : tparkinfoList){


                //tdiscountinfo -- deptcode
                List<Tdiscountinfo> tdiscountinfos = new ArrayList<>();
                if(calculateSearchRequestDto.getDeptcode() == null) {
                    tdiscountinfos = tdiscountinfoRepository.findAllByPindex(tparkinfo.getXindex());
                }else{
                    tdiscountinfos = tdiscountinfoRepository.findAllByPindexAndDeptcode(tparkinfo.getXindex(),calculateSearchRequestDto.getDeptcode());
                }
                if(tdiscountinfos.size() > 0) tdiscountinfoList.put(tparkinfo.getXindex(),tdiscountinfos);


                //tbcardinfo
                if(qtype <= 1) {
                    List<Tbcardinfo> tbcardinfos = tbcardinfoRepository.findAllByPindex(tparkinfo.getXindex());
                    if (tbcardinfos.size() > 0) tbcardinfoList.put(tparkinfo.getXindex(),tbcardinfos);
                }


                //twelfare
                if(qtype == 0){
                    List<Twelfare> twelfares = twelfareRepository.findAllBySitenumAndGroupnumAndCarnum(
                            tparkinfo.getSitenum(),
                            tparkinfo.getGroupnum(),
                            tparkinfo.getCarnum()
                    );
                    if(twelfares.size() > 0) twelfareList.put(tparkinfo.getXindex(), twelfares);
                }

            }
        }


        if(tparkinfoList.isEmpty()) tparkinfoList = null;
        if(tbcardinfoList.isEmpty()) tbcardinfoList = null;
        if(tdiscountinfoList.isEmpty()) tdiscountinfoList = null;
        if(twelfareList.isEmpty()) twelfareList = null;

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tparkinfo",tparkinfoList);
        resultMap.put("tbcardinfo",tbcardinfoList);
        resultMap.put("tdiscountinfo",tdiscountinfoList);
        resultMap.put("welfare",twelfareList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> summarySearch(CalculateSearchRequestDto calculateSearchRequestDto) {

        HashMap summary = summary(
                commonComponent.stringDateToLocalDateTime(calculateSearchRequestDto.getDatefrom(),"from"),
                commonComponent.stringDateToLocalDateTime(calculateSearchRequestDto.getDateto(),"to")
        );

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",0);
        resultMap.put("totin",(long) summary.getOrDefault("totin",null));
        resultMap.put("totout",(Map<String, Long>) summary.getOrDefault("totout",null));
        resultMap.put("totpaytype",(List<Map<String, Long>>) summary.getOrDefault("totpaytype",null));
        resultMap.put("totdiscount",(Map<String, Long>) summary.getOrDefault("totdiscount",null));
        resultMap.put("totgrace",(Map<String, Long>) summary.getOrDefault("totgrace",null));
        resultMap.put("totcartype",(List<Map<String, Long>>) summary.getOrDefault("totcartype",null));
        resultMap.put("totparktype",(List<Map<String, Long>>) summary.getOrDefault("totparktype",null));
        resultMap.put("totdevice",(List<Map<String, Long>>) summary.getOrDefault("totdevice",null));
        resultMap.put("totdiscode",(List<Map<String, Long>>) summary.getOrDefault("totdiscode",null));

        return resultMap;
    }

    @Override
    public HashMap<String, Object> summaryDaysSearch(CalculateSearchRequestDto calculateSearchRequestDto) {

        HashMap<String, Long> totinList = new HashMap<>();
        HashMap<String, Map<String,Long>> totoutList = new HashMap<>();
        HashMap<String, List<Map<String, Long>>> totpaytypeList = new HashMap<>();
        HashMap<String, Map<String,Long>> totdiscountList = new HashMap<>();
        HashMap<String, Map<String,Long>> totgraceList = new HashMap<>();
        HashMap<String, List<Map<String, Long>>> totcartypeList = new HashMap<>();
        HashMap<String, List<Map<String, Long>>> totparktypeList = new HashMap<>();
        HashMap<String, List<Map<String, Long>>> totdeviceList = new HashMap<>();
        HashMap<String, List<Map<String, Long>>> totdiscodeList = new HashMap<>();

        LocalDate datefrom = commonComponent.stringDateToLocalDate(
                calculateSearchRequestDto.getDatefrom().substring(
                        0,
                        Math.min(
                                calculateSearchRequestDto.getDatefrom().length(),
                                10
                        )
                )
        );

        LocalDate dateto = commonComponent.stringDateToLocalDate(
                calculateSearchRequestDto.getDateto().substring(
                        0,
                        Math.min(
                                calculateSearchRequestDto.getDateto().length(),
                                10
                        )
                )
        );

        LocalDate dateupdate = datefrom;
        while(!dateto.equals(dateupdate.plusDays(1))){

            LocalDateTime datetimefrom = commonComponent.stringDateTimeToLocalDateTime(
                    commonComponent.localDateToStringDate(dateupdate)+" 00:00:00"
            );

            LocalDateTime datetimeto = commonComponent.stringDateTimeToLocalDateTime(
                    commonComponent.localDateToStringDate(dateupdate)+" 23:59:59"
            );

            HashMap<String, Object> summary = summary(datetimefrom, datetimeto);


            totinList.put(commonComponent.localDateToStringDate(dateupdate),(Long) summary.get("totin"));

            totoutList.put(commonComponent.localDateToStringDate(dateupdate),(Map<String, Long>) summary.get("totout"));

            totpaytypeList.put(commonComponent.localDateToStringDate(dateupdate),(List<Map<String, Long>>) summary.get("totpaytype"));

            totdiscountList.put(commonComponent.localDateToStringDate(dateupdate),(Map<String, Long>) summary.get("totdiscount"));

            totgraceList.put(commonComponent.localDateToStringDate(dateupdate),(Map<String, Long>) summary.get("totgrace"));

            totcartypeList.put(commonComponent.localDateToStringDate(dateupdate),(List<Map<String, Long>>) summary.get("totcartype"));

            totparktypeList.put(commonComponent.localDateToStringDate(dateupdate),(List<Map<String, Long>>) summary.get("totparktype"));

            totdeviceList.put(commonComponent.localDateToStringDate(dateupdate),(List<Map<String, Long>>) summary.get("totdevice"));

            totdiscodeList.put(commonComponent.localDateToStringDate(dateupdate),(List<Map<String, Long>>) summary.get("totdiscode"));

            dateupdate = dateupdate.plusDays(1);
        }


        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",0);
        resultMap.put("totin",totinList);
        resultMap.put("totout",totoutList);
        resultMap.put("totpaytype",totpaytypeList);
        resultMap.put("totdiscount",totdiscountList);
        resultMap.put("totgrace",totgraceList);
        resultMap.put("totcartype",totcartypeList);
        resultMap.put("totparktype",totparktypeList);
        resultMap.put("totdevice",totdeviceList);
        resultMap.put("totdiscode",totdiscodeList);

        return resultMap;

    }

    @Override
    public Map<String, Object> deptcodesSearch(CalculateSearchRequestDto calculateSearchRequestDto) {


        List<Object[]> deptcodeTparkinfo = tparkinfoRepository.findDeptcode(
                commonComponent.stringDateToLocalDateTime(calculateSearchRequestDto.getDatefrom(),"from"),
                commonComponent.stringDateToLocalDateTime(calculateSearchRequestDto.getDateto(),"to")
        );

        /*
        Map<Long,List<Tparkinfo>> resultList = new HashMap<>();

        for (Object[] map : deptcodeTparkinfo) {
            Tparkinfo tparkinfo = (Tparkinfo) map[0];
            Long deptcode = (Long) map[1];

            if(resultList.get(deptcode) == null){
                List<Tparkinfo> tparkinfos = new ArrayList<>();
                tparkinfos.add(tparkinfo);
                resultList.put(deptcode,tparkinfos);
            }else{
                List<Tparkinfo> tparkinfos = resultList.get(deptcode);
                tparkinfos.add(tparkinfo);
            }
        }
         */

        Map<Long, List<Tparkinfo>> resultList = deptcodeTparkinfo.stream()
                .collect(Collectors.groupingBy(
                        map -> (Long) map[1],
                        Collectors.mapping(map -> (Tparkinfo) map[0], Collectors.toList())
                ));

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",1);
        resultMap.put("tparkinfo",resultList);

        return resultMap;
    }

    @Override
    public Map<String, Object> midsSearch(CalculateSearchRequestDto calculateSearchRequestDto) {
        //tparkinfo.mid

        List<Tparkinfo> midTparkinfo = tparkinfoRepository.findAllByOutdatetimeGreaterThanEqualAndOutdatetimeLessThanEqual(
                commonComponent.stringDateToLocalDateTime(calculateSearchRequestDto.getDatefrom(),"from"),
                commonComponent.stringDateToLocalDateTime(calculateSearchRequestDto.getDateto(),"to")
        );

        Map<String,List<Tparkinfo>> resultList = new HashMap<>();

        for(Tparkinfo tparkinfo : midTparkinfo){
            String mid = tparkinfo.getMid();
            System.out.println("mid = " + mid);

            if(resultList.get(mid) == null){
                List<Tparkinfo> tparkinfos = new ArrayList<>();
                tparkinfos.add(tparkinfo);
                resultList.put(mid,tparkinfos);
            }else{
                List<Tparkinfo> tparkinfos = resultList.get(mid);
                tparkinfos.add(tparkinfo);
            }
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",1);
        resultMap.put("tparkinfo",resultList);

        return resultMap;
    }

    //요약 공통
    public HashMap<String,Object> summary(LocalDateTime datefrom, LocalDateTime dateto){

        HashMap<String,Object> resultMap = new HashMap<>();

        resultMap.put("result",0);
        resultMap.put("totin",(long) tparkinfoRepository.findAllByIndatetimeGreaterThanEqualAndIndatetimeLessThanEqual(
                datefrom,
                dateto
        ).size());
        resultMap.put("totout",tparkinfoRepository.countOut(datefrom, dateto));

        List<Map<String, Long>> tparkinfoMap = tparkinfoRepository.countPayType(datefrom, dateto);
        if(tparkinfoMap.isEmpty()) tparkinfoMap = null;
        resultMap.put("totpaytype",tparkinfoMap);

        resultMap.put("totdiscount",tparkinfoRepository.countDiscount(datefrom, dateto));

        resultMap.put("totgrace",tparkinfoRepository.countGrace(datefrom, dateto));

        List<Map<String, Long>> totcartypeMap = tparkinfoRepository.countCarType(datefrom, dateto);
        if(totcartypeMap.isEmpty()) totcartypeMap = null;
        resultMap.put("totcartype",totcartypeMap);

        List<Map<String, Long>> totparktypeMap = tparkinfoRepository.countParkType(datefrom, dateto);
        if(totparktypeMap.isEmpty()) totparktypeMap = null;
        resultMap.put("totparktype",totparktypeMap);

        List<Map<String, Long>> totdeviceMap = tparkinfoRepository.countDevice(datefrom, dateto);
        if(totdeviceMap.isEmpty()) totdeviceMap = null;
        resultMap.put("totdevice",totdeviceMap);

        List<Map<String, Long>> totdiscodeMap = tdiscountinfoRepository.countDiscode(datefrom, dateto);
        if(totdiscodeMap.isEmpty()) totdiscodeMap = null;
        resultMap.put("totdiscode",totdiscodeMap);

        return resultMap;

    }
}
