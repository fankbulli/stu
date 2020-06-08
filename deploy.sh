cd `dirname $0`                 #�����Ŀ¼

mvn_p="maven:3.3.3-jdk-8"
proj_home=$PWD                  #���̸�Ŀ¼
img_output="school"             #���ɾ����ǩ
appname="stu"                   #��������
port=80                         #docker��¶�˿�

#  mvn�������
docker run  --rm  --name doc  -v /root/.m2:/root/.m2   -v $proj_home:/usr/src/mymaven  -w /usr/src/mymaven "maven:3.3.3-jdk-8" mvn clean install
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

# ��������  8080Ϊ���̵Ķ˿�
docker run -d --name $appname -p $port:8080 $img_output