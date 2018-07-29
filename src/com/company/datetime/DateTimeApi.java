package com.company.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeApi {

    //http://www.baeldung.com/java-8-date-time-intro
    public static void main(String[] args) {
        //Java Date API

        //Legacy problems
        //1. Multithreading
        //2. Date and time calculations
        //3. Time zones

        //4. DB compatibility

//        Date date = new Date();
        //SimpleDateFormat
//        System.out.println(date.getTime());
        //string -> date
        //2018-07-01 -> date
        //date.plus 2 days
        //date.minus 2 days + 1 week
        //new Date()

        //Java Date API structure:
        //Local-  | Zone-

        //LocalDate
        //LocalTime
        //LocalDateTime

//        //immutable/mutable
//        String s = "abcdefg";
//        s.toUpperCase(); //new String
//        s.substring(2); //new String
//
//        System.out.println(s);

        localDate();
        System.out.println();
        System.out.println("--------------");
        System.out.println();
        localTime();
        System.out.println();
        System.out.println("--------------");
        System.out.println();
        localDateTime();
    }

    private static void localDate() {
        LocalDate now = LocalDate.now();
        System.out.printf("Now: %s\n", now);

        //.of() - если у вас уже есть готовые месяцы, дни и года
        LocalDate nowByHand = LocalDate.of(2018, 7, 29);
        System.out.printf("Now by hand: %s\n", nowByHand);

        //.parse() - из string в LocalDate
        LocalDate nowFromString = LocalDate.parse("2018-07-29");
        System.out.printf("Now from string: %s\n", nowFromString);


        LocalDate tomorrow = now.plusDays(1);
        System.out.printf("Tomorrow: %s\n", tomorrow);

        LocalDate yesterday = tomorrow.minusDays(2);
        System.out.printf("Yesterday: %s\n", yesterday);

        //ChronoUnit
        LocalDate todayTwoCenturiesAgo = LocalDate.now().minus(2, ChronoUnit.CENTURIES);
        System.out.printf("Today two centuries ago: %s\n", todayTwoCenturiesAgo);


        String customStringDate = "2018/07/01";

        //DateTimeFormatter - скажи в каком формате у тебя дата
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate customDate = LocalDate.parse(customStringDate, dateFormatter);
        System.out.println(customDate);

        String customStringDateWithAsterisk = "2019*12*31";
        DateTimeFormatter форматировщикДатыПоЗвездочке = DateTimeFormatter.ofPattern("yyyy*MM*dd");
        LocalDate датаПоЗвездочке = LocalDate.parse(customStringDateWithAsterisk, форматировщикДатыПоЗвездочке);
        System.out.println(датаПоЗвездочке);

//        System.out.println(LocalDate.parse(customStringDate));




    }

    private static void localTime() {
        LocalTime now = LocalTime.now();
        System.out.printf("Now: %s\n", now);

        LocalTime twoHoursAgo = LocalTime.now().minus(2, ChronoUnit.HOURS);
        System.out.printf("Two hours ago: %s\n", twoHoursAgo);

        LocalTime calc = LocalTime.now().plusHours(2).minusMinutes(30).minus(30, ChronoUnit.HOURS);
        System.out.println(calc);

        LocalTime nowByHand = LocalTime.of(12, 7, 24);
        System.out.printf("Now by hand: %s\n", nowByHand);

        LocalTime nowFromString = LocalTime.parse("16:22");
        System.out.println(nowFromString);

        String customTimeString = "23$49";

        LocalTime customTime = LocalTime.parse(
                customTimeString,
                DateTimeFormatter.ofPattern("HH$mm"));
        System.out.println(customTime);

    }

    private static void localDateTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        String stringDateTime = "2018-01-01T23:01:57";
        LocalDateTime firstJanuary2018 = LocalDateTime.parse(stringDateTime);
        System.out.println("First Jan 2018: " + firstJanuary2018);

        String myDateTimeFormat = "01/01/2018 10:04:00";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime customFormat = LocalDateTime.parse(myDateTimeFormat, formatter);

        //.format() -> как печатать
        System.out.println(customFormat.format(DateTimeFormatter.ofPattern("yyyy MMMM")));
        LocalDateTime threeWeeksPlus = customFormat.plusWeeks(3);
        System.out.println(threeWeeksPlus.format(formatter));
        System.out.println(threeWeeksPlus.getDayOfWeek());

        ;
    }
}
