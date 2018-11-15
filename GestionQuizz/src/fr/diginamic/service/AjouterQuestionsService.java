package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.exception.AjouterQuestionException;
import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDao;

public class AjouterQuestionsService extends MenuService {

	@Override
	public void executeUC(Scanner questionUser, QuestionDao questions) throws AjouterQuestionException {
		// TODO Auto-generated method stub
		System.out.println("** Ajouter Nouvelle Question  **");
		
		String intitule	= "";
		int nombreQuestion = 0;
		String[] propositions;
		int numéroBonneRéponse;
			
		System.out.println("Veuillez saisir l’intitulé de la question : ");
		questionUser.nextLine();
		String a = questionUser.nextLine();
		System.out.println("Veuillez saisir le nombre de questions : ");
		
		int b = Integer.parseInt(questionUser.nextLine());
		propositions = new String[b];
		
		for (int i = 0 ; i<b ; i++) {
			System.out.println("Veuillez saisir la proposition de réponse n°" + (i+1) + " :");
			String c = questionUser.nextLine();
			propositions[i] = c;
		}
		System.out.println("Veuillez saisir le numéro de la bonne réponse (entre 1 et " + b + ") :");
		
		int d = Integer.parseInt(questionUser.nextLine());
		if (d > b) {
			throw new AjouterQuestionException(" la nombre donner dépasse le nombre de réponse");
		}
	
		Question question = new Question(a, b);
		question.bonneReponse = propositions[d-1];
		for (int i = 0 ; i<b ; i++) {
			question.propositions.add(propositions[i]);
		}
		questions.save(question);
	}



}
