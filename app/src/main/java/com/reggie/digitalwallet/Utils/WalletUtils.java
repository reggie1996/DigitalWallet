package com.reggie.digitalwallet.Utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.reggie.digitalwallet.R;

/**
 * Created by 24073 on 2018/1/30.
 */

public class WalletUtils {


    public static void generateWallet(Context context){
        boolean wrapInScrollView = true;
        new MaterialDialog.Builder(context)
                .title("创建钱包")
                .customView(R.layout.dialog_generate_wallet, wrapInScrollView)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        View view = dialog.getCustomView();
                        EditText et = view.findViewById(R.id.et_gen_wallet_name);

                    }
                })
                .show();
    }

    public static void importWallet(Context context){
        boolean wrapInScrollView = true;
        new MaterialDialog.Builder(context)
                .title("导入钱包")
                .customView(R.layout.dialog_import_wallet, wrapInScrollView)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        View view = dialog.getCustomView();
                    }
                })
                .show();
    }

}
