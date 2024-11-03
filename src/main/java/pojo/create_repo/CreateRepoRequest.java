package pojo.create_repo;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import lombok.Data;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import pojo.BodyModel;


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Accessors(chain = true)
@Data
public class CreateRepoRequest implements BodyModel {
    private String name;
    private String description;
    private String homepage;

    @JsonProperty("private")
    private Boolean isPrivate;

    private Boolean isTemplate;
}
