package park.inc.backend.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "parkingSlot", collectionRelation = "parkingSlots")
public class ParkingSlotDto extends RepresentationModel<ParkingSlotDto> {
    private final long id;
    private final String address;
    private final Link owner;

}
