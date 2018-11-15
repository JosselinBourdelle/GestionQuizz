package fr.diginamic.model;

import java.util.List;

public interface QuestionDao {
	List<Question> findAll();
	void save(Question question);
	void delete(int numéroQuestion);
	
	
}