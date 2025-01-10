package com.example.mobiledev2;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Launcher extends AppCompatActivity {

    private ListView listView;
    private PackageManager packageManager;
    private List<ApplicationInfo> packageInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        listView = findViewById(R.id.listview_apps);
        packageManager = getPackageManager();
        packageInfoList = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

        AppAdapter appAdapter = new AppAdapter(this, R.layout.activity_launcher_items, packageInfoList);
        listView.setAdapter(appAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ApplicationInfo applicationInfo = packageInfoList.get(position);
                String packageName = applicationInfo.packageName;

                Intent intent = packageManager.getLaunchIntentForPackage(packageName);
                if (intent != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(Launcher.this, "Não foi possível abrir o aplicativo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
