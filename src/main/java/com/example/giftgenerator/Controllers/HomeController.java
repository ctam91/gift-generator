package com.example.giftgenerator.Controllers;

import com.example.giftgenerator.Models.APIHandler;
import com.example.giftgenerator.Models.Listing;
import com.example.giftgenerator.Models.SearchRequest;
import com.example.giftgenerator.Models.SearchRequestManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@Validated
@RequestMapping("")

public class HomeController {

    SearchRequestManager manager;
    APIHandler handler;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model) {
        //String url = manager.getSearchResults();
        //ArrayList<Listing> listings = handler.processAPI(url);

        //model.addAttribute("listings", listings);
        return "index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String list(Model model, @RequestParam(value = "price") String price, @RequestParam(value = "gender") String gender, @RequestParam(value = "hobby") String hobby) {

        String url = manager.getSearchResults(new SearchRequest(price, gender, hobby));
        ArrayList<Listing> listings = handler.processAPI(url);
        model.addAttribute("listings", listings);
        return "index";
    }

}
