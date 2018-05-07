package com.ubs.opsit.interviews;

import org.apache.commons.lang.StringUtils;

public class TimeConverterImpl implements TimeConverter {

	/*public static void main(String[] args) {
		TimeConverter converter = new TimeConverterImpl();
		converter.convertTime("00:00:00");
		System.out.println("===============End Test-1================");
		converter.convertTime("13:17:01");
		System.out.println("===============End Test-2================");
		converter.convertTime("23:59:59");
		System.out.println("===============End Test-3================");
		converter.convertTime("24:00:00");
		System.out.println("===============End Test-4================");
	}*/
	
	@Override
	public String convertTime(String aTime) {
		String str[] = aTime.split(":");
		//System.out.println(str);
		int seconds = Integer.parseInt(str[2]);
		int minutes = Integer.parseInt(str[1]);
		int hours = Integer.parseInt(str[0]);
		//System.out.println(hours+":"+minutes+":"+seconds);
		StringBuffer finalOutput = new StringBuffer("");
		finalOutput.append(getSymbolsForSeconds(seconds));
		finalOutput.append(getSymbolsForHours(hours));
		finalOutput.append(getSymbolsForMinutes(minutes));
		//System.out.println(finalOutput.toString());
		return finalOutput.toString();
	}

	public String getSymbolsForSeconds(int seconds) {
		return (seconds % 2 == 0 ? "Y\r\n" : "O\r\n");
	}

	public String getSymbolsForHours(int hours) {
		int secondLineHours = hours % 5;
		int firstLineHours = hours/5;
		String hourStr = "";
		String secondLineHourStr = "";
		for(int i=0; i<firstLineHours; i++){
			hourStr += "R";
		}
		hourStr = StringUtils.rightPad(hourStr, 4, "O") + "\r\n";
		for(int i=0; i<secondLineHours; i++){
			secondLineHourStr += "R";
		}
		secondLineHourStr = StringUtils.rightPad(secondLineHourStr, 4, "O") + "\r\n";
		return hourStr+secondLineHourStr;
	}

	public String getSymbolsForMinutes(int minutes) {
		int secondLineMinutes = minutes % 5;
		int firstLineMinutes = minutes/5;
		String minuteStr = "";
		String secondLineMinuteStr = "";
		for(int i=1; i<=firstLineMinutes; i++){
			if(i != 0 && i % 3 == 0){
				minuteStr += "R";
			} else {
				minuteStr += "Y";
			}
		}
		minuteStr = StringUtils.rightPad(minuteStr, 11, "O") + "\r\n";
		for(int i=0; i<secondLineMinutes; i++){
			secondLineMinuteStr += "Y";
		}
		secondLineMinuteStr = StringUtils.rightPad(secondLineMinuteStr, 4, "O");
		return minuteStr+secondLineMinuteStr;
	
	}

}
