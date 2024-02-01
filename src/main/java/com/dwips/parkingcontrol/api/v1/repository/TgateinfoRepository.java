package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tgateinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TgateinfoRepository extends JpaRepository<Tgateinfo,Long> {
    Tgateinfo findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);

    Tgateinfo findBySitenumAndGroupnumAndGateip(Long sitenum, Long groupnum, String gateip);
}
