package com.cufe.risduo.action;

import java.util.ArrayList;
import java.util.List;

import com.cufe.risduo.model.Procedure;
import com.cufe.risduo.model.Resource;
import com.cufe.risduo.service.ProcedureService;
import com.cufe.risduo.service.ScheduleService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProcedureAction extends ActionSupport implements ModelDriven<Procedure>{
	
	private Procedure procedure =  new Procedure();
	private List<Procedure> procedures =  new ArrayList<Procedure>();
	
	
	
	public void validate (){
		
	}
	
	public String execute() {
		return SUCCESS;
	}
	
	public String listProcedures(){
	
		ProcedureService procedureService = new ProcedureService();
		setProcedures(procedureService.searchProcedures());
		System.out.println(getProcedures());
		return INPUT;
	}

	

	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	public List<Procedure> getProcedures() {
		return procedures;
	}

	public void setProcedures(List<Procedure> procedures) {
		this.procedures = procedures;
	}

	@Override
	public Procedure getModel() {
		
		return procedure;
	}

}
