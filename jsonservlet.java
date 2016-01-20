package com.hmkcode.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

 
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmkcode.vo.Person;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//changes to servelet file



public class jsonservlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	int val1;
	int val2;
	int val3;
	// This will store all received articles
	List<Person> persons = new LinkedList<Person>();
	 
	/***************************************************
	 * URL: /jsonservlet
	 * doPost(): receives JSON data, parse it, map it and send back as JSON
	 ****************************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException{
	    
		// 1. get received JSON data from request
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String json = "";
		if(br != null){
			json = br.readLine();
		}
		
		// 2. initiate jackson mapper
    	ObjectMapper mapper = new ObjectMapper();
    	
    	// 3. Convert received JSON to Article
    	Person person = mapper.readValue(json, Person.class);

		// 4. Set response type to JSON
		response.setContentType("application/json");		    
    	
    	// 5. Add article to List<Article>
		if(persons.size() > 20)
			persons.remove(0);
		
		persons.add(person);

		 val1 = Integer.parseInt(person.getName());
		//int val1 = (integer)person.getName();
		 val2 = Integer.parseInt(person.getCountry());
		 val3 = Integer.parseInt(person.getTwitter());

		int result = val1+val2+val3;

		person.setResult(result);

		// 6. Send List<Article> as JSON to client
    	mapper.writeValue(response.getOutputStream(), result);
		//mapper.writeValue("name":"2","country":"2","twitter":"2"},{"name":"2","country":"2","twitter":"3");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
    	
		//2. initiate jackson mapper
		ObjectMapper mapper = new ObjectMapper();
		

		// 4. Set response type to JSON
		resp.setContentType("application/json");		    
    	

		// 6. Send List<Article> as JSON to client
    	mapper.writeValue(resp.getOutputStream(), "server is started   "+
				" value 1 ="+val1+" value 2 ="+val2+" value 3 ="+val3);
	}
}
