package com.nadeem.app.wicket.panel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.value.ValueMap;

import com.nadeem.app.wicket.event.RefreashFeedBackPanelEvent;

public class SearchPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public SearchPanel(String id, IModel<ValueMap> iModel) {
		super(id, iModel);
		add(newForm(iModel));
	}

	private Form<ValueMap> newForm(final IModel<ValueMap> model) {
		final Form<ValueMap> searchForm = new Form<ValueMap>("searchForm", new CompoundPropertyModel<ValueMap>(new ValueMap()));
		searchForm.add(new TextField<String>("name"));
		searchForm.add(newButton(model, searchForm));

		return searchForm;
	}

	private Button newButton(final IModel<ValueMap> model, final Form<ValueMap> searchForm) {
		return new AjaxButton(("sayHello")) {

			private static final long serialVersionUID = 1L;
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				model.setObject(searchForm.getModelObject());
				new RefreashFeedBackPanelEvent(SearchPanel.this, target, searchForm.getModelObject()).fire();
			}
		};
	}
}
