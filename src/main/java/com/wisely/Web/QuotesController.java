package com.wisely.Web;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wisely.Dao.QuotesRepository;
import com.wisely.Entity.Quotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;

/**
 * Created by Admin on 31/03/2020.
 */
@Controller
public class QuotesController {


    @Autowired
    private QuotesRepository quotesRepository;

    public String stringQuote;




    @RequestMapping(value = "/home")
    public String getQuote(Model model) {

        List<Quotes> quotes1iList = quotesRepository.getOneQuote();
        model.addAttribute("quotesList", quotes1iList);
        return "Home";

    }

    @RequestMapping(value = "/newQuote")
    public String newQuote(Model model) {
        model.addAttribute("quote",new Quotes());
        return "newQuote";
    }


    @RequestMapping(value = "/saveQuote",method = RequestMethod.POST)
    public String saveQuote(Model model, @Valid Quotes quotes, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newQuote";
        }

        quotesRepository.save(quotes);

        return "redirect:/home";

    }
}
