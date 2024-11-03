package endpoints_github;

import io.restassured.response.Response;
import api_configuration.BaseApi;
import lombok.Getter;
import lombok.Setter;
import pojo.create_repo.CreateRepoRequest;

import static api_configuration.GithubProps.*;
import static utils.FakerUtils.*;
@Getter
@Setter
public class CreateRepositoryEndpoint extends BaseApi {

    private String repoName;
    String apiToken;
    String apiVersion;

    public CreateRepositoryEndpoint() {
        super(GITHUB_API_URI, CREATE_REPO_PATH);
    }

    public Response sendCreateRepoRequest(){
      setRepoName(generateName());
      requestSpecBuilder.addHeader("Authorization","Bearer " + API_TOKEN)
              .addHeader( "X-GitHub-Api-Version",API_VERSION)
              .setBody(new CreateRepoRequest().setDescription(generateDescription()).setName(getRepoName()).setHomepage(generateHomePage()).setIsPrivate(true).setIsTemplate(false));
      return sendPostRequest();
    }
}