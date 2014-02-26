package upm.miw.solitaire.views.client;

import upm.jbb.IO;
import upm.miw.solitaire.controllers.client.LoginResourceClient;
import upm.miw.solitaire.models.entities.Gender;
import upm.miw.solitaire.models.entities.User;

public class Main {
    LoginResourceClient lrc = new LoginResourceClient();

    public void login() {
        Object[] c = {"", ""};
        String[] s = {"nick", "password"};
        Object[] v = IO.in.readForm(c, s);
        String nick = (String) v[0];
        String password = (String) v[1];
        IO.out.setStatusBar(lrc.login(nick, password).toString());
    }

    public void register() {
        Object[] c = {"", "", "", "", 0, Gender.MALE, ""};
        String[] s = {"nick", "password", "firstName", "lastName", "age", "gender", "country"};
        Object[] v = IO.in.readForm(c, s);
        User usr = new User((String) v[0], (String) v[1], (String) v[2], (String) v[3], (int) v[4],
                (Gender) v[5], (String) v[6]);
        boolean result = lrc.register(usr);
        if (result)
            IO.out.setStatusBar("Registro correcto");
        else
            IO.out.setStatusBar("Nick ocupado");

    }

    public static void main(String[] args) {
        IO.in.addController(new Main());
    }

}
