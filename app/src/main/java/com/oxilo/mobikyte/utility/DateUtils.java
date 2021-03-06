package com.oxilo.mobikyte.utility;

import android.net.ParseException;

import com.oxilo.mobikyte.POJO.CampList;
import com.oxilo.mobikyte.POJO.InVoiceObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by ericbasendra on 09/12/15.
 */
public final class DateUtils<T> implements Comparator<T> {
    List<T> campLists;

    @Override
    public int compare(T t, T t1) {

        try {
            //Pass String Date Format To Set UserDefined Date
            //Parse given STRING date to DATE format through df

            Long dx = ((CampList)t).getStartDate();
            Date d1 = new Date(dx * 1000);
            Calendar cT = Calendar.getInstance();
            cT.setTime(d1);

            //Pass String Date Format To Set UserDefined Date
            //Parse given STRING date to DATE format through df
            Date d2 = new Date(((CampList)t1).getStartDate() * 1000);
            Calendar cT1 = Calendar.getInstance();
            cT1.setTime(d2);

            if(cT.getTimeInMillis() > cT1.getTimeInMillis())
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }catch (ParseException e) {

            e.printStackTrace();
        }

        return 0;
    }

    public List<T> getCampLists() {
        return campLists;
    }

    public void setCampLists(List<T> campLists) {
        this.campLists = campLists;
    }
}
