package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.service.IRMSService;
import com.vo.BaseInfoVO;
import com.vo.CheckInfoVO;
import com.vo.InspectDetailVO;
import com.vo.InspectItemVO;
import com.vo.PortDetailVO;
import com.vo.PortItemVO;
import com.vo.PortTypeVO;
import com.vo.SetupDetailVO;
import com.vo.SetupItemVO;
import com.vo.UserVO;
/**
 * 资产管理系统中间件接口方法 
 * */
@Controller
@SessionAttributes
public class IRMSController {
	@Resource(name = "irmsService")
	private IRMSService irmsService;
	public IRMSService getIrmsService() {
		return irmsService;
	}
	public void setIrmsService(IRMSService irmsService) {
		this.irmsService = irmsService;
	}

	@RequestMapping("/IRMSmiddleWare/getUerInfo")
	public void getUerInfo(@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			
			UserVO userVO = null;
			Map<String,Object> requestMap = new HashMap<String, Object>();
			requestMap.put("username", username);
			requestMap.put("password", password);
			try {
				userVO = irmsService.getUserInfo(requestMap);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(userVO!=null && userVO.getId() !=-1){
				pw.write("true");
			}else{
				pw.write("false");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@RequestMapping("/IRMSmiddleWare/getBaseInfo")
	public void getBaseInfo(@RequestParam("nfc_id") String nfc_id,@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			//确认用户权限
			UserVO userVO = null;
			Map<String,Object> requestMap = new HashMap<String, Object>();
			requestMap.put("username", username);
			requestMap.put("password", password);
			userVO = irmsService.getUserInfo(requestMap);
			
			if(userVO!=null && userVO.getId() !=-1){ //是否有查询信息的权限
				BaseInfoVO baseInfoVO = null;
				Map<String,Object> baseMap = new HashMap<String, Object>();
				baseMap.put("nfc_id", nfc_id);
				baseInfoVO = irmsService.getBaseInfo(baseMap);
				//实体类数据转换为JSON字符串
				JSONObject object = JSONObject.fromObject(baseInfoVO);
				pw.write(object.toString());
			}else{
				pw.write("false");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@RequestMapping("/IRMSmiddleWare/getCheckInfo")
	public void getCheckInfo(@RequestParam("nfc_id") String nfc_id,@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			//确认用户权限
			UserVO userVO = null;
			Map<String,Object> requestMap = new HashMap<String, Object>();
			requestMap.put("username", username);
			requestMap.put("password", password);
			userVO = irmsService.getUserInfo(requestMap);
			
			if(userVO!=null && userVO.getId() !=-1){ //是否有查询信息的权限
				CheckInfoVO checkInfoVO = null;
				Map<String,Object> baseMap = new HashMap<String, Object>();
				baseMap.put("nfc_id", nfc_id);
				checkInfoVO = irmsService.getCheckInfo(baseMap);
				//实体类数据转换为JSON字符串
				JSONObject object = JSONObject.fromObject(checkInfoVO);
				pw.write(object.toString());
			}else{
				pw.write("false");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@RequestMapping("/IRMSmiddleWare/getPortList")
	public void getPortList(@RequestParam("self_id") String self_id,@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			//确认用户权限
			UserVO userVO = null;
			Map<String,Object> requestMap = new HashMap<String, Object>();
			requestMap.put("username", username);
			requestMap.put("password", password);
			userVO = irmsService.getUserInfo(requestMap);
			
			if(userVO!=null && userVO.getId() !=-1){ //是否有查询信息的权限
				List<PortItemVO> list = new ArrayList<PortItemVO>();
				Map<String,Object> baseMap = new HashMap<String, Object>();
				baseMap.put("self_id", self_id);
				list = irmsService.getPortList(baseMap);
				//数组数据转换为JSON字符串
				JSONArray json = JSONArray.fromObject(list);
				pw.write(json.toString());
			}else{
				pw.write("false");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@RequestMapping("/IRMSmiddleWare/getPortDetail")
	public void getPortDetail(@RequestParam("port_id") String port_id,@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			//确认用户权限
			UserVO userVO = null;
			Map<String,Object> requestMap = new HashMap<String, Object>();
			requestMap.put("username", username);
			requestMap.put("password", password);
			userVO = irmsService.getUserInfo(requestMap);
			
			if(userVO!=null && userVO.getId() !=-1){ //是否有查询信息的权限
				PortDetailVO portDetailVO = null;
				Map<String,Object> baseMap = new HashMap<String, Object>();
				baseMap.put("port_id", port_id);
				portDetailVO = irmsService.getPortDetail(baseMap);
				//实体类数据转换为JSON字符串
				JSONObject object = JSONObject.fromObject(portDetailVO);
				pw.write(object.toString());
			}else{
				pw.write("false");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@RequestMapping("/IRMSmiddleWare/getPortType")
	public void getPortLocation(@RequestParam("self_id") String self_id,@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			//确认用户权限
			UserVO userVO = null;
			Map<String,Object> requestMap = new HashMap<String, Object>();
			requestMap.put("username", username);
			requestMap.put("password", password);
			userVO = irmsService.getUserInfo(requestMap);
			
			if(userVO!=null && userVO.getId() !=-1){ //是否有查询信息的权限
				List<PortTypeVO> list = new ArrayList<PortTypeVO>();
				Map<String,Object> baseMap = new HashMap<String, Object>();
				baseMap.put("self_id", self_id);//查询当前端口设备之外的设备
				list = irmsService.getPortType(baseMap);
				//数组数据转换为JSON字符串
				JSONArray json = JSONArray.fromObject(list);
				pw.write(json.toString());
			}else{
				pw.write("false");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@RequestMapping("/IRMSmiddleWare/getPortNumber")
	public void getPortNumber(@RequestParam("self_id") String self_id,@RequestParam("model_no") String model_no,@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			//确认用户权限
			UserVO userVO = null;
			Map<String,Object> requestMap = new HashMap<String, Object>();
			requestMap.put("username", username);
			requestMap.put("password", password);
			userVO = irmsService.getUserInfo(requestMap);
			
			if(userVO!=null && userVO.getId() !=-1){ //是否有查询信息的权限
				List<PortTypeVO> list = new ArrayList<PortTypeVO>();
				Map<String,Object> baseMap = new HashMap<String, Object>();
				baseMap.put("self_id", self_id);//查询当前端口设备之外的设备
				baseMap.put("model_no", model_no); 
				list = irmsService.getPortNumber(baseMap);
				//数组数据转换为JSON字符串
				JSONArray json = JSONArray.fromObject(list);
				pw.write(json.toString());
			}else{
				pw.write("false");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@RequestMapping("/IRMSmiddleWare/editPortSave")
	public void editPortSave(@RequestParam("username") String username,@RequestParam("password") String password,
			@RequestParam("self_id") String self_id,@RequestParam("s_port") String s_port,@RequestParam("s_type") String s_type,@RequestParam("n_id") String n_id,
			@RequestParam("next_id") String next_id,@RequestParam("n_port") String n_port,@RequestParam("n_type") String n_type,@RequestParam("s_id") String s_id,
			@RequestParam("old_next_id") String old_next_id,@RequestParam("old_n_port") String old_n_port,@RequestParam("new_next_id") String new_next_id,@RequestParam("new_n_port") String new_n_port,
			HttpServletResponse response,HttpServletRequest request) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			//确认用户权限
			UserVO userVO = null;
			Map<String,Object> requestMap = new HashMap<String, Object>();
			requestMap.put("username", username);
			requestMap.put("password", password);
			userVO = irmsService.getUserInfo(requestMap);
			 
			if(userVO!=null && userVO.getId() !=-1){ //是否有修改信息的权限
				boolean reuslt = false;
				//当前设备端口信息修改
				Map<String,Object> baseMap = new HashMap<String, Object>();
				baseMap.put("next_id", next_id); 
				baseMap.put("n_port", n_port);
				baseMap.put("n_type", n_type);
				baseMap.put("port_id", s_id);
				//旧的对应设备端口信息修改
				Map<String,Object> oldMap = new HashMap<String, Object>();
				if(!old_next_id.equals("")){
					oldMap.put("self_id", old_next_id); 
					oldMap.put("s_port", old_n_port);
				}
				//新的对应设备端口信息修改
				Map<String,Object> nextMap = new HashMap<String, Object>();
				nextMap.put("next_id", self_id); 
				nextMap.put("n_port", s_port);
				nextMap.put("n_type", s_type);
				nextMap.put("port_id", n_id);
				//新的对应设备端口的对应端口修改
				Map<String,Object> newMap = new HashMap<String, Object>();
				if(!new_next_id.equals("")){
					newMap.put("self_id", new_next_id); 
					newMap.put("s_port", new_n_port);
				}
				//数据库操作
				reuslt = irmsService.updatePortInfo(oldMap,newMap,baseMap,nextMap);
				
				if(reuslt){
					pw.write("true");
				}else{
					pw.write("false");
				}
			}else{
				pw.write("false");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@RequestMapping("/IRMSmiddleWare/getSetupList")
	public void getSetupList(@RequestParam("device_id") String device_id,@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			//确认用户权限
			UserVO userVO = null;
			Map<String,Object> requestMap = new HashMap<String, Object>();
			requestMap.put("username", username);
			requestMap.put("password", password);
			userVO = irmsService.getUserInfo(requestMap);
			
			if(userVO!=null && userVO.getId() !=-1){ //是否有查询信息的权限
				List<SetupItemVO> list = new ArrayList<SetupItemVO>();
				Map<String,Object> baseMap = new HashMap<String, Object>();
				baseMap.put("device_id", device_id);
				list = irmsService.getSetupList(baseMap);
				//数组数据转换为JSON字符串
				JSONArray json = JSONArray.fromObject(list);
				pw.write(json.toString());
			}else{
				pw.write("false");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@RequestMapping("/IRMSmiddleWare/getSetupDetail")
	public void getSetupDetail(@RequestParam("id") String id,@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			//确认用户权限
			UserVO userVO = null;
			Map<String,Object> requestMap = new HashMap<String, Object>();
			requestMap.put("username", username);
			requestMap.put("password", password);
			userVO = irmsService.getUserInfo(requestMap);  
			
			if(userVO!=null && userVO.getId() !=-1){ //是否有查询信息的权限
				SetupDetailVO setupDetailVO = null;
				Map<String,Object> baseMap = new HashMap<String, Object>();
				baseMap.put("id", id);
				setupDetailVO = irmsService.getSetupDetail(baseMap);
				//实体类数据转换为JSON字符串
				JSONObject object = JSONObject.fromObject(setupDetailVO);
				pw.write(object.toString());
			}else{
				pw.write("false");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@RequestMapping("/IRMSmiddleWare/getInspectList")
	public void getInspectList(@RequestParam("type_id") String type_id,@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			//确认用户权限
			UserVO userVO = null;
			Map<String,Object> requestMap = new HashMap<String, Object>();
			requestMap.put("username", username);
			requestMap.put("password", password);
			userVO = irmsService.getUserInfo(requestMap);
			
			if(userVO!=null && userVO.getId() !=-1){ //是否有查询信息的权限
				List<InspectItemVO> list = new ArrayList<InspectItemVO>();
				Map<String,Object> baseMap = new HashMap<String, Object>();
				baseMap.put("type_id", type_id);
				list = irmsService.getInspectList(baseMap); 
				//数组数据转换为JSON字符串
				JSONArray json = JSONArray.fromObject(list);
				pw.write(json.toString());
			}else{
				pw.write("false");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@RequestMapping("/IRMSmiddleWare/addInspect")
	public void addInspect(@RequestParam("jsonSring") String jsonSring,@RequestParam("username") String username,@RequestParam("password") String password,
			HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			//确认用户权限
			UserVO userVO = null;
			Map<String,Object> requestMap = new HashMap<String, Object>();
			requestMap.put("username", username);
			requestMap.put("password", password);
			userVO = irmsService.getUserInfo(requestMap);  
			
			if(userVO!=null && userVO.getId() !=-1){ //是否有查询信息的权限
				boolean reuslt = false;
				List<InspectDetailVO> inspectList = new ArrayList<InspectDetailVO>();
				JSONArray json = JSONArray.fromString(jsonSring); 
				inspectList = json.toList(json, InspectDetailVO.class);
				reuslt = irmsService.addInspect(inspectList);
				if(reuslt){
					pw.write("true");
				}else{
					pw.write("false");
				}
			}else{
				pw.write("false");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
