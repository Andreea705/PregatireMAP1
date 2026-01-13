package org.example.controller;


import org.example.model.RennenErignis;
import org.example.model.Fahrer;
import org.example.model.Strafe;
import org.example.model.StrafeGrund;
import org.example.repository.FileRepository;
import org.example.service.FahrerService;
import org.example.view.FahrerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FahrerController {
    private FileRepository repo;
    private FahrerView view;
    private FahrerService service;

    public FahrerController() {
        this.repo = new FileRepository();
        this.view = new FahrerView();
        this.service = new FahrerService();
    }

    public void start() throws IOException {
        try {
            List<Fahrer> fahrer = repo.loadFahrer("drivers.json");
            List<RennenErignis> events = repo.loadEvents("events.json");
            List<Strafe> strafen = repo.loadStrafen("penalties.json");

            //view.printTask1Results(fahrer, events.size(), strafen.size());

           // String  inputTeam = view.requestTeamInput();

            // 2. Logik aufrufen (Filtern)

           //List<Fahrer> filteredFahrer = service.filterByTeamAndStatus(fahrer, inputTeam);

            // 3. Ergebnis ausgeben (Format ist gleich wie bei Aufgabe 1) [cite: 79]
             //view.printFahrerList(filteredFahrer);


            List<Fahrer> sortedFahrer = service.sortFahrer(fahrer);

            System.out.println("Sortierte Fahrer:");
            view.printFahrerList(sortedFahrer);

            List<String> linesToWrite = new ArrayList<>();
            for (Fahrer f : sortedFahrer) {
                linesToWrite.add(f.toString()); // Nutzt das Format aus Aufgabe 1
            }

            // 2. In Datei schreiben
            repo.saveToFile("drivers_sorted.txt", linesToWrite);
            System.out.println("Datei 'drivers_sorted.txt' wurde erfolgreich erstellt.");


        } catch (Exception e) {
            System.err.println("Fehler beim Lesen der Dateien: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
