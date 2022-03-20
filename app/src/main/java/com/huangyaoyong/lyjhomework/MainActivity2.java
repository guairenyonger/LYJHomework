package com.huangyaoyong.lyjhomework;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView rv;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rv = (RecyclerView) findViewById(R.id.rv);

//        rv.setLayoutManager(new GridLayoutManager(this, 3));
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        final List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("" + i);
        }

        adapter = new CustomAdapter(this, list);
        rv.setAdapter(adapter);

        findViewById(R.id.textView2).setOnClickListener(view -> {
            new AlertDialog.Builder(this).setTitle("我是弹窗").setNegativeButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).create().show();
        });
        findViewById(R.id.textView2).setOnLongClickListener(view -> {
            openContextMenu(view);
            return true;
        });
        registerForContextMenu(findViewById(R.id.textView2));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        super.onCreateContextMenu(menu, v, menuInfo);
        //设置Menu显示内容
        menu.setHeaderTitle("文件操作");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pop, menu);
    }
}