package com.brightstarschool.schoolmanagementsystem.entity;


import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "fees_per_term")
public class FeesPerTerm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = 11)
    private long Id;

    @Column(name = "term")
    private long term;

    @NotNull
    @Column(name = "start_date")
    private LocalDate startDate;

    @NotNull
    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "fee_charged")
    private long feeCharged;
}
