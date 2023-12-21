package com.linkedinlearning.copilot;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class LapTimeRepositoryTest {

    @Autowired
    private LapTimeRepository lapTimeRepository;

    @Test
    public void whenFindById_thenReturnLapTime() {
        // given
        LapTime savedLapTime = new LapTime();
        savedLapTime.setLapTime(10L);
        savedLapTime.setDriver("Driver1");
        savedLapTime.setCar("Car1");
        savedLapTime.setTrack("Track1");
        savedLapTime.setDate(LocalDate.now());
        savedLapTime = lapTimeRepository.save(savedLapTime);

        // when
        LapTime foundLapTime = lapTimeRepository.findById(savedLapTime.getId()).orElse(null);

        // then
        assertThat(foundLapTime).isNotNull();
        assertThat(foundLapTime.getDriver()).isEqualTo(savedLapTime.getDriver());
    }

    @Test
    public void whenInvalidId_thenReturnNull() {
        // when
        LapTime fromDb = lapTimeRepository.findById(-11L).orElse(null);

        // then
        assertThat(fromDb).isNull();
    }
}
