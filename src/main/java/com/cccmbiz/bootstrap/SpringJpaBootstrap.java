package com.cccmbiz.bootstrap;

import com.cccmbiz.domain.*;
import com.cccmbiz.repositories.*;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private Logger log = LogManager.getLogger(SpringJpaBootstrap.class);

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private RegisterMealRepository registerMealRepository;

    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private MealPlanRepository mealplanRepository;

    @Autowired
    private MealTrackerRepository mealtrackerRepository;

    public void setMealRepository(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Random rnd = new Random();

    private String randomString( int len )
    {
        StringBuilder sb = new StringBuilder( len );
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt( rnd.nextInt(AB.length())));
        return sb.toString();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
    }

    private void loadProducts() {

        // Load Meal plan from Vince's database
        ArrayList<MealPlan> mpl = new ArrayList();
//
//        for (MealPlanProjection m: mealplanRepository.findAllCustom()) {
//
//            if (m.getHouseholdId() != null) {
//                MealPlan mp = new MealPlan();
//                mp.setHouseholdId(m.getHouseholdId());
//                mp.setBreakfast1(m.getBreakfast1());
//                mp.setBreakfast2(m.getBreakfast2());
//                mp.setBreakfast3(m.getBreakfast3());
//                mp.setLunch1(m.getLunch1());
//                mp.setLunch2(m.getLunch2());
//                mp.setLunch3(m.getLunch3());
//                mp.setDinner1(m.getDinner1());
//                mp.setDinner2(m.getDinner2());
//                mp.setDinner3(m.getDinner3());
//                mp.setBreakfastFee(m.getBreakfastFee());
//                mp.setLunchFee(m.getLunchFee());
//                mp.setDinnerFee(m.getDinnerFee());
//
//                log.info("Household ID:" + mp.getHouseholdId() + " Breakfast1:" + mp.getBreakfast2() + " Breakfast2:" + mp.getBreakfast1() + " Breakfast3:" + mp.getBreakfast3() + " Lunch1:" + mp.getLunch1() + " Lunch2:" + mp.getLunch2() + " Lunch3:" + mp.getLunch3() + " Dinner1:" + mp.getDinner1() + " Dinner2:" + mp.getDinner2() + " Dinner3:" + mp.getDinner3());
//                mpl.add(mp);
//            }
//        }
//
//        mealplanRepository.saveAll(mpl);
//
//        // Clean up test data
//        mealtrackerRepository.deleteAll(); // Temporary
//
//        if (registerMealRepository.existsById(9999)) {
//            registerMealRepository.deleteById(9999);
//        }
//
//        if (mealRepository.existsById(9999)) {
//            mealRepository.deleteById(9999);
//        }
//
//        // Insert an new Meal for test
//        Meal testMeal = new Meal() ;
//        testMeal.setUid(randomString(10));
//        Event ev = new Event() ;
//        ev.setId(2);
//        testMeal.setEventByEventId(ev);
//        testMeal.setDate(new java.sql.Date(DateTime.now().getMillis()));
//
//        LocalTime now = LocalTime.now();
//        //3 hours later
//        LocalTime start = new LocalTime(0,1, 0);
//        //3 minutes earlier
//        LocalTime end = new LocalTime(23,59, 59);
//
//        testMeal.setId(9999);
//        testMeal.setStartTime(new Time(start.toDateTimeToday().getMillis()));
//        testMeal.setEndTime(new Time(end.toDateTimeToday().getMillis()));
//        testMeal.setDeadline(new Timestamp(119,12,31,11,59,59,0));
//        testMeal.setType((byte) 3);
//        testMeal.setLocation((byte) 2);
//        testMeal.setFood("早,中,晚餐");
//        testMeal.setPrice(new BigDecimal(12.0));
//
//        mealRepository.save(testMeal);
//
//        // Insert order meal record
//        RegisterMeal rm = new RegisterMeal();
//
//        Register rg = registerRepository.findById(5).get();
//        log.info("Household ID:" + rg.getHouseholdId());
//
//        rm.setRegisterByRegisterId(rg);
//        rm.setMealByMealId(testMeal);
//        rm.setQty((byte) 9);
//        rm.setId(9999);
//
//        registerMealRepository.save(rm);
    }
}



