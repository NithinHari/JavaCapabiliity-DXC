package com.javacapability.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javacapability.model.JavaCompetency;
import com.javacapability.repo.JCRepository;

@Controller
@RequestMapping("/javacapability")
public class JCController {
	
	@Autowired
	private JCRepository jcRepo;
	

	@GetMapping("/index")
	public String javaCapabilityIndex() {
		return "/index.html";
	}
	
	@GetMapping("/javaproficiencymetrics")
	public String countJavaCompetency(Model model) {		
		List<JavaCompetency> cpList = jcRepo.countJcList();
		model.addAttribute("cpList",cpList);
		return "countProficiency";

	}
	
	@RequestMapping("/teamjavaproficiency")
	public ModelAndView employeeProficiency(ModelAndView model, Long employeeId, String emailId) throws IOException {
		
		if(employeeId != null) {
			List<JavaCompetency> epList = jcRepo.proficiencyListbyEmployeeId(employeeId);
			model.addObject("epList",epList);
			model.setViewName("EmployeeProficiency");
			System.out.println("EmployeeId : "+employeeId);
		return model;
		}else if(emailId != null) {
			List<JavaCompetency> epList = jcRepo.proficiencyListbyEmailId(emailId);
			model.addObject("epList",epList);
			model.setViewName("EmployeeProficiency");
			System.out.println("Email : "+emailId);
		return model;
		}else {
		List<JavaCompetency> epList = jcRepo.proficiencyList();
			model.addObject("epList",epList);
			model.setViewName("EmployeeProficiency");
		return model;
		}
	}
	
	@RequestMapping(value = "/javacompetencySearch")
	public String updateLogin(Model model) {
		
		return "JavaCompetencyUpdateLogin";
	}
	
	@RequestMapping("/searchByEmailId")
	public ModelAndView searchByEmailId(String email_id, ModelAndView model) {
		List<JavaCompetency> jc = jcRepo.findByEmailid(email_id);
		model.addObject("jc", jc);
		model.setViewName("JavaCompetencyEmailId");
		System.out.println("Email : "+email_id);
		return model;
	}
	
	@RequestMapping("/searchByEmployeeId")
	public ModelAndView searchByEmployeeId(Long employee_id, ModelAndView model) {
		List<JavaCompetency> jc = jcRepo.findByEmployeeId(employee_id);
		model.addObject("jc", jc);
		model.setViewName("JavaCompetencyEmployeeId");
		System.out.println("EmployeeId : "+employee_id);
		return model;
	}
	@GetMapping("/showFormForUpdateByEid")
	public String showFormForUpdatebyEid(@RequestParam("employee_id") Long employee_id,@RequestParam("competency_name") String competency_name, Model model) {
		JavaCompetency jc = jcRepo.formByEmployeeId(employee_id, competency_name);
		model.addAttribute("jc",jc);
		System.out.println("EmployeeId : "+employee_id);
		System.out.println("Competency : "+competency_name);
		return "updateFormByEmployeeId";
	}
	@GetMapping("/showFormForUpdateByEmailId")
	public String showFormForUpdateByEmailId(@RequestParam("email_Id") String email_id,@RequestParam("competency_name") String competency_name, Model model) {
		JavaCompetency jc = jcRepo.formByEmailId(email_id, competency_name);
		model.addAttribute("jc",jc);
		System.out.println("Email : "+email_id);
		System.out.println("Competency : "+competency_name);
		return "updateFormByEmailId";
	}
	

	@RequestMapping(value = "/emailupdate", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateOnEmail(@ModelAttribute("jc") JavaCompetency jc,@RequestParam("email_Id") String email_id,@RequestParam("competency") String competency_name,@RequestParam(value = "proficiency") String proficiency) {
		jcRepo.updateByEmailIdNew(jc, email_id, competency_name,proficiency);
		System.out.println("Email : "+email_id);
		System.out.println("Competency : "+competency_name);
		System.out.println("Proficiency : "+proficiency);
		return "redirect:/javacapability/teamjavaproficiency";	
	}
	
	@RequestMapping(value = "/eidupdate", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateByEmployeeIdNew(@ModelAttribute("jc") JavaCompetency jc,@RequestParam("employee_Id") Long employee_id,@RequestParam("competency") String competency_name,@RequestParam("proficiency") String proficiency) {
		jcRepo.updateByEmployeeIdNew(jc, employee_id, competency_name,proficiency );
		System.out.println("Proficiency : "+proficiency);
		return "redirect:/javacapability/teamjavaproficiency";
	}
	
}
//@RequestMapping(value = "/emailupdate", method = RequestMethod.POST)
//@PostMapping("/emailupdate")   ///	@RequestParam("email_id") @RequestParam("competency_name")
//@RequestMapping(value = "/javacompetencyemployeeId", method = RequestMethod.POST)
//@PostMapping(value = "/javacompetencyemployeeId" , method = RequestMethod.GET )
//@PostMapping("/eidupdate")

