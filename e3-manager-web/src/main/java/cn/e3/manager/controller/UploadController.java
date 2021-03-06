package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3.utils.FastDFSClient;
import cn.e3.utils.JsonUtils;
import cn.e3.utils.KindEditorModel;

@Controller
public class UploadController {
	//注入图片服务器地址
	@Value("${IMAGE_SERVER_URL}")
	private String IMAGE_SERVER_URL;
	
/*	@RequestMapping("/pic/upload")
	@ResponseBody
	public KindEditorModel upload(MultipartFile uploadFile){
		try {
			//获取文件扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			//创建fastDFS工具类对象,上传图片
			FastDFSClient client=new FastDFSClient("classpath:client.conf");
			//上传图片
			//返回图片虚拟磁盘路径/group1/M00/00/00/wKhCQ1mj2iyAaMiwAAvea_OGt2M047.jpg
			String url = client.uploadFile(uploadFile.getBytes(), extName);
			//组合图片上传绝对地址
			System.out.println(IMAGE_SERVER_URL);
			url = IMAGE_SERVER_URL+url;
			//图片上传成功
			KindEditorModel km = new KindEditorModel();
			//成功:error=0
			km.setError(0);
			km.setUrl(url);
			//把响应对象转换成json字符串
			return km;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//图片上传失败
			KindEditorModel km = new KindEditorModel();
			//成功:error=0
			km.setError(1);
			km.setMessage("上传失败");

			return km;
		}
	}	
	*/

	@RequestMapping("/pic/upload")
	@ResponseBody
	public String upload(MultipartFile uploadFile){
		try {
			//获取文件扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			//创建fastDFS工具类对象,上传图片
			FastDFSClient client=new FastDFSClient("classpath:client.conf");
			//上传图片
			//返回图片虚拟磁盘路径/group1/M00/00/00/wKhCQ1mj2iyAaMiwAAvea_OGt2M047.jpg
			String url = client.uploadFile(uploadFile.getBytes(), extName);
			//组合图片上传绝对地址
			url = IMAGE_SERVER_URL+url;
			//图片上传成功
			KindEditorModel km = new KindEditorModel();
			//成功:error=0
			km.setError(0);
			km.setUrl(url);
			//把响应对象转换成json字符串
			//fastJson
			//jsonlib
			//jackson
			String kmJson = JsonUtils.objectToJson(km);
			return kmJson;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//图片上传失败
			KindEditorModel km = new KindEditorModel();
			//成功:error=0
			km.setError(1);
			km.setMessage("上传失败");		
			String kmJson = JsonUtils.objectToJson(km);
			return kmJson;
		}
	}


}
