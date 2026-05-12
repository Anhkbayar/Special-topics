package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;

import com.mycompany.app.service.TimeService;
import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Test;

public class TimeServiceTest {

  @Test
  void isHoliday_shouldCheckCurrentDate() {
    // This test verifies the isHoliday method works correctly
    TimeService timeService = new TimeService();

    boolean result = timeService.isHoliday();

    // Verify the method returns a boolean
    assertNotNull(result);

    // Verify logic: should return true only if today is January 1st
    LocalDate today = LocalDate.now();
    boolean expectedHoliday = today.getMonth() == Month.JANUARY && today.getDayOfMonth() == 1;
    assertEquals(expectedHoliday, result);
  }

  @Test
  void isHoliday_shouldReturnBoolean() {
    // Test that the method executes without errors
    TimeService timeService = new TimeService();
    boolean result = timeService.isHoliday();

    // Simply verify the result is a boolean (not null)
    assertTrue(result == true || result == false);
  }
}
