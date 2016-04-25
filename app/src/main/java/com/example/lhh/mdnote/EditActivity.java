package com.example.lhh.mdnote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by LHH on 2016/4/25.
 */
public class EditActivity extends Activity {
    private static final String EXTRA_NOTE = "EXTRA_NOTE";
    private TextView titleText;
    private TextView contentText;
    public static Intent buildIntent(Context context, Note note){
        Intent intent = new Intent(context, EditActivity.class);
        intent.putExtra(EXTRA_NOTE, note);
        return intent;
    }
    public static Intent buildIntent(Context context){
        return buildIntent(context, null);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){

    }
}
