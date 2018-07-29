package com.company.enums;


public class Main {

    private static String CONSTANT_BLUE = "";
    private static String CONSTANT_RED = "";
    private static String CONSTANT_WHITE = "";

    public static void main(String[] args) {
	    //Enums
        //Java Date API

        //class
        //interface
        //enum
//        new Person("Moshe");
        Person p1 = new Person("Natalie"); //разная память для p1
        Person p2 = new Person("Natalie"); //разная память для p2
        System.out.println(p1 == p2); //    false
//        new Person("Natalie");
//        new Person("Natalie");
//        new Person("Natalie");
//        new Person("Natalie");

        System.out.printf("Account type: %s | ID: %s\n",
                AccountType.USER.getDisplayName(),
                AccountType.USER.getId());

        Integer accountTypeId = 1;
        AccountType accountType = AccountType.getById(accountTypeId);
        System.out.printf("Account type: %s | ID: %s\n",
                accountType.getId(),
                accountType.getDisplayName());

        System.out.println(accountType == AccountType.GUEST); //    true/false
        AccountType u1 = AccountType.USER; //u1 один и тот же участок памяти
        AccountType u2 = AccountType.USER; //u1 один и тот же участок памяти
        System.out.println(u1 == u2);
        System.out.println(u1.name());

        //AccountType
        //values()
        //valueOf()

        //AccountType: specific object, like USER or GUEST
        //ordinal()
        //name()



    }
}

class Color {
    public static final String BLUE = "BLUE"; //id
    public static final String RED = "RED"; //id
    public static final String WHITE = "WHITE"; //id
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
}