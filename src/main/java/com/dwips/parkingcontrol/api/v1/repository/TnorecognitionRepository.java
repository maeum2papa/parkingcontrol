package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tnorecognition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TnorecognitionRepository extends JpaRepository<Tnorecognition,Long> {
    Tnorecognition findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);

    List<Tnorecognition> findAllBySitenumAndGroupnumAndIodatetimeGreaterThanEqualAndIodatetimeLessThanEqual(
            Long sitenum,
            Long groupnum,
            LocalDateTime datefrom,
            LocalDateTime dateto
    );

    List<Tnorecognition> findAllBySitenumAndGroupnum(Long sitenum, Long groupnum);
}
