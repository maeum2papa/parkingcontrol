package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TparkinfoRepository extends JpaRepository<Tparkinfo, Long> {

    void deleteBySitenumAndGroupnumAndCarnumAndOutflag(
            Long sitenum,
            Long groupnum,
            String carnum,
            Long outflag
    );
}
