package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.domain.Tdepartment;
import com.dwips.parkingcontrol.api.v1.dto.DepartmentRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TdepartmentCustomRepository;
import com.dwips.parkingcontrol.api.v1.repository.TdepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private final TdepartmentRepository tdepartmentRepository;

    private final TdepartmentCustomRepository tdepartmentCustomRepository;

    @Override
    public HashMap<String, Object> search(DepartmentRequestDto departmentRequestDto) {

        Integer result = 0;

        List<Tdepartment> tdepartmentList = tdepartmentCustomRepository.customFindAll(
                departmentRequestDto.getSitenum(),
                departmentRequestDto.getGroupnum(),
                departmentRequestDto.getCcode(),
                departmentRequestDto.getCname(),
                departmentRequestDto.getCode(),
                departmentRequestDto.getName()
        );

        if(!tdepartmentList.isEmpty()){
            result = 1;
        }else{
            tdepartmentList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tdepartment",tdepartmentList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(DepartmentRequestDto departmentRequestDto) {

        Integer result = 0;
        List<Tdepartment> tdepartmentList = new ArrayList<>();

        tdepartmentList.add(tdepartmentRepository.save(departmentRequestDto.getTdepartment()));

        if(!tdepartmentList.isEmpty()){
            result = 1;
        }else{
            tdepartmentList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tdepartment",tdepartmentList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(DepartmentRequestDto departmentRequestDto) {

        Integer result = 0;
        List<Tdepartment> tdepartmentList = new ArrayList<>();

        Tdepartment tdepartment = tdepartmentRepository.findBySitenumAndGroupnumAndXindex(
                departmentRequestDto.getSitenum(),
                departmentRequestDto.getGroupnum(),
                departmentRequestDto.getTdepartment().getXindex()
        );


        if(tdepartment!=null){
            tdepartmentRepository.save(departmentRequestDto.getTdepartment());
            tdepartmentList.add(tdepartment);
            result = 1;
        }else{
            tdepartmentList = null;
        }


        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tdepartment",tdepartmentList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(DepartmentRequestDto departmentRequestDto) {

        Integer result = 0;
        Tdepartment tdepartment = null;

        if(departmentRequestDto.getXindex()!=null){
            tdepartment = tdepartmentRepository.findBySitenumAndGroupnumAndXindex(
                    departmentRequestDto.getSitenum(),
                    departmentRequestDto.getGroupnum(),
                    departmentRequestDto.getTdepartment().getXindex()
            );
        }else if(departmentRequestDto.getCcode()!=null){
            tdepartment = tdepartmentRepository.findBySitenumAndGroupnumAndCode(
                    departmentRequestDto.getSitenum(),
                    departmentRequestDto.getGroupnum(),
                    departmentRequestDto.getCcode()
            );
        }

        if(tdepartment!=null){
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }
}
