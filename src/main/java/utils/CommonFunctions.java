package utils;

public class CommonFunctions {
	
	/**
	 * This method for getting the data from the hash map and returns the value
	 * 
	 * @param Name It is the name of the column
	 * @return
	 * @throws Exception
	 */
	public static String getdata(String Name) throws Exception {

		String data = "";
		if (ExcelReader.hashmap().containsKey(Name)) {
			data = ExcelReader.hashmap().get(Name);
		} else {
			System.out.println("Given Column name is not available in the Excel " + Name);
		}
		return data;

	}


}
