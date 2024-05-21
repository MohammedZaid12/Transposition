package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.List;

import static org.example.Transposition.transposeNotes;

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java -jar task.jar <inputFile> <semitone> <outputFile>");
            System.exit(1);
        }

        String inputFile = args[0];
        int semitone;
        try {
            semitone = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Semitone must be a valid integer.");
            System.exit(1);
            return;
        }
        String outputFile = args[2];

        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(inputFile);
            Type listType = new TypeToken<List<int[]>>() {}.getType();
            List<int[]> notes = gson.fromJson(reader, listType);
            reader.close();

            List<int[]> transposedNotes = transposeNotes(notes, semitone);

            FileWriter writer = new FileWriter(outputFile);
            gson.toJson(transposedNotes, writer);
            writer.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}