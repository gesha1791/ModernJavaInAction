package com.chaplinskiy.modernjavainaction.chapterFive;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Practice {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Finds all transactions in 2011 and sort by value (small to high)
        List<Transaction> collect = transactions.stream()

                .filter(t -> t.getYear() == 2011) // Passes a predicate to filter to select transactions in year 2011

                .sorted(comparing(Transaction::getValue)) // Sorts them by using the value of the transaction
                .collect(toList());
        collect.forEach(System.out::println);

        // What are all the unique cities where the traders work?
        List<String> collect1 = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity()) // Extracts the city from each trader associated with the transaction
                .distinct() // Selects only unique cities
                .collect(toList());
        collect1.forEach(System.out::println);



        // Finds all traders from Cambridge and sort them by name
        List<Trader> traders = transactions.stream()

                .map(Transaction::getTrader)// Extracts all traders from the transactions

                .filter(trader -> trader.getCity().equals("Cambridge")) // select only the traders from the Cambridge

                .distinct() // remove any duplicates

                .sorted(comparing(Trader::getName)) // Sorts the resulting stream  of traders by their names

                .collect(toList());

        traders.forEach(System.out::println);


        // Returns a string of all traders’ names sorted alphabetically
        // bad solution
        String reduce = transactions.stream()
                .map(transaction -> transaction.getTrader().getName()) // Extracts all the names of the traders as a Stream of Strings
                .distinct() // remove duplicate names
                .sorted() // sort the names alphabetically
                .reduce("", (n1, n2) -> n1 + n2); // Combines the names one by one to form a String that concatenates all the names
        //good solution

        String reduceJoin = transactions.stream()
                .map(transaction -> transaction.getTrader().getName()) // Extracts all the names of the traders as a Stream of Strings
                .distinct() // remove duplicate names
                .sorted() // sort the names alphabetically
                .collect(joining());


        System.out.println(reduce);

        // Are any traders based in Milan?
        boolean milan = transactions.stream()
                .anyMatch(transaction -> transaction
                        .getTrader()
                        .getCity()
                        .equals("Milan")); // Pass a predicate to anyMatch to check if there’s a trader from Milan

        // Prints all transactions’ values from the traders living in Cambridge
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity())) // Selects the transactions where the traders live in Cambridge
                .map(Transaction::getValue) // Extracts the values of these trades
                .forEach(System.out::println); // Prints each value

        // What’s the highest value of all the transactions?
        Optional<Integer> reduce1 = transactions.stream()
                .map(Transaction::getValue) // Extracts the value of each transaction
                .reduce(Integer::max);// Calculates the max of the resulting stream

        // Finds the transaction with the smallest value

        Optional<Transaction> reduce2 = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);   // Finds the smallest transaction by
                                                                                // repeatedly comparing the values
                                                                                //of each transaction

        Optional<Transaction> min = transactions.stream()
                .min(comparing(Transaction::getValue));

    }
}
