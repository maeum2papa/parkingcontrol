package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tcompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TcompanyRepository extends JpaRepository<Tcompany,Long> {
    List<Tcompany> findAllBySitenumAndGroupnum(Long stienum, Long groupnum);

    List<Tcompany> findAllBySitenumAndGroupnumAndCodeAndName(Long stienum, Long groupnum, Long code, String name);

    List<Tcompany> findAllBySitenumAndGroupnumAndCode(Long stienum, Long groupnum, Long code);

    List<Tcompany> findAllBySitenumAndGroupnumAndName(Long stienum, Long groupnum, String name);

    Tcompany findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);

    Tcompany findBySitenumAndGroupnumAndCode(Long sitenum, Long groupnum, Long code);
}
