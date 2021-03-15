package reqres.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPostPut {

    private String nome;

    private String job;

    private String id;

    private String createdAt;

    private String updatedAt;

}
