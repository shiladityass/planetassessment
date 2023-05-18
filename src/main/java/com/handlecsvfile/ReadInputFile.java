package com.handlecsvfile.mavenproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;


public class ReadInputFile implements CsvFileHandler {

	
	static final String CAMEROON_REGEX = "\\(237\\)\\ ?[2368]\\d{7,8}$";
	static final String ETHIOPIA_REGEX = "\\(251\\)\\ ?[1-59]\\d{8}$";
	static final String MOROCCO_REGEX = "\\(212\\)\\ ?[5-9]\\d{8}$";
	static final String MOZAMBIQUE_REGEX = "\\(258\\)\\ ?[28]\\d{7,8}$";
	static final String UGANDA_REGEX = "\\(256\\)\\ ?\\d{9}$";
	
	static final String CAMEROON = "Cameroon";
	static final String ETHOPIA = "Ethiopia";
	static final String MOROCCO = "Morocco";
	static final String MOZAMBIQUE = "Mozambique";
	static final String UGANDA = "Uganda";
	
	@Override
	public void readCSV() {

		List<Record> recordList = readRecordFromCSV("C:\\Users\\SHILADITYA\\Documents\\Planet payment\\test_file_2.csv");

		for(Record r : recordList) {
			System.out.println(r);
		}
	}

	private List<Record> readRecordFromCSV(String fileName) {
		
		List<Record> recordList = new ArrayList<>();
		Path pathToFile = Paths.get(fileName);
		
		// create an instance of BufferedReader
		// using try with resource, Java 7 feature to close resources 
		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
		
			//read the first line from the csv file
			String line = br.readLine();
			
			while(line != null) {
				// use string.split to load a string array with the values from
				// each line of the file, using a comma as the delimiter
				String[] attributes = line.split(",");
				
				Record record = createRecord(attributes);
				
				//adding the record into the recordList
				recordList.add(record);
				
				// read next line before looping
				// if end of file reached, line would be null
				line = br.readLine();
				
			}
		}
			catch (IOException ioe) {
			     ioe.printStackTrace();
			}
			
		return recordList;
	}

	private Record createRecord(String[] metadata) {

		String id = metadata[0];
		String mailId = metadata[1];
		String phoneNo = metadata[2];
		BigDecimal parcelWeight = new BigDecimal(metadata[3]);
		StringBuffer country = new StringBuffer();
		
		if(phoneNo.matches(CAMEROON_REGEX)) {
			country.append(CAMEROON);
		} else if(phoneNo.matches(ETHIOPIA_REGEX)) {
			country.append(ETHIOPIA_REGEX);
		} else if(phoneNo.matches(MOROCCO_REGEX)) {
			country.append(MOROCCO);
		} else if(phoneNo.matches(MOZAMBIQUE_REGEX)) {
			country.append(MOZAMBIQUE);
		} else if(phoneNo.matches(UGANDA_REGEX)) {
			country.append(UGANDA);
		} else {
			country.append("");
		}
		
		//create and return record of this metadata
		return new Record(id, mailId, phoneNo, parcelWeight, country.toString());
	}
}
