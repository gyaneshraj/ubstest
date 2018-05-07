package com.ubs.opsit.interviews;

public interface TimeConverter {

    String convertTime(String aTime);
    String getSymbolsForSeconds(int seconds);
    String getSymbolsForHours(int hours);
    String getSymbolsForMinutes(int minutes);

}
