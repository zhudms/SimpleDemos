package com.demo.zxyl.patientlogindemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.demo.zxyl.patientlogindemo.beans.BedMessageB;
import com.demo.zxyl.patientlogindemo.beans.PatientB;
import com.demo.zxyl.patientlogindemo.events.EventBusHelper;
import com.demo.zxyl.patientlogindemo.events.GetBedInfoFinishE;
import com.demo.zxyl.patientlogindemo.events.GetPatientFinishE;
import com.demo.zxyl.patientlogindemo.events.IPChagedE;
import com.demo.zxyl.patientlogindemo.events.PaientInfoEvent;
import com.demo.zxyl.patientlogindemo.net.ClientAPI;
import com.demo.zxyl.patientlogindemo.net.MyHttp;
import com.demo.zxyl.patientlogindemo.net.MyHttpHelper;
import com.demo.zxyl.patientlogindemo.urils.LogUtil;
import com.demo.zxyl.patientlogindemo.urils.NetUtil;
import com.demo.zxyl.patientlogindemo.urils.LocalDataUtil;
import com.demo.zxyl.patientlogindemo.urils.ToastUtil;
import com.demo.zxyl.patientlogindemo.urils.VALUES;
import com.demo.zxyl.patientlogindemo.weight.MySetIpDialog;
import com.demo.zxyl.patientlogindemo.weight.MyURLDialogLisener;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {
    private MyURLDialogLisener mURLBtnLisener;
    private MySetIpDialog mURLDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        initData();
    }


    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    /**
     * 获取http对象
     */
    private void initData() {

        //获取URL
        String url = LocalDataUtil.getURLPreferce(this);//以此为标准
        if (url != null && url.length() != 0) {
            if (ClientAPI.BASE_URL == null || !ClientAPI.BASE_URL.equals(url)) {
                ClientAPI.setBaseUrl(url);
            }
        } else {
            showURLDialog();
            return;
        }

//初始化MyHttp
        if (NetUtil.isNetworkUseful(this)) {
            initHttp();
        } else {
            ToastUtil.toast(this, R.string.net_error);
            return;
        }

        //获取患者信息
        PatientB bean = LocalDataUtil.getLocalPatient(MainActivity.this);
        if (bean != null) {

            EventBusHelper.post(new GetPatientFinishE(bean));
        } else {
            MyHttpHelper.getBedInfo(MainActivity.this);
        }

    }


    public void initHttp() {
        String base = ClientAPI.getBaseUrl();
        String http = ClientAPI.BASE_HTTP;
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(ClientAPI.BASE_HTTP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyHttp mHttp = restAdapter.create(MyHttp.class);
        MyApplication.setmHttp(mHttp);
    }


    private void showURLDialog() {

        mURLDialog = new MySetIpDialog(this, getResources().getString(R.string.set_ip), null,
                getResources().getString(R.string.confirm), null);
        mURLBtnLisener = new MyURLDialogLisener(MainActivity.this, mURLDialog);
        mURLDialog.setMDialogLisener(mURLBtnLisener);
        mURLDialog.setCanceledOnTouchOutside(false);

        mURLDialog.show();
    }

    /**
     * 设备IP发生更改
     *
     * @param change
     */
    @Subscribe
    public void onEvent(IPChagedE change) {
//        MyApplication.clearData(MainActivity.this);
        initData();
    }


    /**
     * 获取到设备信息，由此获取对应病人信息
     *
     * @param getBedinfoFinishE
     */
    @Subscribe
    public void onEvent(GetBedInfoFinishE getBedinfoFinishE) {
        if (getBedinfoFinishE.getErrorMessage() == null) {
            if (MyApplication.getmHttp() != null) {
                BedMessageB messageB = getBedinfoFinishE.getmBedBean();
                if (messageB != null) {
//                    MyApplication.screenStartTime = messageB.getLOW_START_TIME();
//                    MyApplication.endTime = messageB.getLOW_END_TIME();
                    MyHttpHelper.getMyPatient(messageB.getBED_SNO(), messageB.getORG_CODE());
                } else {
                    ToastUtil.toast(this, R.string.get_macinfo_error);
                }
            }
        } else {
            LogUtil.d(VALUES.TAG_FILTER, getBedinfoFinishE.getErrorMessage());
            ToastUtil.toast(this, R.string.get_macinfo_error);
        }
    }

    @Subscribe
    public void onEvent(PaientInfoEvent patientE) {
        if (patientE.getErrorMsg() == null) {
            PatientB patientB = patientE.getBean();
            if (patientB != null) {
                LocalDataUtil.writeLocalPatient(MainActivity.this, patientB);
                EventBusHelper.post(new GetPatientFinishE(patientB));
            } else {
                LogUtil.d(VALUES.TAG_FILTER, patientE.getErrorMsg());
                ToastUtil.toast(this, R.string.get_patient_error);
            }
        } else {
            LogUtil.d(VALUES.TAG_FILTER, patientE.getErrorMsg());
            ToastUtil.toast(this, R.string.get_patient_error);
        }
    }


    @Subscribe
    public void onEvent(GetPatientFinishE getPatientFinishE) {
        PatientB bean = getPatientFinishE.getPatientB();
        if (bean != null) {
            MyApplication.setmPatient(getPatientFinishE.getPatientB());

            ClientAPI.initWS(MainActivity.this);
//            initWebSocket();
//            MyHttpHelper.getCollections();
            LogUtil.d(VALUES.TAG_FILTER, bean.getBED_NO());
        }

    }


}




