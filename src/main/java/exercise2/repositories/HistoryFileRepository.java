package exercise2.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Profile("wrong")
public class HistoryFileRepository implements HistoryRepository {

    public Map<String, Double> storeCalculation(String solution, double answer) {
        return null;
    }

    public Map<String, Double> getCalcHistory() {
        return null;
    }

    public double getAnswerBySolution(String solution) {
        return 0;
    }
}
