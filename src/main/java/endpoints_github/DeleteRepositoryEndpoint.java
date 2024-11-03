package endpoints_github;

import api_configuration.BaseApi;
import io.restassured.response.Response;
import pojo.delete_repo.DeleteRepositoryRequest;

import static api_configuration.GithubProps.*;


public class DeleteRepositoryEndpoint extends BaseApi {

    public DeleteRepositoryEndpoint(String repoName) {
        super(GITHUB_API_URI,"/repos/" +REPO_OWNER + "/" + repoName);
    }

    public Response sendDeleteRepoRequest(String repoName){
        requestSpecBuilder.addHeader("Authorization", "Bearer " + API_TOKEN).addHeader("X-GitHub-Api-Version", API_VERSION)
                .setBody(new DeleteRepositoryRequest().setRepo(repoName).setOwner(REPO_OWNER));
        return sendDeleteRequest();
    }
}