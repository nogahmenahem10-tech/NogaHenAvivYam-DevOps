package bullhit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

    private String secret;
    private List<String> history;
    private boolean won;

    public Game() {
        history = new ArrayList<>();
        won = false;
        generateSecret();
    }

    private void generateSecret() {
        List<Character> letters = new ArrayList<>();

        for (char c = 'A'; c <= 'H'; c++) {
            letters.add(c);
        }

        Collections.shuffle(letters);

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            builder.append(letters.get(i));
        }

        secret = builder.toString();
    }

    public boolean isValidGuess(String guess) {
        if (guess == null || guess.length() != 4) {
            return false;
        }

        Set<Character> usedLetters = new HashSet<>();

        for (char c : guess.toCharArray()) {
            if (c < 'A' || c > 'H' || usedLetters.contains(c)) {
                return false;
            }

            usedLetters.add(c);
        }

        return true;
    }

    public synchronized String checkGuess(String guess) {
        if (guess == null) {
            return "Invalid guess. Use 4 different letters from A to H.";
        }

        guess = guess.toUpperCase();

        if (!isValidGuess(guess)) {
            return "Invalid guess. Use 4 different letters from A to H.";
        }

        if (won) {
            return "You already won. Start a new game to play again.";
        }

        int bulls = 0;
        int hits = 0;

        for (int i = 0; i < 4; i++) {
            char currentLetter = guess.charAt(i);

            if (currentLetter == secret.charAt(i)) {
                bulls++;
            } else if (secret.indexOf(currentLetter) >= 0) {
                hits++;
            }
        }

        String result = "Bulls: " + bulls + " | Hits: " + hits;

        if (bulls == 4) {
            result += " - You won!";
            won = true;
        }

        history.add(guess + " - " + result);

        return result;
    }

    public synchronized List<String> getHistory() {
        return new ArrayList<>(history);
    }
	
}
