package ryanyoshimura.restfulblog;
import data.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {
    @GetMapping
    private ArrayList<Post> fetchAll() {
        // TODO: 9/7/22
        //arraylist of posts\
        ArrayList<Post> blogPosts = new ArrayList<>();
        blogPosts.add(new Post(1L,"cooking","Today, I am going to show y'all how to cook turkey, using chicken"));
        blogPosts.add(new Post(2L,"weather",        "How about that sky toady? Talk about blue"));
        blogPosts.add(new Post(3L,"sup","Up dog everyone....."));
        //return array lists of posts
        return blogPosts;
    }

    @GetMapping("{id}")
    public Post getById(@PathVariable Long id){
        return new Post(1L,"cooking","Today, I am going to show y'all how to cook turkey, using chicken");
    }
}



