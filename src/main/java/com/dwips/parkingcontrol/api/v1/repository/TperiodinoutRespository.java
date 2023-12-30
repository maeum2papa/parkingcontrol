package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tperiodinout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TperiodinoutRespository extends JpaRepository<Tperiodinout,Long> {

    void deleteBySitenumAndGroupnumAndCarnumAndOutflag(
            Long sitenum,
            Long groupnum,
            String carnum,
            Long outflag
    );
}
