package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.model.QuestionDao;

public class SupprimerQuestionsService extends MenuService {

	@Override
	public void executeUC(Scanner questionUser, QuestionDao questions) {
		// TODO Auto-generated method stub
		System.out.println("**** Supprimer une Question ****");
		
		System.out.println("Veuillez choisir le numéro de la question à supprimer : ");
		
		
		if(!questions.findAll().isEmpty()) {
			int a = 100;
			while (a>questions.findAll().size()) {
				a = questionUser.nextInt();
				if(a>questions.findAll().size()) {
					System.out.println("la question n'existe pas réessayez...");
				}
			}
			questions.delete(a-1);
		}
	}



}
