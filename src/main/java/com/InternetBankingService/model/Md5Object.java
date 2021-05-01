package com.InternetBankingService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Md5Object {
    public String data;
    public byte[] hexString;
}
