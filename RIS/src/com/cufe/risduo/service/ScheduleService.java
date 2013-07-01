package com.cufe.risduo.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cufe.risduo.dao.ReservationDaoImpl;
import com.cufe.risduo.dao.RoomDaoImpl;
import com.cufe.risduo.model.Event;
import com.cufe.risduo.model.Resource;
import com.google.gson.Gson;



public class ScheduleService {
	
	
	
	//should be modified to return a JSON array
	public String getResourcesJson(){
		
		Gson gson = new Gson();
		String resourcesJson;
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RoomDaoImpl dao = ctx.getBean("roomDaoImpl", RoomDaoImpl.class);
		List<Resource> resources = dao.listResources();
		
		resourcesJson = gson.toJson(resources).replace("\"name\"","name").replace("\"id\"", "id");
		
		
<<<<<<< HEAD
		try {
=======
		/*try {
>>>>>>> 2157d334380bcea7e2b98ef6d842c314617ceef7
			//write converted json data to a file named "file.json"
			FileWriter writer = new FileWriter("C:\\Users\\Mustafa\\Documents\\GitHub\\RISduo1\\RIS\\web\\WEB-INF\\json\\resources.json");
			writer.write(resourcesJson);
			writer.close();
			System.out.println("file written at C:\\Users\\Mustafa\\Documents\\GitHub\\RISduo1\\RIS\\web\\WEB-INF\\json");
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
<<<<<<< HEAD
		
=======
	*/	
>>>>>>> 2157d334380bcea7e2b98ef6d842c314617ceef7
		return resourcesJson;
	}
	
public String getEventsJson(){
		
		Gson gson = new Gson();
		String eventsJson;
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ReservationDaoImpl dao = ctx.getBean("reservationDaoImpl", ReservationDaoImpl.class);
		List<Event> events = dao.listEvents();
		
		
		eventsJson = gson.toJson(events).replace("\"title\"","title").replace("\"start\"", "start")
				.replace("\"end\"", "end").replace("\"allDay\"", "allDay")
				.replace("\"resourceId\"", "resourceId").replace("\"color\"", "color")
				.replace("\"textColor\"", "textColor").replace("\"false\"", "false").replace("\"url\"", "url");
		
		
<<<<<<< HEAD
		try {
=======
		/*try {
>>>>>>> 2157d334380bcea7e2b98ef6d842c314617ceef7
			//write converted json data to a file named "file.json"
			FileWriter writer = new FileWriter("C:\\Users\\Mustafa\\Documents\\GitHub\\RISduo1\\RIS\\web\\WEB-INF\\json\\events.json");
			writer.write(eventsJson);
			writer.close();
			System.out.println("file written at C:\\Users\\Mustafa\\Documents\\GitHub\\RISduo1\\RIS\\web\\WEB-INF\\json\\events.json");
	 
		} catch (IOException e) {
			e.printStackTrace();
<<<<<<< HEAD
		}
=======
		}*/
>>>>>>> 2157d334380bcea7e2b98ef6d842c314617ceef7
		
		return eventsJson;
	}
	
}
