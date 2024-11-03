package pojo.update_repo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import pojo.BodyModel;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class UpdateRepositoryResponse implements BodyModel {
    String description;
}
