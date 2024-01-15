package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodparktime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TperiodparktimeRepository extends JpaRepository<Tperiodparktime, Long> {

    Tperiodparktime findBySitenumAndGroupnumAndCode(Long sitenum,Long groupnum,Long code);

    List<Tperiodparktime> findAllBySitenumAndGroupnum(Long sitenum, Long groupnum);

    Tperiodparktime findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);
}
