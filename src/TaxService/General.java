package TaxService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class General {
    static HashMap<Human, ArrayList<Penalty>> penaltyHashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        addNewPerson(penaltyHashMap);
        showBase(penaltyHashMap);
        showById(penaltyHashMap, 1);
        showByType(penaltyHashMap, TypePenalty.AUTO_TAX);
        addNewPenalty(penaltyHashMap);
        showBase(penaltyHashMap);
        removePenalty(penaltyHashMap);
        showBase(penaltyHashMap);
    }

    static void showBase(HashMap<Human, ArrayList<Penalty>> map) {
        for (Map.Entry<Human, ArrayList<Penalty>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    static void showById(HashMap<Human, ArrayList<Penalty>> map, int id) {
        for (Map.Entry<Human, ArrayList<Penalty>> entry : map.entrySet()) {
            if (entry.getKey().getId() == id) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    static void showByType(HashMap<Human, ArrayList<Penalty>> map, TypePenalty typePenalty) {
        for (Map.Entry<Human, ArrayList<Penalty>> entry : map.entrySet()) {
            for (Penalty penalty : entry.getValue()) {
                if (penalty.getTypePenalty().equals(typePenalty)) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
            }
        }
    }

    static void addNewPerson(HashMap<Human, ArrayList<Penalty>> map) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter name:");
        String name = reader.readLine();
        System.out.println("Enter type of penalty: Auto/Home/Another");
        String typePenalty = reader.readLine();
        TypePenalty penalty;
        if (typePenalty.equalsIgnoreCase("Auto")) {
            penalty = TypePenalty.AUTO_TAX;
        } else if (typePenalty.equalsIgnoreCase("Home")) {
            penalty = TypePenalty.HOME_TAX;
        } else {
            penalty = TypePenalty.ANOTHER_TAXES;
        }
        System.out.println("Enter city:");
        String city = reader.readLine();
        ArrayList<Penalty> penalties = new ArrayList<>();
        penalties.add(new Penalty(penalty, city));
        map.put(new Human(map.size() + 1, name), penalties);
    }

    static void addNewPenalty(HashMap<Human, ArrayList<Penalty>> map) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter id:");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Enter type of penalty: Auto/Home/Another");
        String typePenalty = reader.readLine();
        TypePenalty penalty;
        if (typePenalty.equalsIgnoreCase("Auto")) {
            penalty = TypePenalty.AUTO_TAX;
        } else if (typePenalty.equalsIgnoreCase("Home")) {
            penalty = TypePenalty.HOME_TAX;
        } else {
            penalty = TypePenalty.ANOTHER_TAXES;
        }
        System.out.println("Enter city:");
        String city = reader.readLine();
        for (Map.Entry<Human, ArrayList<Penalty>> entry : map.entrySet()) {
            if (entry.getKey().getId() == id) {
                entry.getValue().add(new Penalty(penalty, city));
            }
        }
    }

    static void removePenalty(HashMap<Human, ArrayList<Penalty>> map) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter id:");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Enter type of penalty to remove: Auto/Home/Another");
        String typePenalty = reader.readLine();
        TypePenalty penalty;
        if (typePenalty.equalsIgnoreCase("Auto")) {
            penalty = TypePenalty.AUTO_TAX;
        } else if (typePenalty.equalsIgnoreCase("Home")) {
            penalty = TypePenalty.HOME_TAX;
        } else {
            penalty = TypePenalty.ANOTHER_TAXES;
        }
        for (Map.Entry<Human, ArrayList<Penalty>> entry : map.entrySet()) {
            if (entry.getKey().getId() == id) {
                Iterator<Penalty> iterator = entry.getValue().iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().getTypePenalty().equals(penalty)) {
                        iterator.remove();
                    }
                }
            }
        }
    }
}
