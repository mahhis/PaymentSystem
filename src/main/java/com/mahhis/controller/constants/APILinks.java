package com.mahhis.controller.constants;

import java.util.HashMap;
import java.util.Map;

public class APILinks {

    public static final String URLforAPItoGetCardInformation = "https://api.freebinchecker.com/bin/";

    /*public static final String SberBankAPI = "https://api.sber.com/";
    public static final String AlfaBankAPI = "https://api.alfa.com/";
    public static final String VTBBankAPI = "https://api.vtb.com/";

    public static final String JPMorganBankAPI = "https://api.jpmorgan.com/";
    public static final String BankOfAmericaAPI = "https://api.bank-of-america.com/";
    public static final String CitigroupBankAPI = "https://api.citigruop.com/";*/

    private final Map<String, String> apiLinks = new HashMap<String, String>();

    public APILinks(){
        apiLinks.put("SberBank", "https://api.sber.com/" );
        apiLinks.put("AlfaBank", "https://api.alfa.com/");
        apiLinks.put("VTBBank", "https://api.vtb.com/" );

        apiLinks.put("JPMorganBank", "https://api.jpmorgan.com/" );
        apiLinks.put("BankOfAmerica", "https://api.bank-of-america.com/" );
        apiLinks.put("CitigroupBankPA", "https://api.citigruop.com/" );
    }

    public String getAPILink(String bankName){
        String link = apiLinks.get(bankName);
        return link;
    }
}
