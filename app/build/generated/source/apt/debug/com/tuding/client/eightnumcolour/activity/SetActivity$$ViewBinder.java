// Generated code from Butter Knife. Do not modify!
package com.tuding.client.eightnumcolour.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SetActivity$$ViewBinder<T extends com.tuding.client.eightnumcolour.activity.SetActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296409, "field 'ivBack'");
    target.ivBack = finder.castView(view, 2131296409, "field 'ivBack'");
    view = finder.findRequiredView(source, 2131296426, "field 'log_out_tv'");
    target.log_out_tv = finder.castView(view, 2131296426, "field 'log_out_tv'");
  }

  @Override public void unbind(T target) {
    target.ivBack = null;
    target.log_out_tv = null;
  }
}
