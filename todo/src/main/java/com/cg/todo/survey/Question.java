package com.cg.todo.survey;

import java.util.List;

public class Question {
	
	public Question() {
		
	}
	
	public Question(String id, String description, List<String> options, String correctAnswers) {
		super();
		this.id = id;
		this.description = description;
		this.options = options;
		this.correctAnswers = correctAnswers;
	}
	
	private String id;
	private String description;
	private List<String> options;
	private String correctAnswers;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String getCorrectAnswers() {
		return correctAnswers;
	}

	public void setCorrectAnswers(String correctAnswers) {
		this.correctAnswers = correctAnswers;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description + ", options=" + options + ", correctAnswers="
				+ correctAnswers + "]";
	}
	
	
	
	
	
	

}
