package fr.diginamic.service;

import java.util.Scanner;

import fr.diginamic.exception.StockageException;
import fr.diginamic.model.QuestionDao;

public abstract class MenuService {

	public abstract void executeUC(Scanner questionUser, QuestionDao questions) throws StockageException;
	
}
