@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  tempAlgEval startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and TEMP_ALG_EVAL_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\tempAlgEval-1.0-SNAPSHOT.jar;%APP_HOME%\lib\gson-2.8.6.jar;%APP_HOME%\lib\Java-WebSocket-1.5.1.jar;%APP_HOME%\lib\ktor-client-jetty-jvm-1.5.2.jar;%APP_HOME%\lib\slf4j-simple-1.7.26.jar;%APP_HOME%\lib\commons-csv-1.8.jar;%APP_HOME%\lib\ktor-client-websockets-jvm-1.5.2.jar;%APP_HOME%\lib\ktor-client-core-jvm-1.5.2.jar;%APP_HOME%\lib\ktor-http-cio-jvm-1.5.2.jar;%APP_HOME%\lib\ktor-http-jvm-1.5.2.jar;%APP_HOME%\lib\ktor-network-jvm-1.5.2.jar;%APP_HOME%\lib\ktor-utils-jvm-1.5.2.jar;%APP_HOME%\lib\ktor-io-jvm-1.5.2.jar;%APP_HOME%\lib\kotlinx-coroutines-core-jvm-1.5.0.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.5.0.jar;%APP_HOME%\lib\slf4j-api-1.7.30.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.5.0.jar;%APP_HOME%\lib\kotlin-stdlib-1.5.0.jar;%APP_HOME%\lib\http2-client-9.4.31.v20200723.jar;%APP_HOME%\lib\jetty-alpn-openjdk8-client-9.4.31.v20200723.jar;%APP_HOME%\lib\jetty-alpn-java-client-9.4.31.v20200723.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.5.0.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\http2-common-9.4.31.v20200723.jar;%APP_HOME%\lib\jetty-alpn-client-9.4.31.v20200723.jar;%APP_HOME%\lib\http2-hpack-9.4.31.v20200723.jar;%APP_HOME%\lib\jetty-http-9.4.31.v20200723.jar;%APP_HOME%\lib\jetty-io-9.4.31.v20200723.jar;%APP_HOME%\lib\jetty-util-9.4.31.v20200723.jar


@rem Execute tempAlgEval
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %TEMP_ALG_EVAL_OPTS%  -classpath "%CLASSPATH%" main.Main %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable TEMP_ALG_EVAL_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%TEMP_ALG_EVAL_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
