package com.church.test.vo;

/**
 * Created by com on 2015. 7. 18..
 */
public class CalendarVo {

    Integer curYear   = 0;
    Integer curMonth = 0;
    Integer bgnWeek   = 0;
    Integer lastDay   = 0;
    Integer firstDay  = 0;
    Integer nextMonth = 0;
    Integer prevMonth = 0;
    Integer nextYear  = 0;
    Integer prevYear  = 0;

    public Integer getCurYear() {
        return curYear;
    }

    public void setCurYear(Integer curYear) {
        this.curYear = curYear;
    }

    public Integer getCurMonth() {
        return curMonth;
    }

    public void setCurMonth(Integer curMonth) {
        this.curMonth = curMonth;
    }

    public Integer getBgnWeek() {
        return bgnWeek;
    }

    public void setBgnWeek(Integer bgnWeek) {
        this.bgnWeek = bgnWeek;
    }

    public Integer getLastDay() {
        return lastDay;
    }

    public void setLastDay(Integer lastDay) {
        this.lastDay = lastDay;
    }

    public Integer getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(Integer firstDay) {
        this.firstDay = firstDay;
    }

    public Integer getNextMonth() {
        return nextMonth;
    }

    public void setNextMonth(Integer nextMonth) {
        this.nextMonth = nextMonth;
    }

    public Integer getPrevMonth() {
        return prevMonth;
    }

    public void setPrevMonth(Integer prevMonth) {
        this.prevMonth = prevMonth;
    }

    public Integer getNextYear() {
        return nextYear;
    }

    public void setNextYear(Integer nextYear) {
        this.nextYear = nextYear;
    }

    public Integer getPrevYear() {
        return prevYear;
    }

    public void setPrevYear(Integer prevYear) {
        this.prevYear = prevYear;
    }
}
