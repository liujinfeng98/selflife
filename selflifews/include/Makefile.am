#gsoapcpp2= `$(PKG_CONFIG) gsoap++ --variable=exec_prefix`/bin/soapcpp2
#gsoapimport= `$(PKG_CONFIG) gsoap++ --variable=prefix`/share/gsoap/import
gsoapcpp2 = /usr/local/bin/soapcpp2
gsoapimport = /usr/share/gsoap/import

all: getsoapfiles
getsoapfiles:
	@${gsoapcpp2} -S -I ${gsoapimport} command.h

clean-local: cleansoapfiles
cleansoapfiles:
	@rm -f ns.* sl.* soap*