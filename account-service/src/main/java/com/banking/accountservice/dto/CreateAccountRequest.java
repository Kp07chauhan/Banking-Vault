package com.banking.accountservice.dto;

import com.banking.accountservice.entity.enumes.AccountStatus;
import com.banking.accountservice.entity.enumes.AccountType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountRequest {

    @NotBlank(message = "Account holder name is required!")
    private String accountHolderName;

    @NotBlank(message = "Email is required!")
    @Email(message = "Invalid email format!")
    private String email;

    @NotBlank(message = "Phone is required!")
    private String phone;

    @NotNull(message = "Account type is required!")
    private AccountType accountType;

    @NotNull(message = "Initial deposit is required!")
    @Positive(message = "Initial deposit must be positive")
    private BigDecimal initialDeposit;

}
