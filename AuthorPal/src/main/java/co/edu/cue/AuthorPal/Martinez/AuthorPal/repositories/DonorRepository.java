package co.edu.cue.AuthorPal.Martinez.AuthorPal.repositories;

import co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.entities.Donor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends CrudRepository<Donor,Integer> {
}
