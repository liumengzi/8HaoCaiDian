// Generated code from Butter Knife. Do not modify!
package com.tuding.client.eightnumcolour.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class LoginActivity$$ViewBinder<T extends com.tuding.client.eightnumcolour.activity.LoginActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296363, "field 'etPhone'");
    target.etPhone = finder.castView(view, 2131296363, "field 'etPhone'");
    view = finder.findRequiredView(source, 2131296364, "field 'etPs'");
    target.etPs = finder.castView(view, 2131296364, "field 'etPs'");
    view = finder.findRequiredView(source, 2131296511, "field 'retrievePasswordTv'");
    target.retrievePasswordTv = finder.castView(view, 2131296511, "field 'retrievePasswordTv'");
    view = finder.findRequiredView(source, 2131296436, "field 'loginTv'");
    target.loginTv = finder.castView(view, 2131296436, "field 'loginTv'");
    view = finder.findRequiredView(source, 2131296508, "field 'registerTv'");
    target.registerTv = finder.castView(view, 2131296508, "field 'registerTv'");
    view = finder.findRequiredView(source, 2131296417, "field 'ivBack'");
    target.ivBack = finder.castView(view, 2131296417, "field 'ivBack'");
  }

  @Override public void unbind(T target) {
    target.etPhone = null;
    target.etPs = null;
    target.retrievePasswordTv = null;
    target.loginTv = null;
    target.registerTv = null;
    target.ivBack = null;
  }
}
