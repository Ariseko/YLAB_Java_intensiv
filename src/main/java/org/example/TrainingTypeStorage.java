package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TrainingTypeStorage {
    private Map<Integer, String> trainingTypes;
    private Integer lastIndex;

    public TrainingTypeStorage() {
        this.trainingTypes = new HashMap<>();
        lastIndex = 0;
    }

    public void put(String name){
        lastIndex++;
        trainingTypes.put(lastIndex, name);
    }

    public Map<Integer, String> getTrainingTypes() {
        return Collections.unmodifiableMap(trainingTypes);
    }
}
