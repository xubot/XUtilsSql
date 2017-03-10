package uu.bawei.com.xutilssql.Bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Administrator on 2017/3/10.
 */
@Table(name = "Student", onCreated = "")
public class DataBean {
    @Column(name = "id",isId = true,autoGen = true,property = "NOT NULL")
    private int id;

    @Override
    public String toString() {
        return "DataBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Column(name = "c_name")
    private String name;

    public DataBean() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataBean(String name) {

        this.name = name;
    }
}
