package endpoints_github;

import api_configuration.BaseApi;
import io.restassured.response.Response;
import pojo.update_repo.UpdateRepositoryRequest;
import pojo.update_repo.UpdateRepositoryResponse;

import static api_configuration.GithubProps.*;

public class UpdateRepositoryEndpoint extends BaseApi {


    public UpdateRepositoryEndpoint(String repoName) {
        super(GITHUB_API_URI, "/repos/" + REPO_OWNER + "/" + repoName);
    }

    public Response sendUpdateRepoRequest(String repoName){
        requestSpecBuilder.addHeader("Authorization","Bearer " + API_TOKEN)
                .addHeader( "X-GitHub-Api-Version",API_VERSION)
                .setBody(new UpdateRepositoryRequest().setOwner(REPO_OWNER).setRepo(repoName).setName(repoName).setDescription("updated_description"));
        return sendPatchRequest();
    }

    public String getNameOfUpdatedRepo(){
        return deserializeToObject(UpdateRepositoryResponse.class).getDescription();
    }
}