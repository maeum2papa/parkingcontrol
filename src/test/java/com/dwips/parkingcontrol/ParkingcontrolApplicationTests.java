package com.dwips.parkingcontrol;

import com.dwips.parkingcontrol.api.v1.component.CommonComponent;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodinout;
import com.dwips.parkingcontrol.api.v1.domain.Tperiodmember;
import com.dwips.parkingcontrol.api.v1.repository.TperiodinoutRespository;
import com.dwips.parkingcontrol.api.v1.repository.TperiodmemberRespository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Slf4j
@SpringBootTest
class ParkingcontrolApplicationTests {

	private TperiodmemberRespository tperiodmemberRespository;

	@Autowired
	private TperiodinoutRespository tperiodinoutRespository;

	@Autowired
	private CommonComponent commonComponent;


	@Test
	void contextLoads() throws JsonProcessingException {
		Tperiodinout tperiodinout = tperiodinoutRespository.findByXindex(12L);

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		String jsonString = objectMapper.writeValueAsString(tperiodinout);

		System.out.println(jsonString);


	}


}
