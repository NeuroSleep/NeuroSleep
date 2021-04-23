package com.neurosleep;

import java.util.ArrayList;
import java.util.Random;

public class Mapping {
    public Mapping() {

    }
    ArrayList<String> str = new ArrayList<String>();
    public String getAlphaTips(){
        Random rand = new Random(); //instance of random class
        //generate random values from 0-24
        int random = rand.nextInt(8);
        str.add("Learning seems to be high right now: try a book or learn new things for today that you wanted to dive into for a long time. " +
                "Mental focus is at its peak right now: Watch a meaningful documentary today to access more knowledge of the things that fear you. " +
                "Calm and relaxed minds need time to rest: take a power nap for 1 hour, this will boost mental clarity for when you need work done.");
        str.add("You are in a relaxed and calm state. muscles are relaxed now and body has been through a restful state." +
                "Focus might seem to be foggy as you might feel sleepy for waking up to early without stretching.");
        str.add("Give yourself time to heal from past mistakes. Observing without judgement is the highest form of intelligence in this universe. " +
                "Let go of anything blocking your view of an ideal world. This will help you see how important people and society are to the rest of the world.");
        str.add("Life without a path is a life without a purpose, as you are relaxed and calm. Set aside goals and motives for yourself, this helps bring peace within yourself.");
        str.add("ALpha waves can be produced by aerobic exercises. Today you can try: Running 3 miles.");
        str.add("ALpha waves can be produced by aerobic exercises. Today you can try: Biking for 20 mins.");
        str.add("ALpha waves can be produced by aerobic exercises. Today you can try: Walking for 40 mins.");
        str.add("Green Tea in the morning is a must! This will bring all your senses together to uplift you to getting work done on time with no mental strain.");
        return str.get(random);
    }

}