// Generated code from Butter Knife. Do not modify!
package com.tuding.client.eightnumcolour.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class RetrievePasswordActivity$$ViewBinder<T extends com.tuding.client.eightnumcolour.activity.RetrievePasswordActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296409, "field 'ivBack'");
    target.ivBack = finder.castView(view, 2131296409, "field 'ivBack'");
    view = finder.findRequiredView(source, 2131296355, "field 'etNickname'");
    target.etNickname = finder.castView(view, 2131296355, "field 'etNickname'");
    view = finder.findRequiredView(source, 2131296390, "field 'iconYan'");
    target.iconYan = finder.castView(view, 2131296390, "field 'iconYan'");
    view = finder.findRequiredView(source, 2131296360, "field 'etSms'");
    target.etSms = finder.castView(view, 2131296360, "field 'etSms'");
    view = finder.findRequiredView(source, 2131296598, "field 'tvGetSmscode'");
    target.tvGetSmscode = finder.castView(view, 2131296598, "field 'tvGetSmscode'");
    view = finder.findRequiredView(source, 2131296357, "field 'etPs'");
    target.etPs = finder.castView(view, 2131296357, "field 'etPs'");
    view = finder.findRequiredView(source, 2131296359, "field 'etSecondPs'");
    target.etSecondPs = finder.castView(view, 2131296359, "field 'etSecondPs'");
    view = finder.findRequiredView(source, 2131296599, "field 'tvNext'");
    target.tvNext = finder.castView(view, 2131296599, "field 'tvNext'");
  }

  @Override public void unbind(T target) {
    target.ivBack = null;
    target.etNickname = null;
    target.iconYan = null;
    target.etSms = null;
    target.tvGetSmscode = null;
    target.etPs = null;
    target.etSecondPs = null;
    target.tvNext = null;
  }
}
