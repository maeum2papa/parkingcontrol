package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TperiodmemberRespository extends JpaRepository<Tperiodmember, Long> {

    Tperiodmember findBySitenumAndGroupnumAndCarnumAndUseyn(Long sitenum, Long groupnum, String carnum,String useyn);

}
