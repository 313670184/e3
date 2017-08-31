package cn.e3.fdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

import cn.e3.utils.FastDFSClient;

public class MyFdfs {
	public static void main(String[] args) {
		try {
			new MyFdfs().TestUploadPic();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void TestUploadPic() throws Exception {
		// 1.指定上传图片绝对路径
		String path = "C:\\Users\\ko\\Pictures\\look\\88.jpg";
		// 2.指定本地绝对 路径路径，指定Client.conf绝对路径
		String clientPath = "D:\\Users\\ko\\git\\e3\\e3-manager-web\\src\\main\\resources\\client.conf";
		// 3.加载配置文件，连接服务器
		ClientGlobal.init(clientPath);
		// 4.创建tracker客户端
		TrackerClient tClient = new TrackerClient();
		// 5.从客户端获取tracker对象
		TrackerServer trackerServer = tClient.getConnection();
		StorageServer storageServer = null;
		// 6.创建storageClient客户端
		StorageClient sClient = new StorageClient(trackerServer, storageServer);
		// 7.上传
		String[] str = sClient.upload_file(path, "jpg", null);
		for (String string : str) {
			System.out.println(string);
		}
	}

	public void uploadPic() throws Exception{
		String conf = "D:\\Users\\ko\\git\\e3\\e3-manager-web\\src\\main\\resources\\client.conf";
		String fileName = "C:\\Users\\ko\\Pictures\\look\\66.jpg";
		FastDFSClient client=new FastDFSClient(conf);
		String uploadFile = client.uploadFile(fileName);
		System.out.println(uploadFile);
	}
}
