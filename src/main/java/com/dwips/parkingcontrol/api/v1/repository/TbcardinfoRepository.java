package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tbcardinfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TbcardinfoRepository extends JpaRepository<Tbcardinfo, Long> {

    List<Tbcardinfo> findAllByPindex(Long xindex);

}
