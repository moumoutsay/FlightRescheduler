package edu.cmu.sv.flight.rescheduler.ui.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import edu.cmu.sv.flight.rescheduler.ui.activity.PagerActivity;

/**
 * Created by moumoutsay on 4/9/15.
 */
public class IntentToPagerActivityOnClickListener implements View.OnClickListener {

    private Activity act;

    public IntentToPagerActivityOnClickListener(Activity act) {
        this.act = act;
    }

    @Override
    public void onClick(View v) {
        act.startActivity(new Intent(act, PagerActivity.class));
    }
}