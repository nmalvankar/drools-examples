package com.redhat.demo.config;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

//@ApplicationScoped
public class BRMSUtil {

	private KieContainer kContainer = null;
	private KieBase kBase = null;

	public BRMSUtil() {

	}
	
	//@PostConstruct
	/*public void init(@Observes @Initialized(ApplicationScoped.class) Object init) {
		KieServices kServices = KieServices.Factory.get();

		//groupId = "org.drools.workshop", artifactId = "drools-user-kjar", version = "1.0-SNAPSHOT"
		ReleaseId releaseId = kServices.newReleaseId("com.redhat.demo", "drools-user-kjar", "LATEST");
		kContainer = kServices.newKieContainer(releaseId);
		
		KieScanner kScanner = kServices.newKieScanner(kContainer);
		kScanner.start( 10000L );
	}*/

	public KieBase getKieBase() {
		return kBase;
	}

	public StatelessKieSession getStatelessSession() {
		// configure process mode type
		KieBaseConfiguration kBaseConfig = KieServices.Factory.get().newKieBaseConfiguration();
		kBase = kContainer.newKieBase(kBaseConfig);
		
		return kBase.newStatelessKieSession();

	}
	
	public KieSession getStatefulSession() {
		// configure process mode type
		KieBaseConfiguration kBaseConfig = KieServices.Factory.get().newKieBaseConfiguration();
		kBase = kContainer.newKieBase(kBaseConfig);
		
		return kBase.newKieSession();

	}
}