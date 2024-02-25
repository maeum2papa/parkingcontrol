package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tmanager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TmanagerRepository extends JpaRepository<Tmanager,Long> {
    Tmanager findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);

    List<Tmanager> findAllBySitenumAndGroupnum(Long sitenum, Long groupnum);

    List<Tmanager> findAllBySitenumAndGroupnumAndName(Long sitenum, Long groupnum, String name);

    List<Tmanager> findAllBySitenumAndGroupnumAndMid(Long sitenum, Long groupnum, String id);

    List<Tmanager> findAllBySitenumAndGroupnumAndMidAndName(Long sitenum, Long groupnum, String id, String name);

    Tmanager findByMid(String id);
}
