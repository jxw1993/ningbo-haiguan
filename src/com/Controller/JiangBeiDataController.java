package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.service.JiangBeiService;
import com.vos.IndicatorVO;
/**
 * 数据江北中间件接口方法 
 * */
@Controller
@SessionAttributes
public class JiangBeiDataController {
	@Resource(name = "jiangBeiService")
	private JiangBeiService jiangBeiService;
	public JiangBeiService getJiangBeiService() {
		return jiangBeiService;
	}
	public void setJiangBeiService(JiangBeiService jiangBeiService) {
		this.jiangBeiService = jiangBeiService;
	}


	@RequestMapping("/getNewsList")
	public void getNewsList(HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html;charset=utf-8");
//			pw.write("getNewsList");
			List<IndicatorVO> list = new ArrayList<IndicatorVO>();
			
			try {
				list = jiangBeiService.getIndicator();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONArray json = JSONArray.fromObject(list);
			pw.write(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
