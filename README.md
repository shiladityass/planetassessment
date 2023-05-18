# Planet Assessment
Planet Assessment to retrieve csv file

Controller class-->

RecordreadingController: This controller class has the Get methods to:
	-To get the list of orders paginated and with optional filters ○ Per country, per date, and weight limit
	-To get the total number of orders per country
	-To get the total weight of orders per country
	
Service Class-->
	CsvFileHandler:-- It is a interface to provide the readCSV method.
	
	ReadInputFileService:-- This class implements the interface CsvFileHandler. It reads the csv file from a location, access each line of data and then split by 		",". With each splitted value it then creates a metadata and saves id, mailId, phoneNo and parcelWeight. It calculates the country based on the regex:
	
	1. Cameroon | Country code: +237 | Regex = \(237\)\ ?[2368]\d{7,8}$
	2. Ethiopia  | Country code: +251 |  Regex = \(251\)\ ?[1-59]\d{8}$
	3. Morocco | Country code: +212 | Regex = \(212\)\ ?[5-9]\d{8}$
	4. Mozambique  | Country code: +258 | Regex = \(258\)\ ?[28]\d{7,8}$
	5. Uganda | Country code: +256 | Regex = \(256\)\ ?\d{9}$
	
	All the 5 atrributes are then Record object. All the records are saved in a List<Record>. This list is passed to the StoreData class.
	
	StoreData:-- This class connects to the database and inserts the all the List<Record> received from ReadInputFileService into the DB. Created batch execution 		to insert the records. It executes 100 records per batch to improvise the execution speed.
	
	Record:-- This class has all the attributes declared to store id, mailId, phoneNo and parcelWeight.
 	
