package com.rohit.java.supplier.joke;

public class JokeCommunicator {
    private static int counter = -1;
    private static final String[] jokes = {
            "When I see lovers' names carved in a tree, I don't think it's sweet. " +
                    "I just think it's surprising how many people bring a knife on a date.",
            "Scientists have now discovered how women keep their secrets. " +
                    "They do so within group of 40.",
            "\"I wasn't that drunk yesterday\" \"Oh boy you took the shower head in your arms " + "" +
                    "and told it to stop crying\"",
            "Why do women live on average two years longer? Because the time they spend parking don't count.",
            "What do politicians and diapers have in common? \n" +
                    "Both should be changed regularly, and for the same reason"};
    private static final int MAX_JOKES = 5;

    private static void handleCounter(){
        counter++;
        if(counter == MAX_JOKES){
            counter = 0;
        }
    }

    public static String getAJoke(){
        handleCounter();
        return jokes[counter];
    }
}
