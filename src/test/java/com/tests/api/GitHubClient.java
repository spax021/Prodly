package com.tests.api;

import static io.restassured.RestAssured.given;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitHubClient {

	private String token;
    private String owner;
    private String repo;
	private RequestSpecification request;
	private Response response;

    public GitHubClient(String token, String owner, String repo) {
        this.token = token;
        this.owner = owner;
        this.repo = repo;
        startProcess();
    }
	
	//Acquire base URL and setup header
	public void startProcess() {
		RestAssured.baseURI = "https://api.github.com";
		this.request = RestAssured.given();
		this.request.header("Content-Type", "application/json");
	}

	public Response createOrUpdateFileInMainBranch(String filePath, String content, String commitMessage) {
		// First, try to get the SHA of the existing file, if it exists
	    String sha = getShaForFile(filePath);

	    String encodedContent = Base64.getEncoder().encodeToString(content.getBytes(StandardCharsets.UTF_8));
	    
	    Map<String, Object> requestParams = new HashMap<>();
	    requestParams.put("message", commitMessage);
	    requestParams.put("content", encodedContent);

	    // If the file exists and we have its SHA, add it to the request to update the file
	    if (sha != null) {
	        requestParams.put("sha", sha);
	    }

	    Response response = given()
	        .header("Authorization", "token " + token)
	        .contentType(ContentType.JSON)
	        .body(requestParams)
	        .put("/repos/spax021/Prodly/contents/" + filePath);

	    // Handle and print out the error message if the status code is 422
	    if (response.getStatusCode() == 422) {
	        System.out.println("Failed to create or update file. Response body: " + response.getBody().asString());
	    }

	    return response;
	}
	
	public String getShaForFile(String filePath) {
        Response response = given()
                .header("Authorization", "token " + token)
                .contentType(ContentType.JSON)
                .get("/repos/" + owner + "/" + repo + "/contents/" + filePath);

        // If the file does not exist, return null
        if (response.getStatusCode() == 404) {
            return null;
        }

        // If there was some other error, handle it appropriately
        if (response.getStatusCode() != 200) {
            throw new IllegalStateException("API responded with status code: " + response.getStatusCode());
        }

        // Extract the SHA from the response
        String sha = response.jsonPath().getString("sha");
        return sha;
    }

	
	// Method to merge the main branch into a second branch
    public Response mergeBranches(String base, String head, String commitMessage) {
        String payload = "{\"base\": \"" + base + "\", \"head\": \"" + head + "\", \"commit_message\": \"" + commitMessage + "\"}";

        Response response = given()
            .header("Authorization", "token " + token)
            .contentType(ContentType.JSON)
            .body(payload)
            .when()
            .post("/repos/" + owner + "/" + repo + "/merges"); // POST request to merge branches

        return response;
    }

    // Method to retrieve the content of the CSV file from a branch
    public String getContentsFromBranch(String branch, String filePath) {
        Response response = given()
            .header("Authorization", "token " + token)
            .contentType(ContentType.JSON)
            .queryParam("ref", branch)
            .get("/repos/" + owner + "/" + repo + "/contents/" + filePath);

        if (response.getStatusCode() != 200) {
            throw new IllegalStateException("Failed to retrieve content from GitHub. Status code: " + response.getStatusCode());
        }

        // Fetch the content as a String
        String content = response.jsonPath().getString("content");
        if (content == null) {
            throw new IllegalStateException("File content is null, check if file exists and has content");
        }
        byte[] decodedBytes = Base64.getMimeDecoder().decode(content);  // getDecoder() not working
        return new String(decodedBytes);
    }
	
}
