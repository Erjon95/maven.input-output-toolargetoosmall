package com.github.perschola;


import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;


public class InputEvaluator {
    private final int MAX;
    private final int MIN;
    Set<Integer> arrayOfGuesses = new HashSet<>();
    int guess, randomNumber;
    boolean exc;

    private int getRandomNumber() {
        return randomNumber;
    }

    public InputEvaluator()
    {
        this.MAX = 20;
        this.MIN = 0;
        guess = 0;
        exc = false;
        randomNumber = (int) ((Math.random() * ((MAX - MIN) + 1)) + MIN);
    }


    private int getMIN() {
        return MIN;
    }

    private int getGuess() {
        return guess;
    }

    private void setGuess(int guess) {
        this.guess = guess;
    }

    private Set<Integer> getArrayOfGuesses() {
        return arrayOfGuesses;
    }

    private void addToArrayOfGuesses(int guess) {
        arrayOfGuesses.add(guess);
    }

    private boolean isExc() {
        return exc;
    }

    private void setExc(boolean exc) {
        this.exc = exc;
    }

    private int getMAX() {
        return MAX;
    }

    private void readInputFromUser(Scanner scanner)
    {
        try {
            setGuess(scanner.nextInt());
        } catch (InputMismatchException ime) {
            System.out.println("Please, enter an integer");
            setExc(true);
            scanner.nextLine();
        }
    }

    private void evaluate(Scanner scanner)
    {
        while (true) {
            setExc(false);
            readInputFromUser(scanner);

            if (!isExc()) {
                if (getGuess() > getMAX() || getGuess() < getMIN()) {
                    System.out.println("Your guess must be in the range [" + getMIN() + ',' + getMAX() + "] " + "inclusive");
                    scanner.nextLine();
                } else {

                    if (getGuess() < getRandomNumber()) {

                        addToArrayOfGuesses(getGuess());
                        System.out.println("too low");
                        System.out.println("Please enter another guess");
                        scanner.nextLine();
                    } else if (getGuess() > getRandomNumber()) {

                        addToArrayOfGuesses(getGuess());
                        System.out.println("too high");
                        System.out.println("Please enter another guess");
                        scanner.nextLine();
                    } else {
                        addToArrayOfGuesses(guess);
                        System.out.println("Correct value!");
                        System.out.println("number of guesses: " + getArrayOfGuesses().size());
                        scanner.close();
                        return;
                    }
                }
            }
        }
    }
    public void run() {

        Scanner scanner = new Scanner(System.in);
        //ask user for guess
        System.out.println("Please, enter your guess as an integer in the range [0,20] inclusive");
        //read input from user and evaluate
        evaluate(scanner);
    }
}
