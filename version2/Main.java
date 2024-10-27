package version2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Creazione degli oggetti necessari
        Buffer buffer = new Buffer();
        Clipboard clipboard = new Clipboard();
        CommandHistory commandHistory = new CommandHistory();
        IHM ihm = new IHM(buffer, clipboard, commandHistory);
        boolean recording= false;
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Enter some text into the buffer:");
        String initialText = scanner.nextLine();
        buffer.ajouterTexte(initialText);
        buffer.afficher();
        ReplayCommand replay = new ReplayCommand();
        // Ciclo principale per gestire i comandi dell'utente
        while (!exit) {
            System.out.println("Enter a command: (select, copy, cut, paste, add, undo, redo, record, replay, exit)");
            String command = scanner.nextLine();

            switch (command) {
                case "select":
                    System.out.print("Enter start position: ");
                    int debut = scanner.nextInt();
                    System.out.print("Enter end position: ");
                    int fin = scanner.nextInt();
                    scanner.nextLine();  // Consumare il newline rimanente
                    buffer.selectionner(debut, fin);
                    break;

                case "copy":
                    Command copyCommand = new CopyCommand(buffer, clipboard);
                    commandHistory.executeCommand(copyCommand);
                    System.out.println("Text copied to clipboard.");
                    break;

                case "cut":
                    Command cutCommand = new CutCommand(buffer, clipboard);
                    commandHistory.executeCommand(cutCommand);
                    System.out.println("Text cut and copied to clipboard.");
                    break;

                case "paste":
                    Command pasteCommand = new PasteCommand(buffer, clipboard);
                    commandHistory.executeCommand(pasteCommand);
                    if(recording) {
                        replay.record(pasteCommand);
                    }
                    break;

                case "add":
                    System.out.print("Enter text to add: ");
                    String textToAdd = scanner.nextLine();
                    buffer.ajouterTexte(textToAdd);
                    System.out.println("Text added to buffer.");
                    break;

                case "undo":
                    commandHistory.undo();
                    System.out.println("Undo performed.");
                    break;

                case "redo":
                    commandHistory.redo();
                    System.out.println("Redo performed.");
                    break;

                case "exit":
                    exit = true;
                    System.out.println("Exiting program.");
                    break;

                case "record":
                    recording = true;
                    System.out.println("Next paste commands will be recorded, until replay");
                    break;

                case "replay":
                    replay.replay();
                    recording = false;
                    break;

                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }

            // Visualizzare il contenuto del buffer dopo ogni comando
            System.out.println("Current buffer text: ");
            buffer.afficher();
            System.out.println();
            
        }

        scanner.close();
    }
}
