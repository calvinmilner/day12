package vttp.ssf.day12.controller;

// import java.io.File;
import java.io.IOException;
// import java.nio.file.Path;
import java.util.*;

// import org.springframework.core.io.Resource;
// import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/generate")
public class LuckyNumberController {
    // private ResourceLoader resourceLoader;
    private Random rand = new Random();

    @GetMapping()
    public String generateLuckyNumber(@RequestParam String name, @RequestParam String count, Model model)
            throws IOException {
        int numCount = 0;
        List<String> numbers = getNumbers();
        List<String> randomNum = new ArrayList<>();
        try {
            numCount = Integer.parseInt(count);
        } catch (Exception ex) {
        }
        for (int i = 0; i < numCount; i++)
            randomNum.add(numbers.get(rand.nextInt(31)));
        model.addAttribute("name", name);
        model.addAttribute("count", numCount);
        model.addAttribute("numbers", randomNum);
        return "generate";
    }

    private List<String> getNumbers() throws IOException {
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < 32; i++)
            numbers.add("/numbers/number" + i + ".jpg");
        // Resource resource = resourceLoader.getResource("classpath:static/numbers");
        // List<String> numbers = new ArrayList<>();
        // File numDir = Path.of(resource.getURI()).toFile();
        // File[] numFiles = numDir.listFiles();
        // for(int i = 0; i < numFiles.length; i++)
        // numbers.add(numFiles[i].getAbsoluteFile().getName());

        return numbers;
    }

    // @GetMapping("list")
    // public String getList(@PathVariable String name,@PathVariable String count, @RequestParam String num, Model model) throws IOException {
        
    //     String[] arrayNum = num.split(",");
    //     List<String> listNum = getNumbers();
    //     List<String> displayList = new ArrayList<>();

    //     for(int i = 0; i < arrayNum.length; i++)
    //         displayList.add(listNum.get(Integer.parseInt(arrayNum[i])));
        
    //     model.addAttribute("name", name);
    //     model.addAttribute("count", count);
    //     model.addAttribute("num", displayList);
    //     return "listnumbers";
    // }
}
