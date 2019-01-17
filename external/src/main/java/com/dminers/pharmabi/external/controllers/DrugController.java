package com.dminers.pharmabi.external.controllers;

import com.dminers.pharmabi.external.proxies.MicroserviceArticle;
import com.dminers.pharmabi.external.services.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DrugController {
    private DrugService drugService;
    private MicroserviceArticle microserviceArticle;
    private UserDetailsService userService;

    @Autowired
    public void setDrugService(DrugService drugService, MicroserviceArticle microserviceArticle, UserDetailsService userDetailsService) {
        this.drugService = drugService;
        this.microserviceArticle = microserviceArticle;
        this.userService = userDetailsService;
    }

    @GetMapping("/")
    public String greeting(Authentication authentication) {
        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().anyMatch(o -> o.toString().equals("ROLE_MANAGER")))
            return "redirect:/report";
        else if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().anyMatch(o -> o.toString().equals("ROLE_USER")))
            return "redirect:/medicine/list";
        return "redirect:/error403";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/drug/list")
    public String listDrugs(Model model){
        model.addAttribute("drugs", drugService.listAll());
        return "drug/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public String list(){
        return "reports/allinone";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/medicine/list")
    public String listMedicines(Model model){
        model.addAttribute("ateliers", microserviceArticle.listeDesArticles());
        return "medicine/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/report")
    public String report(Model model){
        return "reports/reporting";
    }

    @GetMapping(path = "/drug/delete/{id}")
    public String delete(@PathVariable Long id){
        drugService.delete(id);
        return "redirect:/drug/list";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/drug/show/{id}")
    public String getProduct(@PathVariable Long id, Model model){
        model.addAttribute("drug", drugService.getByid(id));
        return "drug/show";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/drug/test/{id}")
    public String getProductTest(@PathVariable Long id, Model model){
        model.addAttribute("drug", drugService.getByid(id));
        return "test/testgraph";
    }

    @RequestMapping("/test")
    public String getTest(){
        return "errors/error404";
    }

    @RequestMapping("/loggedout")
    public String loggedOut(){
        return "errors/logout";
    }

    @RequestMapping("/error404")
    public String get404(){
        return "errors/error404";
    }

    @RequestMapping("/error403")
    public String get403(){
        return "errors/error403";
    }

    @RequestMapping(value = "/drug/json/{id}")
    @ResponseBody
    public String getJson(@PathVariable Long id){
        return drugService.getByid(id).toString();
    }

}
