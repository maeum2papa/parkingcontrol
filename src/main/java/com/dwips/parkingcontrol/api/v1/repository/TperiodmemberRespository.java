package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TperiodmemberRespository extends JpaRepository<Tperiodmember, Long> {

    Tperiodmember findBySitenumAndGroupnumAndCarnumAndUseyn(Long sitenum, Long groupnum, String carnum,String useyn);

    Tperiodmember findBySitenumAndGroupnumAndDevicenumAndCarnumAndUseyn(Long sitenum, Long groupnum, Long devicenum, String carnum,String useyn);

    Tperiodmember findByCardno(Long cardno);

    Optional<Tperiodmember> findByXindex(Long xindex);

    Tperiodmember findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);

    Tperiodmember findBySitenumAndGroupnumAndCarnum(Long sitenum, Long groupnum, String carnum);

}
