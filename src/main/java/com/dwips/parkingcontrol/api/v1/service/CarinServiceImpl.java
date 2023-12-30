package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.*;
import com.dwips.parkingcontrol.api.v1.dto.CarinRequestDto;
import com.dwips.parkingcontrol.api.v1.dto.CarinResponseDto;
import com.dwips.parkingcontrol.api.v1.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CarinServiceImpl implements CarinService{

    private final CommonComponent commonComponent;

    private final TparkinfoRepository tparkinfoRepository;
    private final TperiodinoutRespository tperiodinoutRespository;

    private final TperiodmemberRespository tperiodmemberRespository;
    private final TperiodparktimeRepository tperiodparktimeRepository;


    @Override
    public CarinResponseDto saveCar(CarinRequestDto carinRequestDto) {

        //등록차량 여부 상세 점검 결과
        Boolean tperiodmemberFlag = true;
        LocalDateTime today = LocalDateTime.now();

        Integer result = 0;

        Integer day = today.getDayOfMonth();
        Integer lastDigit = day % 10; // 날짜 끝자리 수, 15일이면 5

        DayOfWeek dayOfWeek = today.getDayOfWeek(); //오늘 요일

        String carnum = carinRequestDto.getCarnum();
        Integer carnumLast = (int) carnum.charAt(carnum.length() - 1);

        //등록차량 정보 검색
        Tperiodmember tperiodmember = tperiodmemberRespository.findBySitenumAndGroupnumAndCarnumAndUseyn(
                carinRequestDto.getSitenum(),
                carinRequestDto.getGroupnum(),
                carinRequestDto.getCarnum(),
                "y");

        //등록차량 상세 점검
        if (tperiodmember != null) {

            //주차가능유무
            if (tperiodmember.getUseflag() == 0 && tperiodmemberFlag) {
                tperiodmemberFlag = false;
            }

            //게시일 체크
            if (tperiodmember.getStartdate() != null && tperiodmemberFlag) {

                LocalDateTime startdate = commonComponent.stringToLocalDateTime(tperiodmember.getStartdate() + " 00:00:00");

                // !(startdate <= LocalDateTime.now())
                if (!(!startdate.isAfter(today))) {
                    tperiodmemberFlag = false;
                }
            }


            //종료일 체크
            if (tperiodmember.getEnddate() != null && tperiodmemberFlag) {

                LocalDateTime enddate = commonComponent.stringToLocalDateTime(tperiodmember.getEnddate() + " 23:59:59");

                // !(enddate >= LocalDateTime.now())
                if (!(!enddate.isBefore(today))) {
                    tperiodmemberFlag = false;
                }
            }

            //홀짝제 체크 : 번호판 끝자리가 날짜와 일치하면 운행
            if (tperiodmember.getParklevel() == 1 && tperiodmemberFlag) {
                if (carnumLast != lastDigit) {
//                    throw new RuntimeException("홀짝제로 입차 거부");
                    tperiodmemberFlag = false;
                }
            }

            //10부제 체크 : 번호판 끝자리가 날짜와 같으면 쉬는 것
            if (tperiodmember.getParklevel() == 2 && tperiodmemberFlag) {
                if (carnumLast == lastDigit) {
//                    throw new RuntimeException("10부제로 입차 거부");
                    tperiodmemberFlag = false;
                }
            }

            //요일제 체크 : 요일에 운행하지 않는 것
            if (tperiodmember.getParklevel() == 3 && tperiodmemberFlag) {
                char[] charArray = tperiodmember.getParkvalidday().toCharArray();

                //월
                if (DayOfWeek.MONDAY == dayOfWeek && charArray[0] == '0' && tperiodmemberFlag) {
                    tperiodmemberFlag = false;
                }

                //화
                if (DayOfWeek.MONDAY == dayOfWeek && charArray[1] == '0' && tperiodmemberFlag) {
                    tperiodmemberFlag = false;
                }

                //수
                if (DayOfWeek.MONDAY == dayOfWeek && charArray[2] == '0' && tperiodmemberFlag) {
                    tperiodmemberFlag = false;
                }

                //목
                if (DayOfWeek.MONDAY == dayOfWeek && charArray[3] == '0' && tperiodmemberFlag) {
                    tperiodmemberFlag = false;
                }

                //금
                if (DayOfWeek.MONDAY == dayOfWeek && charArray[4] == '0' && tperiodmemberFlag) {
                    tperiodmemberFlag = false;
                }

                //토
                if (DayOfWeek.SATURDAY == dayOfWeek && charArray[5] == '0' && tperiodmemberFlag) {
                    tperiodmemberFlag = false;
                }

                //일
                if (DayOfWeek.MONDAY == dayOfWeek && charArray[6] == '0' && tperiodmemberFlag) {
                    tperiodmemberFlag = false;
                }

            }

            //주차시간제한 체크
            if (tperiodmember.getParktimecode() != null && tperiodmemberFlag) {
                Tperiodparktime tperiodparktime = tperiodparktimeRepository.findBySitenumAndGroupnumAndCode(
                        tperiodmember.getSitenum(),
                        tperiodmember.getGroupnum(),
                        tperiodmember.getParktimecode());

                String stringStartDataTime = String.valueOf(today.getYear())
                        + "-" +
                        String.format("%02d", today.getMonthValue())
                        + "-" +
                        String.format("%02d", today.getDayOfMonth())
                        + " " +
                        String.format("%02d", tperiodparktime.getStarthour())
                        + ":" +
                        String.format("%02d", tperiodparktime.getStartmin())
                        + ":00";

                LocalDateTime startDateTime = commonComponent.stringToLocalDateTime(stringStartDataTime);

                // !(!(startDateTime <= LocalDateTime.now())
                if (!(!startDateTime.isAfter(today))) {
                    tperiodmemberFlag = false;
                }

                String stringEndtDataTime = String.valueOf(today.getYear())
                        + "-" +
                        String.format("%02d", today.getMonthValue())
                        + "-" +
                        String.format("%02d", today.getDayOfMonth())
                        + " " +
                        String.format("%02d", tperiodparktime.getEndhour())
                        + ":" +
                        String.format("%02d", tperiodparktime.getEndmin())
                        + ":59";

                LocalDateTime endDateTime = commonComponent.stringToLocalDateTime(stringEndtDataTime);

                // !(endDateTime >= LocalDateTime.now())
                if (!(!endDateTime.isBefore(today))) {
                    tperiodmemberFlag = false;
                }

            }

        } else {
            tperiodmemberFlag = false;
        }


        Tperiodinout tperiodinoutBuild = null;
        Tparkinfo tparkinfoBuild = null;

        if (tperiodmemberFlag) {
            //등록 차량일 경우

            //옵션이 중복제거이면
            if(carinRequestDto.getOption() == 1){
                tperiodinoutRespository.deleteBySitenumAndGroupnumAndCarnumAndOutflag(
                        carinRequestDto.getSitenum(),
                        carinRequestDto.getGroupnum(),
                        carinRequestDto.getCarnum(),
                        0L
                );
            }

            tperiodinoutBuild = Tperiodinout.builder()
                    .sitenum(carinRequestDto.getSitenum())
                    .groupnum(carinRequestDto.getGroupnum())
                    .carnum(carinRequestDto.getCarnum())
                    .cardno(tperiodmember.getCardno())
                    .cartype(tperiodmember.getCartype())
                    .name(tperiodmember.getName())
                    .indevicenum(carinRequestDto.getDevicenum())
                    .indatetime(commonComponent.stringToLocalDateTime(carinRequestDto.getIndatetime()))
                    .inimage(carinRequestDto.getImage())
                    .outflag(0L)
                    .build();

            tperiodinoutRespository.save(tperiodinoutBuild);

            result = 1;

        } else {
            //일반차량일 경우


            //옵션이 중복제거이면
            if(carinRequestDto.getOption() == 1){
                tparkinfoRepository.deleteBySitenumAndGroupnumAndCarnumAndOutflag(
                        carinRequestDto.getSitenum(),
                        carinRequestDto.getGroupnum(),
                        carinRequestDto.getCarnum(),
                        0L
                );
            }

            tparkinfoBuild = Tparkinfo.builder()
                    .sitenum(carinRequestDto.getSitenum())
                    .groupnum(carinRequestDto.getGroupnum())
                    .cartype(carinRequestDto.getCartype())
                    .parktype(0L)
                    .carnum(carinRequestDto.getCarnum())
                    .indevicenum(carinRequestDto.getDevicenum())
                    .indatetime(commonComponent.stringToLocalDateTime(carinRequestDto.getIndatetime()))
                    .inimage(carinRequestDto.getImage())
                    .outflag(0L)
                    .build();

            tparkinfoRepository.save(tparkinfoBuild);

            result = 2;
        }


        return CarinResponseDto.builder()
                .result(result)
                .tperiodmember(tperiodmember)
                .tparkinfo(tparkinfoBuild)
                .build();

    }

}
