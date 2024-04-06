package BaiLam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Model {
    private List<String> lines;

    public Model() {
        lines = new ArrayList<>();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public void removeLine(int index) {
        lines.remove(index);
    }

    public Stream<String> getLinesStream() {
        return lines.stream();
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public List<String> getLines() {
        return lines;
    }
}

