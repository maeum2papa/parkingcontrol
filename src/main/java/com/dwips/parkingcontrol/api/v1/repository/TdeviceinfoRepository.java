package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tdeviceinfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TdeviceinfoRepository extends JpaRepository<Tdeviceinfo,Long> {

    Tdeviceinfo findBySitenumAndGroupnumAndDevicenum(Long sitenum, Long groupnum, Long deviecenum);

    List<Tdeviceinfo> findAllBySitenumAndGroupnum(Long sitenum, Long groupnum);

    Tdeviceinfo findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);
}
