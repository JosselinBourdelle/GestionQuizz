package fr.diginamic.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionMemDao implements QuestionDao{

	private static List<Question> listDesQuestions = new ArrayList<Question>();
	
	@Override
	public List<Question> findAll() {
		// TODO Auto-generated method stub
		return listDesQuestions;
	}

	@Override
	public void save(Question question) {
		// TODO Auto-generated method stub
		listDesQuestions.add(question);
	}

	@Override
	public void delete(int numéroQuestion) {
		// TODO Auto-generated method stub
		listDesQuestions.remove(numéroQuestion);
	}

}
