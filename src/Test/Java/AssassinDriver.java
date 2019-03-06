import java.io.FileNotFoundException;

public class AssassinDriver {
    public static void main(String[] args) throws FileNotFoundException {

        AssassinManager newGame = new AssassinManager("inputFile.txt");
        System.out.println(newGame);
        newGame.start();
    }
}
