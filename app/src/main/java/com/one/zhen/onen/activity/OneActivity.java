package com.one.zhen.onen.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.one.zhen.onen.R;
import com.one.zhen.onen.adapter.CommonAdaper;
import com.one.zhen.onen.adapter.ViewHolder;
import com.one.zhen.onen.entity.Data;

import java.util.ArrayList;
import java.util.List;

public class OneActivity extends AppCompatActivity {
    private ListView listView;
    private List<Data> list;

    private CommonAdaper<Data> commonAdaper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        listView = (ListView) findViewById(R.id.one_listview);
        initList();

        initAdapter();

        listView.setAdapter(commonAdaper);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"点击了Item",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initAdapter() {
        commonAdaper = new CommonAdaper<Data>(this,list,R.layout.onelist_item) {
            @Override
            public void convert(ViewHolder holder, Data item) {
                holder.setText(R.id.item_text,item.getText());
                if (item.getImageUrl() != null){
                    holder.setImageByUrl(R.id.item_image,item.getImageUrl());
                }else {
                    holder.setImageResource(R.id.item_image,item.getImageId());
                }
            }
        };
    }

    private void initList() {
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Data("本地 "+i,R.mipmap.ic_launcher));
        }

        for (int i = 0; i < 5; i++) {
            list.add(new Data("网络 "+i,"http://pic.cnblogs.com/face/845964/20160301162812.png"));
        }
    }

    public void btnClick(View view) {
        for (int i = 0; i < 5; i++) {
            list.add(new Data("本地 "+i,R.mipmap.ic_launcher));
        }
        for (int i = 0; i < 5; i++) {
            list.add(new Data("网络 "+i,"http://pic.cnblogs.com/face/845964/20160301162812.png"));
        }

        commonAdaper.notifyDataSetChanged();
    }
}
