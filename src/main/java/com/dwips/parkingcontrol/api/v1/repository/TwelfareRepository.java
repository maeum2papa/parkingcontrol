package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Twelfare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TwelfareRepository extends JpaRepository<Twelfare,Long> {

    List<Twelfare> findAllByCarnumAndStarddateLessThanEqualAndEnddateGreaterThanEqual(String carnum, LocalDate starddate, LocalDate enddate);

}
