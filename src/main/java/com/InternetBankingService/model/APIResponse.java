package com.InternetBankingService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse {

    public String currentVersion;
    public Boolean isPasswordStrong;
    public byte[] hexString;

}
