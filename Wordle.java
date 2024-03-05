import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Wordle
{
    public static String solution = randomWord();
    
    public static boolean onlyRealWords = true;
    
    public static void main(String[] args)
    {
        while(true)
        {
            Scanner input = new Scanner(System.in);
            
            run();
        }
    }
    
    public static void run()
    {
        System.out.println(solution);
        
        Scanner input = new Scanner(System.in);
        
        if(isReal(solution) == false && onlyRealWords == true)
        {
            System.out.println("Solution is not a real word");
            System.exit(1);
        }
        
        System.out.println("-WORDLE-");
        
        //5 letter word

        String[] guessArr = {"","","","","",""};
        
        int guessNum = 0;
        
        while(guessNum <= 5 && solution.length() == 5)
        {
            System.out.print(" ");
            guessArr[guessNum] = input.nextLine();
            
            if(guessArr[guessNum].length() == 5)
            {
                if(isReal(guessArr[guessNum]) == true || onlyRealWords == false)
                {
                    check(guessArr[guessNum]);
                    guessNum = guessNum + 1;
                }
                else if(onlyRealWords == true)
                {
                    System.out.println("This is not a real word");
                }
            }
            else if(guessArr[guessNum].equalsIgnoreCase("stop")) //extra commands
                System.exit(1);
            else
                System.out.println("not 5 letters");
        }
        System.out.println("You lose. The word was " + solution);
        playAgain();
    }
    
    public static void check(String origGuess)
    {
        String guess = origGuess.toUpperCase();
        String[] color = {"","","","",""};
        boolean[] isGreen = {false,false,false,false,false};
        
        //letter 1
        if(guess.charAt(0) == solution.charAt(0))
        {
            color[0] = "🟩";
            isGreen[0] = true;
        }
        
        //letter 2
        if(guess.charAt(1) == solution.charAt(1))
        {
            color[1] = "🟩";
            isGreen[1] = true;
        }
        
        
        //letter 3
        if(guess.charAt(2) == solution.charAt(2))
        {
            color[2] = "🟩";
            isGreen[2] = true;
        }
        
        
        //letter 4
        if(guess.charAt(3) == solution.charAt(3))
        {
            color[3] = "🟩";
            isGreen[3] = true;
        }
        
        
        //letter 5
        if(guess.charAt(4) == solution.charAt(4))
        {
            color[4] = "🟩";
            isGreen[4] = true;
        }
        
        //letter 1 yellow/grey
        if((guess.charAt(0) == solution.charAt(1) ||
            guess.charAt(0) == solution.charAt(2) ||
            guess.charAt(0) == solution.charAt(3) ||
            guess.charAt(0) == solution.charAt(4)) &&
            isGreen[0] == false && 
            !((guess.charAt(0) == guess.charAt(1) && isGreen[1] == true) ||
            (guess.charAt(0) == guess.charAt(2) && isGreen[2] == true) ||
            (guess.charAt(0) == guess.charAt(3) && isGreen[3] == true) ||
            (guess.charAt(0) == guess.charAt(4) && isGreen[4] == true)))
        {
            color[0] = "🟨";
        }
        else if(isGreen[0] == false)
        {
            color[0] = "⬜";
        }
        
        //letter 2 yellow/grey
        if((guess.charAt(1) == solution.charAt(0) ||
            guess.charAt(1) == solution.charAt(2) ||
            guess.charAt(1) == solution.charAt(3) ||
            guess.charAt(1) == solution.charAt(4)) &&
            isGreen[1] == false && 
            !((guess.charAt(1) == guess.charAt(0) && isGreen[0] == true) ||
            (guess.charAt(1) == guess.charAt(2) && isGreen[2] == true) ||
            (guess.charAt(1) == guess.charAt(3) && isGreen[3] == true) ||
            (guess.charAt(1) == guess.charAt(4) && isGreen[4] == true)))
        {
            color[1] = "🟨";
        }
        else if(isGreen[1] == false)
        {
            color[1] = "⬜";
        }
        
        //letter 3 yellow/grey
        if((guess.charAt(2) == solution.charAt(0) ||
            guess.charAt(2) == solution.charAt(1) ||
            guess.charAt(2) == solution.charAt(3) ||
            guess.charAt(2) == solution.charAt(4)) &&
            isGreen[2] == false && 
            !((guess.charAt(2) == guess.charAt(0) && isGreen[0] == true) ||
            (guess.charAt(2) == guess.charAt(1) && isGreen[1] == true) ||
            (guess.charAt(2) == guess.charAt(3) && isGreen[3] == true) ||
            (guess.charAt(2) == guess.charAt(4) && isGreen[4] == true)))
        {
            color[2] = "🟨";
        }
        else if(isGreen[2] == false)
        {
            color[2] = "⬜";
        }
        
        //letter 4 yellow/grey
        if((guess.charAt(3) == solution.charAt(0) ||
            guess.charAt(3) == solution.charAt(1) ||
            guess.charAt(3) == solution.charAt(2) ||
            guess.charAt(3) == solution.charAt(4)) && //is yellow
            isGreen[3] == false && 
            !((guess.charAt(3) == guess.charAt(0) && isGreen[0] == true) ||
            (guess.charAt(3) == guess.charAt(1) && isGreen[1] == true) ||
            (guess.charAt(3) == guess.charAt(2) && isGreen[2] == true) ||
            (guess.charAt(3) == guess.charAt(4) && isGreen[4] == true)))
        {
            color[3] = "🟨";
        }
        else if(isGreen[3] == false)
        {
            color[3] = "⬜";
        }
        
        //letter 5 yellow/grey
        if((guess.charAt(4) == solution.charAt(0) ||
            guess.charAt(4) == solution.charAt(1) ||
            guess.charAt(4) == solution.charAt(2) ||
            guess.charAt(4) == solution.charAt(3)) &&
            isGreen[4] == false && 
            !((guess.charAt(4) == guess.charAt(0) && isGreen[0] == true) ||
            (guess.charAt(4) == guess.charAt(1) && isGreen[1] == true) ||
            (guess.charAt(4) == guess.charAt(2) && isGreen[2] == true) ||
            (guess.charAt(4) == guess.charAt(3) && isGreen[3] == true)))
        {
            color[4] = "🟨";
        }
        else if(isGreen[4] == false)
        {
            color[4] = "⬜";
        }
        
        System.out.print("⬛");
        System.out.print(color[0]);
        System.out.print(color[1]);
        System.out.print(color[2]);
        System.out.print(color[3]);
        System.out.print(color[4]);
        System.out.println("⬛");
        
        if(isGreen[0] == true &&
            isGreen[1] == true &&
            isGreen[2] == true && 
            isGreen[3] == true && 
            isGreen[4] == true)
        {
            System.out.println("You Win!!!");
            playAgain();
        }
    }
    public static boolean isReal(String wordToFind)
    {
        boolean isRealWord = false;
        
        List<String> wordList = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader("words.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split by whitespace
                wordList.addAll(Arrays.asList(words));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Convert ArrayList to array if needed
        String[] wordArray = wordList.toArray(new String[0]);
        
        isRealWord = false;
        for(String word : wordArray)
        {
            if(word.equalsIgnoreCase(wordToFind))
            {
                isRealWord = true;
            }
        }
        
        return isRealWord;
    }
    
    public static String randomWord()
    {
        Random rand = new Random();
        
        String fileName = "words.txt";
        List<String> wordList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split each line by space and add resulting words to the list
                String[] words = line.split(" ");
                for (String word : words) {
                    wordList.add(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert list to array
        String[] wordsArray = wordList.toArray(new String[0]);
        
        
        
        return wordsArray[rand.nextInt(wordsArray.length)];
    }
    public static void playAgain()
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Would you like to keep playing? (yes/no)");
        String keepPlaying = input.nextLine();
        if(keepPlaying.equalsIgnoreCase("yes"))
        {
            solution = randomWord();
            run();
        }
        else
            System.out.print("Thanks for playing!");
            System.exit(1);
    }
}
