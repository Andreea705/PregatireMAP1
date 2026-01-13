package org.example.repository;

import org.example.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileRepository {

    public List<Fahrer> loadFahrer(String filename) throws IOException {
        String content = Files.readString(Path.of(filename));
        List<Fahrer> list = new ArrayList<>();

        Matcher m = Pattern.compile("\\{([^}]*)\\}").matcher(content);
        while (m.find()) {
            String obj = m.group(1);
            int id = Integer.parseInt(extractValue(obj, "id"));
            String name = extractString(obj, "name");
            String team = extractString(obj, "team");
            String statusStr = extractString(obj, "status");
            int skill = Integer.parseInt(extractValue(obj, "skillLevel"));

            FahrerStatus status = statusStr.equals("ACTIVE") ? FahrerStatus.ACTIV : FahrerStatus.DNF;
            list.add(new Fahrer(id, name, team, status, skill));
        }
        return list;
    }

    public List<RennenErignis> loadEvents(String filename) throws IOException {
        String content = Files.readString(Path.of(filename));
        List<RennenErignis> list = new ArrayList<>();
        Matcher m = Pattern.compile("\\{([^}]*)\\}").matcher(content);
        while (m.find()) {
            String obj = m.group(1);
            int id = Integer.parseInt(extractValue(obj, "id"));
            int fId = Integer.parseInt(extractValue(obj, "fahrerId"));
            String typeStr = extractString(obj, "typ");
            int basePoints = Integer.parseInt(extractValue(obj, "basePoints"));
            int lap = Integer.parseInt(extractValue(obj, "lap"));

            list.add(new RennenErignis(id, fId, EreignisTyp.valueOf(typeStr), basePoints, lap));
        }
        return list;
    }

    public List<Strafe> loadStrafen(String filename) throws IOException {
        String content = Files.readString(Path.of(filename));
        List<Strafe> list = new ArrayList<>();
        Matcher m = Pattern.compile("\\{([^}]*)\\}").matcher(content);
        while (m.find()) {
            String obj = m.group(1);
            int id = Integer.parseInt(extractValue(obj, "id"));
            int fId = Integer.parseInt(extractValue(obj, "fahrerId"));
            String grund = extractString(obj, "grund");
            int seconds = Integer.parseInt(extractValue(obj, "seconds"));
            int lap = Integer.parseInt(extractValue(obj, "lap"));

            list.add(new Strafe(id, fId, StrafeGrund.valueOf(grund), seconds, lap));
        }
        return list;
    }

    public void saveToFile(String filename, List<String> lines) throws IOException {
        // Schreibt die Liste 'lines' in die Datei.
        // CREATE: Erstellt Datei, falls nicht vorhanden.
        // TRUNCATE_EXISTING: Überschreibt den Inhalt, falls Datei schon existiert.
        Files.write(Path.of(filename), lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    private String extractValue(String src, String key) {
        Matcher m = Pattern.compile("\"" + key + "\":\\s*(-?\\d+)").matcher(src);
        if (m.find()) return m.group(1);
        return "0";
    }
    private String extractString(String src, String key) {
        Matcher m = Pattern.compile("\"" + key + "\":\\s*\"([^\"]+)\"").matcher(src);
        if (m.find()) return m.group(1);
        return "";
    }
}
