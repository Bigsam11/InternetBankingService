package com.InternetBankingService.controller;


import com.InternetBankingService.model.Md5Object;
import com.InternetBankingService.model.PasswordObject;
import com.InternetBankingService.model.VersionResponse;
import com.InternetBankingService.repository.InternetBankingInterface;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class InternetBankingController {

    @Autowired
    private InternetBankingInterface internetBankingInterface;




    @PostConstruct
    @RequestMapping(value = {"/bank/api/version", "/bank/api-version"}, method = RequestMethod.GET)
    public ResponseEntity<VersionResponse> GetApiVersion(){
           VersionResponse response = new VersionResponse();
           response = internetBankingInterface.getVersion();
           return new ResponseEntity(response,HttpStatus.OK);
    }

    @SneakyThrows
    @RequestMapping(value = {"/bank/api/calc/MD5/{md5Val}", "/bank/api/calc/{md5Val}/MD5"}, method = RequestMethod.GET)
    public ResponseEntity<VersionResponse> CalculateMD5(@PathVariable byte[] md5Val){
        Md5Object response = new Md5Object();
        response = internetBankingInterface.calculateMd5(md5Val);
        return new ResponseEntity(response,HttpStatus.OK);
    }


    @RequestMapping(value = {"/bank/api/password/strong/{password}", "/bank/api/is-password-strong/{password}"}, method = RequestMethod.GET)
    public ResponseEntity<PasswordObject> IsPasswordStrong(@PathVariable String password){
        PasswordObject response = new PasswordObject();
        response = internetBankingInterface.checkPasswordStrength(password);
        return new ResponseEntity(response,HttpStatus.OK);
    }














}
