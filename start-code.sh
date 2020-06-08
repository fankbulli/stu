#!/bin/bash
cd `dirname $0`

img_mvn="maven:3.3.3-jdk-8"                 # docker image of maven
m2_cache=~/.m2                              # the local maven cache dir
proj_home=$PWD                              # the project root dir
img_output="school"      # output image tag

git pull  https://github.com/fankbulli/stu.git # should use git clone https://name:pwd@xxx.git

echo "use docker maven"
docker run --rm \
   -v $m2_cache:/root/.m2 \
   -v $proj_home:/usr/local/maven \
   -w /usr/local/maven $img_mvn mvn clean package -U

sudo mv $proj_home/stu/target/stu-*.jar $proj_home/stu/target/demo.jar # ¼æÈÝËùÓÐsh½Å±¾
docker build -t $img_output .

mkdir -p $PWD/logs
chmod 777 $PWD/logs

# É¾³ýÈÝÆ÷
docker rm -f school

#É¾³ýÎÞÐ§¾µÏñ
echo "======== docker rmi containers ========"
logs=$(docker images | grep none | awk '{print $3}')
for log in $logs
        do
             echo $log
	     docker rmi $log
        done
echo "É¾³ý³É¹¦"

version=`date "+%Y%m%d%H"`
spring_datasource_url=jdbc:mysql://192.168.101.53/school?useUnicode=true\&characterEncoding=utf-8\&useSSL=false\&serverTimezone=Asia/Shanghai\&autoReconnect=true\&allowMultiQueries=true

# Æô¶¯¾µÏñ
docker run -d --restart=on-failure:5 --privileged=true \
    -w /home \
    --net=host \
    -v $PWD/logs:/home/logs \
    --name school school \
    java \
        -Duser.timezone=Asia/Shanghai \
        -XX:+PrintGCDateStamps \
        -XX:+PrintGCTimeStamps \
        -XX:+PrintGCDetails \
        -XX:+HeapDumpOnOutOfMemoryError \
        -Xloggc:logs/gc_$version.log \
        -jar /home/demo.jar \
#          --spring.profiles.active=dev \
#          --spring.application.name=school \
#          --eureka.client.serviceUrl.defaultZone=http://ip:port/eureka \
          --spring.datasource.url=$spring_datasource_url \
          --spring.datasource.username=root \
          --spring.datasource.password=root \
#          --xxl.job.admin.addresses=http://localhost:8090/job/ \
#          --mq.namesrvAddr=ip:port \
#          --cache.host=ip \
#          --cache.port=port \
