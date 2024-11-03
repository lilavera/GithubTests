package endpoints_github;

import api_configuration.BaseApi;
import io.restassured.response.Response;

import static api_configuration.GithubProps.*;

public class GetAuthUserEndpoint extends BaseApi {

    public GetAuthUserEndpoint() {
        super(GITHUB_API_URI, GET_AUTH_PATH);
    }

    public Response sendGetAuthUser(){
       requestSpecBuilder.addHeader("Authorization","Bearer " + API_TOKEN).addHeader("X-GitHub-Api-Version",API_VERSION);
       return sendGetRequest();
    }
}
