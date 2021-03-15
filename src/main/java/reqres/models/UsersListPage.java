package reqres.models;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UsersListPage {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<UserPage> data;
    private Support support;

}
