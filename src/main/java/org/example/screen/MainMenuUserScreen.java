package org.example.screen;

import org.example.service.UserService;
import org.example.service.ScreenService;
import org.example.utils.StringConstants;
import org.example.utils.TerminalHelper;

public class MainMenuUserScreen implements Screen {

    protected final ScreenService screenService;
    protected final UserService userService;

    public MainMenuUserScreen(ScreenService screenService, UserService userService) {
        this.screenService = screenService;
        this.userService = userService;
    }

    @Override
    public void enter() {
    }

    @Override
    public void update() {
        System.out.println(StringConstants.MAIN_MENU_USER_SCREEN);
        int index = TerminalHelper.readInt(4, false);
        switch (index) {
            case 1 -> screenService.changeScreen(TrainingListScreen.class);
            case 2 -> System.out.println(StringConstants.NOT_IMPLEMENTED_ERROR);
            case 3 -> System.out.println(StringConstants.NOT_IMPLEMENTED_ERROR);
            case 4 -> {
                userService.logout();
                screenService.changeScreen(AuthorizationScreen.class);
            }
        }
    }

    @Override
    public void exit() {
    }
}