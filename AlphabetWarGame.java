public class AlphabetWarGame {

    // Default strengths for left and right letters
    private int wStrength = 4, pStrength = 3, bStrength = 2, sStrength = 1;
    private int mStrength = 4, qStrength = 3, dStrength = 2, zStrength = 1;

    // Default constructor (sets default strengths)
    public AlphabetWarGame() {
    }

    // Constructor for customizing the strengths
    public AlphabetWarGame(int w, int p, int b, int s, int m, int q, int d, int z) {
        this.wStrength = w;
        this.pStrength = p;
        this.bStrength = b;
        this.sStrength = s;
        this.mStrength = m;
        this.qStrength = q;
        this.dStrength = d;
        this.zStrength = z;
    }

    // Method to calculate strength of a single word
    public String alphabetWar(String word) {
        int leftSideScore = 0;
        int rightSideScore = 0;

        // Calculate scores based on each letter's strength
        for (char ch : word.toCharArray()) {
            switch (ch) {
                case 'w': leftSideScore += wStrength; break;
                case 'p': leftSideScore += pStrength; break;
                case 'b': leftSideScore += bStrength; break;
                case 's': leftSideScore += sStrength; break;
                case 'm': rightSideScore += mStrength; break;
                case 'q': rightSideScore += qStrength; break;
                case 'd': rightSideScore += dStrength; break;
                case 'z': rightSideScore += zStrength; break;
            }
        }

        return declareWinner(leftSideScore, rightSideScore);
    }

    // Method to calculate strength for two separate words
    public String alphabetWar(String leftWord, String rightWord) {
        int leftSideScore = 0;
        int rightSideScore = 0;

        // Calculate left side score
        for (char ch : leftWord.toCharArray()) {
            switch (ch) {
                case 'w': leftSideScore += wStrength; break;
                case 'p': leftSideScore += pStrength; break;
                case 'b': leftSideScore += bStrength; break;
                case 's': leftSideScore += sStrength; break;
            }
        }

        // Calculate right side score
        for (char ch : rightWord.toCharArray()) {
            switch (ch) {
                case 'm': rightSideScore += mStrength; break;
                case 'q': rightSideScore += qStrength; break;
                case 'd': rightSideScore += dStrength; break;
                case 'z': rightSideScore += zStrength; break;
            }
        }

        return declareWinner(leftSideScore, rightSideScore);
    }

    // Helper method to declare the winner
    private String declareWinner(int leftSideScore, int rightSideScore) {
        if (leftSideScore > rightSideScore) {
            return "Left side wins!";
        } else if (rightSideScore > leftSideScore) {
            return "Right side wins!";
        } else {
            return "Let's fight again!";
        }
    }

    // Main method for testing the game
    public static void main(String[] args) {
        AlphabetWarGame game1 = new AlphabetWarGame();

        // Test cases
        System.out.println(game1.alphabetWar("z")); // Right side wins!
        System.out.println(game1.alphabetWar("zdqmwpbs")); // Let's fight again!
        System.out.println(game1.alphabetWar("wwwwwwz")); // Left side wins!
        
        // Custom strengths
        AlphabetWarGame game2 = new AlphabetWarGame(5, 3, 2, 1, 6, 3, 2, 1);
        System.out.println(game2.alphabetWar("wmq")); // Right side wins!

        // Using method that accepts separate left and right words
        System.out.println(game1.alphabetWar("wp", "mdq")); // Left side wins!
    }
}
