
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FractalService {

    public List<Line> generateTree(double x, double y, double angle, double length, int depth) {
        List<Line> lines = new ArrayList<>();
        if (depth == 0) return lines;

        // Вычисляем конец ветки
        double x2 = x + (Math.cos(Math.toRadians(angle)) * length);
        double y2 = y + (Math.sin(Math.toRadians(angle)) * length);

        lines.add(new Line(x, y, x2, y2));

        // Рекурсия: левая и правая ветки
        lines.addAll(generateTree(x2, y2, angle - 25, length * 0.75, depth - 1));
        lines.addAll(generateTree(x2, y2, angle + 25, length * 0.75, depth - 1));

        return lines;
    }
}
