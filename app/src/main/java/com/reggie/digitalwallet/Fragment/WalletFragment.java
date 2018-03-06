package com.reggie.digitalwallet.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.reggie.digitalwallet.Activity.ReciveActivity;
import com.reggie.digitalwallet.Activity.SendActivity;
import com.reggie.digitalwallet.KChart.ExampleActivity;
import com.reggie.digitalwallet.KChart.LoadMoreActivity;
import com.reggie.digitalwallet.Model.Wallet;
import com.reggie.digitalwallet.R;
import com.reggie.digitalwallet.Utils.WalletUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import de.mrapp.android.tabswitcher.Tab;
import de.mrapp.android.tabswitcher.TabSwitcher;
import de.mrapp.android.tabswitcher.TabSwitcherDecorator;

/**
 * A simple {@link Fragment} subclass.
 */
public class WalletFragment extends BaseFragment {

    @BindView(R.id.bt_show_wallet_list)
    Button mBtShowWalletList;
    @BindView(R.id.import_wallet)
    ImageView import_wallet;
    @BindView(R.id.new_wallet)
    ImageView new_wallet;
    private TabSwitcher tabSwitcher;

    private static final String VIEW_TYPE_EXTRA = WalletFragment.class.getName() + "::ViewType";
    private View view;
    private Unbinder unbinder;

    @Override
    protected View initView() {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wallet, container, false);

        tabSwitcher = view.findViewById(R.id.tab_switcher);
        tabSwitcher.setDecorator(new Decorator());

        for (int i = 0; i < 3; i++) {
            tabSwitcher.addTab(createTab(i));
        }
        unbinder = ButterKnife.bind(this, view);


        return view;
    }

    @OnClick({R.id.bt_show_wallet_list, R.id.import_wallet, R.id.new_wallet})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_show_wallet_list:
                tabSwitcher.toggleSwitcherVisibility();
                break;
            case R.id.import_wallet:
                WalletUtils.importWallet(mContext);
                break;
            case R.id.new_wallet:
                WalletUtils.generateWallet(mContext);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private class Decorator extends TabSwitcherDecorator {

        @NonNull
        @Override
        public View onInflateView(@NonNull final LayoutInflater inflater,
                                  @Nullable final ViewGroup parent, final int viewType) {
            View view;
            view = inflater.inflate(R.layout.tab_wallet, parent, false);
            return view;
        }

        @Override
        public void onShowTab(@NonNull final Context context,
                              @NonNull final TabSwitcher tabSwitcher, @NonNull final View view,
                              @NonNull final Tab tab, final int index, final int viewType,
                              @Nullable final Bundle savedInstanceState) {
            Wallet wallet = tab.getParameters().getParcelable("wallet");

            ImageView head = findViewById(R.id.iv_wallet_head);
            TextView name = findViewById(R.id.tv_wallet_name);
            TextView balance = findViewById(R.id.tv_wallet_balance);
            TextView pk = findViewById(R.id.tv_wallet_pk);

            Glide.with(getContext()).load(wallet.getHeadUrl()).into(head);
            name.setText(wallet.getName());
            balance.setText(wallet.getBalance() + "");
            pk.setText(wallet.getPk());

            ImageView trend = findViewById(R.id.iv_trend);
            trend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setClass(getContext(),LoadMoreActivity.class);
                    startActivity(intent);
                }
            });

            //转账
            findViewById(R.id.send_money).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getContext(), SendActivity.class));
                }
            });
            //收款
            findViewById(R.id.recive_money).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getContext(), ReciveActivity.class));
                }
            });


        }

    }

    @NonNull
    private Tab createTab(final int index) {
        CharSequence title = getString(R.string.tab_title, index + 1);
        Tab tab = new Tab(title);
        Wallet wallet = null;
        switch (index){
            case 0:
                wallet  = new Wallet("https://block.gxb.io/api/header/batman111", "batman111", 1000, "备份私钥");
                break;
            case 1:
                wallet  = new Wallet("https://block.gxb.io/api/header/superman111", "superman111", 0, "备份私钥");
                break;
            case 2:
                wallet  = new Wallet("https://block.gxb.io/api/header/flash111", "flash111", 0, "备份私钥");
                break;
            default:
                wallet  = new Wallet("https://block.gxb.io/api/header/batman111", "batman111", 1000, "备份私钥");
                break;
        }
        //用bundle传参数
        Bundle parameters = new Bundle();
        parameters.putInt(VIEW_TYPE_EXTRA, index % 2);
        parameters.putParcelable("wallet", wallet);
        tab.setParameters(parameters);
        return tab;
    }



}
