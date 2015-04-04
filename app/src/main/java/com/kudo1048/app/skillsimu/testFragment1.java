package com.kudo1048.app.skillsimu;


import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonRectangle;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link testFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class testFragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static final String frg ="fragment-Cycle";
    private WindowManager.LayoutParams params;
    private View flortView;
    private WindowManager wm;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment testFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static testFragment1 newInstance(String param1, String param2) {
        testFragment1 fragment = new testFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public testFragment1() {
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
        View v = inflater.inflate(R.layout.fragment_test_fragment1, container, false);

        skillDbOpenHelper dbHelper = new skillDbOpenHelper(getActivity());
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor c = db.query("job_table", new String[] { "job", "lv","training","skillp","restp" },null, null, null, null, null);

        boolean isEof = c.moveToFirst();

        int[] lvs = {R.id.lv0,R.id.lv1,R.id.lv2,R.id.lv3,R.id.lv4,R.id.lv5,R.id.lv6,R.id.lv7,
                R.id.lv8,R.id.lv9,R.id.lv10,R.id.lv11,R.id.lv12,R.id.lv13};

        int[] tras = {R.id.tra0,R.id.tra1,R.id.tra2,R.id.tra3,R.id.tra4,R.id.tra5,R.id.tra6,
                R.id.tra7,R.id.tra8,R.id.tra9,R.id.tra10,R.id.tra11,R.id.tra12,R.id.tra13};

        int[] totals ={R.id.total0,R.id.total1,R.id.total2,R.id.total3,R.id.total4,R.id.total5,
                R.id.total6,R.id.total7,R.id.total8,R.id.total9,R.id.total10,R.id.total11,R.id.total12,
                R.id.total13};

        int[] rests ={R.id.rests0,R.id.rests1,R.id.rests2,R.id.rests3,R.id.rests4,R.id.rests5,
                R.id.rests6,R.id.rests7,R.id.rests8,R.id.rests9,R.id.rests10,R.id.rests11,
                R.id.rests12,R.id.rests13,};

        int i =0;

        final ButtonRectangle button1 = (ButtonRectangle)v.findViewById(R.id.rbutton0);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int[] location = new int[2];
                v.getLocationOnScreen(location);

                MyWindowManager.createWindow(getActivity(),location[1]);

            }
        });

//        button1.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//
//                return false;
//            }
//        });

        ButtonRectangle button2 = (ButtonRectangle)v.findViewById(R.id.rbutton1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wm.removeView(flortView);
            }
        });

        while (isEof) {

            TextView tvl = (TextView)v.findViewById(lvs[i]);
            TextView tvt = (TextView)v.findViewById(tras[i]);
            TextView tvto = (TextView)v.findViewById(totals[i]);
            TextView tvre = (TextView)v.findViewById(rests[i]);
            tvl.setText(c.getString(1));
            tvt.setText(c.getString(2));
            tvto.setText(c.getString(3));
            tvre.setText(c.getString(4));
            isEof = c.moveToNext();
            i++;
        }

        c.close();

        db.close();

//        params = new WindowManager.LayoutParams(
//                WindowManager.LayoutParams.WRAP_CONTENT,
//                WindowManager.LayoutParams.WRAP_CONTENT,
//                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
//                WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
//                PixelFormat.TRANSLUCENT);
//
//        wm = (WindowManager)getActivity().getSystemService(Context.WINDOW_SERVICE);
//
//        // レイアウトファイルから重ね合わせするViewを作成する
//        flortView = inflater.inflate(R.layout.overlay, null);

        Log.d(frg,"CreateView");
        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        wm = (WindowManager)activity.getSystemService(Context.WINDOW_SERVICE);
        Log.d(frg,"onAttach");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(frg,"onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(frg,"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(frg,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(frg,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(frg,"onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
