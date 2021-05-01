package com.InternetBankingService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VersionResponse {

    public int day;
    public int month;
    public int year;
    public String currentVersion;

}
