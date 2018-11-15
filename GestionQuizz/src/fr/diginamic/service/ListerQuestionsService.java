package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.model.QuestionDao;

public class ListerQuestionsService extends MenuService {

	@Override
	public void executeUC(Scanner questionUser, QuestionDao questions) {
		// TODO Auto-generated method stub
		System.out.println("***** Liste des Questions  *****");
		if (questions.findAll().size()!=0) {
			for (int i = 0 ; i<questions.findAll().size() ; i++) {
				System.out.println((i+1)+ ") " + questions.findAll().get(i).intitule);
				for (int j = 0 ; j< questions.findAll().get(i).nombreMaxPropositions ; j++) {
					System.out.println(" - " + questions.findAll().get(i).propositions.get(j));
				}
			}
		}
	}



}
