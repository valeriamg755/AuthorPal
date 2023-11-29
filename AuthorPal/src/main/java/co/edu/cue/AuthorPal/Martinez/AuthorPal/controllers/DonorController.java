package co.edu.cue.AuthorPal.Martinez.AuthorPal.controllers;

import org.springframework.ui.Model;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.domain.entities.Donor;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.mapping.dtos.DonorDto;
import co.edu.cue.AuthorPal.Martinez.AuthorPal.services.DonorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping

public class DonorController {
    private final DonorService service;

    public DonorController(DonorService service) {
        this.service = service;
    }

    @GetMapping("/donors/list")
    public String listAllPerson(Model model) {
        List<DonorDto> donorList = service.list();
        model.addAttribute("donors", donorList);
        return "indexDonors";
    }

    @GetMapping("/donor/new")
    public String save(org.springframework.ui.Model model) {
        model.addAttribute("donor", new Donor());
        return "DonorForm";
    }

    @PostMapping("/donor/create")
    public String create(DonorDto donor) {
        service.save(donor);
        return "redirect:/donors/list";
    }

    @GetMapping("/donor/edit/{id}")
    public String edit(Model model, @PathVariable Integer id) {
        DonorDto dto = service.byId(id);
        model.addAttribute("donor",  dto);
        return "DonorEdit";
    }

    @PostMapping("donor/savedit/{id}")
    public String savedit(DonorDto dto, @PathVariable Integer id) {
        service.save(dto);
        return "redirect:/donors/list";
    }

    @GetMapping("donor/remove/{id}")
    public String remove( @PathVariable Integer id) {
        service.remove(id);
        return "redirect:/donors/list";
    }
}