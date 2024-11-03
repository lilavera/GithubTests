package api_configuration;


import lombok.Getter;

@Getter
public class GithubProps {

    public GithubProps() {
    }

    static PropertiesLoader propertiesLoader = new PropertiesLoader("config.properties");

    public static final String GITHUB_API_URI = propertiesLoader.getProperty("config.url");
    public static final String API_TOKEN = propertiesLoader.getProperty("config.access_token");
    public static final String API_VERSION = propertiesLoader.getProperty("config.github.version");
    public static final String REPO_OWNER = propertiesLoader.getProperty("config.owner");

    public static final String CREATE_REPO_PATH = propertiesLoader.getProperty("api.path.createRepo");
    public static final String GET_AUTH_PATH = propertiesLoader.getProperty("api.path.getAuthUser");
}