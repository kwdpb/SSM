package com.kw.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImgController {
 
     @RequestMapping(value ="/upload")
     @ResponseBody
     public void UpLoadImg(
    		 @RequestParam(value="myFileName")MultipartFile mf,
    		 HttpServletRequest request,
    		 HttpServletResponse response) {
        String realPath = request.getSession().getServletContext().getRealPath("upload");
         
    //获取源文件
     String filename = mf.getOriginalFilename();
     String[] names=filename.split("\\.");//
     String tempNum=(int)(Math.random()*100000)+"";
     String uploadFileName=tempNum +System.currentTimeMillis()+"."+names[names.length-1];
     File targetFile = new File (realPath,uploadFileName);//目标文件
     
     //开始从源文件拷贝到目标文件
     
     //传图片一步到位
     try {
        mf.transferTo(targetFile);
     } catch (IllegalStateException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     }
     
     Map<String, String> map = new HashMap<String, String>();
     map.put("url","http://localhost:8080/web/upload/"+uploadFileName);//这里应该是项目路径
     JSONObject jsonObject=JSONObject.fromObject(map);
     String strjson=jsonObject.toString();
     System.out.println("json的字符串："+strjson);
     PrintWriter out;
	try {
		out = response.getWriter();
		out.write(strjson);//将图片地址返回
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
}
