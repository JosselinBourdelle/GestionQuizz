package fr.diginamic.console;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.sun.javafx.property.adapter.PropertyDescriptor.Listener;

import fr.diginamic.exception.AjouterQuestionException;
import fr.diginamic.exception.StockageException;
import fr.diginamic.exception.SupprimerQuestionException;
import fr.diginamic.model.Question;
import fr.diginamic.model.QuestionMemDao;
import fr.diginamic.service.AjouterQuestionsService;
import fr.diginamic.service.ExecuterQuizzService;
import fr.diginamic.service.ListerQuestionsService;
import fr.diginamic.service.SupprimerQuestionsService;

public class QuizzAdminConsoleApp {

	private static Scanner questionUser = new Scanner(System.in);
	public static QuestionMemDao questions = new QuestionMemDao();
	public static AjouterQuestionsService ajout = new AjouterQuestionsService();
	public static ExecuterQuizzService executerQuizz = new ExecuterQuizzService();
	public static SupprimerQuestionsService supprimer = new SupprimerQuestionsService();
	public static ListerQuestionsService lister = new ListerQuestionsService();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			lister.executeUC(questionUser, questions);
			menuPrincipal();
			break;
		case 2:
			try {
				ajout.executeUC(questionUser, questions);
			} catch (StockageException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			menuPrincipal();
			break;
		case 3:
			try {
				supprimer.executeUC(questionUser, questions);
			} catch (SupprimerQuestionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			menuPrincipal();
			break;
		case 4:
			executerQuizz.executeUC(questionUser, questions);
			menuPrincipal();
			break;
		case 99:
			System.out.println("Sortir");
			break;
		}
	}
	
	public static void remplissageQuestion() {
		Question question1 = new Question ("1Quelle est la capitale de la france ?", 4);
		question1.addPropositions("paris");
		question1.addPropositions("nantes");
		question1.addPropositions("berlin");
		question1.addPropositions("New York");
		question1.bonneReponse = "nantes";
		questions.save(question1);
		
		Question question2 = new Question ("2Quelle est la capitale de la france ?", 4);
		question2.addPropositions("paris");
		question2.addPropositions("nantes");
		question2.addPropositions("berlin");
		question2.addPropositions("New York");
		question2.bonneReponse = "nantes";
		questions.save(question2);
		
		Question question3 = new Question ("3Quelle est la capitale de la france ?", 4);
		question3.addPropositions("paris");
		question3.addPropositions("nantes");
		question3.addPropositions("berlin");
		question3.addPropositions("New York");
		question3.bonneReponse = "nantes";
		questions.save(question3);
	}

}
