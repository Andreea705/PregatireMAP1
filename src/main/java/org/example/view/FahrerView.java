package org.example.view;




import org.example.model.Fahrer;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FahrerView {

    private Scanner scanner = new Scanner(System.in);

    public void printTask1Results(List<Fahrer> fahrer, int eventCount, int strafenCount) {
        System.out.println("Fahrer loaded: " + fahrer.size());
        System.out.println("Events loaded: " + eventCount);
        System.out.println("Strafen loaded: " + strafenCount);

        for (Fahrer f : fahrer) {
            System.out.println(f.toString());
        }
    }


    public String requestTeamInput() {
        System.out.print("Input team: ");

        return scanner.nextLine();
    }

    public void printFahrerList(List<Fahrer> tributes) {
        for (Fahrer t : tributes) {
            System.out.println(t.toString());
        }
    }

}
