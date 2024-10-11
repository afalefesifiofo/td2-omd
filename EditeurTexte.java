package td2_omd;public class EditeurTexte {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Clipboard pressePapier = new Clipboard();
        IHM ihm = new IHM(buffer, pressePapier);

        // Le programme démarre avec la possibilité d'ajouter du texte ou d'utiliser les autres fonctions
        ihm.demarrer();
    }
}
