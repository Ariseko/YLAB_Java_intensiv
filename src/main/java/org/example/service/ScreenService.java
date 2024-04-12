package org.example.service;

import org.example.screen.AuthorizationScreen;
import org.example.screen.Screen;

import java.util.Map;

public class ScreenService {

    private Screen currentScreen;
    private Screen nextScreen;
    private Map<Class, Screen> screens;

    public void init(Map<Class, Screen> screens){
        this.screens = screens;
        currentScreen = screens.get(AuthorizationScreen.class);
    }

    public void update(){
        currentScreen.update();
        if(nextScreen != null){
            changeScreen();
        }
    }

    public void changeScreen(Class screen){

        if(!screens.containsKey(screen)){
            throw new RuntimeException("Scree" + screen.getName() + "not found");
        }

        nextScreen = screens.get(screen);
    }

    private void changeScreen(){

        if(currentScreen == null){
            currentScreen = nextScreen;
            currentScreen.enter();
            return;
        }

        currentScreen.exit();
        currentScreen = nextScreen;
        currentScreen.enter();

    }
}
