package com.codeup.springblog.Controllers;

import com.codeup.springblog.Models.EmailService;
import com.codeup.springblog.Models.Post;
import com.codeup.springblog.Models.User;
import com.codeup.springblog.Repositories.PostRepository;
import com.codeup.springblog.Repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private PostRepository postsDao;
    private UserRepository usersDao;

    private EmailService emailService;

    public PostController(PostRepository postsDao, UserRepository usersDao, EmailService emailService){
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.emailService = emailService;

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
    public String creatForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    public String createPost(@ModelAttribute Post post) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);

        postsDao.save(post);
        emailService.prepareAndSend(post,"You just created a post","hello user, you just created a post!");



        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(Model model, @PathVariable long id){
        model.addAttribute("post", postsDao.findById(id));
        return "/posts/create";
    }

}
