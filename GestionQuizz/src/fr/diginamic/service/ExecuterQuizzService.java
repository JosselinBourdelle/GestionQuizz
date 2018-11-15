package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.model.QuestionDao;
import fr.diginamic.model.TypeQuestion;

public class ExecuterQuizzService extends MenuService {

	@Override
	public void executeUC(Scanner questionUser, QuestionDao questions) {
		// TODO Auto-generated method stub
		int score = 0;
		for (int i = 0 ; i<questions.findAll().size() ; i++) {
			System.out.println(questions.findAll().get(i).intitule);
			int nbrMax = questions.findAll().get(i).nombreMaxPropositions;
			for (int j = 0 ; j<nbrMax  ; j++) {
				System.out.println((j+1)+ ") " + questions.findAll().get(i).propositions.get(j));
			}
			System.out.println(" quelle est la bonne réponse ?");
			int a = 100;
			while (a>nbrMax) {
				a = questionUser.nextInt();
				if(a>nbrMax) {
					System.out.println("la réponse n'existe pas réessayez...");
				}
			}
			if(questions.findAll().get(i).propositions.get(a-1).equals(questions.findAll().get(i).bonneReponse)) {
				System.out.println("bonne réponse");
				if(questions.findAll().get(i).type.equals(TypeQuestion.BONUS)) {
					score += 2;
				}
				else {
					score++;
				}
				
			}
			else {
				System.out.println("Mauvaise réponse");
			}
		}
		System.out.println("vous avez un score de : " + score);
		
	}

}
