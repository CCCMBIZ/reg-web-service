package com.cccmbiz.repositories;

import com.cccmbiz.configuration.RepositoryConfiguration;
import com.cccmbiz.domain.Register;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class RegisterRepositoryTest {

    private Logger log = LogManager.getLogger(MealPlanRepositoryTest.class);

    @Autowired
    private RegisterRepository registerRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testFindRegister() {
        for (Register m: registerRepository.findAll()) {
            log.info("Household ID:" + m.getHouseholdId());
        }
    }
}