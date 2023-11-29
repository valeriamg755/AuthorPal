package co.edu.cue.AuthorPal.Martinez.AuthorPal.services.impls;

import co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.entities.Donor;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.mapping.dtos.DonorDto;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.mapping.mappers.DonorMapper;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.repositories.DonorRepository;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.services.DonorService;
import org.springframework.stereotype.Service;

import java.util.List;

import static co.edu.cue.AuthorPal.Martinez.AuthorPal.mapping.mappers.DonorMapper.mapFrom;
import static co.edu.cue.AuthorPal.Martinez.AuthorPal.mapping.mappers.DonorMapper.mapFromList;

@Service
public class DonorServiceImpl implements DonorService {
    private final DonorRepository repository;

    public DonorServiceImpl(DonorRepository repository){
        this.repository = repository;
    }

    @Override
    public List<DonorDto> list() {
        List<Donor> donor = (List<Donor>)repository.findAll();
        List<DonorDto> donorDto = mapFromList(donor);
        return donorDto;
    }

    @Override
    public DonorDto byId(int donorId) {
        Donor donor = repository.findById(donorId).orElseThrow();
        DonorDto donorDto = mapFrom(donor);
        return donorDto;
    }

    @Override
    public void save(DonorDto donorDto) {
        Donor donor = DonorMapper.mapFrom(donorDto);
        repository.save(donor);
    }

    @Override
    public void remove(Integer donorId) {
        repository.deleteById(donorId);
    }
}
