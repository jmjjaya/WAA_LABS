/**
 * 
 */
package edu.mum.exercise_8B.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.exercise_8B.dao.IBookDao;
import edu.mum.exercise_8B.model.Book;

/**
 * @author jeewa
 *
 *
 */
@Controller
@RequestMapping("/book")
public class BookController {

	@Resource
	private IBookDao bookDao;

	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/books";
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("books", bookDao.getAll());
		return "bookList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAdd(Book book) {
		return "addBook";
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public String add(@Valid Book book, BindingResult result) {
		if (!result.hasErrors()) {
			bookDao.add(book);
			return "redirect:/book/books";
		}
		return "addBook";
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public String get(@PathVariable int id, Model model) {
		model.addAttribute("book", bookDao.get(id));
		return "bookDetails";
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.POST)
	public String update(Book book, @PathVariable int id) {
		bookDao.update(id, book); // car.id already set by binding
		return "redirect:/book/books";
	}

	@RequestMapping(value = "/books/delete", method = RequestMethod.POST)
	public String delete(int bookId) {
		bookDao.delete(bookId);
		return "redirect:/book/books";
	}

	@ExceptionHandler(value = NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("noSuchResource");
		return mv;
	}

}
