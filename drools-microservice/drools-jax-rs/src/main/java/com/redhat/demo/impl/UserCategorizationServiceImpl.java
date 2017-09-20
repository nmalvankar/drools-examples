package com.redhat.demo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.kie.api.cdi.KReleaseId;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import com.redhat.demo.api.UserCategorizationService;
import com.redhat.demo.model.User;

/**
 *
 * @author Nikhil Malvankar
 */
@ApplicationScoped
public class UserCategorizationServiceImpl implements UserCategorizationService {
	
	/*@Inject
	private BRMSUtil brmsUtil;*/
	
    /*@Inject
    @KReleaseId(groupId = "org.drools.workshop", artifactId = "drools-user-kjar", version = "LATEST")
    @KSession
    private KieSession kSession;*/
	
	@Inject
    @KReleaseId(groupId = "com.redhat.demo", artifactId = "drools-user-kjar", version = "LATEST")
	private KieContainer kContainer;

    public UserCategorizationServiceImpl() {
    }

    @Override
    public User categorizeUser(User user) {
    	StatelessKieSession kSession = kContainer.newStatelessKieSession();
        System.out.println(">> kSession: " + kSession);
        System.out.println(">> User: " + user);
        kSession.execute(user);
        return user;

    }
    
    
    @Override
    public User categorizeUserStateful(User user) {
    	KieSession kSession = kContainer.newKieSession();
        System.out.println(">> kSession: " + kSession);
        printKieSessionAllFacts(kSession);
        System.out.println(">> User: " + user);
        kSession.insert(user);
        int fired = kSession.fireAllRules();
        System.out.println(">> Fired: " + fired);
        return user;

    }
    
    @Override
    public List<User> getUsers() {
    	KieSession kSession = kContainer.newKieSession();
        List<User> users = new ArrayList<User>();
        for (Object o : kSession.getObjects()) {
            if (o instanceof User) {
                users.add((User) o);
            }
        }
        return users;
    }

    private void printKieSessionAllFacts(KieSession kSession) {
        System.out.println(" >> Start - Printing All Facts in the Kie Session");
        for (Object o : kSession.getObjects()) {
            System.out.println(">> Fact: " + o);
        }
        System.out.println(" >> End - Printing All Facts in the Kie Session");
    }

}
