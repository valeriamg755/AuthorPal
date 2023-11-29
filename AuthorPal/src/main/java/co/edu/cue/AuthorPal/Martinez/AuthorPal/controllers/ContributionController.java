package co.edu.cue.AuthorPal.Martinez.AuthorPal.controllers;

import co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.enums.PaymentMethod;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.mapping.dtos.ContributionDto;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.services.ContributionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/contribution")
public class ContributionController {

    private final ContributionService service;

    public ContributionController(ContributionService service) {
        this.service = service;
    }

    @GetMapping("/contribution/creation")
    public ModelAndView createContribution() {
        ModelAndView modelAndView = new ModelAndView("ContributionForm");
        modelAndView.addObject("contribution", service.list());
        return modelAndView;
    }
    @PostMapping("/contribution/new")
    public String createNewDonation(@RequestParam("contributionId") String contributionId,
                                    @RequestParam("amount") float amount,
                                    @RequestParam("authors") String authors,
                                    @RequestParam("payment")String paymentMethod) {
        ContributionDto contributionDto = ContributionDto.builder()
                .contributionId(0)
                .amount(amount)
                .date(LocalDate.now())
                //.authors(Authors.valueOf(String.valueOf(authors)))
                .paymentMethod(PaymentMethod.valueOf(String.valueOf(paymentMethod)))
                .build();
        service.save(contributionDto);

        return "redirect:/contribution/creation?success";
    }
    @GetMapping("/contribution/list")
    public String listContribution(Model model) {
        List<ContributionDto> contributionList = service.list();
        model.addAttribute("donations", contributionList);
        return "contributionList";
    }

    @GetMapping("/contribution/update")
    public ModelAndView updateContribution(){
        ModelAndView modelAndView = new ModelAndView("UpdateContribution");
        modelAndView.addObject("authors", service.list());
        return modelAndView;
    }
    @PostMapping("/contribution/updated")
    public String updateContribution(@RequestParam("id") int id,
                                 @RequestParam("name") String name){
        ContributionDto contributionDto = ContributionDto.builder().contributionId(id).build();
        service.save(contributionDto);
        return "redirect:/contribution/update?success";
    }
}
