// Generated code from Butter Knife. Do not modify!
package com.tuding.client.eightnumcolour.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class RegisterActivity$$ViewBinder<T extends com.tuding.client.eightnumcolour.activity.RegisterActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296355, "field 'etPhone'");
    target.etPhone = finder.castView(view, 2131296355, "field 'etPhone'");
    view = finder.findRequiredView(source, 2131296389, "field 'iconYan'");
    target.iconYan = finder.castView(view, 2131296389, "field 'iconYan'");
    view = finder.findRequiredView(source, 2131296359, "field 'etSms'");
    target.etSms = finder.castView(view, 2131296359, "field 'etSms'");
    view = finder.findRequiredView(source, 2131296594, "field 'tvGetSmscode'");
    target.tvGetSmscode = finder.castView(view, 2131296594, "field 'tvGetSmscode'");
    view = finder.findRequiredView(source, 2131296595, "field 'tvNext'");
    target.tvNext = finder.castView(view, 2131296595, "field 'tvNext'");
    view = finder.findRequiredView(source, 2131296408, "field 'ivBack'");
    target.ivBack = finder.castView(view, 2131296408, "field 'ivBack'");
  }

  @Override public void unbind(T target) {
    target.etPhone = null;
    target.iconYan = null;
    target.etSms = null;
    target.tvGetSmscode = null;
    target.tvNext = null;
    target.ivBack = null;
  }
}
