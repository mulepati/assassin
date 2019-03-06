import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AssassinManager {
    private LinkedList<Assassin> list = new LinkedList<>();
    private static final List<String> weapons = Arrays.asList("Candlestick", "Revolver", "Knife", "Lead Pipe", "Rope", "Wrench");
    private StringBuilder deathRecap = new StringBuilder();

    public AssassinManager(String filePath) throws FileNotFoundException {
        Scanner input = new Scanner(new File(filePath));

        while (input.hasNextLine()) {
            String line = input.nextLine();
            Scanner lineScan = new Scanner(line);
            String name = lineScan.next().replace(",", "");
            int skillLevel = lineScan.nextInt();
            Assassin temp = new Assassin(name, skillLevel);
            Node<Assassin> player = new Node<>(temp);
            list.add(player);
        }
    }

    public void start() {
        Node<Assassin> current = list.getFirst();
        while(list.getFirst().next != null) {
            Node<Assassin> victim = getNextVictim();
            if(list.getParent(victim) == null) {
                Node<Assassin> killer = list.getLastNode();
                kill(killer, victim);
            } else {
                Node<Assassin> killer = list.getParent(victim);
                kill(killer, victim);
            }
        }

        System.out.println("The Winner is " + list.getFirst().data.getName() + "!");
        System.out.println("Death recap: " + deathRecap);

    }

    private void kill(Node<Assassin> killer, Node<Assassin> victim) {
        Random rand = new Random();
        int random = rand.nextInt(weapons.size());
        System.out.println(killer.data.getName() + " Killed " + victim.data.getName() + " with the " + weapons.get(random) + "!");
        deathRecap.append(killer.data.getName() + " Killed " + victim.data.getName() + "  ");
        list.remove(victim);
    }
    private Node<Assassin> getNextVictim() {
        Node<Assassin> victim = new Node<>();
        int diff = Integer.MIN_VALUE;
        Node<Assassin> current = list.getFirst();
        Node<Assassin> previous = null;
        while(current != null){
            if(previous == null) {
                int difference = list.getLastNode().data.getSkillLevel() - current.data.getSkillLevel();
                if(difference > diff) {
                    diff = difference;
                    victim = current;
                }

            } else {
                int difference = previous.data.getSkillLevel() - current.data.getSkillLevel();
                if(difference == diff) {
                    Random rand = new Random();
                    boolean coinFlip = rand.nextBoolean();
                    if(coinFlip) {
                        diff = difference;
                        victim = current;
                    }
                }else if(difference > diff) {
                    diff = difference;
                    victim = current;
                }


            }
            previous = current;
            current = current.next;
        }
        return victim;
    }

    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append("Kill Ring: ");
        Node<Assassin> current = list.getFirst();
        while(current.next != null){
            print.append(current.data + " > ");
            current = current.next;
        }
        print.append(current.data);
        return print.toString();
    }

}