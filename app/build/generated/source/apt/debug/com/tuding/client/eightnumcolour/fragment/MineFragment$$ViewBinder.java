// Generated code from Butter Knife. Do not modify!
package com.tuding.client.eightnumcolour.fragment;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MineFragment$$ViewBinder<T extends com.tuding.client.eightnumcolour.fragment.MineFragment> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296411, "field 'ivSetting'");
    target.ivSetting = finder.castView(view, 2131296411, "field 'ivSetting'");
    view = finder.findRequiredView(source, 2131296377, "field 'headPortraitRiv'");
    target.headPortraitRiv = finder.castView(view, 2131296377, "field 'headPortraitRiv'");
    view = finder.findRequiredView(source, 2131296440, "field 'mineGv'");
    target.mineGv = finder.castView(view, 2131296440, "field 'mineGv'");
    view = finder.findRequiredView(source, 2131296333, "field 'daletouIv'");
    target.daletouIv = finder.castView(view, 2131296333, "field 'daletouIv'");
    view = finder.findRequiredView(source, 2131296335, "field 'daletouTitleTv'");
    target.daletouTitleTv = finder.castView(view, 2131296335, "field 'daletouTitleTv'");
    view = finder.findRequiredView(source, 2131296414, "field 'kaijiangIv'");
    target.kaijiangIv = finder.castView(view, 2131296414, "field 'kaijiangIv'");
    view = finder.findRequiredView(source, 2131296415, "field 'kaijiangTitleTv'");
    target.kaijiangTitleTv = finder.castView(view, 2131296415, "field 'kaijiangTitleTv'");
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
