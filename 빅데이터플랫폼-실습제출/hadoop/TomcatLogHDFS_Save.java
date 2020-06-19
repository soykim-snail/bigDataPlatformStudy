package hdfsexam;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class TomcatLogHDFS_Save {

	public static void main(String[] args) throws IOException {
		// File 읽어오기 준비
		String sourcePath = "C:/soykim/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/logs/";		
		String fileName = "";
		String target = "C:/soykim/tomcat_access_log.txt";
		long resultSize = 0;
		// File Writer 준비
		FileWriter fw = new FileWriter(target, true);
		
		// File 목록 읽어오기
		File path = new File(sourcePath);
		File[] fileList = path.listFiles();
		if(fileList.length > 0) {
			// 파일 하나씩 읽어 붙이기
			for(int i=0; i < fileList.length; i++) {
				fileName = fileList[i].toString();
				File f = new File(fileName);
				long size = f.length();
						
				FileReader fr = new FileReader(fileName);
				char[] content = new char[(int)size];
				fr.read(content);
				
				// FileWriter				
				for(char c : content) {
					fw.append(c);
				}						
				fr.close();	
				resultSize += size;
			}
		}
		System.out.println("파일 사이즈 : " + resultSize);
		fw.close();	
		// ---- 여기까지 파일저장 완료
		
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://192.168.111.120:9000");
		FileSystem hdfs = FileSystem.get(conf);
				
		// 하둡 데이터 저장하기	
		hdfs.copyFromLocalFile(new Path("C:/soykim/tomcat_access_log.txt"), new Path("/edudata/tomcat_access_log.txt"));
		System.out.println("하둡 파일사이즈 : " + hdfs.getFileStatus(new Path("/edudata/tomcat_access_log.txt")).getLen());
		hdfs.close();
		
		
	}

}
