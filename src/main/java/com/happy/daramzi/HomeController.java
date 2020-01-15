package com.happy.daramzi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
	
    /**
     * Tiles�� ������� ���� �Ϲ����� ���� git �� �ø��� ���� �ּ��� ����
     */    
    @RequestMapping("/test.do")
    public String test() {
        return "test";
    }    
    
    /**
     * Tiles�� ���(header, left, footer ����)
     */        
    @RequestMapping("/testPage.do")
    public String testPage() {
        return "test.page";
    }
    
    /**
     * Tiles�� ���(header, left, footer ����)
     */    
    @RequestMapping("/testPart.do")
    public String testPart() {
        return "test.part";
    }        
    	
	
}
