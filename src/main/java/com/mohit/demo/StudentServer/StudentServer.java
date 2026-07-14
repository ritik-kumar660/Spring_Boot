package StudentServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServer {
    //make methods for crud operations


    //1. to store the data
    @PostMapping("/create")
    public String storeStudent(){

        System.out.println("hello from storestudent");

        return """
                name:Ritik
                Dep : CSE
                Age : 20
           
               """;
    }
}
