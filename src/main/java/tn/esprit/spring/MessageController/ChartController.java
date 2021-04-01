package tn.esprit.spring.MessageController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.MessageService.IMessageService;
import tn.esprit.spring.entities.Message;
@Controller
@RequestMapping(value = { "", "chart" })
public class ChartController {
	@Autowired
	IMessageService iMessageService;
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "chart/index";
	}

	@RequestMapping(value = "data", method = RequestMethod.GET)
	@ResponseBody
	public List<Message> data() {
	
		return iMessageService.listAll();
	}

}
