import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Client implements ActionListener{
	static GUI gui;
	String data;
	static DataOutputStream out;
	static HttpURLConnection conn;
	public  Client(GUI g) {
		try {
			System.out.println("in the client");

			
			
			// build a string that contains JSON from console
			//String content = "";
			//content = getJSON();
			
			gui = g;//new GUI();

			// write out string to output buffer for message
			/*
			 * the following should all be handled within the listener below
			 */
//			out.writeBytes(content);
//			out.flush();
//			out.close();
//			System.out.println("Done sent to server");

//			InputStreamReader inputStr = new InputStreamReader(conn.getInputStream());
//
//			// string to hold the result of reading in the response
//			StringBuilder sb = new StringBuilder();
//
//			// read the characters from the request byte by byte and build up
//			// the Response
//			int nextChar;
//			while ((nextChar = inputStr.read()) > -1) {
//				sb = sb.append((char) nextChar);
//			}
//			System.out.println("Return String: " + sb);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void actionPerformed(ActionEvent e){
		//add// Client will connect to this location
		URL site = null;
		try {
			site = new URL("http://localhost:8000/sendresults");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn = (HttpURLConnection) site.openConnection();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		// now create a POST request
		try {
			conn.setRequestMethod("POST");
		} catch (ProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		conn.setDoOutput(true);
		conn.setDoInput(true);
		//DataOutputStream out = new DataOutputStream(conn.getOutputStream());
		try {
			out = new DataOutputStream(conn.getOutputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
		if(e.getSource()==gui.Add){
			data =add(gui.Ln.getText(), gui.Fn.getText(), gui.Cp.getText(), gui.de.getText(), gui.group.getSelection().getActionCommand(), (String)gui.combo.getSelectedItem());
			out.writeBytes(data);
			out.flush();
			System.out.println("Done sent to server\n" + data +"\n" );
		}
		//clear
		else if(e.getSource() == gui.Cle){
			data = "CLEAR";
			out.writeBytes(data);
			out.flush();
			//out.close();
			System.out.println("Done sent to server\n" + data +"\n");
		}
		//print
		else if(e.getSource()==gui.Prt){
			data = "PRINT";
			out.writeBytes(data);
			out.flush();
			//out.close();
			System.out.println("Done sent to server\n" + data + "\n");
		}
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
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		conn.disconnect();
	}
	
	public String add(String LastName, String FirstName, String Phone, String Department,String Gender, String Title){
		Employee employee = new Employee(LastName, FirstName, Phone, Department, Gender, Title);
		Gson g = new Gson();
		String json = g.toJson(employee);
		String addS = "ADD ";
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
