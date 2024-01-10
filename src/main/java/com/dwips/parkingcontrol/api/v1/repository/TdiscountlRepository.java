package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tdiscountl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TdiscountlRepository extends JpaRepository<Tdiscountl,Long> {
    List<Tdiscountl> findAllBySitenumAndGroupnum(Long sitenum, Long groupnum);

    Tdiscountl findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);
}
