package com.Controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.print.attribute.HashAttributeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.Exception.HmitException;
import com.ibatis.common.jdbc.SimpleDataSource;
import com.ibatis.sqlmap.client.SqlMapException;
import com.service.DeviceService;
import com.service.UserLoginService;
import com.vos.ConfigType;
import com.vos.Device;
import com.vos.DeviceType;
import com.vos.Json;
import com.vos.MaintainCompanyVo;
import com.vos.MaintainVo;
import com.vos.PortInfoVo;
import com.vos.PortVo;
import com.vos.User;


@Controller
@SessionAttributes
public class ShowDeviceAction {
	
	public  static final String LOGIN_SUCCESS_MSG = "登录成功";
	public  static final String LOGIN_FAILED_MSG = "用户名或密码错误";
	public  static final String LOGIN_ERROR_MSG = "服务器出错,请重试";
	public  static final String SAVE_SUCCESS_MSG = "添加成功";	
	public  static final String SAVE_ERROR_MSG = "操作失败，请重试";	
	public  static final String UPDATE_ERROR_MSG = "更新失败，请重试";
	public  static final String UPDATE_SUCCESS_MSG = "更新成功";
	public  static final String LOAD_FILE_ERROR_MSG = "下载文件失败";	
	public  static final String CONNECT_PORT_FAILED = "端口已被占用，请重新选择";	
	public  static final String CONNECT_PORT_SUCCESS = "端口链接成功";
	public  static final String CONNECT_PORT_ERROR = "服务器出错，请重试";
	@Resource(name = "deviceService")
	private DeviceService deviceService;
	@Resource(name = "userLoginService")
	private UserLoginService userLoginService;
	public UserLoginService getUserLoginService() {
		return userLoginService;
	}

	public void setUserLoginService(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}

