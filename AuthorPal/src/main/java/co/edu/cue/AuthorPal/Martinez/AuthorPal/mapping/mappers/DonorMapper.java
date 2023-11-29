package co.edu.cue.AuthorPal.Martinez.AuthorPal.mapping.mappers;

import co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.entities.Donor;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.mapping.dtos.DonorDto;

import java.util.ArrayList;
import java.util.List;

public class DonorMapper {
    public static DonorDto mapFrom(Donor source){
        return new DonorDto(source.getDonorId(),
                source.getName(),
                source.getPhone(),
                source.getPassword()
        );
    }
    public static Donor mapFrom(DonorDto source){
        return new Donor(source.donorId(),
                source.name(),
                source.phone(),
                source.password()
        );
    }

    public static List<DonorDto> mapFromList(List<Donor> donors){
        ArrayList<DonorDto> donorDto = new ArrayList<DonorDto>();
        for (
                Donor donor: donors
        ){
            donorDto.add(mapFrom(donor));
        }
        return donorDto;
    }

    public static List<Donor> mapFrom(List<DonorDto> donorsDto){
        ArrayList<Donor> donorList = new ArrayList<Donor>();
        for (
                DonorDto donor: donorsDto
        ){
            donorList.add(mapFrom(donor));
        }
        return donorList;
    }
}
