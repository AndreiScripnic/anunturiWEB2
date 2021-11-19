package com.example.anunturi.controller;

import com.example.anunturi.model.Ad;
import com.example.anunturi.repository.AdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdsController {

    @Autowired
    private AdsRepository adsRepository;

    //Urmareste pagina principala "/", returneaza template-ul "home"
    @GetMapping("/")
    public String homePage(Model model) {
        return "home";
    }

    //Urmareste pagina "/ads", returneaza template-ul "ads-main",aici se face afisarea tuturor anunturilor
    @GetMapping("/ads")
    public String adsMain(Model model) {
        model.addAttribute("allPosts", adsRepository.findAll());
        return "ads-main";
    }

    //Urmareste pagina  "/add", returneaza template-ul "ads-add",aici se face adaugarea unui anunt nou

    @GetMapping("/ads/add")
    public String adsAdd(Model model) {
        return "ads-add";
    }

    //Urmareste pagina  "/add", returneaza template-ul "ads-add",aici se face adaugarea unui anunt nou si salvarea lui.
    @PostMapping("/ads/add")
    public String adsPostAdd(@RequestParam String title, @RequestParam String category, @RequestParam String fullText, Model model) {
        Ad post = new Ad(title, category, fullText);
        adsRepository.save(post);
        return "redirect:/ads";
    }
    //Metoda GET
    //Urmareste pagina  "/add/{id}/edit", returneaza template-ul "ads-edit" daca acesta exista,in caz contrar returneaza "404"
    @GetMapping("/ads/{id}/edit")
    public String adEdit(@PathVariable(value = "id") long id, Model model) {
        Ad post = adsRepository.findById(id);
        if (post == null) {
            return "404";

        }
        model.addAttribute("post", post);

        return "ads-edit";
    }
    //Metoda Post
    //Urmareste pagina  "/add/{id}/edit",efectueaza salvarea schimbarilor si returneaza la pagina cu anunturi
    @PostMapping("/ads/{id}/edit")
    public String adUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String category, @RequestParam String fullText, Model model) {
        Ad post = adsRepository.findById(id);
        post.setTitle(title);
        post.setCategory(category);
        post.setFullText(fullText);
        adsRepository.save(post);

        return "redirect:/ads";
    }
    //Urmareste pagina  "/add/{id}/delete, aici se face stergerea anuntului din baza de date si returneaza la pagina cu anunturi
    @PostMapping("/ads/{id}/delete")
    public String adDelete(@PathVariable(value = "id") long id, Model model) {
        Ad post = adsRepository.findById(id);
        adsRepository.delete(post);
        return "redirect:/ads";
    }

}
