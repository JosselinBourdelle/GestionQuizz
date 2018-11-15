package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.exception.SupprimerQuestionException;
import fr.diginamic.model.QuestionDao;

public class SupprimerQuestionsService extends MenuService {

	@Override
	public void executeUC(Scanner questionUser, QuestionDao questions) throws SupprimerQuestionException{
		// TODO Auto-generated method stub
		System.out.println("**** Supprimer une Question ****");
		
		System.out.println("Veuillez choisir le numéro de la question à supprimer : ");
		
		/*
		if(!questions.findAll().isEmpty()) {
			int a = 100;
			while (a>questions.findAll().size()) {
				a = questionUser.nextInt();
				if(a>questions.findAll().size()) {
					System.out.println("la question n'existe pas réessayez...");
				}
			}
			questions.delete(a-1);
		}*/
		
		int a = questionUser.nextInt();
		if(a>questions.findAll().size()) {
			throw new SupprimerQuestionException("la question n'existe pas");
		}
		
	}



}
