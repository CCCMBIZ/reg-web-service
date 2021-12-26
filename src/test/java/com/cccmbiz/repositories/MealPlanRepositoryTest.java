package com.cccmbiz.repositories;

import com.cccmbiz.configuration.RepositoryConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class MealPlanRepositoryTest {

    private Logger log = LogManager.getLogger(MealPlanRepositoryTest.class);

    @Autowired
    private MealPlanRepository mealplanRepository;

    @Test
    public void testFindMealPlan(){

//        Mealplan mp = new Mealplan() ;
//        mp.setHouseholdId(12L);
//        mp.setBreakfast1(12);
//        mealplanRepository.save(mp);

        for (MealPlanProjection m: mealplanRepository.findAllMealPlan()) {
            log.info("Household ID:" + m.getHouseholdId()
                    + " Breakfast1:" + m.getBreakfast2()
                    + " Breakfast2:" + m.getBreakfast1()
                    + " Breakfast3:" + m.getBreakfast3()
                    + " Lunch1:" + m.getLunch1()
                    + " Lunch2:" + m.getLunch2()
                    + " Lunch3:" + m.getLunch3()
                    + " Dinner1:" + m.getDinner1()
                    + " Dinner2:" + m.getDinner2()
                    + " Dinner3:" + m.getDinner3());
        }

//        assertNotNull(church.getId()); //not null after save
//
//        log.info("Church ID:" + church.getId());
    }
}
