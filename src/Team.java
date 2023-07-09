import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class Team {
    List<Team> teams = new ArrayList<>();
    List<String> firstHalfFixture = new ArrayList<>();

    List<String> secondHalfFixture = new ArrayList<>();
    private String teamName;

    public Team() {

    }

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void createFixture() {
        Random random = new Random();
        int firstHalf = teams.size() * (teams.size() - 1);
        firstHalf /= 2;

        Set<String> tempList = new HashSet<>();

        String home, away;
        int counter = 0;
        int matchNumber = teams.size() / 2;

        while (firstHalfFixture.size() < firstHalf) {

            home = teams.get(random.nextInt(0, teams.size())).getTeamName();
            away = teams.get(random.nextInt(0, teams.size())).getTeamName();

            if (tempList.size() == teams.size()) {
                tempList.clear();
            }

            if (!home.equals(away)) {
                if (!tempList.contains(home) && !tempList.contains(away)
                        && !firstHalfFixture.contains(home + " vs " + away) && !firstHalfFixture.contains(away + " vs " + home)
                ) {
                    firstHalfFixture.add(home + " vs " + away);
                    secondHalfFixture.add(away + " vs " + home);

                    tempList.add(home);
                    tempList.add(away);
                    counter = 0;
                    continue;
                }
            }

            if (tempList.size() == teams.size() - 2) {
                counter++;

                if (counter >= 3) {
                    for (int i = 1; i < matchNumber; i++) {
                        firstHalfFixture.remove(firstHalfFixture.get(firstHalfFixture.size() - 1));
                        secondHalfFixture.remove(secondHalfFixture.get(secondHalfFixture.size() - 1));
                    }
                    tempList.clear();
                }
            }
        }
    }

    public void addTeams() {

        teams.add(new Team("Galatasaray"));
        teams.add(new Team("Bursaspor"));
        teams.add(new Team("Fenerbahçe"));
        teams.add(new Team("Beşiktaş"));
        teams.add(new Team("Başakşehir"));
        teams.add(new Team("Trabzonspor"));
        teams.add(new Team("Boluspor"));

        if (teams.size() % 2 == 1) {
            teams.add(new Team("Bay"));
        }
    }

    public void printFixture() {

        int matchNumber = teams.size() / 2;
        int counter = 1;
        int round = 0;

        for (int i = 0; i < firstHalfFixture.size(); i++) {
            if (i % matchNumber == 0) {
                System.out.println("Round " + (round + 1) + ":");
                round++;
            }

            System.out.println(firstHalfFixture.get(i));

            if (counter == matchNumber) {
                counter = 0;
                System.out.println();
            }
            counter++;
        }

        counter = 1;

        for (int i = 0; i < secondHalfFixture.size(); i++) {
            if (i % matchNumber == 0) {
                System.out.println("Round " + (round + 1) + ":");
                round++;
            }

            System.out.println(secondHalfFixture.get(i));

            if (counter == matchNumber && i + 1 != secondHalfFixture.size()) {
                counter = 0;
                System.out.println();
            }
            counter++;
        }
    }
}
