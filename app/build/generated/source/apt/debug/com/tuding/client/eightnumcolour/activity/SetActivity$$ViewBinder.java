// Generated code from Butter Knife. Do not modify!
package com.tuding.client.eightnumcolour.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SetActivity$$ViewBinder<T extends com.tuding.client.eightnumcolour.activity.SetActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296408, "field 'ivBack'");
    target.ivBack = finder.castView(view, 2131296408, "field 'ivBack'");
  }

  @Override public void unbind(T target) {
    target.ivBack = null;
  }
}
