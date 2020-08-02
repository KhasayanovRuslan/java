import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerExample {

    @Autowired
    private BeanDAO BeanDAO;

    @RequestMapping(value = "/example", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("example", BeanDAO.getText());
        return "example";
    }

}
