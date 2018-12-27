// Generated code from Butter Knife. Do not modify!
package com.tuding.client.eightnumcolour.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MineFragment$$ViewBinder<T extends com.tuding.client.eightnumcolour.fragment.MineFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296419, "field 'ivSetting'");
    target.ivSetting = finder.castView(view, 2131296419, "field 'ivSetting'");
    view = finder.findRequiredView(source, 2131296385, "field 'headPortraitRiv'");
    target.headPortraitRiv = finder.castView(view, 2131296385, "field 'headPortraitRiv'");
    view = finder.findRequiredView(source, 2131296448, "field 'mineGv'");
    target.mineGv = finder.castView(view, 2131296448, "field 'mineGv'");
    view = finder.findRequiredView(source, 2131296338, "field 'daletouIv'");
    target.daletouIv = finder.castView(view, 2131296338, "field 'daletouIv'");
    view = finder.findRequiredView(source, 2131296340, "field 'daletouTitleTv'");
    target.daletouTitleTv = finder.castView(view, 2131296340, "field 'daletouTitleTv'");
    view = finder.findRequiredView(source, 2131296422, "field 'kaijiangIv'");
    target.kaijiangIv = finder.castView(view, 2131296422, "field 'kaijiangIv'");
    view = finder.findRequiredView(source, 2131296423, "field 'kaijiangTitleTv'");
    target.kaijiangTitleTv = finder.castView(view, 2131296423, "field 'kaijiangTitleTv'");
  }

  @Override public void unbind(T target) {
    target.ivSetting = null;
    target.headPortraitRiv = null;
    target.mineGv = null;
    target.daletouIv = null;
    target.daletouTitleTv = null;
    target.kaijiangIv = null;
    target.kaijiangTitleTv = null;
  }
}
