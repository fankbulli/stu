cd `dirname $0`                 #进入根目录

mvn_p="maven:3.3.3-jdk-8"
proj_home=$PWD                  #工程根目录
img_output="school"             #生成镜像标签
appname="stu"                   #容器名称
port=80                         #docker暴露端口

#  mvn打包镜像
$ docker run -it --rm --name my-maven-project -v "$(pwd)":/usr/src/mymaven -w /usr/src/mymaven maven:3.3-jdk-8 mvn clean install

r_c=`docker ps -a | grep "$appname" | awk '{print $1 }'`
c=`docker ps -a | grep "$appname" | awk '{print $1 }'`
r_img=`docker images | grep "$appname" | awk '{print $3 }'`
# 如果容器正在运行，停止它
if [ "$r_c"x != ""x ]; then
   docker stop "$r_c"
fi
# 删除容器
if [ "$c"x != ""x ]; then
   docker rm "$c"
fi
# 删除镜像
if [ "$r_img"x != ""x ]; then
    docker rmi "$r_img"
fi

# 生成镜像
docker build -t $img_output .
# 日志目录
mkdir -p $PWD/logs
chmod 777 $PWD/logs

# 启动镜像  8080为工程的端口
docker run -d --name $appname -p $port:8080 $img_output