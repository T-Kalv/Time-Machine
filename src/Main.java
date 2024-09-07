// Program: Main.java
// author: T-Kalv
// email:
// student number:

/*
A Time Machine Java program that opens a website from the past using the Wayback Machine where the user enters the website URL, date and time
*/
//
// Time Machine CLI Program
//
////////////////////////////////////////////////////////////////////////////////////////////////////////
// Libraries
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;
import java.util.Scanner;

////////////////////////////////////////////////////////////////////////////////////////////////////////
//Code
public class Main {
    public static void main(String[] args) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            Scanner myObj = new Scanner(System.in);
            try {
                String welcome = "\n" +
                        "\n" +
                        " __          __  _                            _______      _______ _                  __  __            _     _            _ \n" +
                        " \\ \\        / / | |                          |__   __|    |__   __(_)                |  \\/  |          | |   (_)          | |\n" +
                        "  \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___     | | ___      | |   _ _ __ ___   ___  | \\  / | __ _  ___| |__  _ _ __   ___| |\n" +
                        "   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\    | |/ _ \\     | |  | | '_ ` _ \\ / _ \\ | |\\/| |/ _` |/ __| '_ \\| | '_ \\ / _ \\ |\n" +
                        "    \\  /\\  /  __/ | (_| (_) | | | | | |  __/    | | (_) |    | |  | | | | | | |  __/ | |  | | (_| | (__| | | | | | | |  __/_|\n" +
                        "     \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|    |_|\\___/     |_|  |_|_| |_| |_|\\___| |_|  |_|\\__,_|\\___|_| |_|_|_| |_|\\___(_)\n" +
                        "                                                                                                                             \n" +
                        "                                                                                                                             \n" +
                        "\n";
                System.out.println(welcome);
                System.out.print("Enter Website URL: ");
                String websiteURL = myObj.nextLine();
                System.out.print("Enter Date (YYYYMMDD): ");
                int date = Integer.parseInt(myObj.nextLine());
                System.out.print("Enter Time (hhmmss): ");
                int time = Integer.parseInt(myObj.nextLine());
                URI url = new URI("https://web.archive.org/web/" + date + time + "/" + websiteURL);
                desktop.browse(url);
            } catch (URISyntaxException e) {
                System.out.println("Invalid URL Format!");
            } catch (IOException e) {
                System.out.println("No Internet Connection!");
            } finally {
                myObj.close();
            }
        } else {
            System.out.println("Current Desktop Platform Not Supported!");
        }
    }
}
