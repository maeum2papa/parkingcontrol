package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tholiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TholidayRepository extends JpaRepository<Tholiday,Long> {
    Tholiday findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);
}
