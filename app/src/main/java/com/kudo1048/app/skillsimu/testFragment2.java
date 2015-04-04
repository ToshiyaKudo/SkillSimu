package com.kudo1048.app.skillsimu;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;


public class testFragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    String[] lvs = new String[14];
    String[] tras = new String[14];
    Spinner[] spn = new Spinner[14];
    Spinner[] spn1 = new Spinner[14];

    int[] lvp = {0,0,0,0,0,0,0,0,0,0,3,6,6,9,13,13,17,21,21,25,29,29,32,36,36,40,44,44,49,54,
            54,58,63,63,68,72,72,76,79,79,83,87,87,90,93,93,97,100,100,103,107,107,110,113,113,116,
            118,119,122,124,126,129,131,132,134,136,138,141,144,146,148,151,152,154,156,158,161,
            163,165,167,170,171,173,175,177,179};

    int[] traps = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};

    private int i;
    skillDbOpenHelper dbHelper;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment testFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static testFragment2 newInstance(String param1, String param2) {
        testFragment2 fragment = new testFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public testFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_test_fragment2, container, false);

        dbHelper = new skillDbOpenHelper(getActivity());


        int[] spls ={R.id.spl0,R.id.spl1,R.id.spl2,R.id.spl3,R.id.spl4,R.id.spl5,R.id.spl6,
                R.id.spl7,R.id.spl8,R.id.spl9,R.id.spl10,R.id.spl11,R.id.spl12,R.id.spl13};

        int[] spts = {R.id.spt0,R.id.spt1,R.id.spt2,R.id.spt3,R.id.spt4,R.id.spt5,R.id.spt6,
                R.id.spt7,R.id.spt8,R.id.spt9,R.id.spt10,R.id.spt11,R.id.spt12,R.id.spt13};

        for(i =0;i<14;i++){
            spn[i] = (Spinner)v.findViewById(spls[i]);
            spn[i].setSelection(5);
            lvs[i] = spn[i].getSelectedItem().toString();

            spn1[i] = (Spinner)v.findViewById(spts[i]);
            spn1[i].setSelection(5);
            tras[i] = spn1[i].getSelectedItem().toString();

        }

        Button button = (Button)v.findViewById(R.id.kiroku);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = dbHelper.getWritableDatabase();
                Integer skillp = 0;

                lvs[0] = spn[0].getSelectedItem().toString();
                skillp = lvp[Integer.parseInt(lvs[0])]+traps[spn1[0].getSelectedItemPosition()];
                ContentValues values0 = new ContentValues();
                values0.put("lv", spn[0].getSelectedItem().toString());
                values0.put("training", spn1[0].getSelectedItem().toString());
                values0.put("skillp", skillp.toString());
                values0.put("restp", skillp.toString());
                db.update("job_table",values0, "job = '戦士'", null);

                lvs[1] = spn[1].getSelectedItem().toString();
                skillp = lvp[Integer.parseInt(lvs[1])]+traps[spn1[1].getSelectedItemPosition()];
                ContentValues values1 = new ContentValues();
                values1.put("lv", spn[1].getSelectedItem().toString());
                values1.put("training", spn1[1].getSelectedItem().toString());
                values1.put("skillp", skillp.toString());
                values1.put("restp", skillp.toString());
                db.update("job_table",values1, "job = '魔法使い'", null);

                lvs[2] = spn[2].getSelectedItem().toString();
                skillp = lvp[Integer.parseInt(lvs[2])]+traps[spn1[2].getSelectedItemPosition()];
                ContentValues values2 = new ContentValues();
                values2.put("lv", spn[2].getSelectedItem().toString());
                values2.put("training", spn1[2].getSelectedItem().toString());
                values2.put("skillp", skillp.toString());
                values2.put("restp", skillp.toString());
                db.update("job_table",values2, "job = '僧侶'", null);

                lvs[3] = spn[3].getSelectedItem().toString();
                skillp = lvp[Integer.parseInt(lvs[3])]+traps[spn1[3].getSelectedItemPosition()];
                ContentValues values3 = new ContentValues();
                values3.put("lv", spn[3].getSelectedItem().toString());
                values3.put("training", spn1[3].getSelectedItem().toString());
                values3.put("skillp", skillp.toString());
                values3.put("restp", skillp.toString());
                db.update("job_table",values3, "job = '武闘家'", null);

                lvs[4] = spn[4].getSelectedItem().toString();
                skillp = lvp[Integer.parseInt(lvs[4])]+traps[spn1[4].getSelectedItemPosition()];
                ContentValues values4 = new ContentValues();
                values4.put("lv", spn[4].getSelectedItem().toString());
                values4.put("training", spn1[4].getSelectedItem().toString());
                values4.put("skillp", skillp.toString());
                values4.put("restp", skillp.toString());
                db.update("job_table",values4, "job = '盗賊'", null);

                lvs[5] = spn[5].getSelectedItem().toString();
                skillp = lvp[Integer.parseInt(lvs[5])]+traps[spn1[5].getSelectedItemPosition()];
                ContentValues values5 = new ContentValues();
                values5.put("lv", spn[5].getSelectedItem().toString());
                values5.put("training", spn1[5].getSelectedItem().toString());
                values5.put("skillp", skillp.toString());
                values5.put("restp", skillp.toString());
                db.update("job_table",values5, "job = '旅芸人'", null);

                lvs[6] = spn[6].getSelectedItem().toString();
                skillp = lvp[Integer.parseInt(lvs[6])]+traps[spn1[6].getSelectedItemPosition()];
                ContentValues values6 = new ContentValues();
                values6.put("lv", spn[6].getSelectedItem().toString());
                values6.put("training", spn1[6].getSelectedItem().toString());
                values6.put("skillp", skillp.toString());
                values6.put("restp", skillp.toString());
                db.update("job_table",values6, "job = 'パラディン'", null);

                lvs[7] = spn[7].getSelectedItem().toString();
                skillp = lvp[Integer.parseInt(lvs[7])]+traps[spn1[7].getSelectedItemPosition()];
                ContentValues values7 = new ContentValues();
                values7.put("lv", spn[7].getSelectedItem().toString());
                values7.put("training", spn1[7].getSelectedItem().toString());
                values7.put("skillp", skillp.toString());
                values7.put("restp", skillp.toString());
                db.update("job_table",values7, "job = 'レンジャー'", null);

                lvs[8] = spn[8].getSelectedItem().toString();
                skillp = lvp[Integer.parseInt(lvs[8])]+traps[spn1[8].getSelectedItemPosition()];
                ContentValues values8 = new ContentValues();
                values8.put("lv", spn[8].getSelectedItem().toString());
                values8.put("training", spn1[8].getSelectedItem().toString());
                values8.put("skillp", skillp.toString());
                values8.put("restp", skillp.toString());
                db.update("job_table",values8, "job = '魔法戦士'", null);

                lvs[9] = spn[9].getSelectedItem().toString();
                skillp = lvp[Integer.parseInt(lvs[9])]+traps[spn1[9].getSelectedItemPosition()];
                ContentValues values9 = new ContentValues();
                values9.put("lv", spn[9].getSelectedItem().toString());
                values9.put("training", spn1[9].getSelectedItem().toString());
                values9.put("skillp", skillp.toString());
                values9.put("restp", skillp.toString());
                db.update("job_table",values9, "job = 'スーパースター'", null);

                lvs[10] = spn[10].getSelectedItem().toString();
                skillp = lvp[Integer.parseInt(lvs[10])]+traps[spn1[10].getSelectedItemPosition()];
                ContentValues values10 = new ContentValues();
                values10.put("lv", spn[10].getSelectedItem().toString());
                values10.put("training", spn1[10].getSelectedItem().toString());
                values10.put("skillp", skillp.toString());
                values10.put("restp", skillp.toString());
                db.update("job_table",values10, "job = 'バトルマスター'", null);

                lvs[11] = spn[11].getSelectedItem().toString();
                skillp = lvp[Integer.parseInt(lvs[11])]+traps[spn1[11].getSelectedItemPosition()];
                ContentValues values11 = new ContentValues();
                values11.put("lv", spn[11].getSelectedItem().toString());
                values11.put("training", spn1[11].getSelectedItem().toString());
                values11.put("skillp", skillp.toString());
                values11.put("restp", skillp.toString());
                db.update("job_table",values11, "job = '賢者'", null);

                lvs[12] = spn[12].getSelectedItem().toString();
                skillp = lvp[Integer.parseInt(lvs[12])]+traps[spn1[12].getSelectedItemPosition()];
                ContentValues values12 = new ContentValues();
                values12.put("lv", spn[12].getSelectedItem().toString());
                values12.put("training", spn1[12].getSelectedItem().toString());
                values12.put("skillp", skillp.toString());
                values12.put("restp", skillp.toString());
                db.update("job_table",values12, "job = '魔物使い'", null);

                lvs[13] = spn[13].getSelectedItem().toString();
                skillp = lvp[Integer.parseInt(lvs[13])]+traps[spn1[13].getSelectedItemPosition()];
                ContentValues values13 = new ContentValues();
                values13.put("lv", spn[13].getSelectedItem().toString());
                values13.put("training", spn1[13].getSelectedItem().toString());
                values13.put("skillp", skillp.toString());
                values13.put("restp", skillp.toString());
                db.update("job_table",values13, "job = 'どうぐ使い'", null);

                db.close();
            }
        });


        return v;
    }








}
