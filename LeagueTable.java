// This is the only Class you need to edit
// DO NOT EDIT SOME METHODS FROM THE CLASS - THESE ARE CLEARLY STATED
// DO NOT USE ADDITIONAL LIBRARIES TO IMPLEMENT YOUR SOLUTION

import java.util.ArrayList;
import java.util.HashMap;

public class LeagueTable {
    private ArrayList<Team> teams;

    // Part 1 of A2: Pre-processing of input from HashMap to ArrayList
    public LeagueTable(HashMap<String, Integer> league) {
        teams = new ArrayList<Team>();
        ArrayList<String> keys = new ArrayList<String>(league.keySet());
        for(int index = 0; index < league.size(); index++){
            Team temp1 = new Team();
            temp1.setName(keys.get(index));
            temp1.setPoints(league.get(keys.get(index)));
            teams.add(temp1);
        }
    }

    // DO NOT EDIT THIS METHOD
    // You can use this method to create copies of an ArrayList, e.g. for dividing the list into two for Mergesort
    private ArrayList<Team> copyPartOfLeague(ArrayList<Team> league, int startIndex, int endIndex) {
        ArrayList<Team> copy = new ArrayList<Team>();
        for (int i = startIndex; i <= endIndex; i++) {
            Team team = new Team();
            team.setName(league.get(i).getName());
            team.setPoints(league.get(i).getPoints());
            copy.add(team);
        }

        return copy;
    }

    // DO NOT EDIT THIS METHOD
    // You do not need to use this method
    public ArrayList<Team> copyLeague() {
        return copyPartOfLeague(teams, 0, teams.size()-1);
    }

    // DO NOT EDIT THIS METHOD
    public void printTable() {
        // Print the initial (unsorted) list of teams first
        print(copyLeague());

        // Sort the list of teams - it should also print the recursion tree
        System.out.println("===========================");
        System.out.println("PRINTING THE RECURSION TREE");
        System.out.println("===========================");
        teams = mergeSort(copyLeague());

        // Print the sorted list of teams
        System.out.println("=========================");
        System.out.println("PRINTING THE LEAGUE TABLE");
        System.out.println("=========================");
        print(copyLeague());
    }

    // Part 1 of A2: Implement the Mergesort algorithm to sort the league
    // Part 2 of A2: It should also print the recursion tree, somewhere in mergeSort(...) or merge(...)
    // Takes as input a list and returns the sorted list
    private ArrayList<Team> mergeSort(ArrayList<Team> league) {

        //printing out the recursion tree
        for(Team temp: league) {
            System.out.print(temp.getName() + " ");
        }
        System.out.println();

        //set length variable
        int length = league.size();

        //Termination condition
        if(length == 1){return league;}

        //Set the half variable
        int halfArray = length/2;

        //Left and right arrays
        ArrayList<Team> left = mergeSort(copyPartOfLeague(league, 0, halfArray-1));
        ArrayList<Team> right = mergeSort(copyPartOfLeague(league, halfArray, length-1));

        //Returns that array merged together
        return merge(left, right);
    }

    // Part 1 of A2: Implement the Merge algorithm as part of Mergesort
    // Takes as input two sorted lists and returns the merged sorted list
    private ArrayList<Team> merge(ArrayList<Team> firstHalf, ArrayList<Team> secondHalf) {

        int firstIndex = 0;
        int secondIndex = 0;
        ArrayList<Team> merged = new ArrayList<Team>();

        //While either array has more items
        while(firstIndex < firstHalf.size() || secondIndex < secondHalf.size()){

            //if both arrays have items
            if(firstIndex < firstHalf.size() && secondIndex < secondHalf.size()) {

                //if value in first is bigger than value in second
                if (firstHalf.get(firstIndex).getPoints() > secondHalf.get(secondIndex).getPoints()) {
                    merged.add(firstHalf.get(firstIndex));
                    firstIndex++;
                }

                //if value in second is bigger than value in first
                else {
                    merged.add(secondHalf.get(secondIndex));
                    secondIndex++;
                }
            }
            //If one is bigger than the index
            else {
                if (firstIndex < firstHalf.size()) {
                    merged.add(firstHalf.get(firstIndex));
                    firstIndex++;
                } else {
                    merged.add(secondHalf.get(secondIndex));
                    secondIndex++;
                }
            }
        }
        return merged;
    }

    // Part 1 of A2: Post-processing of output to print the league table
    // ONLY RECURSIVE SOLUTIONS WILL BE ACCEPTED
    private void print(ArrayList<Team> league) {
        if(league.size() != 0 ) {
            System.out.println("Team: " + league.get(0).getName() + "		Points: " + league.get(0).getPoints());
            print(copyPartOfLeague(league, 1, league.size()-1));
        }
    }

    // Part 3 of A2: Find teams with more points than the sum of points of at least 3 teams
    // YOU SHOULD NOT SORT THE TEAMS FIRST
    // HINT: Try reducing this to a similar problem of Subset Sum
    // You need to write one additional recursive method
    // (because the parameter for total points is not known in advance, but it depends on the selected team)
    // ONLY RECURSIVE SOLUTIONS WILL BE ACCEPTED FOR THE ADDITIONAL METHOD
    public void analyseTeams(ArrayList<Team> league) {

    }

}