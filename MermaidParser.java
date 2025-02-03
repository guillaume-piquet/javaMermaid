import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MermaidParser {

    // Pattern pour analyser une ligne de diagramme de séquence
    // Exemple attendu : "Alice -> Bob : Hello"
    private static final Pattern LINE_PATTERN = Pattern.compile("^\\s*(\\w+)\\s*->\\s*(\\w+)\\s*:\\s*(.+)$");

    /**
     * Parse le contenu source d'un diagramme Mermaid (très simplifié).
     *
     * @param source Le texte du diagramme.
     * @return Un objet Diagram représentant le diagramme.
     * @throws Exception Si le format est invalide.
     */
    public static Diagram parse(String source) throws Exception {
        Diagram diagram = new Diagram();

        // Séparer le contenu en lignes (compatible Windows et Unix)
        String[] lines = source.split("\\r?\\n");

        if (lines.length < 2) {
            throw new Exception("Le contenu est trop court pour être un diagramme.");
        }

        // Vérifier que le diagramme commence bien par @startsequence et se termine par @endsequence
        if (!lines[0].trim().equalsIgnoreCase("@startsequence")) {
            throw new Exception("Le diagramme doit commencer par '@startsequence'.");
        }
        if (!lines[lines.length - 1].trim().equalsIgnoreCase("@endsequence")) {
            throw new Exception("Le diagramme doit se terminer par '@endsequence'.");
        }

        // Parcourir les lignes entre le début et la fin
        for (int i = 1; i < lines.length - 1; i++) {
            String line = lines[i].trim();
            if (line.isEmpty()) {
                continue; // ignorer les lignes vides
            }

            Matcher matcher = LINE_PATTERN.matcher(line);
            if (matcher.matches()) {
                String participantFrom = matcher.group(1);
                String participantTo = matcher.group(2);
                String message = matcher.group(3);
                SequenceLine sequenceLine = new SequenceLine(participantFrom, participantTo, message);
                diagram.addLine(sequenceLine);
            } else {
                throw new Exception("Ligne invalide au numéro " + (i + 1) + " : " + line);
            }
        }

        return diagram;
    }
}
