package iii.org.tw.listtest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private  LinkedList<HashMap<String,Object>> data;
    private String from[]={"title","content","img"};
    private int to[]={R.id.item_title,R.id.item_content,R.id.item_img};
    private EditText inputtext;
    private SimpleAdapter adapter;
    private int p[]={R.drawable.bg1,R.drawable.bg2,R.drawable.bg3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputtext=(EditText)findViewById(R.id.inputtext);

        list=(ListView) findViewById(R.id.list);
        initListView();
    }
    private void initListView(){

        data=new LinkedList<>();

        adapter =new SimpleAdapter(this,data,R.layout.layout_item,from,to);
        list.setAdapter(adapter);
    }
    public void additem(View v){

        String input=inputtext.getText().toString();
        HashMap<String,Object> data=new HashMap<>();
        data.put(from[0],input);
        data.put(from[1],"hi");
        data.put(from[2],p[(int)(Math.random()*3)]);
        this.data.add(data);
        adapter.notifyDataSetChanged();
    }
}
