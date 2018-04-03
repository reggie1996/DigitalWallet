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

import com.afollestad.materialdialogs.MaterialDialog;
import com.bumptech.glide.Glide;
import com.reggie.digitalwallet.Activity.Backup1Activity;
import com.reggie.digitalwallet.Activity.Backup2Activity;
import com.reggie.digitalwallet.Activity.GXSExplorerActivity;
import com.reggie.digitalwallet.Activity.ReciveActivity;
import com.reggie.digitalwallet.Activity.SendActivity;
import com.reggie.digitalwallet.KChart.LoadMoreActivity;
import com.reggie.digitalwallet.Model.Wallet;
import com.reggie.digitalwallet.R;
import com.reggie.digitalwallet.Utils.WalletUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.mrapp.android.tabswitcher.Tab;
import de.mrapp.android.tabswitcher.TabSwitcher;
import de.mrapp.android.tabswitcher.TabSwitcherDecorator;

import static java.lang.Thread.sleep;

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
    @BindView(R.id.search)
    ImageView search;
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        import_wallet.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //Toast.makeText(getContext(),"adsad",Toast.LENGTH_LONG).show();
                final MaterialDialog materialDialog = new MaterialDialog.Builder(getContext())
                        .title("正在获取数据")
                        .content("请稍等...")
                        .progress(true, 0)
                        .show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            sleep(3000);
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    materialDialog.dismiss();
                                    new MaterialDialog.Builder(getContext())
                                            .title("返回消息")
                                            .content("钱包导入成功！")
                                            .positiveText("确认")
                                            .show();
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

                return true;
            }
        });
        new_wallet.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                final MaterialDialog materialDialog = new MaterialDialog.Builder(getContext())
                        .title("正在获取数据")
                        .content("请稍等...")
                        .progress(true, 0)
                        .show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            sleep(3000);
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    materialDialog.dismiss();
                                    new MaterialDialog.Builder(getContext())
                                            .title("返回消息")
                                            .content("创建成功！")
                                            .positiveText("确认")
                                            .show();
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();


                return true;
            }
        });
    }

    @OnClick({R.id.bt_show_wallet_list, R.id.import_wallet, R.id.new_wallet, R.id.search})
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
            case R.id.search:
                startActivity(new Intent(getContext(), GXSExplorerActivity.class));
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

            pk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //私钥备份
                    startActivity(new Intent(getContext(), Backup1Activity.class));
                }
            });

            pk.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    //助记词备份
                    startActivity(new Intent(getContext(), Backup2Activity.class));
                    return true;
                }
            });

            ImageView trend = findViewById(R.id.iv_trend);
            trend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setClass(getContext(), LoadMoreActivity.class);
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
        switch (index) {
            case 0:
                wallet = new Wallet("https://block.gxb.io/api/header/batman111", "batman111", 99.47, "私钥备份  |  助记词备份");
                break;
            case 1:
                wallet = new Wallet("https://block.gxb.io/api/header/superman111", "superman111", 0, "私钥备份  |  助记词备份");
                break;
            case 2:
                wallet = new Wallet("https://block.gxb.io/api/header/flash111", "flash111", 0, "私钥备份  |  助记词备份");
                break;
            default:
                wallet = new Wallet("https://block.gxb.io/api/header/batman111", "batman111", 99.47, "私钥备份  |  助记词备份");
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
