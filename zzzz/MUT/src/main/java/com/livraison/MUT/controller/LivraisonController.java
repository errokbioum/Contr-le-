package com.livraison.MUT.controller;

import com.livraison.MUT.entities.Livraison;
import com.livraison.MUT.entities.Transporteur;
import com.livraison.MUT.service.LivraisonService;
import com.livraison.MUT.service.TransporteurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class LivraisonController {

    @Autowired
    private LivraisonService livraisonService;
    @Autowired
    private TransporteurService transporteurService;

    @GetMapping("/signupicone")
    public String showIcone() {

        return "icone";
    }

    @GetMapping("/signupp")
    public String showList(Model model) {
        model.addAttribute("livraisons", livraisonService.getAllLivraisons());
        return "toutelivraison";
    }

    @GetMapping("/addlivraison")
    public String showAddLivraisonForm(Model model) {
        model.addAttribute("livraison", new Livraison());
        model.addAttribute("transporteurs", livraisonService.getAllTransporteurs());
        model.addAttribute("livraisons", livraisonService.getAllLivraisons() );
        return "add-livraison";
    }

    @PostMapping("/addlivraison")
    public String addLivraison(@Valid Livraison livraison, BindingResult result, Model model, @RequestParam(value = "idTransporteur", required = false) Integer idTransporteur) {
        if (livraison.getTransporteur() == null ||
                (livraison.getTransporteur().getId() == null && !livraison.getTransporteur().getNom().equals("new"))) {
            result.rejectValue("transporteur", "error.transporteur", "Veuillez sélectionner un transporteur.");
        }

        if (result.hasErrors()) {
            model.addAttribute("transporteurs", transporteurService.getAllTransporteurs()); // Ajoutez les transporteurs au modèle
            return "add-livraison";
        }

        livraisonService.saveLivraison(livraison, idTransporteur);
        model.addAttribute("livraisons", livraisonService.getAllLivraisons());
        return "toutelivraison";
    }


    @GetMapping("livraison/editerid/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Livraison livraison = livraisonService.getLivraisonById(id);
        model.addAttribute("livraison", livraison);
        model.addAttribute("transporteurs", transporteurService.getAllTransporteurs());
        return "update-livraison";
    }


    @PostMapping("livraison/editerid/{id}")
    public String updateLivraison(@PathVariable("id") int id, @Valid Livraison livraison, BindingResult result, Model model) {
        if (result.hasErrors()) {
            livraison.setId(id);
            model.addAttribute("livraison", livraison);
            model.addAttribute("transporteurs", transporteurService.getAllTransporteurs());
            return "update-livraison";
        }
        try {
            livraisonService.updateLivraison(livraison, id);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Erreur lors de la mise à jour de la livraison : " + e.getMessage());
            return "update-livraison";
        }
        return "redirect:/livraisontr";
    }



    @PostMapping("/livraison/delete/{id}")
    public String deleteLivraison(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        livraisonService.deleteLivraison(id);
        redirectAttributes.addFlashAttribute("message", "Livraison supprimée avec succès!");
        return "redirect:/signupp";
    }

    @GetMapping("/transporteur/livraisons/{id}")
    public String voirLivraisons(@PathVariable("id") Integer id, Model model) {
        Transporteur transporteur = transporteurService.getTransporteurById( id);

        List<Livraison> livraisons = livraisonService.getLivraisonsByTransporteurId(id);
        model.addAttribute("transporteur", transporteur);
        model.addAttribute("livraisons", livraisons);
        return "toutelive-de-transporteur";
    }
    @GetMapping("/livraisontr")
    public String showSignUpForrm( Model model) {
        model.addAttribute("livraisons", livraisonService.getAllLivraisons());
        return"toutelivraison";
    }

    @GetMapping("/search")
    public String searchByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, Model model) {
        List<Livraison> livraisons = livraisonService.getLivraisonsByDate(date);
        model.addAttribute("livraisons", livraisons);
        return "toutelivraison";
    }


}
