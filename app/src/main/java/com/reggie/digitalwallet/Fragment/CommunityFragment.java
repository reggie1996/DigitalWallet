package com.reggie.digitalwallet.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.just.agentweb.IVideo;
import com.reggie.digitalwallet.Activity.ConversationActivity;
import com.reggie.digitalwallet.Activity.WriteMomentActivity;
import com.reggie.digitalwallet.Fragment.ChildFragment.Community1RecyclerViewFragment;
import com.reggie.digitalwallet.Fragment.ChildFragment.Community2RecyclerViewFragment;
import com.reggie.digitalwallet.Fragment.ChildFragment.Community3RecyclerViewFragment;
import com.reggie.digitalwallet.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class CommunityFragment extends BaseFragment {

    TabLayout tablayout;
    ViewPager viewpager;
    FragmentPagerAdapter adapter;
    private View view;

    private List<String> list_title;

    private DrawerLayout drawer;
    private ImageView iv_community_friendlist;
    private ImageView iv_community_message;
    private View drawer_friendlist;

    private View friend1;

    @Override
    protected View initView() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_community, container, false);

        tablayout = view.findViewById(R.id.tablayout);
        viewpager = view.findViewById(R.id.viewpager);
        drawer = view.findViewById(R.id.drawer);
        iv_community_friendlist = view.findViewById(R.id.iv_community_friendlist);
        iv_community_message = view.findViewById(R.id.iv_community_message);
        drawer_friendlist = view.findViewById(R.id.drawer_friendlist);
        friend1 = view.findViewById(R.id.friend1);

        list_title = new ArrayList<>();
        list_title.add("热门");
        list_title.add("关注");
        list_title.add("达人");

        adapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return new Community1RecyclerViewFragment();
                    case 1:
                        return new Community2RecyclerViewFragment();
                    case 2:
                        return new Community3RecyclerViewFragment();
                    default:
                        return new Community1RecyclerViewFragment();
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return list_title.get(position);
            }
        };

        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);

        iv_community_friendlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(drawer_friendlist);
            }
        });

        iv_community_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getContext(), WriteMomentActivity.class),1);
            }
        });

        friend1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ConversationActivity.class));
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                //Toast.makeText(getContext(),"dsadasdasdsa",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}
