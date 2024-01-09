package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tperiodinout;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TperiodinoutRespository extends JpaRepository<Tperiodinout,Long> {

    void deleteBySitenumAndGroupnumAndCarnumAndOutflag(
            Long sitenum,
            Long groupnum,
            String carnum,
            Long outflag
    );

    List<Tperiodinout> findAllBySitenumAndGroupnumAndCarnumLikeAndOutflag(
            Long sitenum,
            Long groupnum,
            String carnum,
            Long outflag
    );

    List<Tperiodinout> findAllBySitenumAndGroupnumAndOutflag(
            Long sitenum,
            Long groupnum,
            Long outflag
    );

    Tperiodinout findBySitenumAndGroupnumAndIndevicenumAndCarnumAndOutflag(
            Long sitenum,
            Long groupnum,
            Long devicenum,
            String carnum,
            Long outflag
    );

    Tperiodinout findByXindex(Long xindex);


}
