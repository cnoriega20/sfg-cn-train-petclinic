package sfgcntrainpetclinicweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sfgcntrainpetclinicweb.sfgcntrainpetclinic.services.VetService;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"/vets", "vets/index", "vets/index.html","/vets.html"})
    public String getListOfVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

}
