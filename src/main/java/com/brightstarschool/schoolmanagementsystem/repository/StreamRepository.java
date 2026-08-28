package com.brightstarschool.schoolmanagementsystem.repository;

import com.brightstarschool.schoolmanagementsystem.entity.Stream;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StreamRepository extends JpaRepository<Stream, Long> {
    Optional<Stream> findByStreamCode(long streamCode);

    Optional<Stream> findByStreamName(String streamName);

}
