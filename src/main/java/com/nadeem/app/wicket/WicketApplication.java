package com.nadeem.app.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import com.nadeem.app.wicket.page.HomePage;


public class WicketApplication extends WebApplication {    
   
	public WicketApplication() {

	}

	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

}
