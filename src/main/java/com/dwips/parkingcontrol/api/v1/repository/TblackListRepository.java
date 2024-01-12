package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tblacklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TblackListRepository extends JpaRepository<Tblacklist,Long> {
    Tblacklist findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);
}
