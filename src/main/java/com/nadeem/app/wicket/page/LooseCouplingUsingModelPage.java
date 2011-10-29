package com.nadeem.app.wicket.page;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.value.ValueMap;

import com.nadeem.app.wicket.model.ChangeSensitiveModel;
import com.nadeem.app.wicket.panel.ResultPanel;
import com.nadeem.app.wicket.panel.SearchPanel;

public class LooseCouplingUsingModelPage extends WebPage {

	private static final String SEARCH_PANEL_ID = "searchPanel";
	private static final String RESULT_PANEL_ID = "resultPanel";
	private ChangeSensitiveModel<ValueMap> changeSensitiveModel;

	public LooseCouplingUsingModelPage() {

		changeSensitiveModel = new ChangeSensitiveModel<ValueMap>(){

			private static final long serialVersionUID = 1L;

			@Override
			protected void onAfterSet() {
				LooseCouplingUsingModelPage.this.addOrReplace(new ResultPanel(RESULT_PANEL_ID, changeSensitiveModel));
				AjaxRequestTarget ajaxRequestTarget = AjaxRequestTarget.get();
				if (ajaxRequestTarget != null) {
					ajaxRequestTarget.addComponent(LooseCouplingUsingModelPage.this.get(RESULT_PANEL_ID));
				}
			}
		};
		add(new SearchPanel(SEARCH_PANEL_ID, changeSensitiveModel));
		add(newEmptyPanel());
	}

	private Panel newEmptyPanel() {
		Panel emptyPanel = new EmptyPanel(RESULT_PANEL_ID);
		emptyPanel.setOutputMarkupPlaceholderTag(true);
		return emptyPanel;
	}

}
