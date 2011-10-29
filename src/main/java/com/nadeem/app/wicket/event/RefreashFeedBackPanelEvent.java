package com.nadeem.app.wicket.event;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.util.value.ValueMap;

public class RefreashFeedBackPanelEvent extends AjaxUpdateEvent {

	private static final long serialVersionUID = 1L;
	
	private ValueMap sourcData;

	public RefreashFeedBackPanelEvent(Component source, AjaxRequestTarget target, ValueMap valueMap) {
		super(source, target);
		this.sourcData = valueMap;
	}

	public ValueMap getSourcData() {
		return sourcData;
	}

	public void setSourcData(ValueMap sourcData) {
		this.sourcData = sourcData;
	}
	
}
