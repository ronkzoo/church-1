package com.church;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by com on 2015. 7. 19..
 */
public class JodaTimeTestMain {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() {
        LocalDate theDay = new LocalDate();
        logger.debug(theDay.toString());
        LocalDate nextDay = theDay.plusDays(1);
        logger.debug(nextDay.toString());

        logger.debug("getDayOfMonth : {} ",theDay.getDayOfMonth());
        logger.debug("getDayOfWeek  : {} ", theDay.getDayOfWeek());
        logger.debug("getDayOfYear  : {} ", theDay.getDayOfYear());

        logger.debug("getDayOfMonth : {} ", nextDay.getDayOfMonth());
        logger.debug("getDayOfWeek  : {} ", nextDay.getDayOfWeek());
        logger.debug("getDayOfYear  : {} ", nextDay.getDayOfYear());


    }

}
