package com.mattiasbergstrom.reseplanerare.fragments;

import java.util.Calendar;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;


public class TimePickerFragment extends DialogFragment 
								implements TimePickerDialog.OnTimeSetListener {
	
	public interface TimeSetCallback {
		public void SetDate(TimePicker view, int hourOfDay, int minute);
	}
	
	private TimeSetCallback callback;
	
	public void setCallback(TimeSetCallback callback) {
		this.callback = callback;
	}
	
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
    	callback.SetDate(view, hourOfDay, minute);
    }
}
