package com.nadeem.app.wicket.event;

import org.apache.wicket.Component;
import org.apache.wicket.Component.IVisitor;
import org.apache.wicket.IClusterable;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;

public abstract class AjaxUpdateEvent implements IClusterable {

	private static final long serialVersionUID = 1L;
	private final AjaxRequestTarget target;
	private final Component source;

	public AjaxUpdateEvent(final Component source, final AjaxRequestTarget ajaxRequestTarget) {
		this.source = source;
		this.target = ajaxRequestTarget;
	}

	public Component getSource() {
		return this.source;
	}

	public AjaxRequestTarget getTarget() {
		return this.target;
	}

	public final void fire() {
		final Page p = getSource().getPage();
		p.visitChildren(new BroadcastingVisitor<Component>(this));

		if (p instanceof AjaxUpdateListener) {
			((AjaxUpdateListener) p).handleAjaxUpdate(this);
		}
	}

	private static final class BroadcastingVisitor <T extends Component> implements IVisitor <T> {
		private final AjaxUpdateEvent broadcastedEvent;

		public BroadcastingVisitor(final AjaxUpdateEvent event) {
			this.broadcastedEvent = event;
		}

		public Object component(final Component component) {
			if (component instanceof AjaxUpdateListener) {
				((AjaxUpdateListener) component).handleAjaxUpdate(this.broadcastedEvent);
			}
			return IVisitor.CONTINUE_TRAVERSAL;
		}
	}
}
