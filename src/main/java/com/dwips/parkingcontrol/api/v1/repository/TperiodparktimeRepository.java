package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodparktime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TperiodparktimeRepository extends JpaRepository<Tperiodparktime, Long> {

    Tperiodparktime findBySitenumAndGroupnumAndCode(Long sitenum,Long groupnum,Long code);

}
