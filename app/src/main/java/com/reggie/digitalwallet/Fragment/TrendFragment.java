package com.reggie.digitalwallet.Fragment;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhouwei.library.CustomPopWindow;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.reggie.digitalwallet.Fragment.ChildFragment.NewsRecyclerViewFragment;
import com.reggie.digitalwallet.Model.News;
import com.reggie.digitalwallet.R;
import com.reggie.digitalwallet.Test.TestData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendFragment extends BaseFragment {

    List<Fragment> fragments;

    MaterialViewPager materialViewPager;
    ViewPager viewPager;
    ImageButton ib_menu;
    CustomPopWindow popWindow;


    @Override
    protected View initView() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trend, container, false);

        materialViewPager = view.findViewById(R.id.materialViewPager);
        viewPager = materialViewPager.getViewPager();
        materialViewPager.getPagerTitleStrip().setTextColorResource(R.color.colorWhite);
        materialViewPager.getToolbar().removeViewAt(0);


        News[] newslist1 = new News[TestData.getNewsData1().size()];
        TestData.getNewsData1().toArray(newslist1);
        News[] newslist2 = new News[TestData.getNewsData2().size()];
        TestData.getNewsData2().toArray(newslist2);
        News[] newslist3 = new News[TestData.getNewsData3().size()];
        TestData.getNewsData3().toArray(newslist3);
        News[] newslist4 = new News[TestData.getNewsData4().size()];
        TestData.getNewsData4().toArray(newslist4);

        fragments = new ArrayList<>();
        fragments.add(NewsRecyclerViewFragment.newInstance(newslist1));
        fragments.add(NewsRecyclerViewFragment.newInstance(newslist2));
        fragments.add(NewsRecyclerViewFragment.newInstance(newslist3));
        fragments.add(NewsRecyclerViewFragment.newInstance(newslist4));


        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return "热门";
                    case 1:
                        return "比特币";
                    case 2:
                        return "以太币";
                    case 3:
                        return "莱特币";
                }
                return "";
            }
        });


        materialViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                Resources resources = mContext.getResources();
                Drawable drawable;
                switch (page) {
                    case 0:
                        drawable = resources.getDrawable(R.drawable.bg_bitcoin);
                        return HeaderDesign.fromColorResAndDrawable(R.color.colorGold2, drawable);
                    case 1:
                        drawable = resources.getDrawable(R.drawable.test);
                        return HeaderDesign.fromColorResAndDrawable(R.color.colorGold2, drawable);
                    case 2:
                        drawable = resources.getDrawable(R.drawable.test);
                        return HeaderDesign.fromColorResAndDrawable(R.color.colorGold2, drawable);
                    case 3:
                        drawable = resources.getDrawable(R.drawable.test);
                        return HeaderDesign.fromColorResAndDrawable(R.color.colorGold2, drawable);
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        materialViewPager.getViewPager().setOffscreenPageLimit(materialViewPager.getViewPager().getAdapter().getCount());
        materialViewPager.getPagerTitleStrip().setViewPager(materialViewPager.getViewPager());

        ib_menu = view.findViewById(R.id.ib_menu);
        ib_menu.setClickable(true);
        ib_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setIb_menu();
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void setIb_menu(){
        View contentView = LayoutInflater.from(getContext()).inflate(R.layout.item_popup,null);
        handleLogic(contentView);
        popWindow = new CustomPopWindow.PopupWindowBuilder(getContext())
                .setView(R.layout.item_popup)//显示的布局
                .create()//创建PopupWindow
                .showAsDropDown(ib_menu,0,10);//显示PopupWindow
    }

    private void handleLogic(View contentView){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(popWindow!=null){
                    popWindow.dissmiss();
                }
                switch (v.getId()){
                    case R.id.tv_add:
                        Toast.makeText(getContext(),"dsabduabsiuda",Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };
        contentView.findViewById(R.id.tv_add).setOnClickListener(listener);
    }

}
