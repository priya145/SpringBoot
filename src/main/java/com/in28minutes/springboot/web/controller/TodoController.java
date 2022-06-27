package com.in28minutes.springboot.web.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.web.service.TodoService;
//below annotation takes that parameter from model and puts into session. So we can fetch the value of it in any jsp or controller
@Controller
@SessionAttributes("Name")
public class TodoController {
	//dependency injectioin = LoginService is the depedency of this class
		//Injected automatically
		@Autowired
		TodoService service;
		
		@RequestMapping(value="/list-todos", method=RequestMethod.GET)
		public String showToDos(ModelMap model) {
			String name = (String) model.get("Name");
			model.put("todos", service.retrieveTodos("in28Minutes"));
			//model.put("todos", service.retrieveTodos("name"));
			return "list-todos";
		}
		
		@RequestMapping(value="/add-todo", method=RequestMethod.GET)
		public String showAddToDo(ModelMap model) {
			return "add-todo";
		}
		
		@RequestMapping(value="/add-todo", method=RequestMethod.POST)
		public String addToDo(ModelMap model, @RequestParam String desc) {
			service.addTodo((String) model.get("Name"), desc, new Date(), false);
			return "redirect:/list-todos";
		}
		
		@RequestMapping(value="/delete-todo", method=RequestMethod.GET)
		public String deleteToDo(@RequestParam int id) {
			service.deleteTodo(id);
			return "redirect:/list-todos";
		}
		
	
}
