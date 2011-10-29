package com.nadeem.app.wicket.model;

import java.io.Serializable;

import org.apache.wicket.model.Model;

public class ChangeSensitiveModel<T extends Serializable> extends Model<T> {

	private static final long serialVersionUID = 1L;

	public ChangeSensitiveModel() {

	}

	public ChangeSensitiveModel(final T object) {
		super(object);
	}

	final public void setObject(final T newObject) {
		if (onBeforeSet(newObject)) {
			super.setObject(newObject);
			onAfterSet();
		}
	}

	protected boolean onBeforeSet(T newObject) {
		return true;
	}

	protected void onAfterSet() {

	}
}
