package com.matschie.data.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class CSVdata  implements DataHandler{
	public  String[][] getData(String CSVFileName){
		CSVReader reader;
		String[][] data =null;
		List<String[]> rowrecords =null;
				try {
					reader =new CSVReaderBuilder(new FileReader("src/main/resources/data/"+CSVFileName+".csv")).withSkipLines(1).build();
					rowrecords = reader.readAll();
					data= new String[rowrecords.size()][rowrecords.get(0).length];
					for(int i=0;i<rowrecords.size();i++) {
						for(int j=0;j<rowrecords.get(0).length;j++) {
							data[i][j]=rowrecords.get(i)[j];
						}
					}
				}
				 catch (CsvException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return data;
				}
				
			
	}


