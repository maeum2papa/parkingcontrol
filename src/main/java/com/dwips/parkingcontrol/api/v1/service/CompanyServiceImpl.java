package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.domain.Tcompany;
import com.dwips.parkingcontrol.api.v1.dto.CompanyRequestDto;
import com.dwips.parkingcontrol.api.v1.repository.TcompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final TcompanyRepository tcompanyRepository;

    @Override
    public HashMap<String, Object> search(CompanyRequestDto companyRequestDto) {

        Integer result = 0;
        List<Tcompany> tcompanyList = new ArrayList<>();

        if(companyRequestDto.getCode()!=null && companyRequestDto.getName()!=null){

            tcompanyList =  tcompanyRepository.findAllBySitenumAndGroupnumAndCodeAndName(
                    companyRequestDto.getSitenum(),
                    companyRequestDto.getGroupnum(),
                    companyRequestDto.getCode(),
                    companyRequestDto.getName()
            );

        }else if(companyRequestDto.getCode()!=null && companyRequestDto.getName()==null){
            tcompanyList =  tcompanyRepository.findAllBySitenumAndGroupnumAndCode(
                    companyRequestDto.getSitenum(),
                    companyRequestDto.getGroupnum(),
                    companyRequestDto.getCode()
            );
        }else if(companyRequestDto.getCode()==null && companyRequestDto.getName()!=null){
            tcompanyList =  tcompanyRepository.findAllBySitenumAndGroupnumAndName(
                    companyRequestDto.getSitenum(),
                    companyRequestDto.getGroupnum(),
                    companyRequestDto.getName()
            );
        }else{
            tcompanyList = tcompanyRepository.findAllBySitenumAndGroupnum(
                    companyRequestDto.getSitenum(),
                    companyRequestDto.getGroupnum()
            );
        }

        if(!tcompanyList.isEmpty()){
            result = 1;
        }else{
            tcompanyList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tcompany",tcompanyList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> save(CompanyRequestDto companyRequestDto) {

        Integer result = 0;
        List<Tcompany> tcompanyList = new ArrayList<>();

        tcompanyList.add(tcompanyRepository.save(companyRequestDto.getTcompany()));

        if(!tcompanyList.isEmpty()){
            result = 1;
        }else{
            tcompanyList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tcompany",tcompanyList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> update(CompanyRequestDto companyRequestDto) {

        Integer result = 0;
        List<Tcompany> tcompanyList = new ArrayList<>();

        Tcompany tcompany = tcompanyRepository.findBySitenumAndGroupnumAndXindex(
                companyRequestDto.getSitenum(),
                companyRequestDto.getGroupnum(),
                companyRequestDto.getTcompany().getXindex()
        );

        if(tcompany!=null){
            tcompanyRepository.save(companyRequestDto.getTcompany());
            tcompanyList.add(tcompany);
            result = 1;
        }else{
            tcompanyList = null;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);
        resultMap.put("tcompany",tcompanyList);

        return resultMap;
    }

    @Override
    public HashMap<String, Object> delete(CompanyRequestDto companyRequestDto) {

        Integer result = 0;
        Tcompany tcompany = null;

        if(companyRequestDto.getXindex()!=null){
            tcompany = tcompanyRepository.findBySitenumAndGroupnumAndXindex(
                    companyRequestDto.getSitenum(),
                    companyRequestDto.getGroupnum(),
                    companyRequestDto.getXindex()
            );
        }else if(companyRequestDto.getCode()!=null){
            tcompany = tcompanyRepository.findBySitenumAndGroupnumAndCode(
                    companyRequestDto.getSitenum(),
                    companyRequestDto.getGroupnum(),
                    companyRequestDto.getCode()
            );
        }



        if(tcompany!=null){
            tcompanyRepository.delete(tcompany);
            result = 1;
        }

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("result",result);

        return resultMap;
    }
}
