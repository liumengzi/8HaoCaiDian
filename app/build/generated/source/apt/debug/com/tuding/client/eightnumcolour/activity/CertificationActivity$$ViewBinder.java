// Generated code from Butter Knife. Do not modify!
package com.tuding.client.eightnumcolour.activity;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class CertificationActivity$$ViewBinder<T extends com.tuding.client.eightnumcolour.activity.CertificationActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296417, "field 'ivBack'");
    target.ivBack = finder.castView(view, 2131296417, "field 'ivBack'");
    view = finder.findRequiredView(source, 2131296365, "field 'etRealName'");
    target.etRealName = finder.castView(view, 2131296365, "field 'etRealName'");
    view = finder.findRequiredView(source, 2131296361, "field 'etIdcardno'");
    target.etIdcardno = finder.castView(view, 2131296361, "field 'etIdcardno'");
    view = finder.findRequiredView(source, 2131296310, "field 'btRenzheng'");
    target.btRenzheng = finder.castView(view, 2131296310, "field 'btRenzheng'");
  }

  @Override public void unbind(T target) {
    target.ivBack = null;
    target.etRealName = null;
    target.etIdcardno = null;
    target.btRenzheng = null;
  }
}
