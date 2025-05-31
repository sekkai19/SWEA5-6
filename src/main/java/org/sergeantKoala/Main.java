package org.sergeantKoala;

import org.sergeantKoala.service.MockLoader;
import org.sergeantKoala.service.Scheduler;

public class Main {
    private static Scheduler scheduler=new Scheduler();
    public static void main(String[] args) {
    MockLoader.loadMockdata();
    scheduler.start();




    }


}