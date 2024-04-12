package org.example.screen;

import org.example.service.UserService;
import org.example.service.ScreenService;
import org.example.utils.StringConstants;

public class MainMenuAdminScreen extends MainMenuUserScreen {


    public MainMenuAdminScreen(ScreenService screenService, UserService userService) {
        super(screenService, userService);
    }

    @Override
    public void enter() {
        System.out.println(StringConstants.MAIN_MENU_ADMIN_SCREEN);
    }

    @Override
    public void exit() {
    }

}
