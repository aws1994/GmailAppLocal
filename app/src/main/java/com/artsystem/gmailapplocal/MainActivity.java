package com.artsystem.gmailapplocal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.artsystem.gmailapplocal.data.FakeDataSource;
import com.artsystem.gmailapplocal.maillist.MailAdapter;
import com.artsystem.gmailapplocal.maillist.MailDiffUtilCallback;
import com.artsystem.gmailapplocal.navigation.LabelItem;
import com.artsystem.gmailapplocal.navigation.MenuItem;
import com.artsystem.gmailapplocal.navigation.NavAdapter;
import com.artsystem.gmailapplocal.navigation.NavItem;
import com.artsystem.gmailapplocal.navigation.NavMenuItemCallback;
import com.artsystem.gmailapplocal.searchactivity.SearchActivity;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mailRecyclerView,navRecyclerview;
    private MailAdapter mailAdapter;
    private ExtendedFloatingActionButton extFab;
    private TextView editSearch;
    private DrawerLayout drawerLayout;
    private ImageView iconDL;
    private NavAdapter navAdapter;
    private int selectedThemeID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        selectedThemeID = R.style.DarkTheme;
        setTheme(selectedThemeID);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if light theme is selected we change to light status bar
        if (selectedThemeID == R.style.AppTheme) {
            setLightStatusBar(getWindow().getDecorView(),this);
        }


        initViews();
        setupFabBehavior();
        initNavMenu();
        swipeRightToRemove();

    }

    private void initViews() {
        extFab = findViewById(R.id.extFab100);
        iconDL = findViewById(R.id.menu_icon);
        mailRecyclerView = findViewById(R.id.rvmail);
        mailAdapter = new MailAdapter(new MailDiffUtilCallback());
        mailRecyclerView.setHasFixedSize(true);
        mailRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mailRecyclerView.setAdapter(mailAdapter);
        mailAdapter.submitList(FakeDataSource.getListMail());
        editSearch = findViewById(R.id.eidtsearch);
        editSearch.setFocusable(false);
        editSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                intent.putExtra("themeid",selectedThemeID);
                intent.setAction(Intent.ACTION_SEARCH);
                startActivity(intent);
            }
        });
    }

    private void swipeRightToRemove() {

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0,  ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                Toast.makeText(MainActivity.this, "on Move", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                Toast.makeText(MainActivity.this, "on Swiped ", Toast.LENGTH_SHORT).show();
                //Remove swiped item from list and notify the RecyclerView
                int position = viewHolder.getAdapterPosition();
                mailAdapter.notifyItemRemoved(position);

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mailRecyclerView);

    }

    private void initNavMenu(){
            // TODO: setup navigation recyclerview list
            // setup nav adapter
            drawerLayout = findViewById(R.id.drawer_layout);
            navRecyclerview = drawerLayout.findViewById(R.id.nav_rv);

            iconDL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    drawerLayout.open();
                }
            });

        // init nav adapter list
        navRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        navRecyclerview.setAdapter(navAdapter);
        List<NavItem> navMenu = new ArrayList<>();

        navMenu.add(new NavItem(
                new MenuItem(R.drawable.ic_baseline_all_inbox_24,"All Inboxes",false,120)
        ));
        navMenu.add(new NavItem(
                new MenuItem(R.drawable.ic_baseline_person_outline_24,"Social",false,20)
        ));
        navMenu.add(new NavItem(
                new MenuItem(R.drawable.ic_outline_local_offer_24,"Promotions",false,120)
        ));
        navMenu.add(new NavItem(
                new MenuItem(R.drawable.ic_outline_forum_24,"Forums",true,5)
        ));
        navMenu.add(new NavItem(new LabelItem("All LABELS")));

        navMenu.add(new NavItem(
                new MenuItem(R.drawable.ic_baseline_star_border_24,"Starred",false)
        ));
        navMenu.add(new NavItem(
                new MenuItem(R.drawable.ic_baseline_snooze_24,"Snoozed",false)
        ));
        navMenu.add(new NavItem(
                new MenuItem(R.drawable.ic_outline_send_24,"Sent",false)
        ));
        navMenu.add(new NavItem(
                new MenuItem(R.drawable.ic_baseline_snooze_24,"Scheduled",false)
        ));
        navMenu.add(new NavItem(
                new MenuItem(R.drawable.ic_outline_drafts_24,"Draft",false,5)
        ));
        navMenu.add(new NavItem(
                new MenuItem(R.drawable.ic_baseline_all_inbox_24,"All Mails",false,120)
        ));

        navMenu.add(new NavItem(new LabelItem("GOOGLE APPS")));
        navMenu.add(new NavItem(
                new MenuItem(R.drawable.ic_baseline_calendar_today_24,"Calendar",false)
        ));
        navMenu.add(new NavItem(
                new MenuItem(R.drawable.ic_baseline_person_outline_24,"Contacts",false)
        ));
        navMenu.add(new NavItem(
                new MenuItem(R.drawable.ic_outline_settings_24,"Settings",false)
        ));
        navMenu.add(new NavItem(
                new MenuItem(R.drawable.ic_baseline_all_inbox_24,"Contacts",false)
        ));



        navAdapter = new NavAdapter(new NavMenuItemCallback());
        navAdapter.submitList(navMenu);
        //recyclerView.setAdapter(navAdapter);
        navRecyclerview.setAdapter(navAdapter);



    }

    private void setupFabBehavior() {

        mailRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {

                if (dy > 0) {
                    // Scrolling up
                    extFab.shrink();

                } else {
                    // Scrolling down
                    extFab.extend();

                }
            }
        });
    }


    public static void setLightStatusBar(View view, Activity activity){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            activity.getWindow().setStatusBarColor(Color.WHITE);
        }

    }


}