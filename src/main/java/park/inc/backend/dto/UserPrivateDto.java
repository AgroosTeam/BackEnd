package park.inc.backend.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "userPrivate", collectionRelation = "userPrivates")
public class UserPrivateDto extends RepresentationModel<UserPrivateDto> {
    private final long userId;
    private final String email;
    private final String password;
    private final String phoneNumber;
}
