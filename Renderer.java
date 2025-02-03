import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Renderer {
    public void render(Diagram diagram, String outputFilePath) {
        // Dimensions arbitraires pour l'exemple
        int width = 800;
        int height = 600;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Fond blanc
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // Exemple de dessin pour chaque ligne du diagramme
        int y = 50;
        for (SequenceLine line : diagram.getLines()) {
            // Dessiner une flèche simple entre deux points fixes (à adapter selon le layout réel)
            int x1 = 100;
            int x2 = 400;
            g2d.setColor(Color.BLACK);
            g2d.drawLine(x1, y, x2, y);
            // Dessiner le message au milieu
            g2d.drawString(line.getMessage(), (x1 + x2) / 2, y - 5);
            y += 50;
        }

        g2d.dispose();

        try {
            ImageIO.write(image, "png", new File(outputFilePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
