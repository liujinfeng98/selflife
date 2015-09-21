#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_PREREQ([2.69])
AC_INIT([selflife], [1.0], [liujinfeng98@126.com])
AC_CONFIG_SRCDIR([src/user.cpp])
AC_CONFIG_HEADERS([config.h])
AM_INIT_AUTOMAKE(selflife, 1.0)
# Checks for programs.
AC_PROG_AWK
AC_PROG_CC
AM_PROG_LIBTOOL
AC_PROG_CXX
AC_PROG_CPP
AC_PROG_OBJC
AC_PROG_INSTALL
AC_PROG_LN_S
AC_PROG_MAKE_SET
AC_PROG_RANLIB
# Checks for OS
AC_CANONICAL_HOST
Z_OS_TYPE=unsupport
case "$host" in
  *-*-darwin*)
    Z_OS_TYPE=Mac
    AC_DEFINE(Z_OS_MAC, 1, [The OS type is Mac])
    ;;
  *-*-mingw*)
    Z_OS_TYPE=Win
    AC_DEFINE(Z_OS_WIN, 1, [The OS type is Win])
    ;;
  *-*-linux*)
    Z_OS_TYPE=Linux
    AC_DEFINE(Z_OS_LINUX, 1, [The OS type is Linux])
    ;;
esac
if test "$Z_OS_TYPE" = "notsupport"; then
   AC_MSG_ERROR([OS "$host" is not supported!])
fi

AM_CONDITIONAL(Z_OS_MAC, test "$Z_OS_TYPE" = "Mac")
AM_CONDITIONAL(Z_OS_WIN, test "$Z_OS_TYPE" = "Win")
AM_CONDITIONAL(Z_OS_LINUX, test "$Z_OS_TYPE" = "Linux")

# Checks for libraries.
#gsoap="gsoap++ >= 2.8"
#PKG_CHECK_MODULES(GSoap, [$gsoap])
#AC_SUBST(Cflags)
#AC_SUBST(Libs)

# 设置程序安装路径
test "x${prefix}" = xNONE && prefix="${ac_default_prefix}"
if test x${Z_OS_TYPE} = xMac; then
   bindir="${prefix}/Contents/MacOS"
   datadir="${prefix}/Contents/Resources"
fi
if test x${Z_OS_TYPE} = xWin; then
   bindir="${prefix}"
   datadir="${prefix}"
fi
if test x${Z_OS_TYPE} = xLinux; then
   bindir="${prefix}/bin"
   datadir="${prefix}/share/selflife"
fi

# Checks for libraries.
# FIXME: Replace `main' with a function in `-lgsoap':
AC_CHECK_LIB([gsoap], [main])
# FIXME: Replace `main' with a function in `-lodbc':
AC_CHECK_LIB([odbc], [main])
# FIXME: Replace `main' with a function in `-lpthread':
AC_CHECK_LIB([pthread], [main])

# Checks for header files.
AC_CHECK_HEADERS([arpa/inet.h fcntl.h float.h inttypes.h limits.h locale.h memory.h netdb.h netinet/in.h stdint.h stdlib.h string.h strings.h sys/ioctl.h sys/socket.h sys/time.h sys/timeb.h unistd.h])

# Checks for typedefs, structures, and compiler characteristics.
AC_CHECK_HEADER_STDBOOL
AC_C_INLINE
AC_TYPE_SIZE_T

# Checks for library functions.
AC_FUNC_ERROR_AT_LINE
AC_FUNC_MALLOC
AC_FUNC_MKTIME
AC_FUNC_STRERROR_R
AC_FUNC_STRTOD
AC_CHECK_FUNCS([ftime gethostbyname gettimeofday localtime_r memset putenv select socket strcasecmp strchr strerror strstr])

# Checks for library functions.
AC_CHECK_LIB(odbc, SQLAllocHandle, , AC_MSG_ERROR([*** odbc/unixodbc not found ***]))

AC_CONFIG_FILES([Makefile
                 include/Makefile
                 src/Makefile])

AC_OUTPUT
