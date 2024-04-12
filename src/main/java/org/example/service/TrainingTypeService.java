package org.example.service;

import org.example.TrainingTypeStorage;

import java.util.HashMap;
import java.util.Map;

public class TrainingTypeService {

    private final Map<String, TrainingTypeStorage> userTrainingTypes;

    public TrainingTypeService(Map<String, TrainingTypeStorage> userTrainingTypes) {
        this.userTrainingTypes = userTrainingTypes;
    }

    public Map<Integer, String> getTrainingsTypes(String userLogin) {
        if (userTrainingTypes.containsKey(userLogin)) {
            return userTrainingTypes.get(userLogin).getTrainingTypes();
        }

        return new HashMap<>();
    }

    public Map<Integer, String> createNewTrainingType(String userLogin, String type) {
        TrainingTypeStorage userTrainingTypeStorage;
        if (userTrainingTypes.containsKey(userLogin)) {
            userTrainingTypeStorage = userTrainingTypes.get(userLogin);
            userTrainingTypeStorage.put(type);
        } else {
            userTrainingTypeStorage = new TrainingTypeStorage();
            userTrainingTypeStorage.put(type);
            userTrainingTypes.put(userLogin, userTrainingTypeStorage);
        }

        return userTrainingTypeStorage.getTrainingTypes();
    }
}
