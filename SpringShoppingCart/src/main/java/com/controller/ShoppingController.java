package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Item;
import com.repository.ItemRepo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/form1")
public class ShoppingController {
	@Autowired
	private ItemRepo itemrepo;
	
	@GetMapping("/shop1")
    public ModelAndView showShopPage(HttpSession session) {
        ModelAndView mandv = new ModelAndView();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            mandv.setViewName("redirect:/form1/login");
        } else {
        	 	List<Item> items=itemrepo.findByShopId(1);
        	 	mandv.addObject("items", items);
            mandv.setViewName("shop1");
        }
        return mandv;
    }
	
	@PostMapping("/shop1")
    public ModelAndView processPage(@RequestParam MultiValueMap<String, String> allParams,HttpSession session) {
        ModelAndView mandv = new ModelAndView();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            mandv.setViewName("redirect:/form1/login");
        } else {
        	List<Item> items=itemrepo.findByShopId(2);
    	 	mandv.addObject("items", items);
            mandv.setViewName("shop2");
          
            List<Item> accumulatedItems = (List<Item>) session.getAttribute("selectedItems");
            if (accumulatedItems == null) {
                accumulatedItems = new ArrayList<>();
            }
            List<String> currentItemDescs = allParams.get("selectedItems");
            if (currentItemDescs != null) {
                for (String desc : currentItemDescs) {
                    Item item = itemrepo.findByItemDesc(desc);
                    if (item != null) {
                        accumulatedItems.add(item);
                    }
                }
            }

            // Save back to session
            session.setAttribute("selectedItems", accumulatedItems);
        }
        return mandv;
    }
	
	@GetMapping("/shop2")
    public ModelAndView showShopPage2(HttpSession session) {
        ModelAndView mandv = new ModelAndView();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            mandv.setViewName("redirect:/form1/login");
        } else {
        	List<Item> items=itemrepo.findByShopId(2);
    	 	mandv.addObject("items", items);
            mandv.setViewName("shop2");
        }
        return mandv;
    }
	
    @PostMapping("/shop2")
    public ModelAndView processPage2(@RequestParam MultiValueMap<String, String> allParams,HttpSession session) {
        ModelAndView mandv = new ModelAndView();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            mandv.setViewName("redirect:/form1/login");
        } else {
    
        	List<Item> items=itemrepo.findByShopId(3);
    	 	mandv.addObject("items", items);
            mandv.setViewName("shop3");

            // Get current shop selected items (assuming param name "selectedItems")
            List<Item> accumulatedItems = (List<Item>) session.getAttribute("selectedItems");
            if (accumulatedItems == null) {
                accumulatedItems = new ArrayList<>();
            }
            List<String> currentItemDescs = allParams.get("selectedItems");
            if (currentItemDescs != null) {
                for (String desc : currentItemDescs) {
                    Item item = itemrepo.findByItemDesc(desc);
                    if (item != null) {
                        accumulatedItems.add(item);
                    }
                }
            }

            // Save back to session
            session.setAttribute("selectedItems", accumulatedItems);
        }
        return mandv;
    }
	
	@GetMapping("/shop3")
    public ModelAndView showShopPage3(HttpSession session) {
        ModelAndView mandv = new ModelAndView();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            mandv.setViewName("redirect:/form1/login");
        } else {
        	List<Item> items=itemrepo.findByShopId(3);
    	 	mandv.addObject("items", items);
            mandv.setViewName("shop3");
        }
        return mandv;
    }
	
    @PostMapping("/shop3")
    public ModelAndView processPage3(@RequestParam MultiValueMap<String, String> allParams,HttpSession session) {
        ModelAndView mandv = new ModelAndView();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            mandv.setViewName("redirect:/form1/login");
        } else {
        	List<Item> items=itemrepo.findByShopId(3);
    	 	mandv.addObject("items", items);
       
    	 	List<Item> accumulatedItems = (List<Item>) session.getAttribute("selectedItems");
            if (accumulatedItems == null) {
                accumulatedItems = new ArrayList<>();
            }
            List<String> currentItemDescs = allParams.get("selectedItems");
            if (currentItemDescs != null) {
                for (String desc : currentItemDescs) {
                    Item item = itemrepo.findByItemDesc(desc);
                    if (item != null) {
                        accumulatedItems.add(item);
                    }
                }
            }
        mandv.setViewName("invoice");
        // Save back to session
        session.setAttribute("selectedItems", accumulatedItems);
        }
        
        return mandv;
    }
    
}
