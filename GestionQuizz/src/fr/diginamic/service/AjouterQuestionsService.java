package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.exception.AjouterQuestionException;
import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionDao;
import fr.diginamic.model.TypeQuestion;

public class AjouterQuestionsService extends MenuService {

	@Override
	public void executeUC(Scanner questionUser, QuestionDao questions) throws AjouterQuestionException {
		// TODO Auto-generated method stub
		System.out.println("** Ajouter Nouvelle Question  **");
		
		String intitule	= "";
		int nombreQuestion = 0;
		String[] propositions;
		int numéroBonneRéponse;
		
		System.out.println("Quelle type de question voulez vous ajouter ?");
		System.out.println(" 1) simple");
		System.out.println(" 2) bonus");	
		String t;
		do {
			t = questionUser.nextLine();
			if(!(t.equals("1") || t.equals("2"))) {
				System.out.println("Veuillez saisir 1 ou 2...");
			}
		}
		while (!(t.equals("1") || t.equals("2")));		
		
		System.out.println("Veuillez saisir l’intitulé de la question : ");
		String a = questionUser.nextLine();
		System.out.println("Veuillez saisir le nombre de questions : ");
		
		String nombreEntrer;

		do {
			nombreEntrer = questionUser.nextLine();
			if(!nombreEntrer.matches("[0-9]*")) {
				System.out.println("Vous n'avez pas entré un nombre");
			}
		}
		while (!nombreEntrer.matches("[0-9]*"));
		
		int b = Integer.parseInt(nombreEntrer);
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
	
		Question question = new Question(((t.equals("1"))?TypeQuestion.SIMPLE: TypeQuestion.BONUS),a, b);
		question.bonneReponse = propositions[d-1];
		for (int i = 0 ; i<b ; i++) {
			question.propositions.add(propositions[i]);
		}
		questions.save(question);
	}



}
