package com.InternetBankingService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse {

    public String currentVersion;
    public Boolean isPasswordStrong;
    public byte[] hexString;

}