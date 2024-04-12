package org.example;

import org.example.screen.*;
import org.example.service.ScreenService;
import org.example.service.TrainingService;
import org.example.service.TrainingTypeService;
import org.example.service.UserService;

import java.util.HashMap;
import java.util.Map;


public class Bootstrap {
    private final UserService userService;
    private final TrainingService trainingService;
    private final ScreenService screenService;
    private final TrainingTypeService trainingTypeService;

    public ScreenService getScreenService() {
        return screenService;
    }


    public Bootstrap() {
        userService = new UserService(createUsers());
        trainingService = new TrainingService();
        trainingTypeService = new TrainingTypeService(crateUserTrainingTypes());

        screenService = new ScreenService();
        Map<Class, Screen> screens = createScreens(screenService, userService, trainingTypeService);
        screenService.init(screens);
    }

    private Map<String, User> createUsers() {
        Map<String, User> users = new HashMap<>();
        User user = new User("user", "user");
        User admin = new User("admin", "admin", true);
        users.put(user.getLogin(), user);
        users.put(admin.getLogin(), admin);
        return users;
    }

    private Map<String, TrainingTypeStorage> crateUserTrainingTypes() {
        Map<String, TrainingTypeStorage> trainingTypes = new HashMap<>();

        TrainingTypeStorage user = new TrainingTypeStorage();
        user.put("Бегит");
        user.put("Атжумания");

        TrainingTypeStorage admin = new TrainingTypeStorage();
        admin.put("Плават");
        admin.put("Спат");

        trainingTypes.put("user", user);
        trainingTypes.put("admin", admin);

        return trainingTypes;
    }

    private Map<Class, Screen> createScreens(ScreenService screenService, UserService userService, TrainingTypeService trainingTypeService) {
        Map<Class, Screen> screens = new HashMap<>();
        Screen authorizationScreen = new AuthorizationScreen(screenService, userService);
        Screen mainMenuAdminScreen = new MainMenuAdminScreen(screenService, userService);
        Screen mainMenuUserScreen = new MainMenuUserScreen(screenService, userService);
        Screen trainingListScreen = new TrainingListScreen(screenService, trainingTypeService, userService);
        screens.put(AuthorizationScreen.class, authorizationScreen);
        screens.put(MainMenuAdminScreen.class, mainMenuAdminScreen);
        screens.put(MainMenuUserScreen.class, mainMenuUserScreen);
        screens.put(TrainingListScreen.class, trainingListScreen);
        return screens;
    }
}
