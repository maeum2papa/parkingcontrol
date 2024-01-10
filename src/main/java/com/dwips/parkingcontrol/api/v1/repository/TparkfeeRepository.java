package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tparkfee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TparkfeeRepository extends JpaRepository<Tparkfee,Long> {
    Tparkfee findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);

    List<Tparkfee> findAllBySitenumAndGroupnum(Long sitenum, Long groupnum);
}
