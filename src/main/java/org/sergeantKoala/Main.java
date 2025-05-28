package org.sergeantKoala;

import org.sergeantKoala.repository.UserRepository;
import org.sergeantKoala.service.Mockloader;

public class Main {
    public static void main(String[] args) {
    Mockloader mockloader= new Mockloader();
    Mockloader.loadMockdata();
    soutMock();



    }

    public static void soutMock(){
        System.out.println(UserRepository.getInstance().findByName("Anna Müller").getEmail());
    }
}