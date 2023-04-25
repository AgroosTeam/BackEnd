package park.inc.backend.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "user", schema = "public", catalog = "park.inc")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private long id;
    @Basic
    @Column(name = "username", nullable = false, length = 255)
    private String username;
    @Basic
    @Column(name = "first_name", nullable = false, length = 255)
    private String firstName;
    @Basic
    @Column(name = "middle_name", nullable = true, length = 255)
    private String middleName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 255)
    private String lastName;
    @Basic
    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    @ColumnDefault(value = "now()")
    private Timestamp createdAt;
    @OneToMany(mappedBy = "owner")
    private List<ParkingSlot> parkingSlots;

    @OneToOne(mappedBy = "userByUserId", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private UserPrivate userPrivate;
}
