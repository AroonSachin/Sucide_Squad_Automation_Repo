package ExcelRunner;


import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import commonuseractions.CommonActionMethods;

public class getValueInJson extends CommonActionMethods {
	
	
	@Test
	public void getValue() {
		String jsonSring = "{"+
			    "data : ["+
		        "{"+
		            "id : 1,"+
		            "Name : Choc Cake,"+
		            "Image : 1.jpg,"+
		            "Category : Meal,"+
		            "Method: meth1 ,"+
		            "Ingredients : ["+
		                "{"+
		                    "name : 1 Cup Ice"+
		                "},"+
		                "{"+
		                    "name : 1 Bag Beans"+
		                "}"+
		            "]"+
		        "},"+
		        "{"+
		            "id : 2,"+
		            "Name : Ice Cake,"+
		            "Image :  dfdsfdsfsdfdfdsf,"+
		            "Category : Meal,"+
		            "Method : meth,"+
		            "Ingredients : ["+
		                "{"+
		                    "name :  1 Cup Ice"+
		                "}"+
		            "]"+
		        "}"+
		    "]"+
		"}";
		
		JSONObject jsonObj = new JSONObject(jsonSring);		
		getValuesFromArray(jsonObj);
		
	}
	
	
	public Object getValuefromJson(JSONObject json,String key) {
		
		return json.get(key);
		
	}
	
	public void getValuesFromArray(JSONObject jsonStr) {
		System.out.println((jsonStr.toString()));
		JSONArray ja_data = jsonStr.getJSONArray("data");
		int length = ja_data.length();
		for(int i=0; i<length; i++){
		    JSONObject jObj = ja_data.getJSONObject(i);
		    JSONArray ja = jObj.getJSONArray("Ingredients");
		    int len = ja.length();
		    ArrayList<String> Ingredients_names = new ArrayList<>();
		    for(int j=0; j<len; j++){
		        JSONObject json = ja.getJSONObject(j);
		        System.out.println(json.toString());
		    }
		}
	}

}
