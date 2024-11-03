import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import endpoints_github.GetAuthUserEndpoint;

public class GetTheAuthenticatedUserTest {

    @Test
    public void sendGetAuthUser(){
        GetAuthUserEndpoint getAuthUserEndpoint = new GetAuthUserEndpoint();
        Response getAuthUserResponse = getAuthUserEndpoint.sendGetAuthUser();

        Assert.assertEquals(getAuthUserResponse.getStatusCode(),200);

    }
}
