package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tdiscountinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tparkingnum;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodinout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface TparkinfoRepository extends JpaRepository<Tparkinfo, Long> {


    void deleteBySitenumAndGroupnumAndCarnumAndOutflag(
            Long sitenum,
            Long groupnum,
            String carnum,
            Long outflag
    );

    List<Tparkinfo> findAllBySitenumAndGroupnumAndCarnumLikeAndOutflag(
            Long sitenum,
            Long groupnum,
            String carnum,
            Long outflag
    );

    List<Tparkinfo> findAllBySitenumAndGroupnumAndOutflag(
            Long sitenum,
            Long groupnum,
            Long outflag
    );

    Tparkinfo findBySitenumAndGroupnumAndIndevicenumAndCarnumAndOutflag(
            Long sitenum,
            Long groupnum,
            Long indevicenum,
            String carnum,
            Long outflag
    );

    List<Tparkinfo> findAllByIndatetimeGreaterThanEqualAndIndatetimeLessThanEqual(
            LocalDateTime datefrom,
            LocalDateTime dateto
    );


    List<Tparkinfo> findAllByOutdatetimeGreaterThanEqualAndOutdatetimeLessThanEqual(
            LocalDateTime datefrom,
            LocalDateTime dateto
    );


    //출차차량정보(totout)
    @Query("SELECT COUNT(e) AS count, SUM(e.parkfee) AS parkfeesum, SUM(e.discountfee) AS discountfeesum FROM Tparkinfo e WHERE (e.indatetime BETWEEN :datefrom AND :dateto)")
    Map<String, Long> countOut(
            @Param("datefrom") LocalDateTime datefrom,
            @Param("dateto")LocalDateTime dateto
    );


    //요금징수별정보(totpaytype)
    @Query("SELECT e.credittype AS credittype, COUNT(e) AS count, SUM(e.parkfee) AS parkfeesum, SUM(e.discountfee) AS discountfeesum FROM Tparkinfo e WHERE e.outdatetime >= :datefrom AND e.outdatetime <= :dateto AND e.parkfee>0 GROUP BY e.credittype")
    List<Map<String,Long>> countPayType(
            @Param("datefrom") LocalDateTime datefrom,
            @Param("dateto")LocalDateTime dateto
    );


    // 할인차량정보(totdiscount)
    // select count(*),sum(parkfee),sum(discountfee) from tparkinfo where outdatetime between a and b and discountfee>0;
    @Query("SELECT COUNT(e) AS count, SUM(e.parkfee) AS parkfeesum, SUM(e.discountfee) AS discountfeesum  FROM Tparkinfo e WHERE e.outdatetime >= :datefrom AND e.outdatetime <= :dateto AND e.discountfee > 0")
    Map<String,Long> countDiscount(
            @Param("datefrom") LocalDateTime datefrom,
            @Param("dateto")LocalDateTime dateto
    );


    //회차차량정보(totgrace)
    //select count(*),sum(parkfee),sum(discountfee) from tparkinfo where outdatetime between a and b and parkfee+discountfee=0;
    @Query("SELECT COUNT(e) AS count ,SUM(e.parkfee) AS parkfeesum, SUM(e.discountfee) AS discountsum FROM Tparkinfo e WHERE e.outdatetime >= :datefrom AND e.outdatetime <= :dateto AND (e.parkfee + e.discountfee) = 0")
    Map<String,Long> countGrace(
            @Param("datefrom") LocalDateTime datefrom,
            @Param("dateto")LocalDateTime dateto
    );


    //차종별세부정보(totcartype)
    //select cartype,count(*),sum(parkfee),sum(discountfee) from tparkinfo where outdatetime between a and b group by cartype;
    @Query("SELECT e.cartype AS cartype, COUNT(e) as count, SUM(e.parkfee) AS parkfeesum, SUM(e.discountfee) AS discountsum FROM Tparkinfo e WHERE e.outdatetime BETWEEN :datefrom AND :dateto GROUP BY e.cartype")
    List<Map<String,Long>> countCarType(
            @Param("datefrom") LocalDateTime datefrom,
            @Param("dateto")LocalDateTime dateto
    );


    //주차별세부정보(totparktype)
    //select parktype,count(*),sum(parkfee),sum(discountfee) from tparkinfo where outdatetime between a and b group by parktype
    @Query("SELECT e.parktype AS parktype, count(e) AS count,SUM(e.parkfee) AS parkfeesum,SUM(e.discountfee) AS discountsum FROM Tparkinfo e WHERE e.outdatetime BETWEEN :datefrom AND :dateto GROUP BY e.parktype")
    List<Map<String,Long>> countParkType(
            @Param("datefrom") LocalDateTime datefrom,
            @Param("dateto")LocalDateTime dateto
    );


    //장치별세부정보(totdevice)
    //select outdevicenum,count(*),sum(parkfee),sum(discountfee) from tparkinfo where outdatetime between a and b group by outdevicenum;
    @Query("SELECT e.outdevicenum AS outdevicenum,count(e) AS count,SUM(e.parkfee) AS parkfeesum,SUM(e.discountfee) AS discountfeesum FROM Tparkinfo e WHERE e.outdatetime BETWEEN :datefrom AND :dateto GROUP BY e.outdevicenum")
    List<Map<String,Long>> countDevice(
            @Param("datefrom") LocalDateTime datefrom,
            @Param("dateto")LocalDateTime dateto
    );


    @Query("SELECT e,ee.deptcode AS deptcode FROM Tparkinfo e JOIN Tdiscountinfo ee ON e.xindex = ee.pindex WHERE e.outflag IN(79,88) AND e.outdatetime BETWEEN :datefrom AND :dateto ")
    List<Object[]> findDeptcode(
            @Param("datefrom") LocalDateTime datefrom,
            @Param("dateto")LocalDateTime dateto
    );

}
