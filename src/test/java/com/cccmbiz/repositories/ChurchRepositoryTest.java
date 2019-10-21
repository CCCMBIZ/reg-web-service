package com.cccmbiz.repositories;

import com.cccmbiz.configuration.RepositoryConfiguration;
import com.cccmbiz.domain.Church;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class ChurchRepositoryTest {

    private Logger log = LogManager.getLogger(ChurchRepositoryTest.class);

    private ChurchRepository churchRepository;
    @Autowired
    public void setChurchRepository(ChurchRepository churchRepository) {
        this.churchRepository = churchRepository;
    }

    @Test
    public void testSaveChurch(){
//        //setup church
//        Church church = new Church() ;
//        church.setAcronym("CNSCCC");
//        church.setAddress("2401 Kirchoff Road");
//        //save product, verify has ID value after save
////        assertNull(church.getId()); //null before save
//        churchRepository.save(church);
//        assertNotNull(church.getId()); //not null after save
//
//        log.info("Church ID:" + church.getId());
    }
}
