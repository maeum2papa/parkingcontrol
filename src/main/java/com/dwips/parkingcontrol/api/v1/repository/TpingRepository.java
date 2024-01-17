package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TpingRepository extends JpaRepository<Tping,Long> {
    List<Tping> findAllBySitenumAndGroupnum(Long sitenum, Long groupnum);

    Tping findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);

    List<Tping> findAllBySitenumAndGroupnumAndXparkin(Long sitenum, Long groupnum, Long xparkin);

    List<Tping> findAllBySitenumAndGroupnumAndXcredit(Long sitenum, Long groupnum, Long xcredit);


    List<Tping> findAllBySitenumAndGroupnumAndXperiodin(Long sitenum, Long groupnum, Long xperiodin);

    List<Tping> findAllBySitenumAndGroupnumAndXparkcal(Long sitenum, Long groupnum, Long xparkcal);

    List<Tping> findAllBySitenumAndGroupnumAndXparkinfo(Long sitenum, Long groupnum, Long xparkinfo);

    List<Tping> findAllBySitenumAndGroupnumAndXperiodinout(Long sitenum, Long groupnum, Long xperiodout);
}
