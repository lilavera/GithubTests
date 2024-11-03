import endpoints_github.UpdateRepositoryEndpoint;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import endpoints_github.CreateRepositoryEndpoint;
import endpoints_github.DeleteRepositoryEndpoint;

public class RepositoryFlowTest {

    @Test(invocationCount = 2, threadPoolSize = 2)
    public void createUpdateAndDeleteRepository(){
        CreateRepositoryEndpoint createRepoEndpoint = new CreateRepositoryEndpoint();
        Response createRepoResponse = createRepoEndpoint.sendCreateRepoRequest();
        String repoName = createRepoEndpoint.getRepoName();
        Assert.assertEquals(createRepoResponse.getStatusCode(),201);

        UpdateRepositoryEndpoint updateRepositoryEndpoint = new UpdateRepositoryEndpoint(repoName);
        Response updateRepoResponse = updateRepositoryEndpoint.sendUpdateRepoRequest(repoName);
        Assert.assertEquals(updateRepoResponse.getStatusCode(),200);
        Assert.assertEquals(updateRepositoryEndpoint.getNameOfUpdatedRepo(), "updated_description");


        Response deleteRepoResponse = new DeleteRepositoryEndpoint(repoName).sendDeleteRepoRequest(repoName);
        Assert.assertEquals(deleteRepoResponse.getStatusCode(),204);
    }
}