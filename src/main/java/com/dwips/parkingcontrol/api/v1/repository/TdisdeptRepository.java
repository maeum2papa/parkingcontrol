package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tdisdept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TdisdeptRepository extends JpaRepository<Tdisdept,Long> {
    Tdisdept findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);
}
