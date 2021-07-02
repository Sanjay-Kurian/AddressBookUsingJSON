package com.bridgelabz.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AddressBookUC3 {
	public static void main(String[] args) {
		JSONObject contact1 = new JSONObject();
		contact1.put("FirstName", "Abhishek");
		contact1.put("LastName", "Rajaram");
		contact1.put("Address", "MLARoad");
		contact1.put("City", "Chennai");
		contact1.put("State", "Tamilnadu");
		contact1.put("Zip", "600020");
		contact1.put("Phone", "8493028432");
		contact1.put("email", "abhi@gmail.com");
		
		JSONObject contact2 = new JSONObject();
		contact2.put("FirstName", "Ananth");
		contact2.put("LastName", "Sai");
		contact2.put("Address", "PatelRoad");
		contact2.put("City", "Mumbai");
		contact2.put("State", "Maharashtra");
		contact2.put("Zip", "743837");
		contact2.put("Phone", "8493233232");
		contact2.put("email", "ananth@gmail.com");
		
		JSONObject contactObject1 = new JSONObject();
		contactObject1.put("contact", contact1);
		JSONObject contactObject2 = new JSONObject();
		contactObject2.put("contact", contact2);
		
		JSONArray contactArray = new JSONArray();
		contactArray.add(contactObject1);
		contactArray.add(contactObject2);
		
		try (FileWriter file = new FileWriter("E:\\AddressBook.json")) {
			file.write(contactArray.toJSONString());
			file.flush();
		}
		
		catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("----------------Data added to Json File SuccessFully --------------------------");
	
		JSONParser jsonParser = new JSONParser();
		
		try (FileReader reader = new FileReader("E://AddressBook.json")) {
			Object obj = jsonParser.parse(reader);
			
			JSONArray contactArray1 = (JSONArray) obj;
			System.out.println(contactArray1);
			System.out.println("-------Before deletion--------");
			for (Object element : contactArray1) {
				JSONObject jsonObject = (JSONObject) element;
				System.out.println("=====================::"+jsonObject.get("contact"));

				JSONObject jsonObject1 = (JSONObject) jsonObject.get("contact");
				String name = (String) jsonObject1.get("FirstName");
				System.out.println("=====================::"+name);

			}
			System.out.println("-------After deletion----------");
			contactArray1.remove(0);
			for (Object element : contactArray1) {
				JSONObject jsonObject = (JSONObject) element;
				System.out.println("=====================::"+jsonObject.get("contact"));

				JSONObject jsonObject1 = (JSONObject) jsonObject.get("contact");
				String name = (String) jsonObject1.get("FirstName");
				System.out.println("=====================::"+name);

			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
	     } catch (IOException e) {
	     	e.printStackTrace();
	     } catch (ParseException e) {
	        e.printStackTrace();
	     }
	}
}
