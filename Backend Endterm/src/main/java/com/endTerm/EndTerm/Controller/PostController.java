package com.endTerm.EndTerm.Controller;


import com.endTerm.EndTerm.model.Post;
import com.endTerm.EndTerm.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String getUserPost(Model model, HttpSession session) {


        List<Post> posts=postService.getAllPosts();
        model.addAttribute("posts",posts);
        return "posts";
    }

    @RequestMapping(method= RequestMethod.GET,value="/posts/newpost")
    public String newPost(){
        return "posts/create";
    }

    @RequestMapping(method = RequestMethod.POST, value="/posts/create")
    public String createNewPost(Post newPost, HttpSession session){

        postService.createPost(newPost);
        return "redirect:/";
    }

    @RequestMapping(method=RequestMethod.DELETE,value = "/deletePost")
    public String deletePost(@RequestParam(name="postId") Integer postId){
        postService.deletePost(postId);
        return "redirect:/";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/editpost")
    public String editPost(@RequestParam(value = "postId") Integer postId, Model model) {
        Post post = postService.getPost(postId);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/editpost")
    public String editPostSubmit(@RequestParam(value = "postId") Integer postId, Post updatedPost, HttpSession session) {
        updatedPost.setId(postId);
        postService.updatePost(updatedPost);
        return "redirect:/";
    }
}



