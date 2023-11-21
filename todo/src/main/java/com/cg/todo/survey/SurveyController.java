package com.cg.todo.survey;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SurveyController {
	
	private SurveyService surveyservice;
			
	public SurveyController(SurveyService surveyservice) {
		super();
		this.surveyservice = surveyservice;
	}

	@RequestMapping("/surveys")
	public List<Survey> retrieveAllSurveys(){
		return surveyservice.retrieveAllSurveys();
	}
	
	@RequestMapping("/surveys/{surveyId}")
	public Survey retrieveSurvey(@PathVariable String surveyId){
		Survey survey = surveyservice.retrieveSurveyById(surveyId);
		if(survey == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return survey;
	}
	
	@RequestMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveAllSurveyQuestions(@PathVariable String surveyId){
		List<Question> questions = surveyservice.retrieveAllSurveyQuestions(surveyId);
		if(questions == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}		
		return questions;
	}
	
	@RequestMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveSpecificSurveyQuestions(@PathVariable String surveyId, @PathVariable String questionId){
		Question question = surveyservice.retrieveSpecificSurveyQuestions(surveyId, questionId);
		if(question == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}		
		return question;
	}
	
	@PostMapping("/surveys/{surveyId}/questions")
	public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String surveyId, @RequestBody Question question){
		 String questionId = surveyservice.addNewSurveyQuestion(surveyId, question);
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/questionId").buildAndExpand(questionId).toUri();
		 return ResponseEntity.created(location).build();	
	}

}
