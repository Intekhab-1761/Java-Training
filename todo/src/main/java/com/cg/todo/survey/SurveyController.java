package com.cg.todo.survey;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
		Survey survey = surveyservice.retrieveSurvey(surveyId);
		if(survey == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return survey;
	}

}
