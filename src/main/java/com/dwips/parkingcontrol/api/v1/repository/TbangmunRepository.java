package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tbangmun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TbangmunRepository extends JpaRepository<Tbangmun,Long> {
    Tbangmun findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);

    Tbangmun findBySitenumAndGroupnumAndCarnum(Long sitenum, Long groupnum, String carnum);
}
