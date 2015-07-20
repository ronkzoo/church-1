package com.church.test.web;

import com.church.test.vo.CalendarVo;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * Created by com on 2015. 7. 18..
 */
@Controller("calendarController")
public class CalendarController extends HttpServlet {

    /** **/
    private DecimalFormat format = new DecimalFormat("yyyyMMdd hh:mm:ss");
    /** **/
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/calendar")
    public ModelAndView getCalendarPage(HttpServletRequest request, HttpServletResponse response, Model model) {

        Calendar cal = Calendar.getInstance();
        Calendar cal2 = (Calendar) cal.clone();
        Calendar cal3 = (Calendar) cal.clone();
        Calendar cal4 = (Calendar) cal.clone();

        CalendarVo vo = new CalendarVo();

        vo.setCurYear(cal.get(Calendar.YEAR));
        vo.setCurMonth(cal.get(Calendar.MONTH) + 1);
        vo.setLastDay(cal.getActualMaximum(Calendar.DATE));

        cal3.add(Calendar.MONTH, 1);
        vo.setNextMonth(cal3.get(Calendar.MONTH));
        cal3.add(Calendar.MONTH, -2);
        vo.setPrevMonth(cal3.get(Calendar.MONTH));

        if (vo.getCurMonth() == 12) {
            cal2.add(Calendar.YEAR, 1);
            vo.setNextYear(cal2.get(Calendar.YEAR));
        } else {
            vo.setNextYear(cal.get(Calendar.YEAR));
        }

        if (vo.getCurMonth() == 1) {
            cal2.add(Calendar.YEAR, -1);
            vo.setPrevYear(cal2.get(Calendar.YEAR));
        } else {
            vo.setPrevYear(cal.get(Calendar.YEAR));
        }

        cal4.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),1);
        vo.setBgnWeek(cal4.get(Calendar.DAY_OF_WEEK));

        model.addAttribute("calendar",vo);

        return new ModelAndView("com/ronkzoo/test/Calendar");
    }

    @RequestMapping(value = "/calendar/{year}/{month}")
    public ModelAndView getCalendarPage(
            HttpServletRequest request,  HttpServletResponse response,
            @PathVariable("year") Integer year, @PathVariable("month") Integer month, Model model) {

        logger.debug("{1}, {2} ::::: ",year, month);

        CalendarVo vo  = new CalendarVo();
        Calendar cal   = (Calendar)Calendar.getInstance().clone();

        cal.set(year, month, Calendar.DATE);

        vo.setCurYear(cal.get(Calendar.YEAR));
        vo.setCurMonth(cal.get(Calendar.MONTH) + 1);
        vo.setLastDay(cal.getActualMaximum(Calendar.DATE));

        Calendar c = (Calendar)cal.clone();
        c.add(Calendar.MONTH, 1);
        vo.setNextMonth(c.get(Calendar.MONTH));

        c = (Calendar)cal.clone();
        c.add(Calendar.MONTH, -1);
        vo.setPrevMonth(c.get(Calendar.MONTH));

        if (vo.getCurMonth() == 12) {
            c = (Calendar)cal.clone();
            c.add(Calendar.YEAR, 1);
            vo.setNextYear(c.get(Calendar.YEAR));
        } else {
            vo.setNextYear(cal.get(Calendar.YEAR));
        }

        if (vo.getCurMonth() == 1) {
            c = (Calendar)cal.clone();
            c.add(Calendar.YEAR,-1);
            vo.setPrevYear(c.get(Calendar.YEAR));
        } else {
            vo.setPrevYear(cal.get(Calendar.YEAR));
        }
        c = (Calendar)Calendar.getInstance().clone();
        c.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),1);
        vo.setBgnWeek(c.get(Calendar.DAY_OF_WEEK));

        model.addAttribute("route","calendar");
        model.addAttribute("calendar",vo);

        return new ModelAndView("com/ronkzoo/test/Calendar");

    }

    @RequestMapping(value="/jodaCalendar")
    public ModelAndView getJodaTodayCalendarPage(
            HttpServletRequest request,  HttpServletResponse response, Model model) {

        LocalDate theDay = new LocalDate();
        return this.getJodaCalendarPage(request, response, theDay.getYear(), theDay.getMonthOfYear(), model);

    }

    @RequestMapping(value = "/jodaCalendar/{year}/{month}")
    public ModelAndView getJodaCalendarPage(
            HttpServletRequest request,  HttpServletResponse response,
            @PathVariable("year") Integer year, @PathVariable("month") Integer month, Model model) {

        logger.debug("year : {}, month : {} ::::: ",year, month);

        CalendarVo vo    = new CalendarVo();
        LocalDate theDay = new LocalDate();
        year             =   (year != null) ? year  : theDay.getYear();
        month            =   (month!= null) ? month : theDay.getDayOfMonth();
        Integer day      = theDay.getDayOfMonth();
        theDay = new LocalDate(year,month,day);

        vo.setCurYear(theDay.getYear());
        vo.setCurMonth(theDay.getMonthOfYear());
        vo.setLastDay(theDay.dayOfMonth().getMaximumValue());
        vo.setNextMonth(theDay.plusMonths(1).getMonthOfYear());
        vo.setPrevMonth(theDay.minusMonths(1).getMonthOfYear());

        if (vo.getCurMonth() == 12) {
            vo.setNextYear(theDay.plusYears(1).getYear());
        } else {
            vo.setNextYear(year);
        }

        if (vo.getCurMonth() == 1) {
            vo.setPrevYear(theDay.minusYears(1).getYear());
        } else {
            vo.setPrevYear(year);
        }
        LocalDate bgnDate = new LocalDate(year, month, 1);
        vo.setBgnWeek(bgnDate.getDayOfWeek());

        model.addAttribute("route", "jodaCalendar");
        model.addAttribute("calendar",vo);

        return new ModelAndView("com/ronkzoo/test/Calendar");
    }

}
