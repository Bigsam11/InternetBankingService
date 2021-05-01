package com.InternetBankingService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordObject {
    public   String password;
    public boolean isPasswordStrong;
}
