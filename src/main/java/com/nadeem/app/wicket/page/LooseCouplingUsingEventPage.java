package com.nadeem.app.wicket.page;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.value.ValueMap;

import com.nadeem.app.wicket.event.AjaxUpdateEvent;
import com.nadeem.app.wicket.event.AjaxUpdateListener;
import com.nadeem.app.wicket.event.RefreashFeedBackPanelEvent;
import com.nadeem.app.wicket.panel.SearchPanel;

public class LooseCouplingUsingEventPage extends WebPage implements AjaxUpdateListener {
	
	private FeedbackPanel feedbackPanel;

	public LooseCouplingUsingEventPage() {
		feedbackPanel = newFeedbackPanel();
		add(feedbackPanel);
		
		add(new SearchPanel("searchPanel",new Model<ValueMap>()));
		
	}

	private FeedbackPanel newFeedbackPanel() {
		FeedbackPanel feedbackPanel =  new FeedbackPanel("feedbackPanel");
		feedbackPanel.setOutputMarkupPlaceholderTag(true);
		return feedbackPanel;
	}

	public void handleAjaxUpdate(final AjaxUpdateEvent event) {
		if (event instanceof RefreashFeedBackPanelEvent) {
			info("You said : " + ((RefreashFeedBackPanelEvent)event).getSourcData().getString("name"));
			event.getTarget().addComponent(feedbackPanel);
			
			System.out.println(((RefreashFeedBackPanelEvent)event).getSourcData());
		}
		System.out.println(event);
	}
}