	public DeviceService getDeviceService() {
		return deviceService;
	}

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

//	@RequestMapping(value="/hello",method = RequestMethod.POST)
//	
//	public String handleRequest() throws Exception {
//		//System.out.println("age is " + user.getAge());
//		//String s = deviceService.getAllUser();
//		System.out.println("asd");
//		return "hello";
//	}
	 
//	@RequestMapping("/showUser")
//	public ModelAndView showUser(){
//		ModelAndView mav = new ModelAndView("login", "common", new User());
//		return mav;
//	}
/*	@RequestMapping("/addDevice")
	public void addDevice(@RequestParam("jsonDate") String jsonData,@RequestParam("id") int id,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			 String str = URLDecoder.decode(request.getParameter("jsonDate"),"UTF-8");  
			JSONObject object = JSONObject.fromObject(str);
			Device device = new Device();
//			device.setName(object.getString("name"));
//			device.setBrand(object.getString("brand"));
//			device.setOrderDate(object.getString("orderDate"));
//			device.setOrderBy(object.getString("orderBy"));
//			device.setPrice(object.getString("price"));
//			device.setSeriesNo(object.getString("seriesNo"));
//			device.setGuaranteeDate(object.getString("guaranteeDate"));
//			device.setExpireDate(object.getString("expireDate"));
			//sNo = object.getString("seriesNo");//pre-condition:seriesNo is unique 
			try {
				//1.first check if this record is in db(this part can code in store procedure)
				int i = deviceService.checkIfExists(id);
				if (i == 1) {
					deviceService.updateDevice(device, id);
				} else {
					deviceService.addDevice(device);
				}
				
				PrintWriter pw = response.getWriter();
				pw.print(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				PrintWriter pw = response.getWriter();
				pw.print(false);
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
	@RequestMapping("/getAllDevice")
	@ResponseBody
	public Map<String,Object> getAllDevice() {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map <String, Object>map = new HashMap<String, Object>();
		List<Device> dl = new ArrayList<Device>();
		try {
			dl = deviceService.getAllDevice();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		list.add(map);
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("rows", dl);
		resultMap.put("total", dl.size());
		return resultMap;
		
	}
	@RequestMapping("/deleteDevice")
	@ResponseBody
	public Map<String,Object> deleteDevice(@RequestParam("id") int id) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		try{
			deviceService.deleteDevice(id);
			map.put("success", "success");
			return map;
		}catch(Exception e) {
			map.put("error", "error");
			return map;
		}
	}
	@RequestMapping("/getDeviceTypeByPager")
	@ResponseBody
	public Map<String,Object> getDeviceTypeByPager(@RequestParam("pageSize") Integer pageSize,
			@RequestParam("pageNumber") Integer pageNumber,@RequestParam("typeId") int typeId , @RequestParam("selfId") int selfId) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Device> pageList = new ArrayList<Device>();
		int intPageNum=pageNumber==null||pageNumber<=0?1:pageNumber;
		int intPageSize=pageSize==null||pageSize<=0?10:pageSize;;
		int firstRow = (pageNumber - 1) * pageSize;
		try{
			pageList = deviceService.getDeviceByPager(firstRow, pageSize,typeId, selfId);
			int count = deviceService.getAllDevice(typeId);
			map.put("rows", pageList);
			map.put("total", count);
			return map;
		}catch(Exception e) {
			e.printStackTrace();
			map.put("error", false);
			return map;
		}
	}
	@RequestMapping("/getDeviceByPager")
	@ResponseBody
	public Map<String,Object> getDeviceByPager(@RequestParam("pageSize") Integer pageSize,
			@RequestParam("pageNumber") Integer pageNumber) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<Device> pageList = new ArrayList<Device>();
		List<Device> totalList = new ArrayList<Device>();
		int intPageNum=pageNumber==null||pageNumber<=0?1:pageNumber;
		int intPageSize=pageSize==null||pageSize<=0?10:pageSize;;
		int firstRow = (pageNumber - 1) * pageSize;
		try{
			pageList = deviceService.getDeviceByPager(firstRow, pageSize);
			totalList = deviceService.getAllDevice();
			int count = totalList.size();
			map.put("rows", pageList);
			map.put("total", count);
			return map;
		}catch(Exception e) {
			e.printStackTrace();
			map.put("error", false);
			return map;
		}
	}
	
	@RequestMapping("/queryMaintainDetailById")
	@ResponseBody
	public Map<String,Object> queryMaintainDetailById(@RequestParam("id") int id) {
		Map<String,Object> map = null;
		//List<MaintainVo> list = new ArrayList<MaintainVo>();
		try {
			map = deviceService.queryMaintainDetailById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MaintainVo mvo = (MaintainVo) map.get("mvo");
		if (mvo == null) {
			map.put("result", "none");
			return map;
		} else {
			//list.add(mvo);
			map.put("result", "success");
			//map.put("rows", list);
			return map;
		}
		
	}
	@RequestMapping("/addNewDevice")
	public void addNewDevice(
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		//Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> requestMap = new HashMap<String, Object>();
		String filePath = null;//need to be stored in db
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String seriesNo = null;
		Date date = new Date();
		PrintWriter pw = response.getWriter();
		String filename = null;
		try{
			
			String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/");
			File file = new File(path);
			if (!file.exists() && !file.isDirectory()) {
				file.mkdir();
			}
			 DiskFileItemFactory factory = new DiskFileItemFactory();
			 ServletFileUpload upload = new ServletFileUpload(factory);
			 upload.setHeaderEncoding("UTF-8");
			 List<FileItem> list = upload.parseRequest(request);
			 for(FileItem item : list) {
				 if(item.isFormField()){
					 String name = item.getFieldName();
					 String value = item.getString("UTF-8");
					 if (name.equals("seriesNo")) {
						 seriesNo = value;
					 }
					 if (value == null) {
						 value = "";
					 }
					 if (!name.equals("configFile")) {
						 requestMap.put(name, value);
					 }					 
				 } else {
					 filename = item.getName();
					 if(filename==null || filename.trim().equals("")){
						 continue;
					 }
					 filename = filename.substring(filename.lastIndexOf("\\")+1);
					 filePath = path + "\\" + seriesNo + "_" + sdf.format(date) + "_" + filename;// append the id to avoid the duplicated record
					 InputStream in = item.getInputStream();
					 FileOutputStream out = new FileOutputStream(filePath);
					 byte buffer[] = new byte[1024];
					 int len = 0;
					 while((len=in.read(buffer))>0){
						 //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
						 out.write(buffer, 0, len);
					 }
					 in.close();
					 out.close();
					 
				 }
			 }
			 requestMap.put("configFile", filePath);
			 deviceService.addDevice(requestMap);
			 pw.write("{\"result\":"+true+",\"msg\":\""+SAVE_SUCCESS_MSG+"\"}");
		}catch(Exception e) {
			e.printStackTrace();
			pw.write("{\"result\":"+false+",\"msg\":\""+SAVE_ERROR_MSG+"\"}");
		}
	}
	@RequestMapping("/updateDeviceInfo")
	@ResponseBody
	public void updateDeviceInfo(@RequestParam("id") int id,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String,Object> requestMap = new HashMap<String, Object>();
		PrintWriter pw = response.getWriter();
		try{
			
			String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/");
			File file = new File(path);
			if (!file.exists() && !file.isDirectory()) {
				file.mkdir();
			}
			 DiskFileItemFactory factory = new DiskFileItemFactory();
			 ServletFileUpload upload = new ServletFileUpload(factory);
			 upload.setHeaderEncoding("UTF-8");
			 List<FileItem> list = upload.parseRequest(request);
			 for(FileItem item : list) {
				 if(item.isFormField()){
					 String name = item.getFieldName();
					 String value = item.getString("UTF-8");
					 if (name.equals("portNumber")) {
						 requestMap.put(name, Integer.parseInt(value));
					 } else {
						 requestMap.put(name, value);
					 }			
					 System.out.println(name + " " + value);
				 } 
//				 else {
//					 String filename = item.getName();
//					 if(filename==null || filename.trim().equals("")){
//						 continue;
//					 }
//					 filename = filename.substring(filename.lastIndexOf("\\")+1);
//					 filePath = path + "\\" + id + "_"+ sdf.format(date) +"_" + filename;// append the id to avoid the duplicated record
//					 InputStream in = item.getInputStream();
//					 FileOutputStream out = new FileOutputStream(path + "\\" + id + "_"+ sdf.format(date) +"_" + filename);
//					 byte buffer[] = new byte[1024];
//					 int len = 0;
//					 while((len=in.read(buffer))>0){
//						 //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
//						 out.write(buffer, 0, len);
//					 }
//					 in.close();
//					 out.close();
//					 
//				 }
			 }
			 requestMap.put("id", id);
			deviceService.updateMaintainInfo(requestMap);
			 pw.write("{\"result\":"+true+",\"msg\":\""+UPDATE_SUCCESS_MSG+"\"}");
		}catch(Exception e) {
			e.printStackTrace();
			pw.write("{\"result\":"+false+",\"msg\":\""+UPDATE_ERROR_MSG+"\"}");
		}
	}
	@RequestMapping("/getConfigFile")
	@ResponseBody
	public void getConfigFile(@RequestParam("id") int id,
			HttpServletResponse response) throws IOException, SQLException, HmitException {
		//PrintWriter pw = null;
		try {
			//pw = response.getWriter();
			String filePath = deviceService.getFilePathById(id);
			if (filePath == null) {
				throw new HmitException("配置文件不存在");
				//pw.write("{\"result\":"+false+",\"msg\":\""+LOAD_FILE_ERROR_MSG+"\"}");// if config file does not exist,set 0;
			} else {
				response.setContentType("application/octet-stream");
				String filename = filePath
						.substring(filePath.lastIndexOf("\\") + 1);
				System.out.println(filename);
				response.setHeader(
						"content-disposition",
						"attachment;filename="
								+ URLEncoder.encode(filename, "UTF-8"));
				FileInputStream in = new FileInputStream(filePath);
				OutputStream out = response.getOutputStream();
				byte buffer[] = new byte[1024];
				int len = 0;
				while ((len = in.read(buffer)) > 0) {
					out.write(buffer, 0, len);
				}
				out.flush();
				in.close();
				out.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//pw.write("{\"result\":"+false+",\"msg\":\""+LOAD_FILE_ERROR_MSG+"\"}");
			//HmitException hmitEe = new HmitException(e.getMessage());
			throw e;
		} catch(IOException e) {
			e.printStackTrace();
			
			//HmitException hmitEe = new HmitException(e.getMessage());
			throw e;
			//pw.write("{\"result\":"+false+",\"msg\":\""+LOAD_FILE_ERROR_MSG+"\"}");
		}

	}
	@RequestMapping("/validateUser")
	public void validateUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
		User user = new User();
		user.setLoginName(request.getParameter("name"));
		user.setPassword(request.getParameter("md5_pwd"));
		int result; 
		PrintWriter pw = response.getWriter();
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			result = userLoginService.validateUser(user);
			if (result == 1) {
//				map.put("result", true);
//				map.put("msg",LOGIN_SUCCESS_MSG);
				request.getSession().setAttribute("current_user", user.getLoginName());
				pw.print("{\"result\":"+true+",\"msg\":\""+LOGIN_SUCCESS_MSG+"\"}"); 
				
			} else {
//				map.put("result", false);
//				map.put("msg",LOGIN_FAILED_MSG);
				pw.print("{\"result\":"+false+",\"msg\":\""+LOGIN_FAILED_MSG+"\"}"); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			map.put("result", false);
//			map.put("msg",LOGIN_ERROR_MSG);
			pw.print("{\"result\":"+false+",\"msg\":\""+LOGIN_ERROR_MSG+"\"}"); 
			
		} finally {
			pw.flush();
			pw.close();
		}
	}
	@RequestMapping("/getDeviceType")
	public void getDeviceType(HttpServletResponse response) throws IOException {
		List<DeviceType> list = new ArrayList<DeviceType>();
		PrintWriter pw = response.getWriter();
		
		try {
			list = deviceService.getDeviceType();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		JSONArray json = JSONArray.fromObject(list);
		//response.setContentType("text/html;charset=utf-8");
		pw.write(json.toString());
	}
	
	
	@RequestMapping("/getConfigType")
	public void getConfigType(HttpServletResponse response) throws IOException {
		List<ConfigType> list = new ArrayList<ConfigType>();
		PrintWriter pw = response.getWriter();
		try {
			list = deviceService.getConfigType();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		JSONArray json = JSONArray.fromObject(list);
		//response.setContentType("text/html;charset=utf-8");
		pw.write(json.toString());
	}
	@RequestMapping("/getCompany") 
	public void getCompany(HttpServletResponse response) throws IOException {
		List<MaintainCompanyVo> list = new ArrayList<MaintainCompanyVo>();
		PrintWriter pw = response.getWriter();
		
		try {
			list = deviceService.getMaintainCompany();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		JSONArray json = JSONArray.fromObject(list);
		pw.write(json.toString());
	}
	
	//interface for mobile
	@RequestMapping("/NFCQuery")
	
	public void getDeviceByNFC(@RequestParam("seriesNo") String seriesNo,HttpServletResponse response) {
		
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			Device device = deviceService.getDeviceByNFC(seriesNo);
			if (device != null) {
				JSONArray json = JSONArray.fromObject(device);
				pw.write(json.toString());	
			} else {
				pw.write("{\"result\":"+false+"}");	
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/getPortNumber")
	public void getPortNumber(@RequestParam("id") int id,HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			List<PortVo> list = new ArrayList<PortVo>();
			int portNum = deviceService.getPortNumber(id);
			for(int i = 1 ; i <= portNum ; i++) {
				PortVo pvo = new PortVo();
				pvo.setId(i);
				list.add(pvo);
			}
			JSONArray json = JSONArray.fromObject(list);
			pw.write(json.toString());	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/getPortInfo")
	@ResponseBody
	public Map<String,Object> getPortInfo(@RequestParam("id") int id,@RequestParam("portId") int portId,HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<PortInfoVo> list = new ArrayList<PortInfoVo>();
		try {
			list = deviceService.getPortInfo(id, portId);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("rows", list);
		map.put("total", list.size());
		return map;
	}
	@RequestMapping("/updatePortInfo")
	public void updatePortInfo(@RequestParam("jsonData") String jsonData,HttpServletRequest request,HttpServletResponse response) {
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			String str = request.getParameter("jsonData");
			JSONObject obj = JSONObject.fromObject(str);
			PortInfoVo pvo = new PortInfoVo();
			pvo.setsName(obj.getString("sName"));
			pvo.setsNo(obj.getString("sNo"));
			pvo.setsPort(obj.getInt("sPort"));
			pvo.setnName(obj.getString("nName"));
			pvo.setnNo(obj.getString("nNo"));
			pvo.setnPort(obj.getInt("nPort"));
			pvo.setIsVailable(obj.getString("isAvailable"));
			pvo.setNewOrUpdate(obj.getString("isNewOrUpdate"));
			int result = deviceService.updatePortInfo(pvo);
			if (result == 1) {//1代表链接记录已存在
				pw.print("{\"result\":"+true+",\"msg\":\""+CONNECT_PORT_FAILED+"\"}");
				
			} else {
				pw.print("{\"result\":"+true+",\"msg\":\""+CONNECT_PORT_SUCCESS+"\"}");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.print("{\"result\":"+false+",\"msg\":\""+CONNECT_PORT_ERROR+"\"}");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}
