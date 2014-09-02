@echo off
::
:: SPDXVersion: SPDX-1.1
:: Creator: Person: Nuno Brito (nuno.brito@triplecheck.de)
:: Creator: Organization: TripleCheck (http://triplecheck.de)
:: Created: 2014-01-01T00:00:00Z
:: LicenseName: EUPL-1.1-without-appendix
:: FileName: publish.bat 
:: FileType: SOURCE
:: FileCopyrightText: <text> Copyright (c) 2014 Nuno Brito, TripleCheck </text>
:: FileComment: <text> Creates a new zip file containing the binaries ready
:: for end-users. </text>
::
:: Things you'll need in order to run this script:
::  - Running on Windows or ReactOS to run this script
::	- Install Launch4j on folder "c:\Program Files (x86)\Launch4j"
:: 

set zipfile=triplecheck.zip
set cabfile=triplecheck-recent.cab
set build=reporter
set publish=publish

:: Deleting the old files
echo Deleting the old publish folder if it exists
mkdir ..\publish
cd ..\publish
for /f "tokens=* delims=" %%i in ('dir /s/b') do (
  rd /s /q "%%i" > null
)
del /s /q *.*

echo Creating the folder structure
cd ..\%publish%
mkdir misc

echo Building the new executable
cd ..\%build%
"c:\Program Files (x86)\Launch4j\launch4jc.exe" .\docs\launch4j-triplecheck.xml


echo copying the needed folders
cd ..\%build%
xcopy /s/y run\plugins ..\%publish%\plugins\
xcopy /s/y run\misc\icons ..\%publish%\misc\icons\
xcopy /s/y run\extensions ..\%publish%\extensions\
xcopy /s/y run\triggers ..\%publish%\triggers\
xcopy /s/y run\licenses ..\%publish%\licenses\
xcopy /s/y run\components ..\%publish%\components\
xcopy /s/y ..\misc\java ..\%publish%\java\


:: copy the licenses and other related files
copy EUPL-1.1.txt ..\%publish%\EUPL-1.1.txt
copy LICENSE ..\%publish%\LICENSE

:: creating the reports folder
cd ..\%publish%
mkdir reports
echo This folder contains the generated reports > .\reports\readme.txt

:: copy the example report
copy ..\%build%\run\reports\adblockplusandroid.spdx .\reports\example.spdx


::pause

echo Creating a new zip file
del ..\%zipfile% 
del ..\%cabfile% 

::pause

cd ..\%publish%

:: now delete some redundant files
cd extensions\unknown
for /f "tokens=* delims=" %%i in ('dir /s/b') do (
  rd /s /q "%%i" > null
)
del /s /q *.*
:: go back to main folder
cd..
cd..

:: final steps, create the zipped files
..\%build%\tools\7z.exe a -r ..\%zipfile%
:: create the cabinet file
::cabarc -r -p n ..\%cabfile% * 

echo opening explorer
explorer .

echo launching triplecheck
triplecheck.exe
