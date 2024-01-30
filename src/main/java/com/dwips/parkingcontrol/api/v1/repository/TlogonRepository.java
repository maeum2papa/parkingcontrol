package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tlogon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TlogonRepository extends JpaRepository<Tlogon,Long> {

    Tlogon findBySitenumAndGroupnumAndDevicenum(Long sitenum, Long groupnum, Long deviecenum);

    List<Tlogon> findAllBySitenumAndGroupnumAndLogdatetimeGreaterThanEqualAndLogdatetimeLessThanEqual(Long sitenum, Long groupnum, LocalDateTime from, LocalDateTime to);

    List<Tlogon> findAllBySitenumAndGroupnumAndDevicenumAndLogdatetimeGreaterThanEqualAndLogdatetimeLessThanEqual(Long sitenum, Long groupnum, Long devicenum, LocalDateTime from, LocalDateTime to);

    Tlogon findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);
}
