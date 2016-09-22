package com.demo.zxyl.patientlogindemo.events;

import com.demo.zxyl.patientlogindemo.beans.PatientB;

/**
 * 这只是个tag，用来识别事件
 *  Created by TANG on 2016/6/3.
 * Patient
 */
public class GetPatientFinishE extends RetifitE {

    public PatientB patientB;

    public GetPatientFinishE(PatientB patientB) {
        this.patientB = patientB;
    }

    public PatientB getPatientB() {
        return patientB;
    }

    public void setPatientB(PatientB patientB) {
        this.patientB = patientB;
    }
}
