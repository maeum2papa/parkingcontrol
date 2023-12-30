package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tlogon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TlogonRepository extends JpaRepository<Tlogon,Long> {

    Tlogon findBySitenumAndGroupnumAndDevicenum(Long sitenum, Long groupnum, Long deviecenum);
}
