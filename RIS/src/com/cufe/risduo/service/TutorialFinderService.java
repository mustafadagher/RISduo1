package com.cufe.risduo.service;

public class TutorialFinderService {

	public String getBestTutorialSite(String language){
		if (language.equals("java"))
			return "java brains";
		else
			return "Not supported!";
	}
}
