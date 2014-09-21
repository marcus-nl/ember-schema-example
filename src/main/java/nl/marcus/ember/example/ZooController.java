package nl.marcus.ember.example;

import nl.marcus.ember.example.model.Zoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZooController {
	
	@Autowired
	private ZooService zooService;

    @RequestMapping("/zoos/{id}")
    @ResponseBody
	public Zoo getZoo(String id) {
		return zooService.getZooById(id);
	}
}
