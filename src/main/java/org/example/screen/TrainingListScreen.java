package org.example.screen;

import org.example.User;
import org.example.service.UserService;
import org.example.service.ScreenService;
import org.example.service.TrainingTypeService;
import org.example.utils.StringConstants;
import org.example.utils.TerminalHelper;

import java.util.Map;
import java.util.stream.Collectors;

public class TrainingListScreen implements Screen {

    private final ScreenService screenService;
    private final TrainingTypeService trainingTypeService;
    private final UserService userService;

    public TrainingListScreen(ScreenService screenService, TrainingTypeService trainingTypeService, UserService userService) {
        this.screenService = screenService;
        this.trainingTypeService = trainingTypeService;
        this.userService = userService;
    }

    @Override
    public void enter() {
    }

    @Override
    public void update() {
        User currentUser = userService.getCurrentUser();
        Map<Integer, String> trainingsTypes = trainingTypeService.getTrainingsTypes(currentUser.getLogin());

        String mapAsString = trainingsTypes.keySet().stream()
                .map(key -> key + "=" + trainingsTypes.get(key))
                .collect(Collectors.joining(") ", "", "\n"));
        String text = StringConstants.TRAINING_LIST_SCREEN.formatted(mapAsString);
        System.out.println(text);

        int value = TerminalHelper.readInt(1, true);

        switch (value) {
            case -1 -> screenService.changeScreen(MainMenuUserScreen.class);
            case 1 -> {
                System.out.println(StringConstants.TRAINING_TYPE_NAME);
                String name = TerminalHelper.readString();
                trainingTypeService.createNewTrainingType(currentUser.getLogin(), name);
            }
        }
    }

    @Override
    public void exit() {
    }
}
