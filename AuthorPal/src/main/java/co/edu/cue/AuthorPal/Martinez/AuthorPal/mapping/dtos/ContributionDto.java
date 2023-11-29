package co.edu.cue.AuthorPal.Martinez.AuthorPal.mapping.dtos;

import co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.entities.Donor;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.enums.Authors;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.enums.PaymentMethod;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ContributionDto(Integer contributionId,
                              float amount,
                              LocalDate date,
                              Donor donor,
                              PaymentMethod paymentMethod,
                              Authors Author) {}
