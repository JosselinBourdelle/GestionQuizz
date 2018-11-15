package fr.diginamic.service;

public class MenuServiceFactory {

	public static MenuService getMenuService(int choix) {
		switch(choix) {
		case 1:
			return new ListerQuestionsService();
		case 2:
			return new AjouterQuestionsService();
		case 3:
			return new SupprimerQuestionsService();
		case 4:
			return new ExecuterQuizzService();
		case 99:
			return new SortieQuestionsService();
		default :
			return null;
		}
	}
	
}
