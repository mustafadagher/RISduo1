package com.cufe.risduo.action;

import com.cufe.risduo.service.TutorialFinderService;

public class TutorialAction {
	
	private String bestTutorial;
	private String language;
	
	public String execute(){
		TutorialFinderService tutorialFinderService = new TutorialFinderService();
		setBestTutorial(tutorialFinderService.getBestTutorialSite(getLanguage()));
		System.out.println(getLanguage());
		System.out.println(bestTutorial);
		return "success";
	}
	public String getTutorial(){
		TutorialFinderService tutorialFinderService = new TutorialFinderService();
		setBestTutorial(tutorialFinderService.getBestTutorialSite(getLanguage()));
	/*	System.out.println(getLanguage());
		System.out.println(bestTutorial);*/
		System.out.println("getTutorial Method called");
		return "success";
	}
	public String addTutorial(){
		TutorialFinderService tutorialFinderService = new TutorialFinderService();
		setBestTutorial(tutorialFinderService.getBestTutorialSite(getLanguage()));
		/*System.out.println(getLanguage());
		System.out.println(bestTutorial);*/
		System.out.println("addTutorial method called");
		return "success";
	}
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getBestTutorial() {
		return bestTutorial;
	}
	public void setBestTutorial(String bestTutorial) {
		this.bestTutorial = bestTutorial;
	}
}
