package version1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creazione degli oggetti
        Buffer buffer = new Buffer();
        Clipboard clipboard = new Clipboard();
        IHM ihm = new IHM(buffer, clipboard);

        // Aggiunta di testo iniziale nel buffer
        System.out.println("Enter some text into the buffer:");
        String initialText = scanner.nextLine();
        buffer.ajouterTexte(initialText);
        buffer.afficher();

        while (true) {
            System.out.println("\nAvailable commands: select, copy, cut, paste, add, exit");
            System.out.print("Enter a command: ");
            String comando = scanner.nextLine();

            switch (comando.toLowerCase()) {
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
                    ihm.gererSelection(debut, fin);
                    System.out.println("Selected text: " + buffer.copier());
                    break;

                case "copy":
                    Command copyCommand = new CopyCommand(ihm);
                    copyCommand.execute();
                    System.out.println("Text copied to clipboard: " + clipboard.obtenirContenu());
                    break;

                case "cut":
                    Command cutCommand = new CutCommand(ihm);
                    cutCommand.execute();
                    System.out.println("Text cut and copied to clipboard: " + clipboard.obtenirContenu());
                    buffer.afficher();
                    break;

                case "paste":
                    Command pasteCommand = new PasteCommand(ihm);
                    if(clipboard.obtenirContenu() != "")
                    {
                        System.out.print("Where do you want to paste the text? (Position): ");
                        int pos = scanner.nextInt();
                        scanner.nextLine(); // Consuma il carattere di nuova riga
                        ihm.gererSelection(pos, pos);
                        pasteCommand.execute();
                        buffer.afficher();
                        break;
                    }else
                    {
                        System.out.print("Clipboard is empty! ");
                        break;
                    }

                case "add":
                    System.out.print("Enter the text to add: ");
                    String nuovoTesto = scanner.nextLine();
                    buffer.ajouterTexte(nuovoTesto);
                    buffer.afficher();
                    break;

                case "exit":
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
