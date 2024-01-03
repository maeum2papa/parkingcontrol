package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tparkinfo;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodinout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TparkinfoRepository extends JpaRepository<Tparkinfo, Long> {

    void deleteBySitenumAndGroupnumAndCarnumAndOutflag(
            Long sitenum,
            Long groupnum,
            String carnum,
            Long outflag
    );

    List<Tparkinfo> findAllBySitenumAndGroupnumAndCarnumLikeAndOutflag(
            Long sitenum,
            Long groupnum,
            String carnum,
            Long outflag
    );

    List<Tparkinfo> findAllBySitenumAndGroupnumAndOutflag(
            Long sitenum,
            Long groupnum,
            Long outflag
    );

    Tparkinfo findBySitenumAndGroupnumAndIndevicenumAndCarnumAndOutflag(
            Long sitenum,
            Long groupnum,
            Long indevicenum,
            String carnum,
            Long outflag
    );
}
