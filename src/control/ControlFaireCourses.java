package control;

import elements.ListeAliments;

public class ControlFaireCourses {
	private ListeAliments placard;
	private ListeAliments listeCourses;
	
	public ControlFaireCourses(ListeAliments placard, ListeAliments listeCourses) {
		this.placard = placard;
		this.listeCourses = listeCourses;
	}
	
	public void faireCourses() {
		listeCourses.faireCourses(placard);
	}
}
