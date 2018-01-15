package com.reggie.digitalwallet.Fragment;


import android.content.Context;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.reggie.digitalwallet.Activity.MainActivity;
import com.reggie.digitalwallet.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.mrapp.android.tabswitcher.Layout;
import de.mrapp.android.tabswitcher.PullDownGesture;
import de.mrapp.android.tabswitcher.SwipeGesture;
import de.mrapp.android.tabswitcher.Tab;
import de.mrapp.android.tabswitcher.TabSwitcher;
import de.mrapp.android.tabswitcher.TabSwitcherDecorator;
import de.mrapp.android.util.ThemeUtil;

import static de.mrapp.android.util.DisplayUtil.getDisplayWidth;

/**
 * A simple {@link Fragment} subclass.
 */
public class WalletFragment extends BaseFragment {

    private TabSwitcher tabSwitcher;

    private static final String VIEW_TYPE_EXTRA = WalletFragment.class.getName() + "::ViewType";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_wallet, container, false);
        tabSwitcher = view.findViewById(R.id.tab_switcher);
        ViewCompat.setOnApplyWindowInsetsListener(tabSwitcher, createWindowInsetsListener());
        tabSwitcher.setDecorator(new Decorator());
        for (int i = 0; i < 5; i++) {
            tabSwitcher.addTab(createTab(i));
        }


        return view;
    }

    @Override
    protected View initView() {


        return null;
    }

    @Override
    protected void initData() {
    }



    private class Decorator extends TabSwitcherDecorator {

        @NonNull
        @Override
        public View onInflateView(@NonNull final LayoutInflater inflater,
                                  @Nullable final ViewGroup parent, final int viewType) {
            View view;

            if (viewType == 0) {
                view = inflater.inflate(R.layout.tab_edit_text, parent, false);
            } else {
                view = inflater.inflate(R.layout.tab_text_view, parent, false);
            }
            /*
            Toolbar toolbar = view.findViewById(R.id.toolbar);
            toolbar.inflateMenu(R.menu.tab);
            toolbar.setOnMenuItemClickListener(createToolbarMenuListener());
            Menu menu = toolbar.getMenu();
            TabSwitcher.setupWithMenu(tabSwitcher, menu, createTabSwitcherButtonListener());
            */
            return view;
        }

        @Override
        public void onShowTab(@NonNull final Context context,
                              @NonNull final TabSwitcher tabSwitcher, @NonNull final View view,
                              @NonNull final Tab tab, final int index, final int viewType,
                              @Nullable final Bundle savedInstanceState) {
  //          TextView textView = findViewById(android.R.id.title);
//            textView.setText(tab.getTitle());

            //Toolbar toolbar = findViewById(R.id.toolbar);
            //toolbar.setVisibility(tabSwitcher.isSwitcherShown() ? View.GONE : View.VISIBLE);

            if (viewType != 0) {
                EditText editText = findViewById(android.R.id.edit);

                if (savedInstanceState == null) {
                    editText.setText(null);
                }

                editText.requestFocus();
            }
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getViewType(@NonNull final Tab tab, final int index) {
            Bundle parameters = tab.getParameters();
            return parameters != null ? parameters.getInt("1") : 0;
        }

    }

    @NonNull
    private Tab createTab(final int index) {
        CharSequence title = getString(R.string.tab_title, index + 1);
        Tab tab = new Tab(title);
        Bundle parameters = new Bundle();
        parameters.putInt(VIEW_TYPE_EXTRA, index % 2);
        tab.setParameters(parameters);
        return tab;
    }

    @NonNull
    private OnApplyWindowInsetsListener createWindowInsetsListener() {
        return new OnApplyWindowInsetsListener() {

            @Override
            public WindowInsetsCompat onApplyWindowInsets(final View v,
                                                          final WindowInsetsCompat insets) {
                int left = insets.getSystemWindowInsetLeft();
                int top = insets.getSystemWindowInsetTop();
                int right = insets.getSystemWindowInsetRight();
                int bottom = insets.getSystemWindowInsetBottom();
                tabSwitcher.setPadding(left, top, right, bottom);
                float touchableAreaTop = top;

                if (tabSwitcher.getLayout() == Layout.TABLET) {
                    touchableAreaTop += getResources()
                            .getDimensionPixelSize(R.dimen.tablet_tab_container_height);
                }

                RectF touchableArea = new RectF(left, touchableAreaTop,
                        getDisplayWidth(mContext) - right, touchableAreaTop +
                        ThemeUtil.getDimensionPixelSize(mContext, R.attr.actionBarSize));
                tabSwitcher.addDragGesture(
                        new SwipeGesture.Builder().setTouchableArea(touchableArea).create());
                tabSwitcher.addDragGesture(
                        new PullDownGesture.Builder().setTouchableArea(touchableArea).create());
                return insets;
            }

        };
    }


}
