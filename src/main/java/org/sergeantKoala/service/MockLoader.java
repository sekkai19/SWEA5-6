package org.sergeantKoala.service;

import org.sergeantKoala.model.observerTypes.MailObserver;
import org.sergeantKoala.model.observerTypes.PushObserver;
import org.sergeantKoala.model.observerTypes.SmsObserver;
import org.sergeantKoala.model.Website;
import org.sergeantKoala.repository.WebsiteRepository;
import org.sergeantKoala.service.comparisionStrategies.ComparisionStrategyEnum;

public class MockLoader {
    public static void loadMockdata() {

        //MailObservers
        MailObserver mailObserver1 = new MailObserver("Dagobert Duck", "dagobertDuck@aol.com", 100);
        MailObserver mailObserver2 = new MailObserver("Jane Smith", "janeSmith@googlemail.com", 30);
        MailObserver mailObserver3 = new MailObserver("Alice Johnson", "aliceJohnson@example.com", 20);
        MailObserver mailObserver4 = new MailObserver("Bob Brown", "bobBrown@gmx.net", 10);

        //PushObservers
        PushObserver pushObserver1 = new PushObserver("John Wick", "14a8f6ee", 25);
        PushObserver pushObserver2 = new PushObserver("Sarah Connor", "9b7c3d2a", 40);
        PushObserver pushObserver3 = new PushObserver("Tony Stark", "3e5f8a1b", 15);
        PushObserver pushObserver4 = new PushObserver("Bruce Wayne", "7d2a4c9f", 30);
        PushObserver pushObserver5 = new PushObserver("Diana Prince", "5f9b3e7a", 20);

        //SmsObservers
        SmsObserver smsObserver1 = new SmsObserver("Charlie Chaplin", "+1-1234567890", 15);
        SmsObserver smsObserver2 = new SmsObserver("Mary Poppins", "+44-9876543210", 25);
        SmsObserver smsObserver3 = new SmsObserver("Sherlock Holmes", "+44-5556667777", 20);
        SmsObserver smsObserver4 = new SmsObserver("Hercule Poirot", "+32-4445556666", 30);


        //Websites
        Website website1 = new Website("https://www.example.com/", ComparisionStrategyEnum.CONTENT_SIZE);
        Website website2 = new Website("https://www.reddit.com/r/airfryer", ComparisionStrategyEnum.TEXT_CONTENT);
        Website website3 = new Website("https://www.reddit.com/r/supplements", ComparisionStrategyEnum.TEXT_CONTENT);
        Website website4 = new Website("https://www.web.de", ComparisionStrategyEnum.HTML_CONTENT);

        WebsiteRepository.getInstance().add(website1);
        WebsiteRepository.getInstance().add(website2);
        WebsiteRepository.getInstance().add(website3);
        WebsiteRepository.getInstance().add(website4);

        website1.attach(mailObserver1);
        website1.attach(pushObserver1);
        website2.attach(smsObserver1);
        website3.attach(pushObserver4);
        website3.attach(smsObserver4);
        website3.attach(mailObserver1);
        website4.attach(mailObserver3);


    }

}
