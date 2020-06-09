package com.springframework.togaspringmvc.bootstrap;

import com.springframework.togaspringmvc.domain.User;
import com.springframework.togaspringmvc.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final UserRepository userRepository;

    public BootStrapData(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public void run(String... args)throws Exception{
        System.out.println("Loading data");
    }


}
