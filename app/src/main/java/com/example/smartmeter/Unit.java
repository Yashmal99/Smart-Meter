package com.example.smartmeter;

import com.google.gson.annotations.SerializedName;

public class Unit {
    @SerializedName("Record_Time")
    private String recordtime;
    @SerializedName("Frequency_Hz")
    private String frequency;
    @SerializedName("R_Phase_to_Neutral_Voltage")
    private  String R_Phase_to_Neutral_Voltage;
    @SerializedName("Y_Phase_to_Neutral_Voltage")
    private String Y_Phase_to_Neutral_Voltage;
    @SerializedName("B_Phase_to_Neutral_Voltage")
    private String B_Phase_to_Neutral_Voltage;
    @SerializedName("Average_Voltage")
    private String averagevoltage;
    @SerializedName("R_Phase_Line_current")
    private String R_Phase_Line_current;
    @SerializedName("Y_Phase_Line_current")
    private String Y_Phase_Line_current;
    @SerializedName("B_Phase_Line_current")
    private String B_Phase_Line_current;
    @SerializedName("Neutral_Line_current")
    private String Neutral_Line_current;
    @SerializedName("Avg_power_factor")
    private String Avg_power_factor;
    @SerializedName("R_Phase_Active_Power")
    private String R_Phase_Active_Power;
    @SerializedName("Y_Phase_Active_power")
    private String Y_Phase_Active_power;
    @SerializedName("B_Phase_Active_Power")
    private String B_Phase_Active_Power;
    @SerializedName("3_Phase_Active_Power")
    private String three_Phase_Active_Power;
    @SerializedName("Active_Total_Import")
    private String Active_Total_Import;


    public Unit(String recordtime, String frequency, String r_Phase_to_Neutral_Voltage,
                String y_Phase_to_Neutral_Voltage, String b_Phase_to_Neutral_Voltage, String averagevoltage,
                String r_Phase_Line_current, String y_Phase_Line_current, String b_Phase_Line_current,
                String neutral_Line_current, String avg_power_factor, String r_Phase_Active_Power,
                String y_Phase_Active_power, String b_Phase_Active_Power, String three_Phase_Active_Power,
                String active_Total_Import) {
        this.recordtime = recordtime;
        this.frequency = frequency;
        this.R_Phase_to_Neutral_Voltage = r_Phase_to_Neutral_Voltage;
        this.Y_Phase_to_Neutral_Voltage = y_Phase_to_Neutral_Voltage;
        this.B_Phase_to_Neutral_Voltage = b_Phase_to_Neutral_Voltage;
        this.averagevoltage = averagevoltage;
        this.R_Phase_Line_current = r_Phase_Line_current;
        this.Y_Phase_Line_current = y_Phase_Line_current;
        this.B_Phase_Line_current = b_Phase_Line_current;
        this.Neutral_Line_current = neutral_Line_current;
        this.Avg_power_factor = avg_power_factor;
        this.R_Phase_Active_Power = r_Phase_Active_Power;
        this.Y_Phase_Active_power = y_Phase_Active_power;
        this.B_Phase_Active_Power = b_Phase_Active_Power;
        this.three_Phase_Active_Power = three_Phase_Active_Power;
        this.Active_Total_Import = active_Total_Import;
    }

    public String getR_Phase_to_Neutral_Voltage() {
        return R_Phase_to_Neutral_Voltage;
    }

    public String getY_Phase_to_Neutral_Voltage() {
        return Y_Phase_to_Neutral_Voltage;
    }

    public void setR_Phase_to_Neutral_Voltage(String r_Phase_to_Neutral_Voltage) {
        R_Phase_to_Neutral_Voltage = r_Phase_to_Neutral_Voltage;
    }

    public void setY_Phase_to_Neutral_Voltage(String y_Phase_to_Neutral_Voltage) {
        Y_Phase_to_Neutral_Voltage = y_Phase_to_Neutral_Voltage;
    }

    public void setB_Phase_to_Neutral_Voltage(String b_Phase_to_Neutral_Voltage) {
        B_Phase_to_Neutral_Voltage = b_Phase_to_Neutral_Voltage;
    }

    public void setAveragevoltage(String averagevoltage) {
        this.averagevoltage = averagevoltage;
    }

    public void setR_Phase_Line_current(String r_Phase_Line_current) {
        R_Phase_Line_current = r_Phase_Line_current;
    }

    public void setY_Phase_Line_current(String y_Phase_Line_current) {
        Y_Phase_Line_current = y_Phase_Line_current;
    }

    public void setB_Phase_Line_current(String b_Phase_Line_current) {
        B_Phase_Line_current = b_Phase_Line_current;
    }

    public void setNeutral_Line_current(String neutral_Line_current) {
        Neutral_Line_current = neutral_Line_current;
    }

    public void setAvg_power_factor(String avg_power_factor) {
        Avg_power_factor = avg_power_factor;
    }

    public void setR_Phase_Active_Power(String r_Phase_Active_Power) {
        R_Phase_Active_Power = r_Phase_Active_Power;
    }

    public void setY_Phase_Active_power(String y_Phase_Active_power) {
        Y_Phase_Active_power = y_Phase_Active_power;
    }

    public void setB_Phase_Active_Power(String b_Phase_Active_Power) {
        B_Phase_Active_Power = b_Phase_Active_Power;
    }

    public void setThree_Phase_Active_Power(String three_Phase_Active_Power) {
        this.three_Phase_Active_Power = three_Phase_Active_Power;
    }

    public void setActive_Total_Import(String active_Total_Import) {
        Active_Total_Import = active_Total_Import;
    }

    public String getB_Phase_to_Neutral_Voltage() {
        return B_Phase_to_Neutral_Voltage;
    }

    public String getAveragevoltage() {
        return averagevoltage;
    }

    public String getR_Phase_Line_current() {
        return R_Phase_Line_current;
    }

    public String getY_Phase_Line_current() {
        return Y_Phase_Line_current;
    }

    public String getB_Phase_Line_current() {
        return B_Phase_Line_current;
    }

    public String getNeutral_Line_current() {
        return Neutral_Line_current;
    }

    public String getAvg_power_factor() {
        return Avg_power_factor;
    }

    public String getR_Phase_Active_Power() {
        return R_Phase_Active_Power;
    }

    public String getY_Phase_Active_power() {
        return Y_Phase_Active_power;
    }

    public String getB_Phase_Active_Power() {
        return B_Phase_Active_Power;
    }

    public String getThree_Phase_Active_Power() {
        return three_Phase_Active_Power;
    }

    public String getActive_Total_Import() {
        return Active_Total_Import;
    }

    public String getRecordtime() {
        return recordtime;
    }

    public String getFrequency() {
        return frequency;
    }


    public void setRecordtime(String recordtime) {
        this.recordtime = recordtime;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}