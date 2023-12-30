package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tdeviceinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TdeviceinfoRepository extends JpaRepository<Tdeviceinfo,Long> {

    Tdeviceinfo findBySitenumAndGroupnumAndDevicenum(Long sitenum, Long groupnum, Long deviecenum);
}
