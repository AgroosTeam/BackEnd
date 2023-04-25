package park.inc.backend.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "parking_slot_document", schema = "public", catalog = "park.inc")
public class ParkingSlotDocument {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "parking_slot_id", nullable = false)
    private long parkingSlotId;
    @Basic
    @Column(name = "document", nullable = false, length = 255)
    private String document;
    @OneToOne
    @MapsId
    @JoinColumn(name = "parking_slot_id", referencedColumnName = "id", nullable = false)
    private ParkingSlot parkingSlot;
}
