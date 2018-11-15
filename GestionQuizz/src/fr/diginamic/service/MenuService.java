package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.model.QuestionDao;

public abstract class MenuService {

	abstract void executeUC(Scanner questionUser, QuestionDao questions);
	
}
