import java.awt.event.ActionEvent;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Client {
	static GUI gui;
	String data;
	static DataOutputStream out;
	public static void main(String[] args) {
		try {
			System.out.println("in the client");

			// Client will connect to this location
			URL site = new URL("http://localhost:8000/sendresults");
			HttpURLConnection conn = (HttpURLConnection) site.openConnection();

			// now create a POST request
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			//DataOutputStream out = new DataOutputStream(conn.getOutputStream());
			out = new DataOutputStream(conn.getOutputStream());
			
			// build a string that contains JSON from console
			//String content = "";
			//content = getJSON();
			
			gui = new GUI();

			// write out string to output buffer for message
//			out.writeBytes(content);
//			out.flush();
//			out.close();

//			System.out.println("Done sent to server");

			InputStreamReader inputStr = new InputStreamReader(conn.getInputStream());

			// string to hold the result of reading in the response
			StringBuilder sb = new StringBuilder();

			// read the characters from the request byte by byte and build up
			// the Response
			int nextChar;
			while ((nextChar = inputStr.read()) > -1) {
				sb = sb.append((char) nextChar);
			}
			System.out.println("Return String: " + sb);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e){
		//add
		if(e.getSource()==gui.buttonAdd){
			data =add(gui.getLastName(), gui.getFirstName(), gui.getPhone(), gui.getDept(), gui.getGender(), gui.getTitle());
			out.writeBytes(data);
			out.flush();
			out.close();
			System.out.println("Done sent to server");
		}
		//clear
		else if(e.getSource() == gui.buttonClear){
			data = "CLEAR";
			out.writeBytes(data);
			out.flush();
			out.close();
			System.out.println("Done sent to server");
		}
		//print
		else{
			data = "PRINT";
			out.writeBytes(data);
			out.flush();
			out.close();
			System.out.println("Done sent to server");
		}
	}
	
	public String add(String LastName, String FirstName, String Phone, String Department,String Gender, String Title){
		Employee employee = new Employee(LastName, FirstName, Phone, Department, Gender, Title);
		Gson g = new Gson();
		String json = g.toJson(employee);
		String addS = "ADD";
		addS+=json;
		
		return addS;
		
	}
	
	public void close(){
		
	}

//	private static String getJSON() {
//
//		ArrayList<Employee> em = new ArrayList<>();
//		em.add(new Employee("Eric", "Fritz", "Computer Science", "1"));
//		em.add(new Employee("Tanawat", "Khun", "Computer Science", "2"));
//		em.add(new Employee("Foo", "Bar", "Baz", "3"));
//		em.add(new Employee("Donald", "Duck", "Disney Animals", "4"));
//		Employee employee = new Employee(null, null, null, null, null, null);
//		Gson g = new Gson();
//		String json = g.toJson(employee);
//		return json;
//	}

}
