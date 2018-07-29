package com.company.enums;

/**
 * AccountType
 * AccountStatus: NEW_USER, EMAIL_CONFIRMED, PHONE_CONFIRMED, BLOCKED
 * FileType: JPG, JPEG, DOC, DOCX
 * EmailType: REGISTRATION_CONFIRMATION, PASSWORD_RESET_CONFIRMATION...
 */
public enum AccountType { //AccountType GUEST = new AccountType(1, "Guest")
    /*ordinal*/
    /*0*/USER(2, "User"),
    /*1*/ADMIN(3, "Admin"), //new GUEST()
    /*2*/GUEST(1, "Guest"); //"admin" | "Admin" | "ADMIN" | "damin"

    private final String displayName;
    private final Integer id;

    AccountType(Integer agr0, String arg1) {
        this.id = agr0;
        this.displayName = arg1;
    }

    public Integer getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static AccountType getById(Integer id) {
        if (id == null) {
            return null;
        }

        for (AccountType accountType : AccountType.values()) {
            //1 итерация -> GUEST -> id 1
            //2 итерация -> USER -> id 2
            //3 итерация -> ADMIN -> id 3

            if (accountType.getId().equals(id)) {
                return accountType;
            }
        }

        return null;
    }



}

//new Color("BLUE")