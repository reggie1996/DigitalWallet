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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.reggie.digitalwallet.Activity.ReciveActivity;
import com.reggie.digitalwallet.Activity.SendActivity;
import com.reggie.digitalwallet.Model.Wallet;
import com.reggie.digitalwallet.R;

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
                Toast.makeText(getContext(),"导入钱包",Toast.LENGTH_LONG).show();
                break;
            case R.id.new_wallet:
                Toast.makeText(getContext(),"新建钱包",Toast.LENGTH_LONG).show();
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

            CircleImageView head = findViewById(R.id.iv_wallet_head);
            TextView name = findViewById(R.id.tv_wallet_name);
            TextView balance = findViewById(R.id.tv_wallet_balance);
            TextView pk = findViewById(R.id.tv_wallet_pk);

            Glide.with(getContext()).load(wallet.getHeadUrl()).into(head);
            name.setText(wallet.getName());
            balance.setText(wallet.getBalance() + "");
            pk.setText(wallet.getPk());

            //转账
            findViewById(R.id.send_money).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "转账" + index, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getContext(), SendActivity.class));
                }
            });
            //收款
            findViewById(R.id.recive_money).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), "收款" + index, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getContext(), ReciveActivity.class));
                }
            });


        }

    }

    @NonNull
    private Tab createTab(final int index) {
        CharSequence title = getString(R.string.tab_title, index + 1);
        Tab tab = new Tab(title);

        Wallet wallet = new Wallet("http://image11.m1905.cn/uploadfile/2012/0509/20120509110013368.jpg", "第一个钱包", 1000, "0xhudafshfuhdsjafhjshfjksf");
        //用bundle传参数
        Bundle parameters = new Bundle();
        parameters.putInt(VIEW_TYPE_EXTRA, index % 2);
        parameters.putParcelable("wallet", wallet);
        tab.setParameters(parameters);
        return tab;
    }


}
