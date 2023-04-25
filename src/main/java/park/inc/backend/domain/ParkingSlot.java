package park.inc.backend.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "parking_slot", schema = "public", catalog = "park.inc")
public class ParkingSlot {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, insertable = false)
    private long id;
    @Basic
    @Column(name = "address", nullable = false, length = 255)
    private String address;
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false)
    private User owner;

    @OneToOne(mappedBy = "parkingSlot", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private ParkingSlotDocument parkingSlotDocument;
}
