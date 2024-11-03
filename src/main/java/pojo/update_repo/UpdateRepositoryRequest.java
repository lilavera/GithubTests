package pojo.update_repo;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.experimental.Accessors;
import pojo.BodyModel;

@Data
@Accessors(chain = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UpdateRepositoryRequest implements BodyModel {

    private String owner;
    private String repo;
    private String name;
    private String description;
}