cd `dirname $0`                 #�����Ŀ¼

proj_home=$PWD                  #���̸�Ŀ¼
img_output= "stu"          #���ɾ����ǩ
appname="stu"                  #��������
port=80                         #docker��¶�˿�

#  mvn�������
docker run  --rm doc--name my-maven-project -v /root/.m2:/root/.m2 -v "$PWD":/usr/src/mymaven -w /usr/src/mymaven maven:3.5.0-jdk-8-alpine mvn clean install
# ���docker���� id�;��� id
r_c=`docker ps -a | grep "$appname" | awk '{print $1 }'`
c=`docker ps -a | grep "$appname" | awk '{print $1 }'`
r_img=`docker images | grep "$appname" | awk '{print $3 }'`
# ��������������У�ֹͣ��
if [ "$r_c"x != ""x ]; then
    docker stop "$r_c"
fi
# ɾ������
if [ "$c"x != ""x ]; then
    docker rm "$c"
fi
# ɾ������
if [ "$r_img"x != ""x ]; then
    docker rmi "$r_img"
fi

# ���ɾ���
docker build -t $img_output .
# ��־Ŀ¼
mkdir -p $PWD/logs
chmod 777 $PWD/logs

# ��������  8086Ϊ���̵Ķ˿�
docker run -d --name $appname -p $port:8086 $img_output