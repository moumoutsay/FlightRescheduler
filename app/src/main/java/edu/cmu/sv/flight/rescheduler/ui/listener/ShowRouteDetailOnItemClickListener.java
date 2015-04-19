package edu.cmu.sv.flight.rescheduler.ui.listener;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import edu.cmu.sv.flight.rescheduler.entities.rescheduler.CurrentRoute;
import edu.cmu.sv.flight.rescheduler.ui.R;
import edu.cmu.sv.flight.rescheduler.ui.activity.PagerConfirmActivity;

/**
 * Created by moumoutsay on 4/10/15.
 */
public class ShowRouteDetailOnItemClickListener implements AdapterView.OnItemClickListener {
    private final String mockFlightDetail = "Test flight detail.........\nFlight# 12345678";
    private Activity act;
    private Dialog dialog;
    private Button buttonRebook;
    private Button buttonCancel;
    private TextView textViewFlightDetail;
    private CurrentRoute currentRoute;


    public ShowRouteDetailOnItemClickListener(Activity act) {
        this.act = act;
        dialog = new Dialog(act);
        dialog.setContentView(R.layout.flight_details);
        dialog.setTitle("Flight details");

        buttonRebook = (Button) dialog.findViewById(R.id.buttonRebook);
        buttonCancel = (Button) dialog.findViewById(R.id.buttonCancelRebook);
        buttonRebook.setOnClickListener(new DialogDismissAndIntentToAnotherActivityOnClickListener(act, dialog, PagerConfirmActivity.class));
        buttonCancel.setOnClickListener(new DialogDismissAndIntentToAnotherActivityOnClickListener(act, dialog, null));
        textViewFlightDetail = (TextView) dialog.findViewById(R.id.textViewFlightDetails);
    }

    private void display(String fightDetails) {
        currentRoute = new CurrentRoute();
        // TODO, get data from ProxyRescheduler

        dialog.show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        textViewFlightDetail.setText(mockFlightDetail);
        display( ((TextView)view).getText().toString());
    }
}
