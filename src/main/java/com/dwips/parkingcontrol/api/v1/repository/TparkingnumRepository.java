package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tparkingnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TparkingnumRepository extends JpaRepository<Tparkingnum,Long> {
    List<Tparkingnum> findAllBySitenumAndGroupnum(Long sitenum, Long groupnum);

    List<Tparkingnum> findAllBySitenum(Long sitenum);

    Tparkingnum findBySitenumAndGroupnum(Long sitenum, Long groupnum);
}
