package org.example.screen;

import org.example.User;
import org.example.service.UserService;
import org.example.service.ScreenService;
import org.example.utils.StringConstants;
import org.example.utils.TerminalHelper;

public class AuthorizationScreen implements Screen {

    private final ScreenService screenService;
    private final UserService userService;

    public AuthorizationScreen(ScreenService screenService, UserService userService) {
        this.screenService = screenService;
        this.userService = userService;
    }

    @Override
    public void enter() {
    }

    @Override
    public void update() {
        System.out.println(StringConstants.AUTHORIZATION_SCREEN);
        //todo избавиться от магических чисел
        int value = TerminalHelper.readInt(2, false);
        System.out.println(StringConstants.INPUT_USER_FORMAT);
        User user = TerminalHelper.readUser();

        switch (value) {
            case 1 -> userService.register(user);
            case 2 -> userService.login(user);
        }

        if (userService.getCurrentUser() != null) {
            if (userService.currentUserIsAdmin()) {
                screenService.changeScreen(MainMenuAdminScreen.class);
            } else {
                screenService.changeScreen(MainMenuUserScreen.class);
            }
        }
    }

    @Override
    public void exit() {
    }
}
