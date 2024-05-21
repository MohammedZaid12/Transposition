package org.example;

import java.util.List;

public class Transposition {
    public static List<int[]> transposeNotes(List<int[]> notes, int semitone) throws Exception {
        final int TOTAL_NOTES = 12;
        final int[][] NOTE_RANGE = {{-3, 10}, {5, 1}};
        final int MIN_NOTE = (NOTE_RANGE[0][0] * TOTAL_NOTES) + NOTE_RANGE[0][1];
        final int MAX_NOTE = (NOTE_RANGE[1][0] * TOTAL_NOTES) + NOTE_RANGE[1][1];

        for (int[] note : notes) {
            int octave = note[0];
            int noteNumber = note[1];
            int resultingNote = (octave * TOTAL_NOTES) + noteNumber + semitone;

            if (resultingNote < MIN_NOTE || resultingNote > MAX_NOTE) {
                throw new Exception("Resulting notes falls out of the keyboard range");
            }

            note[0] = resultingNote / TOTAL_NOTES; // next octave
            note[1] = resultingNote % TOTAL_NOTES; // next note
        }

        return notes;
    }
}
