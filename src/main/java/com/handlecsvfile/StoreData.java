package com.handlecsvfile.mavenproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class StoreData {

	static final String DB_URL = "jdbc:mysql://localhost/mydatabase";
	static final String USER = "root";
	static final String PASS = "password";
	   
	public void storeDataInDatabase(List<Record> recordList) {
		
		String SQL = "INSERT INTO RecordTable(PersonId, MaildId, PhoneNumber, ParcelWeight, Country) "
                		+ "VALUES(?,?,?,?)";
		
		try (
			     Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			     //Creating a Statement object
				 PreparedStatement statement = con.prepareStatement(SQL);) {
			
			int count = 0;

            for (Record r : recordList) {
                statement.setString(1, r.getId());
                statement.setString(2, r.getMailId());
                statement.setString(3, r.getMailId());
                statement.setString(4, r.getPhoneNo());
                statement.setString(5, r.getCountry());

                statement.addBatch();
                count++;
                // execute every 100 rows or less
                if (count % 100 == 0 || count == recordList.size()) {
                    statement.executeBatch();
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
	}
}