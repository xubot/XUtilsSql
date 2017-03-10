package uu.bawei.com.xutilssql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.DbManager;
import org.xutils.common.util.KeyValue;
import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import uu.bawei.com.xutilssql.Bean.DataBean;
import uu.bawei.com.xutilssql.Utils.AppData;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private List<TextView> textViewList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        setContentView(R.layout.activity_main);
        TextView add= (TextView) findViewById(R.id.add);
        TextView deleter= (TextView) findViewById(R.id.deleter);
        TextView uppdata= (TextView) findViewById(R.id.updata);
        TextView fill= (TextView) findViewById(R.id.fill);
        textViewList.add(add);
        textViewList.add(deleter);
        textViewList.add(uppdata);
        textViewList.add(fill);
        for(TextView t:textViewList)
        {
            t.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        DbManager db = new AppData().getDb();
        switch (v.getId())
        {
            case R.id.add:
                List<DataBean> dataBeanList=new ArrayList<>();
                dataBeanList.add(new DataBean("张1"));
                dataBeanList.add(new DataBean("张2"));
                dataBeanList.add(new DataBean("张3"));
                dataBeanList.add(new DataBean("张4"));
                try {
                    db.save(dataBeanList);
                    Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
                } catch (DbException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.deleter:
                try {
                    db.delete(DataBean.class, WhereBuilder.b("id","=",1));
                    Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                } catch (DbException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.updata:
                break;
            case R.id.fill:
                try {
                    List<DataBean> all = db.findAll(DataBean.class);
                    for (DataBean data : all) {
                        Log.i("zzz", data.toString());
                    }
                } catch (DbException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
