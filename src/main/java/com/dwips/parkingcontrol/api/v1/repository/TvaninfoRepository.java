package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tvaninfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TvaninfoRepository extends JpaRepository<Tvaninfo,Long> {


    List<Tvaninfo> findAllBySitenumAndGroupnumAndVancode(Long sitenum, Long groupnum, Long vancode);

    List<Tvaninfo> findAllBySitenumAndGroupnum(Long sitenum, Long groupnum);

    Tvaninfo findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);

    Tvaninfo findBySitenumAndGroupnumAndVancodeAndBranchcode(Long sitenum, Long groupnum, Long vancode, String branchcode);
}
