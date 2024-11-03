package pojo.delete_repo;


import lombok.Data;
import lombok.experimental.Accessors;
import pojo.BodyModel;

@Accessors(chain = true)
@Data
public class DeleteRepositoryRequest implements BodyModel {
    private String owner;
    private String repo;
}
