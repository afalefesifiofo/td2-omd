package version2;

import java.util.Scanner;
import version2.CommandHistory;

public class IHM {
    private Buffer buffer;
    private Clipboard clipboard;
    private CommandHistory history;
    private ReplayCommand replayCommand;

    public IHM() {
        this.buffer = new Buffer();
        this.clipboard = new Clipboard();
        this.history = new CommandHistory();
        this.replayCommand = new ReplayCommand();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        boolean isRecording = false;
    
        System.out.println("Enter some text into the buffer:");
        String initialText = scanner.nextLine();
        buffer.ajouterTexte(initialText);
        buffer.afficher();
        while (running) {
            // Aggiunta di testo iniziale nel buffer
       
            System.out.println("Enter a command: (select, copy, cut, paste, add, undo, redo, record, replay, exit)");
            String command = scanner.nextLine();
    
            switch (command) {
                case "select":
                    System.out.print("Enter the starting position of the selection: ");
                    int debut = scanner.nextInt();
                    System.out.print("Enter the ending position of the selection: ");
                    int fin = scanner.nextInt();
                    scanner.nextLine(); // Consuma il carattere di nuova riga
                    if(debut > fin) {
                        System.out.print("Start is greather than end! ");
                        scanner.nextLine(); 
                        break;
                    }
                    buffer.selectionner(debut, fin);
                    System.out.println("Selected text: " + buffer.copier());
                    break;
                case "copy":
                    Command copy = new CopyCommand(buffer, clipboard);
                    history.executeCommand(copy);
                    if (isRecording) replayCommand.record(copy);
                    break;
                case "cut":
                    Command cut = new CutCommand(buffer, clipboard);
                    cut.execute();
                    history.executeCommand(cut);
                    if (isRecording) replayCommand.record(cut);
                    break;
                case "paste":
                    Command paste = new PasteCommand(buffer, clipboard);
                    if(clipboard.obtenirContenu() != "")
                    {
                        System.out.print("Where do you want to paste the text? (Position): ");
                        int pos = scanner.nextInt();
                        scanner.nextLine(); // Consuma il carattere di nuova riga
                        buffer.selectionner(pos, pos);
                        paste.execute();
                        buffer.afficher();
                        history.executeCommand(paste);
                        if (isRecording) replayCommand.record(paste);
                        break;
                    }else
                    {
                        System.out.print("Clipboard is empty! ");
                        break;
                    }
                case "undo":
                    history.undo();
                    buffer.afficher();
                    break;
                case "redo":
                    history.redo();
                    buffer.afficher();
                    break;
                case "record":
                    isRecording = true; // Inizia a registrare
                    System.out.println("Recording actions...");
                    break;
                case "replay":
                    System.out.println("Replaying actions...");
                    replayCommand.replay();
                    break;
                case "exit":
                    running = false;
                    break;
                case "add":
                    System.out.print("Enter the text to add: ");
                    String nuovoTesto = scanner.nextLine();
                    buffer.ajouterTexte(nuovoTesto);
                    buffer.afficher();
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
    
        }
    
        scanner.close();
    }
    
}
