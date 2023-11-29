package co.edu.cue.AuthorPal.Martinez.AuthorPal.repositories;

import co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.entities.Contribution;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionRepository extends CrudRepository<Contribution,Integer> {
}
