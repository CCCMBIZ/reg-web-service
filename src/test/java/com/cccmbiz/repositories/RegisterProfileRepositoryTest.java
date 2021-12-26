package com.cccmbiz.repositories;

import com.cccmbiz.configuration.RepositoryConfiguration;
import com.cccmbiz.domain.MealPlan;
import com.cccmbiz.domain.RegisterProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class RegisterProfileRepositoryTest {

    private Logger log = LogManager.getLogger(RegisterProfileRepositoryTest.class);

    @Autowired
    private RegisterRepository registerRepository;

    @Test
    public void testGetRegisterProfile() {

//        // Reset Data
//        if (registerProfileRepository.count() > 0) {
//            registerProfileRepository.deleteAll();
//        }
        // Load Register Profile
//        ArrayList<RegisterProfile> list = new ArrayList();
//
//        for (RegisterProfileProjection rpp : registerRepository.getRegisterProfile()) {
//            if (rpp != null) {
//                RegisterProfile rp = new RegisterProfile();
//                rp.setProfileId(rpp.getProfileId());
//                rp.setRegisterId(rpp.getRegisterId());
//
//                log.info("Profile ID:" + rp.getProfileId() + " Register ID:" + rp.getRegisterId());
//
//                list.add(rp);
//            }
//        }

//        registerProfileRepository.saveAll(list);
    }
}
