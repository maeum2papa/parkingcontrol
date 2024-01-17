package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tparkconfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TparkconfigRepository extends JpaRepository<Tparkconfig,Long> {
    List<Tparkconfig> findAllBySitenumAndGroupnum(Long sitenum, Long groupnum);

    Tparkconfig findBySitenumAndGroupnumAndCmdtype(Long sitenum, Long groupnum, String cmdtype);

    Tparkconfig findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);
}
