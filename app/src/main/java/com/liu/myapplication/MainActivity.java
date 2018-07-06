package com.liu.myapplication;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liu.myapplication.Adapter.LeftAdapter;
import com.liu.myapplication.Adapter.RightAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //左边的ListView
    private ListView lv_left;
    //左边ListView的Adapter
    private LeftAdapter leftAdapter;
    //右边的ListView
    private HaveHeaderListView lv_right;
    //右边的ListView的Adapter
    private RightAdapter rightAdapter;
    //是否滑动标志位
    private Boolean isScroll = false;
    private List<Bean> retList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        initView();
        //初始化数据
        initData();
        initListener();
    }
    //从资源文件中获取分类json
    private String getAssetsData(String path) {
        String result = "";
        try {
            //获取输入流
            InputStream mAssets = getAssets().open(path);
            //获取文件的字节数
            int lenght = mAssets.available();
            //创建byte数组
            byte[] buffer = new byte[lenght];
            //将文件中的数据写入到字节数组中
            mAssets.read(buffer);
            mAssets.close();
            result = new String(buffer);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("fuck", e.getMessage());
            return result;
        }
    }
    private void initData() {
        String assetsData = getAssetsData("sort.json");
        Gson gson = new Gson();
        retList = gson.fromJson(assetsData,new TypeToken<List<Bean>>(){}.getType());
        leftAdapter = new LeftAdapter(MainActivity.this, retList);
        lv_left.setAdapter(leftAdapter);
        rightAdapter = new RightAdapter(MainActivity.this, retList);
        lv_right.setAdapter(rightAdapter);
    }

    private void initView() {
        lv_left = (ListView) findViewById(R.id.lv_left);
        lv_right = (HaveHeaderListView) findViewById(R.id.lv_right);
    }
    private void initListener() {
        lv_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                isScroll = false;
                for (int i = 0; i < retList.size(); i++) {
                    if (i == position) {
                        retList.get(i).setIsBoolean(true);
                    } else {
                        retList.get(i).setIsBoolean(false);
                    }
                }
                //更新
                leftAdapter.notifyDataSetChanged();
                int rightSection = 0;
                for (int i = 0; i < position; i++) {
                    //查找
                    rightSection += rightAdapter.getCountForSection(i) + 1;
                }
                //显示到rightSection所代表的标题
                lv_right.setSelection(rightSection);
            }
        });
        lv_right.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    // 当不滚动时
                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        // 判断滚动到底部
                        if (lv_right.getLastVisiblePosition() == (lv_right.getCount() - 1)) {
                            lv_left.setSelection(ListView.FOCUS_DOWN);
                        }
                        // 判断滚动到顶部
                        if (lv_right.getFirstVisiblePosition() == 0) {
                            lv_left.setSelection(0);
                        }
                        break;
                }

            }

            int y = 0;
            int x = 0;

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (isScroll) {
                    for (int i = 0; i < retList.size(); i++) {
                        if (i == rightAdapter.getSectionForPosition(lv_right.getFirstVisiblePosition())) {
                            retList.get(i).setIsBoolean(true);
                            //获取当前标题的标志位
                            x = i;
                        } else {
                            retList.get(i).setIsBoolean(false);
                        }
                    }
                    if (x != y) {
                        leftAdapter.notifyDataSetChanged();
                        //将之前的标志位赋值给y，下次判断
                        y = x;
                    }
                } else {
                    isScroll = true;
                }
            }
        });
    }
}
//ListLinkage
