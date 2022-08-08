package com.codeup.springblog.Controllers;

import com.codeup.springblog.Models.Post;
import com.codeup.springblog.Repositories.PostRepository;
import com.codeup.springblog.Repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private PostRepository postsDao;
    private UserRepository usersDao;

    public PostController(PostRepository postsDao, UserRepository usersDao){
        this.postsDao = postsDao;
        this.usersDao = usersDao;

    }

    @GetMapping("/posts")
    public String all(Model model) {

        model.addAttribute("posts", postsDao.findAll());
        model.addAttribute("users",usersDao.findAll());

        return "posts/index";
    }


    @GetMapping("/posts/{id}")

    public String post(@PathVariable long id, Model model) {

        Post p = postsDao.getById(id);
        model.addAttribute("post", p);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String creatForm() {
        return "posts/create";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        postsDao.save(new Post(title,body,usersDao.getById(1L)));


        return "redirect:/posts";
    }

}
