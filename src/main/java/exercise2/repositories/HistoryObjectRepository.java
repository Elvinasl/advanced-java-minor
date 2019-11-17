package exercise2.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Profile("good")
public class HistoryObjectRepository implements HistoryRepository {

    private Map<String, Double> history = new HashMap<>();

    public Map<String, Double> storeCalculation(String solution, double answer) {
        this.history.put(solution, answer);
        return history;
    }

    public  Map<String, Double> getCalcHistory() {
        return history;
    }

    public double getAnswerBySolution(String solution) {
        return history.get(solution);
    }
}
