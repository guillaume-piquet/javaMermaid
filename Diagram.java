import java.util.ArrayList;
import java.util.List;

public class Diagram {
    private List<SequenceLine> lines;

    public Diagram() {
        this.lines = new ArrayList<>();
    }

    public void addLine(SequenceLine line) {
        this.lines.add(line);
    }

    public List<SequenceLine> getLines() {
        return lines;
    }
}
