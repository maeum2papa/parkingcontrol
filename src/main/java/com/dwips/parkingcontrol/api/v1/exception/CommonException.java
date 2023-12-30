package com.dwips.parkingcontrol.api.v1.exception;

import com.dwips.parkingcontrol.api.v1.dto.common.CommonResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CommonException {

    @ExceptionHandler({HttpMessageNotReadableException.class})
    protected CommonResponseDto CommonException(
            HttpMessageNotReadableException e
    ) {
        log.error("JSON 형식 오류 : ",e);

        return CommonResponseDto.builder()
                .result(0)
                .build();
    }


    @ExceptionHandler({RuntimeException.class})
    protected CommonResponseDto CommonException(
            RuntimeException e
    ) {
        log.error("",e);

        return CommonResponseDto.builder()
                .result(0)
                .build();
    }
}
