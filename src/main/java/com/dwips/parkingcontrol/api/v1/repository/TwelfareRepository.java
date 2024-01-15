package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Twelfare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TwelfareRepository extends JpaRepository<Twelfare,Long> {

    List<Twelfare> findAllByCarnumAndStarddateLessThanEqualAndEnddateGreaterThanEqual(String carnum, LocalDate starddate, LocalDate enddate);

    List<Twelfare> findAllBySitenumAndGroupnumAndCarnum(Long sitenum, Long groupnum, String carnum);

    Twelfare findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);

    Twelfare findBySitenumAndGroupnumAndCarnum(Long sitenum, Long groupnum, String carnum);
}
