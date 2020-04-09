package com.wisely.Web;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wisely.Dao.QuotesRepository;
import com.wisely.Entity.Quotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.condition.ParamsRequestCondition;

import java.util.List;

/**
 * Created by Admin on 01/04/2020.
 */
@Controller
public class QuotesManagmentController {


    @Autowired
    private QuotesRepository quotesRepository;

    @RequestMapping(value = "/allQuotes", method = RequestMethod.GET)
    public String index(Model model, @RequestParam(value = "page", defaultValue = "0") int p, @RequestParam(value = "size", defaultValue = "5") int s
            , @RequestParam(defaultValue = "", name = "quotesText") String quotesText) {
        Page<Quotes> pageQuotes = quotesRepository.chercher("%" + quotesText + "%", PageRequest.of(p, s));
        model.addAttribute("listQuotes", pageQuotes);
        int[] pages = new int[pageQuotes.getTotalPages()];
        model.addAttribute("page", pages);
        model.addAttribute("pageCourante", p);
        model.addAttribute("quotesText", quotesText);
        return "quoteManagment";
    }

    @RequestMapping(value = "/deleteQuotes", method = RequestMethod.GET)
    public String delete(Long codeQuotes, @RequestParam(value = "page", defaultValue = "0") int p, @RequestParam(value = "size", defaultValue = "5") int s
            , @RequestParam(defaultValue = "", name = "quotesText")
                                 String quotesText)

    {
        quotesRepository.deleteById(codeQuotes);
        return "redirect:/allQuotes?page="+p+"&size="+s+"&quotesText="+quotesText;
    }


    @RequestMapping(value = "/editQuotes",method = RequestMethod.GET)
    public String editQuotes(Model model,Long codeQuotes){
        Quotes quotes = quotesRepository.getOne(codeQuotes);
        model.addAttribute("quotes",quotes);
        return "editQuotes";

    }

}
