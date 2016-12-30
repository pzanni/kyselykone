
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.repository.CategoryRepository;
import wad.repository.PollRepository;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    
    @Autowired
    private CategoryRepository categoryRepo;
    
    @RequestMapping(method = RequestMethod.GET)
    public String categories(Model model) {
        model.addAttribute("categories", categoryRepo.findAll());
        return "categories";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String category(Model model, @PathVariable Long id) {
        model.addAttribute("category", categoryRepo.findOne(id));
        model.addAttribute("polls", categoryRepo.findOne(id).getPolls());
        return "category";
    }
}
