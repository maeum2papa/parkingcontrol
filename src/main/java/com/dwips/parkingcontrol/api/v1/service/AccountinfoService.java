package com.dwips.parkingcontrol.api.v1.service;

import com.dwips.parkingcontrol.api.v1.dto.AccountinfoRquestDto;

import java.util.HashMap;

public interface AccountinfoService {

    HashMap<String,Object> search(AccountinfoRquestDto accountinfoRquestDto);

    HashMap<String,Object> save(AccountinfoRquestDto accountinfoRquestDto);

    HashMap<String,Object> update(AccountinfoRquestDto accountinfoRquestDto);

    HashMap<String,Object> delete(AccountinfoRquestDto accountinfoRquestDto);
}
