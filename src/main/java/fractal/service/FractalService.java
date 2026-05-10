package fractal.service;


import fractal.config.Line;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class FractalService {

    public List<Line> generateTree(double x, double y, double angle, double length, int depth, double angleStep, double reduction) {
        List<Line> lines = new ArrayList<>();
        if (depth == 0) return lines;

        double x2 = x + (Math.cos(Math.toRadians(angle)) * length);
        double y2 = y + (Math.sin(Math.toRadians(angle)) * length);

        double width = depth * 0.8;

        lines.add(new Line(x, y, x2, y2, width));

        // Используем переданные параметры вместо жестко прописанных 25 и 0.75
        lines.addAll(generateTree(x2, y2, angle - angleStep, length * reduction, depth - 1, angleStep, reduction));
        lines.addAll(generateTree(x2, y2, angle + angleStep, length * reduction, depth - 1, angleStep, reduction));

        return lines;
    }
}
