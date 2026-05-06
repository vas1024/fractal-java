package fractal.controller;


import fractal.service.FractalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FractalController {

    private final FractalService fractalService;

    public FractalController(FractalService fractalService) {
        this.fractalService = fractalService;
    }

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "10") int depth, Model model) {

        var lines = fractalService.generateTree(400, 600, -90, 150, depth);
        model.addAttribute("lines", lines);
        model.addAttribute("currentDepth", depth);
        return "fractal";
    }
}
