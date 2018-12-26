// Generated code from Butter Knife. Do not modify!
package com.tuding.client.eightnumcolour.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class SetNickNameAndPsActivity$$ViewBinder<T extends com.tuding.client.eightnumcolour.activity.SetNickNameAndPsActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296355, "field 'etNickname'");
    target.etNickname = finder.castView(view, 2131296355, "field 'etNickname'");
    view = finder.findRequiredView(source, 2131296357, "field 'etPs'");
    target.etPs = finder.castView(view, 2131296357, "field 'etPs'");
    view = finder.findRequiredView(source, 2131296359, "field 'etSecondPs'");
    target.etSecondPs = finder.castView(view, 2131296359, "field 'etSecondPs'");
    view = finder.findRequiredView(source, 2131296599, "field 'tvNext'");
    target.tvNext = finder.castView(view, 2131296599, "field 'tvNext'");
    view = finder.findRequiredView(source, 2131296409, "field 'ivBack'");
    target.ivBack = finder.castView(view, 2131296409, "field 'ivBack'");
  }

  @Override public void unbind(T target) {
    target.etNickname = null;
    target.etPs = null;
    target.etSecondPs = null;
    target.tvNext = null;
    target.ivBack = null;
  }
}
