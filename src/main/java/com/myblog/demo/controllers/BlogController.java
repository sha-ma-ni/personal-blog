package com.myblog.demo.controllers;

import com.myblog.demo.models.Post;
import com.myblog.demo.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;


@Controller
public class BlogController {

    //передача записей в шаблон
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain (Model model) {
        //здесь содержаться вся значения из таблицы базы данных
        //находим
        Iterable<Post> posts = postRepository.findAll();
        //отражаем
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add") //при переходе по URL вызывается шаблон blog-add
    public String blogAdd(Model model) {

        return "blog-add";
    }

    // Postmapping потому что мы полуаем данные из формы post
    @PostMapping ("/blog/add")
    //чтобы получать введенные в форму данные @RequestParam. title - из blog-add первой строки input
    public String blogPostAdd (@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
    //создаем обьект на основе модели Post
        Post post = new Post (title, anons, full_text); // --> нужно создать конструктор
        // сохраняем обьект в бд
        postRepository.save(post);
        //переадрессация на страницу со статьями
        return "redirect:/blog";
    }

    //
    @GetMapping("/blog/{id}") //
    public String blogDetails (@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)){
            return "redirect:/blog";
        }
        //находим запись по id
        Optional <Post>  post = postRepository.findById(id);
        //переводим option в класс arraylist
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        //передача в шаблон
        model.addAttribute("post", res);
        return "blog-details";
    }

    @GetMapping("/blog/{id}/edit") //
    public String blogEdit (@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)){
            return "redirect:/blog";
        }
        //находим запись по id
        Optional <Post>  post = postRepository.findById(id);
        //переводим option в класс arraylist
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        //передача в шаблон
        model.addAttribute("post", res);
        return "blog-edit";
    }
}
