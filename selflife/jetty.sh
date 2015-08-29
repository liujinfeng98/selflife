#!/bin/sh
#add for chkconfig
#chkconfig: 2345 70 30
#description: the description of the shell
#processname: selflife
#关于脚本的简短描述
#第一个进程名，后边设置自启动的时候会用到
pid=` pgrep memcached `
echo $pid
function onePid(){
if [ ${pid} != null ]
        then
        kill $pid
fi
}
for onePid in ${pid}
do
        kill $pid
done

cd /opt/memcached-1.4.24/
./memcached -d -m 256 -u root -p 9096 -c 1024 –P /tmp/memcached.pid 
cd /home/ljf/selflifegit/selflife/
#su ljf
#sleep 60
mvn jetty:run
