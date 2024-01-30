package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tparkunpaied;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TparkunpaiedRepository extends JpaRepository<Tparkunpaied,Long> {
    List<Tparkunpaied> findAllBySitenumAndGroupnumAndOutdatetimeGreaterThanEqualAndOutdatetimeLessThanEqual(Long sitenum, Long groupnum, LocalDateTime from, LocalDateTime to);

    List<Tparkunpaied> findAllBySitenumAndGroupnumAndOutdatetimeGreaterThanEqualAndOutdatetimeLessThanEqualAndDevicenum(Long sitenum, Long groupnum, LocalDateTime from, LocalDateTime to, Long devicenum);

    List<Tparkunpaied> findAllBySitenumAndGroupnumAndOutdatetimeGreaterThanEqualAndOutdatetimeLessThanEqualAndCarnumAndDevicenum(Long sitenum, Long groupnum, LocalDateTime from, LocalDateTime to, String carnum, Long devicenum);

    List<Tparkunpaied> findAllBySitenumAndGroupnumAndOutdatetimeGreaterThanEqualAndOutdatetimeLessThanEqualAndCarnum(Long sitenum, Long groupnum, LocalDateTime from, LocalDateTime to, String carnum);

    Tparkunpaied findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);
}
