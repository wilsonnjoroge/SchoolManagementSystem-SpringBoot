package com.brightstarschool.schoolmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "streams")
public class Stream {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stream_id")
    private long streamId;

    @Column(name = "stream_code")
    private long streamCode;

    @Column(name = "stream_name")
    private String streamName;
}
