package utils;

import java.util.HashMap;
import java.util.Map;


	


public class CommonActions  {
	public static ThreadLocal<Map<String, String>> inputdata = ThreadLocal.withInitial(() -> {
		Map<String, String> map = new HashMap<>();

		return map;
	});

	public static Map<String, String> getInputData() {
		return inputdata.get();
	}


	/**
	 * This method for getting the data from the hash map and returns the value
	 * 
	 * @param Name It is the name of the column
	 * @return
	 * @throws Exception
	 */
	public static String getdata(String Name) throws Exception {

		String data = "";
		if (inputdata.get().containsKey(Name)) {
			data = inputdata.get().get(Name);
		} else {
			System.out.println("Given Column name is not available in the Excel " + Name);
		}
		return data;

	}

}
