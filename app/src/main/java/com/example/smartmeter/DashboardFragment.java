package com.example.smartmeter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.smartmeter.Api.Api;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardFragment extends Fragment implements View.OnClickListener {

    ImageView LoadStateLogo,RecordTimeLogo;
    CardView frequency_card;
    Button settings;
    TextView frequency;
    TextView recordtime,Active_Total_Import,three_Phase_Active_Power,Avg_power_factor,
            averagevoltage,R_Phase_Active_Power,Y_Phase_Active_Power,B_Phase_Active_Power,
            R_Phase_Line_current,Y_Phase_Line_current,B_Phase_Line_current,R_Phase_to_Neutral_Voltag,
            Y_Phase_to_Neutral_Voltag,B_Phase_to_Neutral_Voltag,Neutral_Line_current,
            Avg_Current,LoadStateValue,Avg_Voltage,Avg_PowerFactor;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getUnits();
        //new
        Avg_Current = (TextView) view.findViewById(R.id.currentValue);
        LoadStateLogo = (ImageView) view.findViewById(R.id.idLoadStateLogo);
        RecordTimeLogo = (ImageView) view.findViewById(R.id.idDateTimeLogo);
        LoadStateValue = (TextView) view.findViewById(R.id.Load_State_Value);
        Avg_Voltage = (TextView) view.findViewById(R.id.VoltageValue);
        Avg_PowerFactor = (TextView) view.findViewById(R.id.PowerFactorValue);


        //previous

        R_Phase_Active_Power = view.findViewById(R.id.R_Phase_Active_Power);
        Y_Phase_Active_Power = view.findViewById(R.id.Y_Phase_Active_Power);
        B_Phase_Active_Power = view.findViewById(R.id.B_Phase_Active_Power);
        R_Phase_Line_current = view.findViewById(R.id.R_Phase_Line_current);

        Y_Phase_Line_current = view.findViewById(R.id.Y_Phase_Line_current);
        B_Phase_Line_current = view.findViewById(R.id.B_Phase_Line_current);
        R_Phase_to_Neutral_Voltag = view.findViewById(R.id.R_Phase_to_Neutral_Voltage);
        Y_Phase_to_Neutral_Voltag = view.findViewById(R.id.Y_Phase_to_Neutral_Voltage);
        B_Phase_to_Neutral_Voltag = view.findViewById(R.id.B_Phase_to_Neutral_Voltage);
        Neutral_Line_current = view.findViewById(R.id.Neutral_Line_current);

        frequency_card = (CardView) view.findViewById(R.id.frequency_card);

        frequency = (TextView) view.findViewById(R.id.frequency);
        recordtime = (TextView) view.findViewById(R.id.RecordTimeValue);
        averagevoltage = view.findViewById(R.id.averagevoltage);
        Avg_power_factor = view.findViewById(R.id.Avg_power_factor);
        three_Phase_Active_Power = view.findViewById(R.id.three_Phase_Active_Power);
        Active_Total_Import = view.findViewById(R.id.Active_Total_Import);


            frequency_card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getUnits();
                    Toast.makeText(getContext(), "Refreshing", Toast.LENGTH_SHORT).show();
                }
            });
    }


    public void getUnits()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<Unit> call = api.getUnits(); //calling getunit method

        call.enqueue(new Callback<Unit>() {
            @Override
            public void onResponse(Call<Unit> call, Response<Unit> response) {
                Unit unitList = response.body();

                //Creating an String array for the ListView
                String freq,rt,avgvol,avgpowerfac,three_p_active_power,active_total_import,neutral_Line_current,rpapower,ypapower,bpapower,rpynvoltage,yptnvoltage,bptnvoltage,rplcurrent,yplcurrent,bplcurrent;
                //looping through all the heroes and inserting the names inside the string array

                freq = unitList.getFrequency();
                rt = unitList.getRecordtime();
                avgvol = unitList.getAveragevoltage();
                avgpowerfac = unitList.getAvg_power_factor();
                three_p_active_power = unitList.getThree_Phase_Active_Power();
                active_total_import = unitList.getActive_Total_Import();
                neutral_Line_current = unitList.getNeutral_Line_current();
                rpapower = unitList.getR_Phase_Active_Power();
                ypapower = unitList.getY_Phase_Active_power();
                bpapower = unitList.getB_Phase_Active_Power();
                rpynvoltage = unitList.getR_Phase_to_Neutral_Voltage();
                yptnvoltage = unitList.getY_Phase_to_Neutral_Voltage();
                bptnvoltage = unitList.getY_Phase_to_Neutral_Voltage();
                rplcurrent = unitList.getR_Phase_Line_current();
                yplcurrent = unitList.getY_Phase_Line_current();
                bplcurrent = unitList.getB_Phase_Line_current();


                //Setting Load State value and logo
                double avgCurrent =(Double.parseDouble(rplcurrent)+Double.parseDouble(yplcurrent)+Double.parseDouble(bplcurrent))/3;
                String avgCurrentValue=Double.toString(avgCurrent);
                if(avgCurrent>1){
                    LoadStateLogo.setImageResource(R.drawable.ic_green_circle);
                    LoadStateValue.setText("ON");
                }
                else{
                    LoadStateLogo.setImageResource(R.drawable.ic_red_circle);
                    LoadStateValue.setText("OFF");
                }
                // Setting Record Time value and logo
                recordtime.setText(rt);
                if(rt!=" "){
                    RecordTimeLogo.setImageResource(R.drawable.ic_recordtime_logo);
                }
                //Setting Avg Voltage
                double avgVoltage = (Double.parseDouble(rpynvoltage)+Double.parseDouble(yptnvoltage)+Double.parseDouble(bptnvoltage))/3;
                String avgVoltageValue = Double.toString(avgVoltage);
                Avg_Voltage.setText(avgVoltageValue.substring(0,6));

                //Setting Avg Power Factor (!!!!!! issue in this because of YbpaPower)
                double avgPowerFactor = (Double.parseDouble(rpapower)+Double.parseDouble(bpapower))/2;
                String avgPowerFactorValue = Double.toString(avgPowerFactor);
                Avg_PowerFactor.setText(avgPowerFactorValue.substring(0,4));


                //Setting values to UI
                Avg_Current.setText(avgCurrentValue.substring(0,4));
                frequency.setText(freq.substring(0,5));

                Y_Phase_Active_Power.setText(ypapower);
                averagevoltage.setText(avgvol);
                Avg_power_factor.setText(avgpowerfac);
                three_Phase_Active_Power.setText(three_p_active_power);
                Active_Total_Import.setText(active_total_import);
                Neutral_Line_current.setText(neutral_Line_current);
                R_Phase_Active_Power.setText(rpapower);
                Y_Phase_Active_Power.setText(ypapower);
                B_Phase_Active_Power.setText(bpapower);
                R_Phase_Line_current.setText(rplcurrent);
                Y_Phase_Line_current.setText(yplcurrent);
                B_Phase_Line_current.setText(bplcurrent);
                R_Phase_to_Neutral_Voltag.setText(rpynvoltage);
                Y_Phase_to_Neutral_Voltag.setText(yptnvoltage);
                B_Phase_to_Neutral_Voltag.setText(bptnvoltage);



            }

            @Override
            public void onFailure(Call<Unit> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("ye hai error", t.getMessage());
            }


        });
    }


    @Override
    public void onClick(View v) {
        getUnits();
    }
}
