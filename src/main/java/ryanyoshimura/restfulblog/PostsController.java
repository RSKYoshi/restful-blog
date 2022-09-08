package ryanyoshimura.restfulblog;
import data.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostsController {
    private ArrayList<Post> posts = new ArrayList<>();

    @GetMapping
    private ArrayList<Post> fetchAll() {
        // TODO: 9/7/22
        //arraylist of posts\
//        blogPosts.add(new Post(1L,"cooking","Today, I am going to show y'all how to cook turkey, using chicken"));
//        blogPosts.add(new Post(2L,"weather",        "How about that sky toady? Talk about blue"));
//        blogPosts.add(new Post(3L,"sup","Up dog everyone....."));
//        return array lists of posts
        return posts;
    }

    @GetMapping("{id}")
    public Post getById(@PathVariable Long id){
//        return new Post(1L,"cooking","Today, I am going to show y'all how to cook turkey, using chicken");
        for(Post post:posts){
            if(Objects.equals(post.getId(), id)){
                return post;
            }
        }
        throw new RuntimeException("error");
    }
    @PostMapping
    private void createPost( @RequestBody Post newPost){
//        System.out.println(newPost);
        posts.add(newPost);
    }
    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post post){
        posts.set(Math.toIntExact(id), post);
    }
    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id){
        //e equals new e
        posts.removeIf(e -> e.getId().equals(id));
    }
}



