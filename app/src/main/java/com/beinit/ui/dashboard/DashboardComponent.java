package com.beinit.ui.dashboard;


import com.beinit.AppComponent;
import com.beinit.ui.dashboard.fragments.account.MyAccountFragment;
import com.beinit.ui.dashboard.fragments.account.channels.ChannelsFragment;
import com.beinit.ui.dashboard.fragments.account.channels.blocked.ChannelsBlockedFragment;
import com.beinit.ui.dashboard.fragments.account.channels.followers.ChannelsFollowersFragment;
import com.beinit.ui.dashboard.fragments.account.channels.following.ChannelsFollowingFragment;
import com.beinit.ui.dashboard.fragments.account.livestreaming.LiveStreamingFragment;
import com.beinit.ui.dashboard.fragments.account.livestreaming.favourites.FavouritesLiveStreamsFragment;
import com.beinit.ui.dashboard.fragments.account.livestreaming.mylivestreams.MyLiveStreamsFragment;
import com.beinit.ui.dashboard.fragments.account.profile.ProfileFragment;
import com.beinit.ui.dashboard.fragments.account.settings.SettingFragment;
import com.beinit.ui.dashboard.fragments.account.settings.about.AboutFragment;
import com.beinit.ui.dashboard.fragments.account.settings.account.AccountFragment;
import com.beinit.ui.dashboard.fragments.account.settings.changepassword.ChangePasswordFragment;
import com.beinit.ui.dashboard.fragments.account.settings.social.SocialFragment;
import com.beinit.ui.dashboard.fragments.account.settings.streamingquality.StreamingQualityFragment;
import com.beinit.ui.dashboard.fragments.account.videos.VideosFragment;
import com.beinit.ui.dashboard.fragments.account.videos.favourites.FavouritesVideosFragment;
import com.beinit.ui.dashboard.fragments.account.videos.myvideos.MyVideosFragment;
import com.beinit.ui.dashboard.fragments.discover.DiscoverFragment;
import com.beinit.ui.dashboard.fragments.discover.fragments.CategoriesFragment;
import com.beinit.ui.dashboard.fragments.discover.fragments.ChannelFragment;
import com.beinit.ui.dashboard.fragments.home.HomeFragment;
import com.beinit.ui.dashboard.fragments.search.SearchFragment;
import com.beinit.ui.dashboard.fragments.stream.StreamFragment;

import dagger.Component;

@DashboardScope
@Component(dependencies = AppComponent.class, modules = {DashboardModule.class, ApiModule.class})
public interface DashboardComponent extends DashboardGraph {

    void inject(DashboardActivity mActivity);

    void inject(HomeFragment mFragment);

    void inject(DiscoverFragment mFragment);

    void inject(StreamFragment mFragment);

    void inject(SearchFragment mFragment);

    void inject(ChannelFragment mFragment);

    void inject(CategoriesFragment mFragment);

    void inject(MyAccountFragment mFragment);

    void inject(SettingFragment mFragment);

    void inject(AccountFragment mFragment);

    void inject(ChangePasswordFragment mFragment);

    void inject(StreamingQualityFragment mFragment);

    void inject(AboutFragment mFragment);

    void inject(SocialFragment mFragment);

    void inject(ProfileFragment mFragment);

    void inject(LiveStreamingFragment mFragment);

    void inject(ChannelsFragment mFragment);

    void inject(VideosFragment mFragment);

    void inject(FavouritesLiveStreamsFragment mFragment);

    void inject(MyLiveStreamsFragment mFragment);

    void inject(FavouritesVideosFragment mFragment);

    void inject(MyVideosFragment mFragment);

    void inject(ChannelsBlockedFragment mFragment);

    void inject(ChannelsFollowersFragment mFragment);

    void inject(ChannelsFollowingFragment mFragment);
}


