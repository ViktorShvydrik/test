package com.example.client;

import com.example.client.bean.Category;
import com.example.client.bean.Vote;
import com.example.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class WebControllers {

    @Autowired
    ClientService service;

    @RequestMapping("/")
    public ModelAndView startApp(@ModelAttribute("vote") Vote vote) {
        return reloadModel();
    }

    @RequestMapping("/view/{link}")
    public ModelAndView view(@ModelAttribute("vote") Vote vote, @PathVariable("link") String link) {
        vote = service.get(link);
        return new ModelAndView("view", "browse", vote);
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute("vote") Vote vote, HttpServletRequest request) {
        String[] namesCategory = request.getParameterValues("categogyName");
        vote = service.add(vote, namesCategory);
        return "redirect:";

    }

    @RequestMapping("/{id}")
    public ModelAndView get(@ModelAttribute("vote") Vote vote, @PathVariable("id") int id) {
        vote = service.get(id);
        return new ModelAndView("view","browse", vote);
    }


    @RequestMapping("/vote/{link}")
    public ModelAndView view( @PathVariable("link") String link) {
       Vote vote = service.get(link);
        return new ModelAndView("view", "polling", vote);
    }

    @RequestMapping("/vote/{link}/{id}")
    public String vote(@ModelAttribute("vote") Vote vote, @PathVariable("link") String link,
                             @PathVariable("id") int id) {
        service.vote(id);
        vote = service.get(link);
        return "redirect:/view/"+link;
    }

    @RequestMapping("/status/{id}")
    public ModelAndView changeStatus (@ModelAttribute("vote") Vote vote, @PathVariable("id") int id) {
        service.changeStatus(id);
        return reloadModel();
    }

    private ModelAndView reloadModel() {
        List<Vote> list = service.getAll();
        ModelAndView model = new ModelAndView("index", "listVotes", list);
        return model;
    }


}
