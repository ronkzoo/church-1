package com.church;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by com on 2015. 7. 18..
 */
public class TestCalendar extends Assert {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Test
    public void test2() {
        Calendar cal = Calendar.getInstance();
        // month
        logging(cal);

        // month + 1
//        Calendar cal1 = (Calendar)cal.clone();
//        cal1.add(Calendar.MONTH, 1);
//        logging(cal1);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), 1);
        logging(cal);



    }

    public void logging(Calendar cal){
        logger.debug("============================================================");
        logger.debug("today                     : " + this.format.format(cal.getTime()));
        logger.debug("DAY_OF_WEEK               : " + cal.get(Calendar.DAY_OF_WEEK));
        logger.debug("DAY_OF_MONTH              : " + cal.get(Calendar.DAY_OF_MONTH));
        logger.debug("DAY_OF_WEEK_IN_MONTH      : " + cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        logger.debug("DAY_OF_YEAR               : " + cal.get(Calendar.DAY_OF_YEAR));
        logger.debug("getFirstDayOfWeek         : " + cal.getFirstDayOfWeek());
        logger.debug("timezone                  : " + cal.getTimeZone());
        logger.debug("getMinimalDaysInFirstWeek : " + cal.getMinimalDaysInFirstWeek());
        logger.debug("cal.getWeekYear()         : " + cal.getWeekYear());
        logger.debug("last day                  : " + cal.getActualMaximum(Calendar.DATE));
        logger.debug("TOTAL_WEEK                : " + (cal.getActualMaximum(Calendar.DATE) / 7));
        logger.debug("TOTAL_WEEK mod 7          : " + (cal.getActualMaximum(Calendar.DATE) % 7));
        logger.debug("============================================================");
    }



}
