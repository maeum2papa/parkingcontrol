package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tdepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TdepartmentRepository extends JpaRepository<Tdepartment,Long> {
    Tdepartment findBySitenumAndGroupnumAndXindex(Long sitenum, Long groupnum, Long xindex);

    Tdepartment findBySitenumAndGroupnumAndCode(Long sitenum, Long groupnum, Long ccode);
}
