
package com.livraison.MUT.controller;

import com.livraison.MUT.entities.Livraison;
import com.livraison.MUT.entities.Transporteur;
import com.livraison.MUT.repository.LivraisonRepository;
import com.livraison.MUT.repository.TransporteurRepository;
import com.livraison.MUT.service.TransporteurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TransporteurController {


    @Autowired
    private TransporteurService transporteurService;


    @GetMapping("/")
    public String racine() {

        return "page-principale";
    }

    @GetMapping("/signuppp")
    public String ShowTransport(Model model) {
        model.addAttribute("transporteurs", transporteurService.getAllTransporteurs());
        return "touteTransporteurDynamic";
    }


    @GetMapping("/signup")
    public String showSignup() {
        return "add-transporteur";
    }

    @GetMapping("/addtransporteur")
    public String showAddTransporteurForm(Model model) {

        model.addAttribute("transporteur", new Transporteur());
        return "add-transporteur";
    }


    @PostMapping("/addtransporteur")
    public String addtransporteur(@Valid Transporteur transporteur, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-transporteur";
        }
        transporteurService.saveTransporteur(transporteur);
        model.addAttribute("transporteurs", transporteurService.getAllTransporteurs());
        return "touteTransporteurDynamic";

    }

    @GetMapping("/adddtransporteur")
    public String showAddTransporteurFormm(Model model) {

        model.addAttribute("transporteur", new Transporteur());

        return "addd-transporteur";

    }

    @PostMapping("/adddtransporteur")
    public String addTransporteurs(@Valid Transporteur transporteur, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addd-transporteur";
        }

        // Save the transporteur
        transporteurService.saveTransporteur(transporteur);


        return "redirect:/addlivraison?idTransporteur=" + transporteur.getId();
    }

    @GetMapping("/transporteur/editerid/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Transporteur transporteur = transporteurService.getTransporteurById(id);

        model.addAttribute("transporteur", transporteur);
        model.addAttribute("transporteurs", transporteurService.getAllTransporteurs());
        return "update-transporteur";
    }

    @PostMapping("/transporteur/editerid/{id}")
    public String updateTransporteur(@PathVariable("id") Integer id, @Valid Transporteur transporteur, BindingResult result, Model model) {
        if (result.hasErrors()) {
            transporteur.setId(id);
            model.addAttribute("transporteur", transporteur);
            return "update-transporteur";
        }

        try {

            transporteurService.updateTransporteur(id, transporteur);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Erreur lors de la mise à jour du transporteur : " + e.getMessage());
            return "update-transporteur";
        }

        model.addAttribute("transporteurs", transporteurService.getAllTransporteurs());

        return "touteTransporteurDynamic";
    }

    @PostMapping("/transporteur/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        Transporteur transporteur = transporteurService.getTransporteurById(id);

        transporteurService.deleteTransporteur(transporteur.getId());

        return "redirect:/signuppp";
    }


    @GetMapping("/transporteur/recherche")
    public String search(@RequestParam(required = false) String nom, Model model) {

        List<Transporteur> transporteurs;
        if (nom == null || nom.trim().isEmpty()) {
            transporteurs = transporteurService.getAllTransporteurs();
        } else {
            transporteurs = transporteurService.rechercherParNom(nom);
        }

        model.addAttribute("transporteurs", transporteurs);
        return "transporteurList";
    }

}







