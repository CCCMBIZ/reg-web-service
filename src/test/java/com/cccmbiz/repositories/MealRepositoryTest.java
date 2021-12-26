package com.cccmbiz.repositories;

import com.cccmbiz.configuration.RepositoryConfiguration;
import com.cccmbiz.domain.Event;
import com.cccmbiz.domain.Meal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class MealRepositoryTest {

    private Logger log = LogManager.getLogger(MealPlanRepositoryTest.class);

    @Autowired
    private MealRepository mealRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void retreiveAndConvertDateTime() {
        Optional<Meal> meal = mealRepository.findById(10);
        java.time.LocalDate localDate = meal.get().getDate().toLocalDate();
        LocalTime localTime = meal.get().getStartTime().toLocalTime();
        LocalDateTime ldt = LocalDateTime.of(localDate,localTime) ;

        log.debug("Local DateTime:"+ ldt.toString());

        List<Meal> list = mealRepository.findByLocation((byte)1) ;

        for (Meal m: list) {
            log.info("Meal Info:" + m.getDate() + " " + m.getName() + " " + m.getEventByEventId().getNameEn());
        }

        Event ev = new Event() ;
        ev.setId(2);

        List<Meal> elist = mealRepository.findByEventByEventId(ev);

        for (Meal m: elist) {
            log.info("Meal Info2:" + m.getDate() + " " + m.getName() + " " + m.getEventByEventId().getNameEn());
        }

    }
}