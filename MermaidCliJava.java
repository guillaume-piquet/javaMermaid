import java.nio.file.Files;
import java.nio.file.Paths;

public class MermaidCliJava {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java MermaidCliJava <fichier_source.mmd> <fichier_sortie.png>");
            System.exit(1);
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];

        try {
            // Lire le contenu du fichier source Mermaid
            String source = new String(Files.readAllBytes(Paths.get(inputFilePath)));

            // Utiliser le parser pour créer le diagramme
            Diagram diagram = MermaidParser.parse(source);

            // Afficher quelques informations pour vérification
            System.out.println("Diagramme analysé avec succès. Lignes trouvées :");
            for (SequenceLine line : diagram.getLines()) {
                System.out.println("  " + line);
            }

            // Rendre le diagramme en image (ici, un rendu simplifié)
            Renderer renderer = new Renderer();
            renderer.render(diagram, outputFilePath);

            System.out.println("Diagramme généré : " + outputFilePath);
        } catch (Exception e) {
            System.err.println("Erreur lors de la génération du diagramme :");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
