# HADOOP 실습

1. Spring MVC 연동 : DFS 실습

```java
/** Controller **/
@Controller
public class HadoopController {
    @Autowired
    HadooopDAO dao;
    @RequestMapping("/hadooprw")
    public ModelAndView myHadooprw(String name){
        String result = dao.readwrite(name);
        ModelAndView mav = new ModelAndView();
        mav.addObject("hadooprw", result);
        mav.setViewName("hadoopView"); // view 구현
    }
}
/********************************************************/
/** Data Access Object **/
@Repository
public class HadoopDAO {
    public String readwrite(String name) throws Exception {
        String result ="";
        /** HDFS connect **/
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://192.168.111.120:9000");
        FileSystem hdfs = FileSystem.get(conf); // throws error!!
        Path filePath = new Path("/edudata/"+name);
        /** if there exist the file **/
        if(hdfs.exists(filePath)){
            BufferedReader r = new BufferedReader(new InputStreamReader(hdfs.open(filePath)));
            String line = null;
            while((line = r.readLine()) != null){
                System.out.println(line);
                result += line;
            }
            r.close();              
        }
        /** if there not exist file **/
        else {
            // To do
        }
        return result;
    }
}
/*************************************************/
/** view 구현 **/

```



2. 리눅스에서 Yarn 명령으로 수행
   1. 이클립스 소스파일을 export 하여 Jar 파일 생성
   2. 리눅스에서…
   3. `yarn jar <실행할 jar 파일> <main method 클래스> [args]`  
      : `yarn jar fruitswc.jar mrexam.WordCount`