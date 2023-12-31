package com.martijndashorst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Conference {
    private List<String> speakers = getSpeakers();

    public List<String> speakers() {
        return new ArrayList<>(speakers);
    }

    public List<String> randomSpeakers(int number) {
        var speakers = speakers();
        Collections.shuffle(speakers);
        return speakers.subList(0, number);
    }

    public boolean delete(String speaker) {
        return speakers.remove(speaker);
    }

    public void update(String oldName, String newName) {
        int index = speakers.indexOf(oldName);
        if (index >= 0) {
            speakers.remove(index);
            speakers.add(index, newName);
        }
    }

    public void reset() {
        speakers = getSpeakers();
    }

    private List<String> getSpeakers() {
        return new ArrayList<>(Arrays.asList(
                "Tom Cools",
                "Roy Wasse",
                "Hanno Embregts",
                "Jakub Marchwicki",
                "Wim Blommaert",
                "Johan Janssen",
                "Maarten Mulders",
                "Simon Martinelli",
                "Ionut Balosin",
                "Bernd Ruecker",
                "Milan Savić",
                "Sharat Chander",
                "Remco Siemonsma",
                "Roobert Noordzij",
                "Sara Pellegrini",
                "Piotr Przybyl",
                "David Stibbe",
                "Ko Turk",
                "Peter Keereweer",
                "Willem Cheizoo",
                "Johannes Bechberger",
                "Ixchel Ruiz",
                "Kevin Dubois",
                "Geertjan Wielenga",
                "David Vlijmincx",
                "Joris Kuipers",
                "Grace Jansen",
                "Ivar Grimstad",
                "Rafael Maia",
                "Ryan Susana",
                "Thom van Kalkeren",
                "Jago de Vreede",
                "Angela Abdoelhafiezkhan",
                "Nataliia Dziubenko",
                "Sam Hepburn",
                "Jamie Coleman",
                "Arthur van Leeuwen",
                "Dick Eimers",
                "Elias Nogueira",
                "Andres Almiray",
                "Jan-Hendrik Kuperus",
                "Maarten Koller",
                "Gerrit Grunwald",
                "Maurice Naftalin",
                "Ronald Dehuysser",
                "Alexander Chatzizacharias",
                "Elien Callens",
                "Kaya Weers",
                "Tim te Beek",
                "Stephan Schroevers",
                "Simone van Erp",
                "Peter Streef",
                "Julian Exenberger",
                "Martijn Dashorst",
                "Lutske De Leeuw",
                "Deepu K Sasidharan",
                "Justin Reock",
                "Sander Mak",
                "Frank Delporte",
                "Bouke Nijhuis",
                "Roy van Rijn",
                "Louëlla Creemers",
                "Lennart ten Wolde",
                "Urs Peter",
                "Irene Blanken",
                "Dmytro Vyazelenko",
                "Rick Ossendrijver",
                "Ana Maria Mihalceanu",
                "Adam Michalik",
                "Jeroen Berndsen",
                "Daniel Garnier-Moiroux",
                "Ricky van Rijn",
                "Han Markslag",
                "Jan Ouwens",
                "Mohammed Aboullaite",
                "Alina Yurenko",
                "Lucas Jellema",
                "Susanne Pieterse"));
    }
}
