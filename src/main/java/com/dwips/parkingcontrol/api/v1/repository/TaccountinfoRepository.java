package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Taccountinfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaccountinfoRepository extends JpaRepository<Taccountinfo,Long> {
    List<Taccountinfo> findAllBySitenumAndGroupnumAndId(Long sitenum, Long groupnum, String id);

    Taccountinfo findBySitenumAndGroupnumAndIdAndDiskey(Long sitenum, Long groupnum, String id, Long diseky);

    Taccountinfo findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);


    List<Taccountinfo> findAllBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);
}
