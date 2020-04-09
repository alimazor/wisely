package com.wisely.Dao;

import com.wisely.Entity.Quotes;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Admin on 31/03/2020.
 */
public interface QuotesRepository extends JpaRepository<Quotes, Long> {


    public static final String FIND_QUOTE = "SELECT * FROM quotes order by rand() limit 1";

    @Query(value = FIND_QUOTE, nativeQuery = true)
    public List<Quotes> getOneQuote();



    @Query("select e from Quotes e where e.quotesText like :x")
    public Page<Quotes> chercher(@Param("x") String e, Pageable pageable);
}
