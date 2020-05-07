# Spark

HADOOP의 에코시스템. 속도 개선. 멀티쓰레드로 잘 처리.

## Prequisite 지식

#### 쓰레드란?

process와 thread의 개념 대비

* process status 확인하는 리눅스 명령어 실행해서 확인해 보자

  > `-ps`
  >
  > `-ps -ef`
  >
  > `-ps -ef|more`
  >
  > `-ps -ef>filename.txt`

multi thread programing의 장점과 유의사항

| 장점 | - 자원을  보다 **효율적**으로  사용할 수 있다.  -  사용자에 대한 **응답성****(****responseness****)****이  향상**된다.  - 작업이  분리되어 **코드가  간결**해  진다.  -  **“****여러  모로 좋다****.****”** |
| ---- | ------------------------------------------------------------ |
| 단점 | -  동기화(synchronization)에  주의해야 한다.  -  교착상태(dead-lock)가  발생하지 않도록 주의해야 한다.  - 각 쓰레드가  효율적으로 고르게 실행될 수 있게 해야 한다.     **“****프로그래밍할  때 고려해야 할 사항들이 많다****.****”** |

* 성공사례 **서블릿** : CGI(*Common Gateway Interface*)는 multi process 였으나 서블릿(Servlet, *Server Side Applet*)은 multi thread 로 속도면에서 탁월하였음. 
* 성공사례 **스파크** : 잘 배워보자!

#### Java에서 Thread 구현

방법1 : `java.lang.Thread` 클래스 상속  

방법2 : `java.lang.Runnable` 인터페이스 이용

인스턴스 생성방법이 다름

```java
/* Thread 클래스 상속한 경우 */
Thread_1 t1 = new Thread_1();
```

```java
/* Runnable 인터페이스 이용한 경우 */
Runnable r = new Thread_2();
Thread t2 = new Thread(r);
```

쓰레드 기동 방법

```java
/* 쓰레드 기동 */
t.start();
```

```java
/* 데몬으로 쓰레드 기동 */
t.setDaemon();
t.start();
```

JVM의  Thread 관리 방법은 라운드로빈 앤드 프라이어리티



#### Java의 이너클래스

이너클래스의 종류

| 내부클래스의 종류          | 예시                  | 사용                                                      |
| -------------------------- | --------------------- | --------------------------------------------------------- |
| 멤버 클래스 - *non static* | `Outer$Inner.class`   | `Outer o = new Outer();`  <br />`o.new Inner().멤버;`     |
| 멤버 클래스 - *static*     | `Outer$Inner.class`   | `Outer.Inner.멤버`                                        |
| 로컬 클래스 - *named*      | `Outer$1$Inner.class` |                                                           |
| 로컬 클래스 - *anonymous*  | `Outer$1.class`       | `new Abstract(){ … }` 또는  <br />`new Interface() { … }` |

```java
/* 인터페이스 하나가 있음 */
interface Testable {
    final static String fs = "Interface Test";
    abstract void output(String s);
}
/* 그 인터페이스를 인자로 받는 메쏘드가 있음 */
class InnerTest4 {
    void pr(Testable o){
        o.output("Test");
    }
}
/* 메인메쏘드 클래스가 있음 */
public class Main {
    public static void main(String args[]){
        InnerTest4 n = new InnerTest4();
        /* 인터페이스를 인자로 받는 메쏘드 호출 하려면~!*/
        /* 익명클래스로 정의해 줘야 함 ****************/
        n.pro(new Testable(){            
            int su = 100;
            @Override
            public void output(String s){
                System.out.println(su + " : " + s);
            }
        });
        /* new Testable() { ... } 로 생성된 익명클래스!! */
    }
}
```



#### Java의 람다식

`() -> { … … }`

**타겟타입**[^target type]은 반드시 **함수적인터페이스**[^functional interface] 여야 함.

[^target type]:람다식이 대입되는 인터페이스
[^functional interface]: 하나의 추상메서드만 선언된 인터페이스. `@FunctionalInterface` 어노테이션을 붙이면 컴파일 할 때 체크할 수 있음



## Spark 실습용 환경설정

1. 가상머신 4대 --> ==2대==

> master : namenode  
> slave1 : secondarynamenode, datanode

2. 하둡의 환경 설정 변경 (모든 머신에서)

   * `slaves` 파일 편집 (`$HADOOP_HOME/etc/hadoop/slaves`)

   > slave1  
   > slave2 –> ==삭제==  
   > slave3 –> ==삭제== 

   

   * `hdfs-site.xml` 편집 : 복제갯수 3개 –> 1개

   ><property>
   >      <name>dfs.replication</name>
   >      <value>==1==</value>
   ></property>

   

3. 하둡파일시스템 기동

   `start-dfs.sh`

4. Spark 설치

   * spark.apache.org 에서 다운로드

   * Hadoop 버젼과 맞추자 (hadoop-2.7.x)

   * tgz 압축을 풀려면 반디집 설치

   * 환경변수 잡아주기

     > SPARK_HOME  
     > PATH 편집  : %SPARK_HOME%\bin  
     > (리눅스에 설치하는 경우 `$SPARK_HOME/sbin`도 추가)

   * log4j.properties 만들기  (템플릿에서 정보수정)
     log4j.rootCategory===WARN==, console

5. Spark 실행

   cmd 창에서 

   `spark-shell` : scala 언어로 스칼라 구동

   `sc` : spark context 객체 확인

   * hdfs 에서 파일 읽어오기

     ```scala
     val textFile = sc.textFile("hdfs://192.168.111.120:9000/edudata/xxx.txt")
     ```

     

   * 이런저런 처리들 (쪼개고, 매핑하고, 집계) (참고: `var` 와 `val`)

     ```scala
     val count = textFile.flatMap(line => line.split("")).map(word=>(word,1)).reduceByKey(_+_)
     ```

   * 출력하기

     ```scala
     count.collect()
     ```

     

* ㅇㅇㅇ



#### Spark 작동 개요

1. SparkContext 객체가 생성되어,

2. RDD 로 변환되어,

3. 일반 파일로 액션된다.







