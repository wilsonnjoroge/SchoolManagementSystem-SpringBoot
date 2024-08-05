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


    public Stream() {
    }

    public Stream(long streamId,
                  long streamCode,
                  String streamName) {
        this.streamId = streamId;
        this.streamCode = streamCode;
        this.streamName = streamName;
    }

    public Stream(long streamCode,
                  String streamName) {
        this.streamCode = streamCode;
        this.streamName = streamName;
    }

    public long getStreamId() {
        return streamId;
    }

    public void setStreamId(long streamId) {
        this.streamId = streamId;
    }

    public long getStreamCode() {
        return streamCode;
    }

    public void setStreamCode(long streamCode) {
        this.streamCode = streamCode;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    @Override
    public String toString() {
        return "Stream{" +
                "streamId=" + streamId +
                ", streamCode=" + streamCode +
                ", streamName='" + streamName + '\'' +
                '}';
    }
}
