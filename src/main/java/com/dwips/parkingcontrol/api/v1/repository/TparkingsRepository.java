package com.dwips.parkingcontrol.api.v1.repository;

import com.dwips.parkingcontrol.api.v1.domain.Tparkings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TparkingsRepository extends JpaRepository<Tparkings,Long> {
}
