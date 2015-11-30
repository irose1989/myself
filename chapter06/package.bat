@set curPath=%cd%
@cd %~dp0
@call mvn clean install -Dmaven.test.skip=true
@call mvn clean package -Dmaven.test.skip=true
@cd %curPath%
@pause