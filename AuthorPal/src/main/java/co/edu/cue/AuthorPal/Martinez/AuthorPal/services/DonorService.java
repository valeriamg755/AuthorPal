package co.edu.cue.AuthorPal.Martinez.AuthorPal.services;

import co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.entities.Donor;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.mapping.dtos.DonorDto;

import java.util.List;

public interface DonorService {
    List<DonorDto> list();
    DonorDto byId(int donorId);
    void save (DonorDto donor);
    void remove (Integer donorId);
}
