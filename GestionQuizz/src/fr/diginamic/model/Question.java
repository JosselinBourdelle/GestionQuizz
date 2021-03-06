package fr.diginamic.model;

import java.util.ArrayList;
import java.util.List;

public class Question {
	public String intitule;
	public List<String> propositions;
	public String bonneReponse;
	public int nombreMaxPropositions;
	public TypeQuestion type;
	
	public Question(TypeQuestion type, String question, int nombreDeReponse) {
		this.type = type;
		this.intitule = question;
		propositions = new ArrayList<String>();
		nombreMaxPropositions = nombreDeReponse;
	}
	
	public boolean verifierReponse(String reponsePropose) {
		return reponsePropose.equals(bonneReponse);
	}
	
	public void addPropositions(String nouvellePropositions) {
		if (propositions.size()<nombreMaxPropositions) {
			propositions.add(nouvellePropositions);
		}
	}
	
}
