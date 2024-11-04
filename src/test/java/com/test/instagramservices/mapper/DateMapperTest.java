package com.test.instagramservices.mapper;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateMapperTest {

    @ParameterizedTest
    @MethodSource("provideStringsForDaysHoursMinutesSeconds")
    void given1dayPublishDayMessageReturn1d(LocalDateTime publishMessage, String expectedResult) {
        // action
        String publish = DateMapper.getPublishedTime(publishMessage);
        // assert
        assertEquals(expectedResult, publish);
    }

    private static Stream<Arguments> provideStringsForDaysHoursMinutesSeconds() {
        return Stream.of(
                Arguments.of(LocalDateTime.now().minusDays(1), "1d"),
                Arguments.of(LocalDateTime.now().minusDays(2), "2d"),
                Arguments.of(LocalDateTime.now().minusDays(7), "7d"),
                Arguments.of(LocalDateTime.now().minusHours(6), "6h"),
                Arguments.of(LocalDateTime.now().minusHours(15), "15h"),
                Arguments.of(LocalDateTime.now().minusMinutes(23), "23m"),
                Arguments.of(LocalDateTime.now().minusMinutes(59), "59m"),
                Arguments.of(LocalDateTime.now().minusSeconds(3), "3s")
        );
    }
}