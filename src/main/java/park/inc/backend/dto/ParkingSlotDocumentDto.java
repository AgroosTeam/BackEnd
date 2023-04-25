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
@Relation(itemRelation = "parkingSlotDocument", collectionRelation = "parkingSlotDocuments")
public class ParkingSlotDocumentDto extends RepresentationModel<ParkingSlotDocumentDto> {
    private final long parkingSlotId;
    private final String document;
}
