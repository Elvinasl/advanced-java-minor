package exercise2.repositories;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface HistoryRepository {

    Map<String, Double> storeCalculation(String solution, double answer);
    Map<String, Double> getCalcHistory();
    double getAnswerBySolution(String solution);
}
