package my.spring.springedu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.HadoopDAO;

@Controller
public class HadoopController {
	@Autowired
	HadoopDAO dao;
	@RequestMapping("/hadooprw")
	public ModelAndView put(String filename) {
		String result = dao.readwrite(filename);
		ModelAndView mav = new ModelAndView();
		mav.addObject("hadooprw", result);
		mav.setViewName("hadoopView");
		return mav;
	}
}
