package com.infy.LibraryManagment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TxnRequest {
    @NotBlank(message = "userPhoneNo should not be blank")
    private String userPhoneNo;

    @NotBlank(message = "bookNo should not be blank")
    private String bookNo;

}
