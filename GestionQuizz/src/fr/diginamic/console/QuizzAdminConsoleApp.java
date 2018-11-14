package fr.diginamic.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.model.Question;

public class QuizzAdminConsoleApp {

	private static Scanner questionUser = new Scanner(System.in);
	public static List<Question> listDesQuestions;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listDesQuestions = new ArrayList();
		remplissageQuestion();
		menuPrincipal();
		
	}
	
	public static void menuPrincipal() {
		System.out.println("********************************");
		System.out.println("***** Quizz Administration *****");
		System.out.println("1. Lister les questions");
		System.out.println("2. Ajouter une nouvelle question");
		System.out.println("3. Supprimer une question");
		System.out.println("4. Exécuter le quizz");
		System.out.println("99. Sortir");
		System.out.println("********************************");
		
		int a = questionUser.nextInt() ;
		
		switch (a) {
		case 1:
			listeQuestions();
			break;
		case 2:
			nouvelleQuestion();
			break;
		case 3:
			supprimerQuestion();
			break;
		case 4:
			executionQuizz();
			break;
		case 99:
			System.out.println("Sortir");
			break;
		}
	}
	
	public static void listeQuestions() {
		System.out.println("***** Liste des Questions  *****");
		if (listDesQuestions.size()!=0) {
			for (int i = 0 ; i<listDesQuestions.size() ; i++) {
				System.out.println((i+1)+ ") " + listDesQuestions.get(i).intitule);
				for (int j = 0 ; j< listDesQuestions.get(i).nombreMaxPropositions ; j++) {
					System.out.println(" - " + listDesQuestions.get(i).propositions.get(j));
				}
			}
		}
		menuPrincipal();
	}
	
	public static void nouvelleQuestion() {
		
		System.out.println("** Ajouter Nouvelle Question  **");
		
		String intitule	= "";
		int nombreQuestion = 0;
		String[] propositions;
		int numéroBonneRéponse;
			
		System.out.println("Veuillez saisir l’intitulé de la question : ");
		questionUser.nextLine();
		String a = questionUser.nextLine();
		System.out.println("Veuillez saisir le nombre de questions : ");
		
		int b = questionUser.nextInt();
		propositions = new String[b];
		
		for (int i = 0 ; i<b ; i++) {
			System.out.println("Veuillez saisir la proposition de réponse n°" + (i+1) + " :");
			questionUser.nextLine();
			String c = questionUser.nextLine();
			propositions[i] = c;
		}
		System.out.println("Veuillez saisir le numéro de la bonne réponse (entre 1 et " + b + ") :");
		int d = questionUser.nextInt();
	
		Question question = new Question(a, b);
		question.bonneReponse = propositions[d-1];
		for (int i = 0 ; i<b ; i++) {
			question.propositions.add(propositions[i]);
		}
		listDesQuestions.add(question);
		menuPrincipal();
		
	}
	
	public static void supprimerQuestion() {
		
		System.out.println("**** Supprimer une Question ****");
		
		System.out.println("Veuillez choisir le numéro de la question à supprimer : ");
		
		
		if(!listDesQuestions.isEmpty()) {
			int a = 100;
			while (a>listDesQuestions.size()) {
				a = questionUser.nextInt();
				if(a>listDesQuestions.size()) {
					System.out.println("la question n'existe pas réessayez...");
				}
			}
			listDesQuestions.remove(a-1);
		}
		menuPrincipal();
	}
	
	public static void executionQuizz() {
		int score = 0;
		for (int i = 0 ; i<listDesQuestions.size() ; i++) {
			System.out.println(listDesQuestions.get(i).intitule);
			int nbrMax = listDesQuestions.get(i).nombreMaxPropositions;
			for (int j = 0 ; j<nbrMax  ; j++) {
				System.out.println((j+1)+ ") " + listDesQuestions.get(i).propositions.get(j));
			}
			System.out.println(" quelle est la bonne réponse ?");
			int a = 100;
			while (a>nbrMax) {
				a = questionUser.nextInt();
				if(a>nbrMax) {
					System.out.println("la réponse n'existe pas réessayez...");
				}
			}
			if(listDesQuestions.get(i).propositions.get(a-1).equals(listDesQuestions.get(i).bonneReponse)) {
				System.out.println("bonne réponse");
				score++;
			}
			else {
				System.out.println("Mauvaise réponse");
			}
		}
		System.out.println("vous avez " + score + " bonne(s) réponse(s)");
		menuPrincipal();
	}
	
	public static void remplissageQuestion() {
		Question question1 = new Question ("1Quelle est la capitale de la france ?", 4);
		question1.addPropositions("paris");
		question1.addPropositions("nantes");
		question1.addPropositions("berlin");
		question1.addPropositions("New York");
		question1.bonneReponse = "nantes";
		listDesQuestions.add(question1);
		
		Question question2 = new Question ("2Quelle est la capitale de la france ?", 4);
		question2.addPropositions("paris");
		question2.addPropositions("nantes");
		question2.addPropositions("berlin");
		question2.addPropositions("New York");
		question2.bonneReponse = "nantes";
		listDesQuestions.add(question2);
		
		Question question3 = new Question ("3Quelle est la capitale de la france ?", 4);
		question3.addPropositions("paris");
		question3.addPropositions("nantes");
		question3.addPropositions("berlin");
		question3.addPropositions("New York");
		question3.bonneReponse = "nantes";
		listDesQuestions.add(question3);
	}

}
