package com.wisely;

import com.wisely.Web.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WiselyApplication implements CommandLineRunner {


    @Autowired
    private MailService mailService;


    public static void main(String[] args) {
        SpringApplication.run(WiselyApplication.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
        try {

            mailService.send("alimazor529@gmail.com","alimazor1998@gmail.com","Test","Message1");
            System.out.println("Done");


        }catch (Exception e){
            System.out.print(e.getMessage());
        }

    }
}
