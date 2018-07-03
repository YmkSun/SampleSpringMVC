package mm.com.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import mm.com.demo.entity.User;
import mm.com.demo.service.UserService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String showList(Model model) {
		model.addAttribute("userList", userService.getAllUserList());
		return "list";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String registerUser(@ModelAttribute("message") String message, Locale locale, Model model) {
		model.addAttribute("userObj", new User());
		model.addAttribute("message", message);
		return "register";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, params="List")
	public String goUserList(Locale locale, Model model) {
		return "redirect:welcome.html";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, params="Save")
	public String saveUser(@ModelAttribute User user, Locale locale, Model model, RedirectAttributes attribs) {
		String result = "";
		if(user.getId()==0)
			result = userService.insert(user);
		else
			result = userService.updateUser(user);
		attribs.addFlashAttribute("message", result);
		return "redirect:user.html";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST, params="Delete")
	public String deleteUser(@ModelAttribute User user, Locale locale, Model model, RedirectAttributes attribs) {
		String result = userService.deleteUserById(user.getId());
		attribs.addFlashAttribute("message", result);
		return "redirect:user.html";
	}
	
	@RequestMapping(value = "/edituserInfo", method = RequestMethod.POST)
	public String getInfoById(@ModelAttribute("id") int id, Locale locale, Model model) {
		model.addAttribute("userObj", userService.getUserById(id));
		return "register";
	}
	
	@RequestMapping(value = "/userReportPdf", method = RequestMethod.GET)
	@ResponseBody
	public void printReportPdf(HttpServletResponse response) {
		List<User> userList = userService.getAllUserList();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("printBy", "San Win Thet Aung");
		String fileName = servletContext.getRealPath("/reports")+"/userList.jrxml";
		JRBeanCollectionDataSource l_dataSource = new JRBeanCollectionDataSource(userList);
		try {
			JasperReport jasperRpt = JasperCompileManager.compileReport(fileName);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperRpt, params, l_dataSource);
			
			/*final OutputStream outStream = response.getOutputStream();
		    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);*/
			
			JRPdfExporter pdfExporter = new JRPdfExporter();
			
			response.setContentType("application/pdf");
			//response.setHeader("Content-Disposition","attachment;filename=userList.pdf");
			pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
			pdfExporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM,response.getOutputStream());
			pdfExporter.exportReport();
			
		} catch (JRException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/userReportExcel", method = RequestMethod.GET)
	@ResponseBody
	public void printReportExcel(HttpServletResponse response) {
		List<User> userList = userService.getAllUserList();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("printBy", "San Win Thet Aung");
		String fileName = servletContext.getRealPath("/reports")+"/userList.jrxml";
		JRBeanCollectionDataSource l_dataSource = new JRBeanCollectionDataSource(userList);
		try {
			JasperReport jasperRpt = JasperCompileManager.compileReport(fileName);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperRpt, params, l_dataSource);
			
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

			JRXlsExporter excelExporter = new JRXlsExporter();

			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition","attachment;filename=userList.xls");

			excelExporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
			excelExporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,response.getOutputStream());
			excelExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,	Boolean.TRUE);
			excelExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,Boolean.FALSE);
			excelExporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,Boolean.FALSE);
			excelExporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,Boolean.TRUE);
			excelExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "UserList.xls");
			excelExporter.exportReport();

			ServletOutputStream servletOutputStream = response.getOutputStream();
			servletOutputStream.write(byteArrayOutputStream.toByteArray());
			servletOutputStream.flush();
			
		} catch (JRException | IOException e) {
			e.printStackTrace();
		}
	}
}
