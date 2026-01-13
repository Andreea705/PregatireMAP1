package org.example.service;

import org.example.model.Fahrer;
import org.example.model.FahrerStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FahrerService {


        public List<Fahrer> filterByTeamAndStatus(List<Fahrer> fahrer, String team) {
            List<Fahrer> filteredList = new ArrayList<>();

            for (Fahrer f : fahrer) {

                if (f.getTeam().equals(team) && f.getStatus() == FahrerStatus.ACTIV) {
                    filteredList.add(f);
                }
            }
            return filteredList;
        }

    public List<Fahrer> sortFahrer(List<Fahrer> fahrer) {
        return fahrer.stream()
                // 1. Sortiere nach Skill Level absteigend (höchster zuerst)
                .sorted(Comparator.comparingInt(Fahrer::getSkillLevel).reversed()
                        // 2. Bei gleichem Skill: Sortiere nach Name aufsteigend (A-Z)
                        .thenComparing(Fahrer::getName))
                .collect(Collectors.toList());
    }

}
