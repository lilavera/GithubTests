package api_configuration;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import pojo.BodyModel;


public abstract class BaseApi {

    protected final String uri;
    protected String basePath;
    protected RequestSpecBuilder requestSpecBuilder;
    protected Response response;

    public BaseApi(String uri, String basePath) {
        this.uri = uri;
        this.basePath = basePath;
        this.requestSpecBuilder = requestSpecBuilderConfig();
    }

    public Response sendPostRequest(){
        return response = RestAssured.given().spec(requestSpecBuilder.build()).when().post();
    }

    public Response sendDeleteRequest(){
        return response = RestAssured.given().spec(requestSpecBuilder.build()).when().delete();
    }

    public Response sendGetRequest(){
        return response = RestAssured.given().spec(requestSpecBuilder.build()).when().get();
    }

    public Response sendPatchRequest(){
        return response = RestAssured.given().spec(requestSpecBuilder.build()).when().patch();
    }

    protected RequestSpecBuilder requestSpecBuilderConfig() {
        return new RequestSpecBuilder().setBaseUri(uri)
                .setBasePath(basePath)
                .setConfig(getBasicConfig())
                .setContentType(ContentType.JSON)
                .addFilter(new CustomLoggingFilter())
                .setRelaxedHTTPSValidation();
    }

    public static RestAssuredConfig getBasicConfig() {
        return RestAssured.config()
                .objectMapperConfig(ObjectMapperConfig.objectMapperConfig().defaultObjectMapperType(ObjectMapperType.JACKSON_2))
                .redirect(new RedirectConfig().followRedirects(false));
    }

    public <T extends BodyModel> T deserializeToObject(Class<T> clazz) {
        return response.as(clazz);
    }
}