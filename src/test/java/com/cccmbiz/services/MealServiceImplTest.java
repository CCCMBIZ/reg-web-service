package com.cccmbiz.services;

import com.cccmbiz.configuration.RepositoryConfiguration;
import com.cccmbiz.domain.Meal;
import com.cccmbiz.domain.Product;
import com.cccmbiz.repositories.MealRepository;
import com.cccmbiz.repositories.ProductRepository;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class MealServiceImplTest {

    MealServiceImpl mealServiceImpl ;
    @Mock
    private MealRepository mealRepository;
    @Mock
    private Meal meal;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mealServiceImpl = new MealServiceImpl();
        mealServiceImpl.setMealRepository(mealRepository);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldReturnMeal_whenGetMealIdIsCalled() throws Exception {
//        assertNotNull(mealService);
        // Arrange
        when(mealRepository.findById(5)).thenReturn(Optional.of(meal));
        // Act
        Integer mealID = mealServiceImpl.getMealIDByTime(DateTime.now());
        // Assert
        assertThat(mealID, is(equalTo(meal.getId())));
    }

//    @Test
//    public void shouldReturn_whenGetMealIdIsCalled() throws Exception {
////        assertNotNull(mealService);
//        // Arrange
//        when(mealRepository.findById(5)).thenReturn(Optional.of(meal));
//        // Act
//        Integer mealID = mealServiceImpl.getMealID(DateTime.now());
//        // Assert
//        assertThat(mealID, is(equalTo(meal.getId())));
//    }
}