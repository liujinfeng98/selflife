
			
bin_PROGRAMS = selflife

selflife_SOURCES =  ../include/stdsoap2.cpp ../include/soapC.cpp ../include/soapServer.cpp \
					otldb.cpp user.cpp commands.cpp cattag.cpp


noinst_HEADERS = otldb.h otlv4.h ../include/command.h\
					 ../include/soapH.h\
					../include/soapStub.h ../include/stdsoap2.h ../include/stllist.h
lib_LTLIBRARIES = libselflife.la
libselflife_la_SOURCES = otldb.cpp
selflife_CPPFLAGS = -I../include -I/usr/include  
#					-I../public/out/include

selflife_LDADD = -lgsoap++ -lodbc -lpthread -lgsoap\
					$(top_builddir)/src/libselflife.la
#				 -L../public/out/lib -lpthread