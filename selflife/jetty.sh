#!/bin/sh
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
mvn jetty:run
