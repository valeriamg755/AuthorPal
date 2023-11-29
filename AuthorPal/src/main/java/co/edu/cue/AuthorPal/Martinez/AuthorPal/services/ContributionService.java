package co.edu.cue.AuthorPal.Martinez.AuthorPal.services;

import co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.entities.Contribution;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.mapping.dtos.ContributionDto;

import java.util.List;

public interface ContributionService {

    List<ContributionDto> list();

    ContributionDto byId(int contributionId);
    void save(ContributionDto contribution);
    void remove(int contributionId);
}
