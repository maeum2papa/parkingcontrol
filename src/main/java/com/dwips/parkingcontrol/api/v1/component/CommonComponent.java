package com.dwips.parkingcontrol.api.v1.component;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CommonComponent {

    // "0000-00-00 00:00:00" -> LocalDateTime
    public LocalDateTime stringDateTimeToLocalDateTime(String dateString) {

        if(dateString == null) return null;

        // DateTimeFormatter를 사용하여 문자열을 LocalDateTime으로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateString, formatter);

    }

    // LocalDateTime -> "0000-00-00 00:00:00"
    public String localDateTimeToStringDateTime(LocalDateTime dateTime) {

        if(dateTime == null) return null;

        // DateTimeFormatter를 사용하여 LocalDateTime을 문자열로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(formatter);
    }

    // "0000-00-00" -> LocalDate
    public LocalDate stringDateToLocalDate(String dateString) {

        if(dateString == null) return null;

        // DateTimeFormatter를 사용하여 문자열을 LocalDate로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateString, formatter);

    }


    // LocalDate -> "0000-00-00"
    public String localDateToStringDate(LocalDate dateTime) {

        if(dateTime == null) return null;

        // DateTimeFormatter를 사용하여 LocalDate을 문자열로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateTime.format(formatter);
    }


    // "0000-00-00" -> LocalDateTime(type "to" = 0000-00-00 23:59:59, type "from" = 0000-00-00 00:00:00)
    public LocalDateTime stringDateToLocalDateTime(String dateString, String type) {

        if(dateString == null) return null;

        if(dateString.length() == 10){
            if(type == "to"){
                dateString = dateString + " 23:59:59";
            }else{
                dateString = dateString + " 00:00:00";
            }
        }

        return stringDateTimeToLocalDateTime(dateString);
    }


    // TCP Client Sender
    public String TcpClientSender(String ip, Integer port, String message){

        String serverResponse = "";

        try{

            // 소켓 생성 및 연결
            Socket socket = new Socket(ip, port);

            // 전송할 문자열
            message = "\u0002"+"gateip-command(192.168.0.140-RL11)"+"\u0003";

            // 문자열을 바이트로 변환하여 소켓으로 전송
            OutputStream output = socket.getOutputStream();
            output.write(message.getBytes(StandardCharsets.UTF_8));
            output.flush();


            // 소켓으로부터 서버 응답 수신
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            StringBuilder responseBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBuilder.append(line);
            }

            serverResponse = responseBuilder.toString();

            // 소켓 및 스트림 닫기
            reader.close();
            output.close();
            inputStream.close();
            socket.close();



        }catch (Exception e){
            e.printStackTrace();
        }

        return serverResponse;
    }
}
