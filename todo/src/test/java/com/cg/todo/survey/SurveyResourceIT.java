package com.cg.todo.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyResourceIT {

	private static String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question1";
	private static String GENERIC_QUESTION_URL = "/surveys/Survey1/questions";

	// http://localhost:RANDOM_PORT/surveys/survey1/questions/Question1
	@Autowired
	TestRestTemplate template;

	String str = """
			{
			"id" = Question1,
			"description" = "Most popular cloud platform today.",
			"options":[
			"AWS",
			"Azure",
			"Google Cloud",
			"Oracle Cloud"
			],
			"correctAnswer": "AWS"
			}
			""";

	@Test
	void retrieveSpecificSurveyQuestion_basicscenario() throws JSONException {
		ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);

		String expectedResponse = """
				{
				"id":"Question1",
				"description":"Most Popular Cloud Platform Today",
				"options":["AWS","Azure","Google Cloud","Oracle Cloud"],
				"correctAnswers":"AWS"}
				""";

		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json",responseEntity.getHeaders().get("Content-Type").get(0));
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);

	}
	@Test
	void retrieveAllSurveyQuestions_basicScenario() throws JSONException {
		
		ResponseEntity<String> responseEntity = template.getForEntity(GENERIC_QUESTION_URL, String.class);

		
		String expectedResponse = 
				"""
				[
				    {
				        "id": "Question1"
				    },
				    {
				        "id": "Question2"
				    },
				    {
				        "id": "Question3"
				    },
				    {
				        "id": "706090938"
				    }
				]
				""";
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json",responseEntity.getHeaders().get("Content-Type").get(0));
		JSONAssert.assertEquals(expectedResponse, responseEntity.getBody(), false);
	}
	
	@Test
	void AddAllSurveyDetails_basicScenario() {
		
		String requestBody = """
				{
	        "description": "Most Used Cloud Platform ",
	        "options": [
	            "AWS",
	            "Azure",
	            "Google Cloud",
	            "Oracle Cloud"
	        ],
	        "correctAnswers": "Google Cloud"
	    }
				""";
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		HttpEntity<String> httpEntity = new HttpEntity<String>(requestBody,headers);
		ResponseEntity<String> responseEntity =
				template.exchange(GENERIC_QUESTION_URL, HttpMethod.POST, httpEntity,String.class);
		System.out.println(responseEntity.getHeaders());
	
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		
	}
}
