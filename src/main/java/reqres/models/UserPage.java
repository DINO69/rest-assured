package reqres.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserPage {

    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

}
