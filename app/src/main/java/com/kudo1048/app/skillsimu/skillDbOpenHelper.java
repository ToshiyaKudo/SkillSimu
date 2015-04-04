package com.kudo1048.app.skillsimu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by 0901AND on 2015/02/23.
 */
public class skillDbOpenHelper extends SQLiteOpenHelper {

    final static private int DB_VERSION = 1;
    static final String DB = "sqlite_sample.db";

    public skillDbOpenHelper(Context context) {
        super(context, DB, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d("dddddd", "eeeeeeeeeeee");

        db.execSQL(

                "create table job_table("+" job text not null,"+" lv text," +
                        ""+" training text,"+" skillp text,"+" restp text"+");"
        );

        db.execSQL("insert into job_table(job,lv,training,skillp,restp) values('戦士','0','0','0','0');" );
        db.execSQL("insert into job_table(job,lv,training,skillp,restp) values('魔法使い','0','0','0','0');" );
        db.execSQL("insert into job_table(job,lv,training,skillp,restp) values('僧侶','0','0','0','0');" );
        db.execSQL("insert into job_table(job,lv,training,skillp,restp) values('武闘家','0','0','0','0');" );
        db.execSQL("insert into job_table(job,lv,training,skillp,restp) values('盗賊','0','0','0','0');" );
        db.execSQL("insert into job_table(job,lv,training,skillp,restp) values('旅芸人','0','0','0','0');" );
        db.execSQL("insert into job_table(job,lv,training,skillp,restp) values('パラディン','0','0','0','0');" );
        db.execSQL("insert into job_table(job,lv,training,skillp,restp) values('レンジャー','0','0','0','0');" );
        db.execSQL("insert into job_table(job,lv,training,skillp,restp) values('魔法戦士','0','0','0','0');" );
        db.execSQL("insert into job_table(job,lv,training,skillp,restp) values('スーパースター','0','0','0','0');" );
        db.execSQL("insert into job_table(job,lv,training,skillp,restp) values('バトルマスター','0','0','0','0');" );
        db.execSQL("insert into job_table(job,lv,training,skillp,restp) values('賢者','0','0','0','0');" );
        db.execSQL("insert into job_table(job,lv,training,skillp,restp) values('魔物使い','0','0','0','0');" );
        db.execSQL("insert into job_table(job,lv,training,skillp,restp) values('どうぐ使い','0','0','0','0');" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }
}
