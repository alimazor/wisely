package com.wisely.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Admin on 31/03/2020.
 */
@Entity
public class Quotes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codeQuotes;


    private String titleQuotes;


    private String quotesText;

    public Quotes() {
        super();
    }

    public Quotes(String titleQuotes, String quotesText) {

        this.titleQuotes = titleQuotes;
        this.quotesText = quotesText;
    }

    public Long getCodeQuotes() {
        return codeQuotes;
    }

    public void setCodeQuotes(Long codeQuotes) {
        this.codeQuotes = codeQuotes;
    }

    public String getTitleQuotes() {
        return titleQuotes;
    }

    public void setTitleQuotes(String titleQuotes) {
        this.titleQuotes = titleQuotes;
    }

    public String getQuotesText() {
        return quotesText;
    }

    public void setQuotesText(String quotesText) {
        this.quotesText = quotesText;
    }
}
