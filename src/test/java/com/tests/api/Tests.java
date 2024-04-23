package com.tests.api;

import java.io.IOException;
import com.tests.config.CompanyGenerator;
import io.restassured.response.Response;

public class Tests{
	
	private static final String TOKEN = "";
    private static final String owner = "";
    private static final String repo = "";
    private static final String CSV_FILE_PATH = "";
    private static CompanyGenerator gen = new CompanyGenerator();
    
    public static void main(String[] args) throws IOException {

        GitHubClient gitHubClient = new GitHubClient(TOKEN, owner, repo);
               
        // Create or update CSV file in the main branch
        Response createOrUpdateResponse = gitHubClient.createOrUpdateFileInMainBranch(CSV_FILE_PATH, gen.getCompanies(), "Create or update CSV file");
        System.out.println("Create/Update File Response: " + createOrUpdateResponse.getStatusCode());

        // Merge main into development
        Response mergeResponse = gitHubClient.mergeBranches("development", "main", "Merge main into feature-branch");
        System.out.println("Merge Branches Response: " + mergeResponse.getStatusCode());

        // Retrieve the contents of the CSV file from development
        String fileContents = gitHubClient.getContentsFromBranch("development", CSV_FILE_PATH);
        System.out.println("File Contents from feature-branch: \n" + fileContents);        
    }
 
}
