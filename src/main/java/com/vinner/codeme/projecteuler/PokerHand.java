package com.vinner.codeme.projecteuler;

import com.vinner.codeme.ProblemStatement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class PokerHand implements ProblemStatement {
    @Override
    public String getDescription() {
        return "In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:\n" +
                "\n" +
                "High Card: Highest value card.\n" +
                "One Pair: Two cards of the same value.\n" +
                "Two Pairs: Two different pairs.\n" +
                "Three of a Kind: Three cards of the same value.\n" +
                "Straight: All cards are consecutive values.\n" +
                "Flush: All cards of the same suit.\n" +
                "Full House: Three of a kind and a pair.\n" +
                "Four of a Kind: Four cards of the same value.\n" +
                "Straight Flush: All cards are consecutive values of same suit.\n" +
                "Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.\n" +
                "The cards are valued in the order:\n" +
                "2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.\n" +
                "\n" +
                "If two players have the same ranked hands then the rank made up of the highest value wins; for example, a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie, for example, both players have a pair of queens, then highest cards in each hand are compared (see example 4 below); if the highest cards tie then the next highest cards are compared, and so on.\n" +
                "\n" +
                "Consider the following five hands dealt to two players:\n" +
                "\n" +
                "Hand\t \tPlayer 1\t \tPlayer 2\t \tWinner\n" +
                "1\t \t5H 5C 6S 7S KD\n" +
                "Pair of Fives\n" +
                " \t2C 3S 8S 8D TD\n" +
                "Pair of Eights\n" +
                " \tPlayer 2\n" +
                "2\t \t5D 8C 9S JS AC\n" +
                "Highest card Ace\n" +
                " \t2C 5C 7D 8S QH\n" +
                "Highest card Queen\n" +
                " \tPlayer 1\n" +
                "3\t \t2D 9C AS AH AC\n" +
                "Three Aces\n" +
                " \t3D 6D 7D TD QD\n" +
                "Flush with Diamonds\n" +
                " \tPlayer 2\n" +
                "4\t \t4D 6S 9H QH QC\n" +
                "Pair of Queens\n" +
                "Highest card Nine\n" +
                " \t3D 6D 7H QD QS\n" +
                "Pair of Queens\n" +
                "Highest card Seven\n" +
                " \tPlayer 1\n" +
                "5\t \t2H 2D 4C 4D 4S\n" +
                "Full House\n" +
                "With Three Fours\n" +
                " \t3C 3D 3S 9S 9D\n" +
                "Full House\n" +
                "with Three Threes\n" +
                " \tPlayer 1\n" +
                "The file, poker.txt, contains one-thousand random hands dealt to two players. Each line of the file contains ten cards (separated by a single space): the first five are Player 1's cards and the last five are Player 2's cards. You can assume that all hands are valid (no invalid characters or repeated cards), each player's hand is in no specific order, and in each hand there is a clear winner.\n" +
                "\n" +
                "How many hands does Player 1 win?";
    }

    public int execute() {
        int player1Wins = 0;
        int countRuns = 0;
        try {
           // InputStream is = getClass().getClassLoader().getResourceAsStream("pokerhand-test.txt");
            InputStream is = getClass().getClassLoader().getResourceAsStream("pokerhand.txt");

            if (is == null) {
                throw new IllegalArgumentException("file not found! ");
            }
            InputStreamReader streamReader =
                    new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);

            String line;

            while ((line = reader.readLine()) != null) {
                countRuns++;
                String[] runs = line.split(" ");
                Hand player1Hand = computeHand(runs, 0, 5);
                Hand player2Hand = computeHand(runs, 5, 10);


                if (player1Hand.rankValue.getRankValue() > player2Hand.rankValue.getRankValue())
                    player1Wins++;
                else if (player1Hand.rankValue.getRankValue() == player2Hand.getRankValue().getRankValue()) { // If Rank is same then we compare the highest card
                    if(player1Hand.getRankHighestValue() > player2Hand.getRankHighestValue())
                        player1Wins++;

                    else if(player1Hand.getRankHighestValue() == player2Hand.getRankHighestValue()) {
                        boolean player1Won = false;
                        int counter = 0;
                        int totalCardsPlayer1Has = player1Hand.getValueToCountMap().keySet().size();
                        while (counter < totalCardsPlayer1Has) {
                            int maxPlayer1Has = player1Hand.getValueToCountMap().lastKey();
                            int maxPlayer2Has = player2Hand.getValueToCountMap().lastKey();

                            if (maxPlayer1Has < maxPlayer2Has) {
                                player1Won = false;
                                break;
                            } else if (maxPlayer1Has == maxPlayer2Has) //Remove this and compare next of both players
                            {
                                player1Hand.getValueToCountMap().remove(maxPlayer1Has);
                                player2Hand.getValueToCountMap().remove(maxPlayer2Has);
                            }
                            else //Means Player 1 won
                            {
                                player1Won = true;
                                break;
                            }

                            counter++;
                        }
                        if (player1Won)
                            player1Wins++;
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return  player1Wins;
    }



    private Hand computeHand (String[] run, int startIndex, int endIndex)
    {
        Hand hand = new Hand();
        Map<Character, Integer> suitsToCountMap = new HashMap<>();
        TreeMap<Integer, Integer> valueToCountMap = new TreeMap<>();
        for(int i=startIndex; i<endIndex; i++)
        {
            int val = getCardValue(run[i].charAt(0));
            char suit = run[i].charAt(1);
            int suitsCount = 1;
            int valueCount = 1;
            if(suitsToCountMap.containsKey(suit))
                suitsCount = suitsToCountMap.get(suit) + 1;

            if(valueToCountMap.containsKey(val))
                valueCount = valueToCountMap.get(val) + 1;

            suitsToCountMap.put(suit,suitsCount);
            valueToCountMap.put(val,valueCount);
        }
        hand.setSuitsToCountMap(suitsToCountMap);
        hand.setValueToCountMap(valueToCountMap);

        RankValue rankValue;
        if(suitsToCountMap.keySet().size() == 1)//Means All of Same Suit
            rankValue = getRankForSameSuit(hand);
        else
            rankValue = getRankForDiffSuit(hand);

        hand.setRankValue(rankValue);
        return hand;
    }

    //Can only be Royal Flush , Straigh Flush  and Flush
    private RankValue getRankForSameSuit(Hand hand)
    {
        //Means has 5 Values and first Value start with 10 then it is Royal Flush
        hand.setRankHighestValue(hand.getValueToCountMap().lastKey());
        if(hand.getValueToCountMap().firstKey() == 10 &&  hand.getValueToCountMap().keySet().size() == 5)
        {

            return  RankValue.RoyalFlush;

        }
        if(isConsecutiveCards(hand.getValueToCountMap())) {
            return RankValue.StraightFlush;
        }
        // If it still maintained consecuitve order , it is Straight flush

//means it is neither Straight Flush nor Royal Flush then since same suit it is just flush
        return RankValue.Flush;
    }

    private RankValue getRankForDiffSuit(Hand hand)
    {
        int highestValRank = 0;
        if(hand.getValueToCountMap().values().contains(4)) {// Means has a Card value of 4 times
            highestValRank = hand.getValueToCountMap().keySet().stream().filter(key -> hand.getValueToCountMap().get(key) == 4).findFirst().get();
            hand.setRankHighestValue(highestValRank);
            return RankValue.FourOfKind;
        }
        if(hand.getValueToCountMap().values().contains(3) &&  hand.getValueToCountMap().values().contains(2) ) // Means 3 of a kind and a Pair
        {
            highestValRank = hand.getValueToCountMap().keySet().stream().filter(key -> hand.getValueToCountMap().get(key) == 3).findFirst().get();
            hand.setRankHighestValue(highestValRank);
            return RankValue.FullHouse;

        }
        if(isConsecutiveCards (hand.getValueToCountMap()) && hand.getValueToCountMap().keySet().size() == 5) {
            highestValRank = hand.getValueToCountMap().lastKey();
            hand.setRankHighestValue(highestValRank);
            return RankValue.Straight;
        }

        if(hand.getValueToCountMap().values().contains(3)) {
            highestValRank = hand.getValueToCountMap().keySet().stream().filter(key -> hand.getValueToCountMap().get(key) == 3).findFirst().get();
            hand.setRankHighestValue(highestValRank);
            return RankValue.ThreeOfKind;
        }

        int pairsCount =  (int)hand.getValueToCountMap().values().stream().filter(cnt -> cnt == 2).count();
        if(pairsCount == 2) {
            for(Integer key : hand.getValueToCountMap().keySet())
            {
                if(hand.getValueToCountMap().get(key ) == 2 &&  key > highestValRank)
                {
                    highestValRank = key;
                }
            }
            hand.setRankHighestValue(highestValRank);
            return RankValue.TwoPairs;
        }
        if(hand.getValueToCountMap().values().contains(2)) {
            highestValRank = hand.getValueToCountMap().keySet().stream().filter(key -> hand.getValueToCountMap().get(key) == 2).findFirst().get();
            hand.setRankHighestValue(highestValRank);
            return RankValue.OnePair;
        }
        else {
            highestValRank = hand.getValueToCountMap().lastKey();
            hand.setRankHighestValue(highestValRank);
            return RankValue.HighCard;
        }

    }

    private boolean isConsecutiveCards (Map<Integer,Integer> valueToCountMap)
    {
        int previousValue=0;
        boolean isConsecuitve = true;
        for(Integer val : valueToCountMap.keySet()) // Since it is a tree map it will preserve the order
        {
            if(previousValue != 0)
            {
                if(previousValue + 1 != val)
                {
                    isConsecuitve = false;
                    break;
                }
            }
            previousValue = val;

        }
        return  isConsecuitve;
    }

    class Hand{
        Map<Character, Integer> suitsToCountMap;
        TreeMap<Integer, Integer> valueToCountMap;
        RankValue rankValue;
        int rankHighestValue;


        public TreeMap<Integer, Integer> getValueToCountMap() {
            return valueToCountMap;
        }

        public void setValueToCountMap(TreeMap<Integer, Integer> valueToCountMap) {
            this.valueToCountMap = valueToCountMap;
        }

        public Map<Character, Integer> getSuitsToCountMap() {
            return suitsToCountMap;
        }

        public void setSuitsToCountMap(Map<Character, Integer> suitsToCountMap) {
            this.suitsToCountMap = suitsToCountMap;
        }

        public RankValue getRankValue() {
            return rankValue;
        }

        public void setRankValue(RankValue rankValue) {
            this.rankValue = rankValue;
        }

        public int getRankHighestValue() {
            return rankHighestValue;
        }

        public void setRankHighestValue(int rankHighestValue) {
            this.rankHighestValue = rankHighestValue;
        }
    }

    private int getCardValue (char valC)
    {
        if(valC == 'J')
            return  11;
        if(valC == 'Q')
            return 12;
        if(valC == 'K')
            return 13;
        if(valC == 'T')
            return 10;
        if(valC == 'A')
            return 14;
        else
            return Integer.parseInt(valC+"");
    }
}

enum RankValue  {
    RoyalFlush(10),
    StraightFlush (9),
    FourOfKind(8),
    FullHouse(7),
    Flush(6),
    Straight(5),
    ThreeOfKind(4),
    TwoPairs(3),
    OnePair(2),
    HighCard(1)
    ;

    int rankValue;
    RankValue(int rankValue)
    {
        this.rankValue = rankValue;
    }
    public int getRankValue()
    {
        return this.rankValue;
    }
};

