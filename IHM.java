package td2_omd;
import java.util.Scanner;
import java.util.Scanner;

public class IHM {
    private Buffer buffer;
    private Clipboard pressePapier;
    private Scanner scanner;

    public IHM(Buffer buffer, Clipboard pressePapier) {
        this.buffer = buffer;
        this.pressePapier = pressePapier;
        this.scanner = new Scanner(System.in);
    }

    // Afficher le texte
    public void afficherTexte() {
        System.out.println("Texte actuel: " + buffer.getText());
    }

    // Gérer la sélection du texte
    public void gererSelection() {
        System.out.print("Entrer début de la sélection: ");
        int debut = scanner.nextInt();
        System.out.print("Entrer fin de la sélection: ");
        int fin = scanner.nextInt();
        buffer.selectionner(debut, fin);
        System.out.println("Texte sélectionné: " + buffer.copier());
    }

    // Copier le texte sélectionné dans le presse-papier
    public void copier() {
        String texte = buffer.copier();
        pressePapier.copier(texte);
        System.out.println("Texte copié: " + texte);
    }

    // Couper le texte sélectionné et le mettre dans le presse-papier
    public void couper() {
        String texte = buffer.couper();
        pressePapier.copier(texte);
        System.out.println("Texte coupé: " + texte);
    }

    // Coller le texte du presse-papier dans le buffer
    public void coller() {
        String texte = pressePapier.obtenirContenu();
        buffer.coller(texte);
        System.out.println("Texte collé: " + texte);
    }

    // Nouvelle méthode pour écrire du texte dans le buffer
    public void ecrireTexte() {
        System.out.print("Entrer le texte à ajouter : ");
        String texte = scanner.nextLine();
        buffer.ajouterTexte(texte);
        System.out.println("Texte ajouté.");
    }

    // Méthode pour démarrer le menu
    public void demarrer() {
        while (true) {
            System.out.println("\nCommandes: ");
            System.out.println("1. Afficher texte");
            System.out.println("2. Sélectionner texte");
            System.out.println("3. Copier");
            System.out.println("4. Couper");
            System.out.println("5. Coller");
            System.out.println("6. Écrire du texte");
            System.out.println("7. Quitter");

            System.out.print("Choisissez une commande: ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme le retour à la ligne

            switch (choix) {
                case 1:
                    afficherTexte();
                    break;
                case 2:
                    gererSelection();
                    break;
                case 3:
                    copier();
                    break;
                case 4:
                    couper();
                    break;
                case 5:
                    coller();
                    break;
                case 6:
                    ecrireTexte();
                    break;
                case 7:
                    System.out.println("Fin de l'éditeur.");
                    return;
                default:
                    System.out.println("Commande invalide.");
            }
        }
    }
}
