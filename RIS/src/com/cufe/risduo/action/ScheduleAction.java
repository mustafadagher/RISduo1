package com.cufe.risduo.action;

import java.util.ArrayList;
import java.util.List;

import com.cufe.risduo.model.Resource;
import com.cufe.risduo.service.ScheduleService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ScheduleAction extends ActionSupport implements ModelDriven<Resource>{
	
	private Resource resource =  new Resource();
	private List<Resource> resources =  new ArrayList<Resource>();
	private String json = new String();
	private String evJson = new String();
	
	
	public void validate (){
		
	}
	
	public String execute() {
		return SUCCESS;
	}
	
	public String getScheduleResources(){
	
		ScheduleService scheduleService= new ScheduleService();
		String resourcesJson= scheduleService.getResourcesJson();
		setJson(resourcesJson);
		
		return INPUT;
	}

	public String getScheduleEvents(){
		
		ScheduleService scheduleService= new ScheduleService();
		String eventsJson= scheduleService.getEventsJson();
		setEvJson(eventsJson);
		
		return INPUT;
	}
	
	public String view(){
		
		ScheduleService scheduleService= new ScheduleService();
		String resourcesJson= scheduleService.getResourcesJson();
		setJson(resourcesJson);
		
		String eventsJson = scheduleService.getEventsJson();
		setEvJson(eventsJson);
		
		return INPUT;
	}
	

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	@Override
	public Resource getModel() {
		
		return resource;
	}

	public String getEvJson() {
		return evJson;
	}

	public void setEvJson(String evJson) {
		this.evJson = evJson;
	}

}
