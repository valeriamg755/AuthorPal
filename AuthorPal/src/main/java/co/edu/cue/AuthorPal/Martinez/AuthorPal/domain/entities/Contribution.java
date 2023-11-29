package co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.entities;

import co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.enums.Authors;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contributions")
public class Contribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contributionId;
    public LocalDate date;
    private float amount;
    @OneToOne
    private Donor donor;
    @Enumerated(EnumType.STRING)
    public PaymentMethod paymentMethod;
    @Enumerated(EnumType.STRING)
    public Authors author;
}
