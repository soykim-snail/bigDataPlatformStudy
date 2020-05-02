> 인용구 : ctl+shift+q

[TOC]

-----

---

##  MarkUp editor 학습

> 인용구 : ctrl+shift+q

> 인용구 : `>`

코드펜스 : ctrl+shift+k

```html
<script scr="http://code.jquery.com/jquery-2.1.3.min.js"></script>
<script>
$(document).ready(function(){})
</script>
```



수식펜스 : ctl+shift+m
$$
524 / 327 = 2
$$
순서있는 목록 : ctrl+shift+[

- 응용프로그램
- 셸
- 커널
- 하드웨어

순서없는 목록 : ctrl+shift+]

1. 응용프로그램
2. 셸
3. 커널
4. 하드웨어

표삽입 : ctrl+t

| 커널 버전 | 0.01 | 1.0  | 2.0  | 2.2  | 2.4  | 2.6  | 3.0  | 3.2  | 3.4  | 3.10 |
| --------- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| 발표 연도 | 1991 | 1994 | 1996 | 1999 | 2001 | 2003 | 2011 | 2012 | 2012 | 2013 |

들여쓰기 : ctrl+]  		**작동 안됨**

내어쓰기 : cntl+[ 		**작동 안됨**

제목수준 올리기: ctrl+=

제목수준 내리기: ctrl+-

제목수준 설정: ctrl+1 ~ ctrl+6

[w3schools]:www.w3schools.com

[^각주를 붙입니다.]:각주사용방법

각주 테스트입니다. [^주1]

[^주1]: 이곳에 주석을 작성합니다.

(w3schools)[www.w3schools.com]

[www.w3schools.com]:이런저런것들입니다.



## 리눅스 명령어 학습[^`man`]

[^`man`]:리눅스의 명령어는 수천 개가 넘는다.  체계화된 도움말 사용이 가능하다. `man <명령어>`로 사용한다.

`pwd` : 현위치 알려줘 *(print working directory)*

`ls` : list

- `ls - l` |  `ll`  :  정보를 길게 보여줘 (*permission mode, 소유자, 생성일 등*)
- ​	`ls -a` : 숨김 파일까지 모두 보여줘
- ​	`ls -al` : 숨김까지 길게 보여줘
  - `ls <폴더위치>`

`..` : 상위 디렉토리

`.` : 현재 디렉토리

`mkdir` : 폴더 만들어줘 *(make directory)* 

`cd` : 디렉토리 변경 (*change directory*)

- `cd` + `Enter` : 홈으로 이동
- `cd ~<계정명>` : 특정 계정의 홈디렉토리로 이동

`cat <파일이름>` :  파일내용 보기

`head <파일이름>` : 앞 10개 행만 보기

`tail <파일이름>` : 끝 10개 행만 보기

`rm` : 삭제해라 (*remove*) 

- ​	`rm <파일명>`

`cp` : 복사하라 (*copy*)

- `cp <복사할 파일> <새 파일>`
- `cp -r` : 디렉토리 복사(*recursively*)

`touch` : 새 파일 생성, 또는 수정시간 변경

`mv` : (*move*)

- `mv <대상 파일들> <옮겨질 위치>`

- `mv <대상 파일> <새 파일>`

`cat`

`cat <파일명> <파일명> > <파일명>` : change

`cat <파일명> <파일명> >> <파일명>` : append

`ll > <파일명>`: change

`ll >> <파일명>` : append

`|more` : 한페이지씩 보여줌

- `space + enter` 다음 페이지로, 
- `b + enter` 앞 페이지로, 
- `q+ enter` 중단

`ps` : 현재 프로세스 체크 (*process status*)

- `ps -e` : 다른 터미널에서 수행되는 것도 모두 보여줘
- `ps -e | wc -l` : 행단위로 세어줘 (*word count by line*)

`wc` : (*word count*)

- `wr <파일명>` : 파일의 행, 단어, 문자 갯수 세어줘
- `wr -l <파일명>` : 행 갯수 세어줘

`sleep <초>` : 숫자초만큼 수면

- `sleep <초>& ` : 백그라운드에서 수행

##### java 구동

`java -version` : 내장된 자바 버젼 확인

`javac <파일이름>.java` : 컴파일 하시오 (*java developer*가 설치된 경우만)



### vi 에디터 학습

##### `i`| `a` : 입력 모드

- `i` : 현재 커서의 위치부터 입력 (*insert*)
- `a` : 현재 커서의 위치 다음 칸부터 입력 (*append*)
- `o` : 현재 커서의 다음 줄에 입력 (*open*)
- `s` :  현재 커서 위치의 한 글자를 지우고 입력 (*switch*)
- `I` : 현재 커서의 줄의 맨 앞에서부터 입력
- `A` : 현재 커서의 줄의 맨 마지막부터 입력
- `O` : 현재 커서의 다음 줄에 입력
- `S` : 현재 커서의 한 줄을 지우고 입력

##### `esc` : 명령 모드

- `dd` : 한행 삭제
- `yy` : 한행 복사
  - `3 yy` : 3행 복사
- `x` : 한글자 삭제
- `p` : 행 추가

##### 커서이동 (명령모드에서)

- `^` : 현재 행의 처음으로
- `$` : 현재 행의 마지막으로
- `gg` : 제일 첫행으로
- `G` : 제일 끝행으로
- `숫자 G` | `:숫자`: 해당 숫자의 행으로 이동
- `/문자열` : 문자열 찾음
  - `n` : 다음 문자열

##### 종료하기 (명령모드에서)

- `:wq` | `ZZ` : 저장하고 종료
- `:q` : 그냥 종료
- `:q!` : 무조건 그냥 종료

##### 바로가기 파일 만들기

`ln -s <파일명> <바로가기 파일>` : *바로가기파일은 파일타입이 ‘l’*

- `ll`의 결과 : 파일타입 `l` <바로가기 파일> -> <파일명>`

###### 기타

`date` : 지금 시각 출력

`ifconfig` : (윈도우즈의 `ipconfig`에 해당함)

`su <사용자계정>` : 계정 바꾸기

`wget <파일 다운로드 경로>`

`source <설정파일>` : 환경변수 변경내용을 수행시켜 현재 쉘에 반영하라.

- 별도로 실행시키지 않으면, 환경설정파일은 로그인시에 적용된다.
- 실행한 쉘에만 반영됨

`ping <IP주소>` : 통신 테스트
`ifconfig` : 통신환경 보기
`systemctl restart network` : 네트워크 재시작

`ctrl+d` : 로그아웃

`whoami` : 어느 계정으로 로그인되었니?

`hostname` : 내컴 이름 알려줘

`ps` : process status 알려줘
`jps` : java로 구동되는 process status 알려줘



### IP 주소 고정하기

BOOTPROTO = “dhcp” (*Dynamic Host Configuration Protocol*)  을 none으로 변경하고, 적당한 (고정) IP 주소를 세팅힌다.

설정파일 수정: 	~/systemconfig/network-scripts/ 에 있는 설정파일 수정 

​	수정할 내용	

> BOOTPROTO=none

​	추가할 내용

> IPADDR=*ip address (ex: 192.168.111.120)*
> NETMASK=*subnet mask (ex: 255.255.255.0)*
> GATEWAY=*gate way (ex: 192.168.111.2)*
> DNS1=*(ex: 192.168.111.2)*

`systemctl restart network` : 네트워크 재시작하여 변경설정 적용함.
`ifconfig` : 네트워크 정보 확인

`hostname`: 컴퓨터 네트워크 이름 확인
`hostnamectl set-hostname <네트워크 이름>` : 컴퓨터 네트워크 이름 설정
`cntrl c` : 강제중단

### JDK 1.8 설치

[Java](java.sun.com) 에서 [*Linux x64 Compressed Archive* 다운로드](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html#license-lightbox)

관리자계정으로 로그인한다.

설치파일을 `tar xvyz`로 압축풀고,
`/usr/local` (전체 사용자들이 공동으로 사용하는 폴더. 주로 프로그램 설치) 에 설치하고

> `tar xvyz jak-8xx-linux-x64.tar.gz`
> `mv jdk1.8.x_xxx /usr/local` 

심볼릭 링크를  `java`로 설정한다. (`ln -s`)  
(Java 버전이 업데이트 되어도 나중에 설정바꾸기가 쉽다.)

> `ln -s jdk1.8.x_xxx java` 

실행 패스를 추가한다. (**/etc/profile/**[^/etc/profile/]) :   

[^/etc/profile/]:전역적인 환경설정 파일

**JAVA_HOME**에는 JDK 설치된 디렉토리 경로를, **PATH**에는 bin 디렉토리 경로를 넣어주어야 함. 

> export JAVA_HOME=/usr/local/
> export PATH=\$JAVA_HOME/bin:\$PATH

source로 변경사항을 적용한다.

> `source /etc/profile/`

설치 확인
	설치된 자바 버젼 확인한다.
	javac 명령어로 컴파일도 테스트한다.

> `java -version`
> `javac <자바파일명.java>`

### Eclipse 설치

설치파일 압축풀면 됨.

백그라운드에서 실행시키려면 `&`와 함께 호출

PATH 안 잡아주면 설치파일에서 ./eclipse로 실행하자

### Tomcat 설치

Tomcat v9.0 Server 설치

설치파일 압축풀고, 

이클립스를 열어 등록한다.

server.xml 수정 (port 번호 8000으로)

> <Connector connectionTimeout="20000" port="8000" protocol="HTTP/1.1" redirectPort="8443"/>

### 방화벽 종료[^stop]와 중단[^disable]

[^stop]:방화벽을 끈다. 재로그인시에는 복구됨.
[^disable]:재로그인시에도 방화벽 해제를 유지

> `systemctl stop firewalld`
> `systemctl disable firewalld`



# VMworkstation 사용

1. IP를 맞춰준다. 
   - //Program Files(x86)/VMware/VMware Player 경로에 
   - vmnetcfg.exe를 설치하고 관리자권한으로 실행
   - NAT에서 머신의 IP 주소 변경

# Hadoop 사용 (http://hadoop.apache.org/) - 2.7.7 버젼 사용

https://hadoop.apache.org/docs/r2.7.7/hadoop-project-dist/hadoop-common/ClusterSetup.html

-----

HDFS (*Hadoop Distributed File System*) : 파일 분산저장 시스템

MapReduce (*Map `-->` Reduce*) : 클러스터 환경에서 파일 병렬처리 프레임워크

----

### Hadoop HDFS 명령어들

hdfs dfs -ls  
				-lsr    (-ls -R)  
				-mkdir  
				-cat  
				-put  
				-get  
				-rm  
				-rmr   (-rm -r)   
				-tail  
				-chmod    
    			-mv  
				……



`start-dfs.sh` : hdfs 데이터시스템 시작
`stop-dfs.sh` : hdfs 데이터시스템 종료

### Hadoop 설치

1. 설정파일

`/root` 디렉토리의 `.bashrc`에 내용 추가

> export HADOOP_HOME=/root/hadoop-2.7.7  
> export PATH=\$HADOOP_HOME/bin:\$HADOOP_HOME/sbin:\$PATH

Hadoop 설정파일들에 내용 추가

​	xxx-env.sh : PATH 정보 추가

> - hadoop-env.sh
> - mapred-env.sh
> - yarn-env.sh

​	xxx-site.xml : <configuration> 정보 편집

> - core-site.xml  : 네임노드 정보
> - hdfs-site.xml
> - mapred-site.xml
> - yarn-site.xml

slaves 파일을 다음으로 변경 ( *\$HADOOP_HOME/etc/hadoop* 위치)
누가 슬래이브들인지 알려주자!!

> slave1
> slave2
> slave3	

masters 파일을 생성하고 다음을 저장 ( *\$HADOOP_HOME/etc/hadoop* 위치)
누가 secondary 마스터인지 알려주자!!

> slave1

​	

2. machine 3개 복제하여 개별화 처리

- displayName 변경 : VM > m2~m4 폴더의 xxx.vmx 파일

- MAC address 변경 : 
  - VMware Workstation 에서 MAC address를 생성한다.

> *m1	00:0C:29:09:07:28  (<– 기존)*
> *m2    00:50:56:2A:FA:40 (<– Generate)*
> *m3	00:50:56:3D:FC:7A (<– Generate)*
> *m4	00:50:56:37:F6:DA (<– Generate)*

- 각 머신으로 접속하여 통신시스템 설정을 변경한다.

  (/etc/sysconfig/network-scripts/ 안의 ifcfg-enoxxx 파일을 수정한다.)

> **HWADDR**=“새로 생성한 MAC address”
> ~~
> **IPADDR**=“적절하게 IP 변경”

- IP 주소에 별칭 설정 : DNS(*Domain Name System*) 설정
  - /etc/hosts 에 설정을 추가

> *192.168.111.120 master*
> *192.168.111.130 slave1*
> *192.168.111.140 slave2*
> *192.168.111.150 slave3*

##### Hadoop 사용

- 메모리  최대한 확보

용량 확보를 위해 진짜컴퓨터의 Oracle 서비스를 중단하자.  (윈도우즈 )
슬래이브 머신들의 메모리 용량도 낮춰 놓자   (4GB –> 2GB)

- 마스터에서 SSH Key를 생성하여 다른 시스템과 공유


`ssh-keygen -t rsa` : 키 생성 (기본적으로 `/root/.ssh/id-rsa` 로 저장됨)
`ssh-copy-id -i /root/.ssh/id_rsa.pub root@slave1` : 키 공유 (다른 머신들과 자신의 계정과도 공유해야 함)

- 하둡파일시스템 초기화(포맷)

`hdfs namenode -format`

* 하둡서비스 구동

  `start-dfs.sh`  
  `jps` : 데몬이 제대로 수행되었는지 확인

  

* 하둡명령어 사용하여 데이터 조회, 저장 …

  

- 하둡 OverView 확인하기 (하둡이 쓰는 기본 포트번호 : *50070*)

  > http://192.168.111.120:50070  
  > http://master:50070   (ip 별칭을 사용)

* 하둡시스템은 파일수정 허용하지 않음. (설정할 경우 append는 가능함)



## 하둡 활용을 위한 Java Project 만들기

* Java project 만들고,
* Maven으로 적용한다. (Configure > Maven ~ )
* Maven 설정파일에 <dependency> 추가  (https://mvnrepository.com/)
  * hadoop-common  
  * hadoop-client  

(예제용) 톰캣서버의 로그 기록

C:\soykim\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\logs



https://hadoop.apache.org/docs/r2.7.7/api/index.html



### Windows에서 하둡 사용

1. 필요 유틸리티 설치하고, 시스템 환경변수 설정

   - winutils.exe를 저장하고
   - Path 환경변수 설정

2. 이클립스 재기동

3. pom.xml 편집

   ```xml
   <!-- https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-common -->
   		<dependency>
   			<groupId>org.apache.hadoop</groupId>
   			<artifactId>hadoop-common</artifactId>
   			<version>2.7.7</version>
   		</dependency>
   		<dependency>
   			<groupId>org.apache.hadoop</groupId>
   			<artifactId>hadoop-client</artifactId>
   			<version>2.7.7</version>
   		</dependency>
   		<dependency>
   			<groupId>org.apache.hadoop</groupId>
   			<artifactId>hadoop-mapreduce-client-core</artifactId>
   			<version>2.7.7</version>
   		</dependency>
   
   		<dependency>
   			<groupId>commons-io</groupId>
   			<artifactId>commons-io</artifactId>
   			<version>2.6</version>
   		</dependency>
   		<dependency>
   			<groupId>org.springframework.data</groupId>
   			<artifactId>spring-data-hadoop</artifactId>
   			<version>2.5.0.RELEASE</version>
   		</dependency>
   ```

4. 소스코드 복붙하기

5. servlet-context.xml 파일에 추가 (  namespace에 하둡 추가)

   ```xml
   	<hadoop:configuration id="hdConf">
   		fs.defaultFS=hdfs://192.168.111.120:9000
   	</hadoop:configuration>
   ```

   

##### Java에서 사용가능한 하둡 API

org.apache.hadoop.conf.Configuration

> `void addResource(String name)` : 설정 리소스를 추가한다.  
> `void set(String name, String value)` : key와 value 값을 설정한다.

```java
import org.apache.hadoop.conf.Configuration;
/* 하둡 컨프 객체를 생성하고 초기화 */
Configuration conf = new Configuration();
conf.set("fs.defaultFS", "hdfs://192.168.111.120:9000");
```

org.apache.hadoop.fs.Path

> FileSystem getFileSystem(Configuration conf) : NameNode에 의해 관리되는 FileSystem 객체를 리턴함

```java
import org.apache.hadoop.fs.Path; 
/* 하둡 컨프객체와 하둡 패스객체로 --> 하둡 파일시스템 객체 생성 */
Path path = new Path("/edudata/soykim/sample.csv");
FileSystem hdfs = path.getFileSystem(conf);
```



org.apache.hadoop.fs.FileSystem

> `static FileSystem get(Configuration conf)` :   
> `static FileSystem get(URI uri, Configuration conf)` : .   
> `static FileSystem get(URI uri, Configuration conf, String user)` : 

```java
import org.apache.hadoop.fs.FileSystem;
import java.net.URI;
/* 하둡 컨프 객체로 하둡 파일시스템 객체를 생성*/
URI uri = URI.create("/edudata/soykim/sample.csv");
FileSystem hdfs = FileSystem.get(uri, conf);
// FileSystem hdfs = FileSystem.get(conf);
```





# site.xml 설정파일 변경 내용들

- ###### core-site.xml

  ```xml
  <configuration>
     <property>
        <name>fs.defaultFS</name>
        <value>hdfs://master:9000/</value>
     </property>   
  </configuration>
  ```

  

- ###### hdfs-site.xml

  ```xml
  <configuration>
     <property>
         <!-- 파일복제 갯수 설정 -->
        <name>dfs.replication</name>
        <value>3</value>
     </property>
     <property>
         <!-- 네임모드 위치 설정-->
        <name>dfs.name.dir</name>
        <value>/root/hadoop-2.7.7/hdfs/name</value>
     </property>
     <property>
         <!-- 데이터노드 위치 저장-->
        <name>dfs.data.dir</name>
        <value>/root/hadoop-2.7.7/hdfs/data</value>
     </property>
     <property>
         <!-- 어펜드기능 지원 -->
        <name>dfs.support.append</name>
        <value>true</value>
     </property>
     <property>
         <!--세컨더리 네임노드 설정 -->
        <name>dfs.namenode.secondary.http-address</name>
        <value>slave1:50090</value>
     </property>
     <property>
        <name>dfs.namenode.secondary.https-address</name>
        <value>slave1:50091</value>
     </property> 
  </configuration>
  ```

  

- ###### mapred-site.xml

  ```xml
  <configuration>
     <property>
        <name>mapreduce.framework.name</name>
        <value>yarn</value>
     </property>
     <property>
        <name>yarn.resourcemanager.hostname</name>
        <value>master</value>
     </property>
  </configuration>
  ```

  

- ###### yarn-site.xml

  ```xml
  <configuration>
  <!-- Site specific YARN configuration properties -->
     <property>
        <name>yarn.nodemanager.aux-services</name>
        <value>mapreduce_shuffle</value>
     </property>
  </configuration>
  ```

  

### Hadoop MapReduce 사용하기

`$HADOOP_HOME/etc/hadoop/yarn-site.xml`에 설정 추가 (4개 머신 모두)

```xml
<property>
	<name>yarn.resourcemanager.hostname</name>
	<value>master</value>
</property>
<property>
	<name>yarn.resourcemanager.webapp.address</name>
	<value>${yarn.resourcemanager.hostname}:8088</value>
</property>
<property>
	<name>yarn.nodemanager.resource.memory-mb</name>
	<value>4096</value>
</property>
	<property>
	<name>yarn.scheduler.minimum-allocation-mb</name>
	<value>2048</value>
</property>
```

실행하기

1. `start-dfs.sh`와 `start-yarn.sh`로 시스템 기동

2. `jps`로 데몬 확인

> master : NameNode, RsourceManager  
> slave1 : DataNode, NodeManager, SecondaryNameNode  
> slave2 : DataNode, NodeManager  
> slave3 : DataNode, NodeManager  



**YARN** 이란? (Yet Another Resource Negotiator)

….



----

[실습]

샘플 예제

Mapper 구현

```java
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
    private final static IntWritable one = new IntWritable(1); // 반환값 상수 1 설정
    private Text word = new Text();
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        StringTokenizer itr = new StringTokenizer(value.toString());
        while(itr.hasMoreTokens()){
            word.set(itr.nextToken());
            context.write(word, one);
        }
    }    
}
```

Reducer 구현

```java
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
    private IntWritable result = new IntWritable();
    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException{
    	int sum = 0;
        for (IntWritable val : values){
            sum += val.get(); // int로 변환해서 더하기
        }
        result.set(sum);
        context.write(key, result);
    }    
}
```

Main Method 구현

```java

```

> [ Hadoop MapReduce 실습 (1) ]  
> 단어의 길이가 3자 이상이고 5자 이하의 경우에만 결과를 만들어내도록 수정한다.
>
> [ Hadoop MapReduce 실습 (2) ]  
> 단어의 갯수가 4개 이상인 경우에만 결과를 만들어내도록 수정한다.



[Sort 구현]

FruitsResultSort.java

```java
public static void main(String[] args) throws Exception {
    @AutoWired
    Configuration conf;
    FileSystem hdfs = FileSystem.get(conf);
    FSDataInputStream in = hdfs.open(new Path("/result/fruits1/part-r-00000"));
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    Map<String, Integer> map = new HashMap<String, Integer>;
    while(br.ready()){
        String line = br.readLine();
        String data[] = line.split("\\s+");
        map.put(data[0], Integer.parseInt(data[1]));
    }
    List<String> keySetList = new ArrayList<>(map.keySet());
    
    ..... ......
    /*람다식을 사용합니다~~!!*/
    ..... .....
        
}
```

