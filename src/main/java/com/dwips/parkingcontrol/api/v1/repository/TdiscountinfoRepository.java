package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tdiscountinfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TdiscountinfoRepository extends JpaRepository<Tdiscountinfo, Long> {

    List<Tdiscountinfo> findAllByPindex(Long xindex);
}
