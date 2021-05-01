package com.InternetBankingService.controller;


import com.InternetBankingService.model.APIResponse;
import com.InternetBankingService.model.VersionResponse;
import com.InternetBankingService.repository.InternetBankingInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<VersionResponse> GetAPIVersion(){
           VersionResponse response = new VersionResponse();
           response = internetBankingInterface.getVersion();
           return new ResponseEntity(response,HttpStatus.OK);
    }









}
