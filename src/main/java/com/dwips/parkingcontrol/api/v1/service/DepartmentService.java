package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.DepartmentRequestDto;

import java.util.HashMap;

public interface DepartmentService {

    HashMap<String,Object> search(DepartmentRequestDto departmentRequestDto);

    HashMap<String,Object> save(DepartmentRequestDto departmentRequestDto);

    HashMap<String,Object> update(DepartmentRequestDto departmentRequestDto);

    HashMap<String,Object> delete(DepartmentRequestDto departmentRequestDto);
}
