package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tbcardinfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TbcardinfoRepository extends JpaRepository<Tbcardinfo, Long> {

    List<Tbcardinfo> findAllByPindex(Long xindex);

    List<Tbcardinfo> findAllBySitenumAndGroupnumAndAcceptnum(Long sitenum, Long groupnum, String acceptnum);

    List<Tbcardinfo> findAllBySitenumAndGroupnumAndCarnumAndOutdatetimeLessThanEqualAndOutdatetimeGreaterThanEqual(Long sitenum, Long groupnum, String carnum, LocalDateTime from, LocalDateTime to);

    Tbcardinfo findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);
}

