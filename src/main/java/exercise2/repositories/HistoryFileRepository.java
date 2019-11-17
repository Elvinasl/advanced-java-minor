package exercise2.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
@Profile("good")
public class HistoryFileRepository implements HistoryRepository {

    private Map<String, Double> history;
    private final String filepath = "src/main/resources/history.log";


    public HistoryFileRepository() {
        getCalcHistory();
    }

    public Map<String, Double> storeCalculation(String solution, double answer) {
        try {
            FileWriter writer = new FileWriter(filepath, true);
            writer.write(solution + "=" + answer);
            writer.write(System.getProperty("line.separator"));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return history;
    }

    public Map<String, Double> getCalcHistory() {
        try {
            history = getLines()
                    .map(line -> line.split("="))
                    .collect(Collectors.toMap(e -> e[0], e -> Double.valueOf(e[1])));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return history;
    }

    public double getAnswerBySolution(String solution) {
        return 0;
    }

    private Stream<String> getLines() throws IOException {
        return Files.lines(Paths.get(filepath));
    }
}
