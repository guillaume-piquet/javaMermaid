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
            String source = new String(Files.readAllBytes(Paths.get(inputFilePath)));

            // 1. Parser le code Mermaid (en utilisant ANTLR ou autre)
            // Diagram diagram = MermaidParser.parse(source);
            // Ici, MermaidParser est une classe hypothétique que vous implémenterez.

            // Pour l'exemple, créons un diagramme factice
            Diagram diagram = new Diagram();
            diagram.getLines().add(new SequenceLine("Alice", "Bob", "Hello"));
            diagram.getLines().add(new SequenceLine("Bob", "Alice", "Hi"));

            // 2. Rendre le diagramme en image
            Renderer renderer = new Renderer();
            renderer.render(diagram, outputFilePath);

            System.out.println("Diagramme généré : " + outputFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
