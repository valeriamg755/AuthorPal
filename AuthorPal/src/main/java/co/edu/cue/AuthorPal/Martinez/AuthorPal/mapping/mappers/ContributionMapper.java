package co.edu.cue.AuthorPal.Martinez.AuthorPal.mapping.mappers;

import co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.entities.Contribution;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.mapping.dtos.ContributionDto;

import java.util.ArrayList;
import java.util.List;

public class ContributionMapper {
    public static ContributionDto mapFrom(Contribution source){
        return new ContributionDto(source.getContributionId(),
                source.getAmount(),
                source.getDate(),
                source.getDonor(),
                source.getPaymentMethod(),
                source.getAuthor()
        );
    }
    public static Contribution mapFrom(ContributionDto source){
        return new Contribution(source.contributionId(),
                source.date(),
                source.amount(),
                        source.donor(),
                        source.paymentMethod(),
                        source.Author()
                );
    }

    public static List<ContributionDto> mapFromList(List<Contribution> contributions){
        ArrayList<ContributionDto> contributionDto = new ArrayList<ContributionDto>();
        for (
                Contribution contribution : contributions
        ){
            contributionDto.add(mapFrom(contribution));
        }
        return contributionDto;
    }

    public static List<Contribution> mapFrom(List<ContributionDto> contributionsDto){
        ArrayList<Contribution> contributionList = new ArrayList<Contribution>();
        for (
                ContributionDto contribution: contributionsDto
        ){
            contributionList.add(mapFrom(contribution));
        }
        return contributionList;
    }
}
