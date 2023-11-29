package co.edu.cue.AuthorPal.Martinez.AuthorPal.services.impls;

import co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.entities.Contribution;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.mapping.dtos.ContributionDto;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.mapping.mappers.ContributionMapper;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.repositories.ContributionRepository;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.services.ContributionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContributionServiceImpl implements ContributionService {
    private final ContributionRepository repository;

    public ContributionServiceImpl(ContributionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ContributionDto> list() {
        List<Contribution> contribution = (List<Contribution>) repository.findAll();
        List<ContributionDto> contributionDto = ContributionMapper.mapFromList(contribution);
        return contributionDto;
    }

    @Override
    public ContributionDto byId(int contributionId) {
        Contribution contribution = repository.findById(contributionId).orElseThrow();
        ContributionDto contributionDto = ContributionMapper.mapFrom(contribution);
        return contributionDto;
    }

    @Override
    public void save(ContributionDto contributionDto) {
        Contribution contribution = ContributionMapper.mapFrom(contributionDto);
        repository.save(contribution);
    }

    @Override
    public void remove(int contributionId) {
    }
}
