package com.pluralsight;

import ui.UserInterface;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("Welcome to Pizza Licious");

        UserInterface ui = new UserInterface();
        ui.showHomeScreen();
    }
}
