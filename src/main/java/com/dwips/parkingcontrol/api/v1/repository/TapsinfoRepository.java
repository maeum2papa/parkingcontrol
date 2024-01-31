package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tapsinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TapsinfoRepository extends JpaRepository<Tapsinfo,Long> {
    Tapsinfo findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);
}
