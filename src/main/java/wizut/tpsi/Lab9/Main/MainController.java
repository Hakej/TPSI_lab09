package wizut.tpsi.Lab9.Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wizut.tpsi.Lab9.BlogPost;
import wizut.tpsi.Lab9.BlogRepository;

import java.sql.SQLException;
import java.util.List;

@Controller
public class MainController
{

    @Autowired
    private BlogRepository blogRepository;


    @RequestMapping("/")
    public String home(Model model) throws SQLException
    {
        List<BlogPost> posts;

        posts = blogRepository.getAllPosts();

        model.addAttribute("posts", posts);
        return "index";
    }

    @PostMapping("/newpost")
    public String newPost(BlogPost post) throws SQLException
    {
        blogRepository.createPost(post);
        return "redirect:/";
    }

    @RequestMapping(value = {"/deletepost"}, method = RequestMethod.POST)
    public String deletePost(Long id) throws SQLException
    {
        blogRepository.createDelete(id);
        return "redirect:/";
    }
}
