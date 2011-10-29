package com.nadeem.app.wicket.panel;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.value.ValueMap;


public class ResultPanel extends Panel {

	private static final long serialVersionUID = 1L;

	private final IModel<ValueMap> searchModel;

	public ResultPanel(String id, IModel<ValueMap> searchModel) {
		super(id, searchModel);
		this.searchModel = searchModel;

		add(new Label("message", searchModel.getObject().getString("name")));
		this.setOutputMarkupPlaceholderTag(true);
	}

	@Override
	public boolean isVisible() {
		return searchModel.getObject() != null;
	}

}
