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
                "Jochen Neuhaeuser",
                "Nicolas Herschlag",
                "Fiete Kästner",
                "Yannik Gerstäcker",
                "Nils Mohnhaupt",
                "Fabian Vogt",
                "Hauke Klugman",
                "Jörg Franke",
                "Clemens Katzenbach",
                "Viviana Schreber",
                "Bettina Raab",
                "Natascha Friesinger",
                "Tiana Liebermann",
                "Daria Schoeler",
                "Anna-Lena Krahl",
                "Gabriela Kott",
                "Wilhelmina Schanz",
                "Juliane Schwann",
                "Patricia Schürmann",
                "Gust Dokter",
                "Leendert Boiten",
                "Arnout Jaspers",
                "Eldert Hilbrink",
                "Jan-Joost Brok",
                "Jolijn Herbers",
                "Lotje Kuhleman",
                "Femke Elhorst",
                "Jorieke Albach",
                "Liene Jansen van 't Laar",
                "Dindad Anet",
                "Ugokud Toim",
                "Toasdul Ovan",
                "Ketum Baa",
                "Addul Kisu",
                "Eintan Zavik",
                "Asbas Bredan",
                "Ankud Maanut",
                "Tana Heaco",
                "Mivra Bore",
                "Mude Atruvu",
                "Jeemmeh Igelbrum",
                "Stennow Ividi",
                "Hamade Uchaax",
                "Leveye Nu",
                "Jeastravan Ba",
                "Yirod Lenor",
                "Mobis Billaam",
                "Asa Bianer",
                "Sulaull Lonin",
                "Isel Bers",
                "Neenheh Grisud",
                "Kiadzi Tador",
                "Eleeh Tillux",
                "Maryam Smith",
                "Georgia Hunt",
                "Mollie Hart",
                "Eliana Burns",
                "Annabelle Newman",
                "Honey Matthews",
                "Ella-Rose Armstrong",
                "Oksana Dotsenko",
                "Hanna Tarasenko",
                "Larysa Sirenko",
                "Iryna Chajka",
                "Zhanna Kramarenko",
                "Natalya Kutsenko",
                "Svitlana Bozhko",
                "Maryna Artemivna",
                "Vira Mykolayivna",
                "Stanislava Vsevolodivna"));
    }
}
