package uu.bawei.com.xutilssql.Utils;

import android.app.Application;

import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;

/**
 * Created by Administrator on 2017/3/10.
 */

public class AppData extends Application{
    @Override
    public void onCreate() {
        x.Ext.init(this);
    }
    public static DbManager getDb() {
        //对daoConfig初始化 进行配置
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig().setDbName("bw.db").setDbDir(new File("/mnt/sdcard")).setDbVersion(1);
        DbManager db = x.getDb(daoConfig);
        return db;
    }
}
