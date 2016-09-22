package com.demo.zxyl.patientlogindemo.weight;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.demo.zxyl.patientlogindemo.R;
import com.demo.zxyl.patientlogindemo.events.EventBusHelper;
import com.demo.zxyl.patientlogindemo.events.IPDialogOnBackE;
import com.demo.zxyl.patientlogindemo.urils.LocalDataUtil;
import com.demo.zxyl.patientlogindemo.urils.VALUES;


/**
 * Created by TANG on 2016/6/13.
 * Nurse
 */
public class MySetIpDialog extends Dialog {

    protected final Button mConfirmBtn;
    private final Button mCancleBtn;
    protected Context mContext;

    private EditText mEditTv;
    private OnDialogLCickLisener mDialogLisener;


    public MySetIpDialog(Context context, String title,
                         String editHint, String confirm,
                         OnDialogLCickLisener mLisener) {

        super(context);
        mContext = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        View view = LayoutInflater.from(context).
                inflate(R.layout.ipchange_dialog, null, false);
        setContentView(view);

        setCanceledOnTouchOutside(false);

        TextView mTitleTv = (TextView) findViewById(R.id.ipchange_dialog_title);
        if (title == null) {
            mTitleTv.setVisibility(View.GONE);
        } else {
            mTitleTv.setText(title);
        }


        mEditTv = (EditText) findViewById(R.id.ipchange_dialog_edittext);

        String base = LocalDataUtil.getURLPreferce(mContext);
        if (base != null && base.length() != 0) {
            mEditTv.setText(base);
        }

        mConfirmBtn = (Button) findViewById(R.id.ipchange_dialog_confirm);
        mConfirmBtn.setText(confirm);

        mCancleBtn = ((Button) findViewById(R.id.ipchange_dialog_cancel));
        mDialogLisener = mLisener;


        mConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDialogLisener != null) {
                    mDialogLisener.onConfirm(mEditTv.getText().toString());

                }
            }
        });

        mCancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDialogLisener != null) {
                    mDialogLisener.onCancle();
                    dismiss();
                }
            }
        });


    }

    public void setMDialogLisener(OnDialogLCickLisener dialogLisener) {
        this.mDialogLisener = dialogLisener;
    }

    public void setEditString(String editString) {
        mEditTv.setText(editString);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        EventBusHelper.post(new IPDialogOnBackE());
        return false;
    }

//    private String getMyHttpPreferce() {
//        SharedPreferences preferences = mContext.getSharedPreferences(VALUES.BASE_URL, mContext.MODE_PRIVATE);
//        String baseUrl = preferences.getString(VALUES.BASE_URL, VALUES.LOGIN_AUTO_NULL);
//        return baseUrl;
//    }

    /**
     * 获取Edittext中的文字
     *
     * @return
     */
    public String getEditText() {
        return mEditTv.getText().toString();
    }
}
