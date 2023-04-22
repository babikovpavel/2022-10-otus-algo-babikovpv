package dev.lochness;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

//tested on nicknames from https://www.kaggle.com/datasets/pavelbiz/4-228-398-unique-nicknames-of-minecraft-players
public class Bloom {

    public static void main(String[] args) throws IOException, CsvValidationException {
        String[] contains = {"hellkiller94", "i_felix", "i_fck_first_date", "i_dont_care_man", "i_do_the_boogie",
                "bobbyplay", "111112007", "1111116", "temagamer", "vitorcosta27",
                "vitoria_conciani", "auguste77", "augustplays", "mlg_happyface", "mlg_killer_omg",
                "mlg_minecrafter", "mlg_llama", "mlg_penguin2005", "therealpewdiepie", "_pewdiepie_"};
        String[] doesNotContain = {"000_Dilly Dally_000", "000_Boomhauer_000", "000_Amethyst_000", "000_Fiesta_000",
                "000_First Mate_000", "000_Pork Chop_000", "000_Cello_000", "000_Rumplestiltskin_000",
                "000_Frodo_000", "000_Buster_000", "000_Babe_000", "000_C-Dawg_000", "000_Gummi Bear_000",
                "000_Beetle_000", "000_Cheese_000", "000_Skinny Jeans_000", "000_Schnookums_000",
                "000_Bunny_000", "000_Toots_000", "000_Dino_000", "000_Belle_000", "000_Fattykins_000",
                "000_Big Bird_000", "000_Mini Me_000", "000_Rubber_000", "000_Amorcita_000", "000_Bub_000",
                "000_Diet Coke_000", "000_Headlights_000", "000_Bebe_000", "000_Silly Sally_000", "000_Tyke_000",
                "000_Raindrop_000", "000_Dulce_000", "000_Daffodil_000", "000_Pansy_000", "000_Mr. Clean_000",
                "000_Doobie_000", "000_Bandit_000", "000_Cricket_000", "000_Ticklebutt_000", "000_Stud_000",
                "000_Scarlet_000", "000_Spud_000", "000_Peppa Pig_000", "000_Gizmo_000", "000_Taco_000",
                "000_Fun Size_000", "000_Belch_000", "000_Cheerio_000", "000_Dum Dum_000", "000_Flyby_000",
                "000_Bubba_000", "000_Birdy_000", "000_Thumper_000", "000_Diesel_000", "000_Psycho_000",
                "000_Fifi_000", "000_Bruiser_000", "000_Gams_000", "000_Shrinkwrap_000", "000_Pinkie_000",
                "000_Goblin_000", "000_Cuddles_000", "000_Lefty_000", "000_Doctor_000", "000_Mini Skirt_000",
                "000_Moose_000", "000_Sunshine_000", "000_Twiggy_000", "000_Azkaban_000", "000_Bellbottoms_000",
                "000_Frankfurter_000", "000_Big Mac_000", "000_Skinny Minny_000", "000_Snuggles_000",
                "000_Dragon_000", "000_Marge_000", "000_Carrot_000", "000_Rocketfuel_000", "000_Mouse_000",
                "000_Muscles_000", "000_Kirby_000", "000_Queenie_000", "000_Papito_000", "000_Loser_000",
                "000_Tata_000", "000_Chum_000", "000_Mimi_000", "000_Homer_000", "000_Dragonfly_000",
                "000_Bossy_000", "000_Frau Frau_000", "000_Butterfinger_000", "000_Highbeam_000",
                "000_Red Velvet_000", "000_Happy_000", "000_Rufio_000", "000_Con_000", "000_Chuckles_000"};
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset()),
                4195490, 0.01);
        try (CSVReader csvReader = new CSVReader(new FileReader("c:/tmp/nicknames.csv"))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                bloomFilter.put(values[0]);
            }
        }
        int hits = 0;
        int misses = 0;
        for (String s : contains) {
            if (bloomFilter.mightContain(s)) {
                hits++;
            } else {
                System.out.printf("Source doesn't contains %s. It's incorrect!%n", s);
                misses++;
            }
        }
        System.out.printf("Got correct %d out of %d for contained items%n", hits, misses);

        hits = 0;
        misses = 0;
        for (String s : doesNotContain) {
            if (bloomFilter.mightContain(s)) {
                System.out.printf("Source contains %s. It's incorrect!%n", s);
                misses++;
            } else {
                hits++;
            }
        }
        System.out.printf("Got %d false positive hits out of %d items. It's %d percents of misses!%n", hits, misses,
                misses);
    }
}
