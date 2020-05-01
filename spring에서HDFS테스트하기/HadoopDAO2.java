package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class HadoopDAO2 {
	@Autowired
	private Configuration conf;
	
	public String read(String name) {	
		String result = "";	
		FileSystem hdfs = null;
		try {
			hdfs = FileSystem.get(conf);
			Path filePath = new Path(name);
			if (hdfs.exists(filePath)) {
				BufferedReader r = new BufferedReader(new InputStreamReader(hdfs.open(filePath), "utf-8"));
				String line = null;
				while ((line = r.readLine()) != null) {
					System.out.println(line);
					result += line;
				}
				r.close();
			} else {
				result = "파일이 존재하지 않습니다!!";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "오류가 발생했어요";
		} finally {
			try {
				if (hdfs != null)
					hdfs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public String write(String msg) {
		String result = "";
		String filename = "/edudata/message.txt";
		FileSystem hdfs = null;
		try {
			hdfs = FileSystem.get(conf);
			Path filePath = new Path(filename);
			if (hdfs.exists(filePath)) {
				hdfs.delete(filePath, true);
			}	
			FSDataOutputStream out = hdfs.create(filePath, false);
			out.write(msg.getBytes("utf-8"));
			out.flush();
			result = filename + "으로 저장 완료되었어요.. 하둡가서 확인해 보세요..";
			out.close();			
		} catch (Exception e) {
			e.printStackTrace();
			result = "오류가 발생했어요";
		} finally {
			try {
				if (hdfs != null)
					hdfs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}	
	public String delete() {
		String result = "";
		String filename = "/edudata/message.txt";
		try (FileSystem hdfs=FileSystem.get(conf)){
			Path filePath = new Path(filename);
			hdfs.delete(filePath, true);
			result = filename + " 파일이 삭제되었어요.. 확인해 보세요..";
		} catch (Exception e) {
			e.printStackTrace();
			result = "오류가 발생했어요";
		} 
		return result;
	}
}

