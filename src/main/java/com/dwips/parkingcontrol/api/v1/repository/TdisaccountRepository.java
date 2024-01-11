package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tdisaccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TdisaccountRepository extends JpaRepository<Tdisaccount,Long> {
    Tdisaccount findBySitenumAndGroupnumAndXindex(Long sienum, Long groupnum, Long xindex);
}
