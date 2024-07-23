package com.brightstarschool.schoolmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdateDTO {
    private long studentId;

    @NotNull
    private String name;

    @NotNull
    private String adress;

    @NotNull
    private long phoneNumber;

    @NotNull
    private String email;

    @NotNull
    private long idNumber;

    @NonNull
    private String password;
}
