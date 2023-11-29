package co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "donors")
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer donorId;
    private String name;
    private String phone;
    private String password;

}
