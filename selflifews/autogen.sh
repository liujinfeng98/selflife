#! /bin/sh
sudo libtoolize --force --automake
sudo rm -f config.cache
sudo rm -f config.log
sudo aclocal
sudo autoheader
sudo autoconf
sudo automake -a
