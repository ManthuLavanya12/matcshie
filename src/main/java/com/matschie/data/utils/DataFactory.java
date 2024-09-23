package com.matschie.data.utils;

public class DataFactory {
public static DataHandler engine(DataEngine dataengine) {
	if(DataEngine.EXCEL==dataengine) {
		return new Exceldata();
		
	}else {
		return new CSVdata();

	}
	
}
}
