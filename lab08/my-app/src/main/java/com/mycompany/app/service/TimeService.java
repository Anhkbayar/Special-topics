package com.mycompany.app.service;

import java.time.LocalDate;
import java.time.Month;

public class TimeService {
  public boolean isHoliday() {
    LocalDate today = LocalDate.now();
    return today.getMonth() == Month.JANUARY && today.getDayOfMonth() == 1;
  }
}
